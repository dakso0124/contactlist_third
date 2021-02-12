package com.dakso.contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dakso.contact.service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
       
    public LoginServlet()
    {
        super();
        m_service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		UserVO member = m_service.selectByID(request.getParameter("id"), request.getParameter("pw"));
		
		if(member == null)
		{
			response.sendRedirect("loginForm.html");
			System.out.println("-");
		}
		else
		{
			System.out.println("--");
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getUserid());
			session.setAttribute("name", member.getName());
			
			response.sendRedirect("MainServlet");
		}
	}
}