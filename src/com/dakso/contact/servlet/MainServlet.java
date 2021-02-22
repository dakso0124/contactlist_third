package com.dakso.contact.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dakso.contact.VO.ContactVO;
import com.dakso.contact.service.UserService;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
	
    public MainServlet()
    {
        super();
        m_service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		
		if(id == null || name == null)
		{
			if(request.getAttribute("msg") != null)	// session 만료일 경우
			{
				if(request.getAttribute("msg").equals("timeout"))
					request.setAttribute("msg", "timeout");
			}

			RequestDispatcher disp = request.getRequestDispatcher("loginForm.jsp");
			disp.forward(request, response);
		}
		else
		{
			ArrayList<ContactVO> contactList = m_service.showAll(id);
			request.setAttribute("list", contactList);
			
			RequestDispatcher disp = request.getRequestDispatcher("mainForm.jsp");
			disp.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
}