package com.dakso.contact.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dakso.contact.service.UserService;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
	
    public FindServlet()
    {
        super();
        m_service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendRedirect("findForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String result = "";
		
		String msg = request.getParameter("msg");
		
		if(msg.equals("id"))
		{
			String name = request.getParameter("id_name");
			String phone = request.getParameter("id_phone");
			
			result = m_service.searchUserID(name, phone);
			
			if(result.isEmpty())
			{
				request.setAttribute("msg", "noid");
			}
			else
			{
				request.setAttribute("msg", "findid");
				request.setAttribute("id", result);
			}
		}
		else if(msg.equals("pw"))
		{
			String name = request.getParameter("pw_name");
			String phone = request.getParameter("pw_phone");
			String userID = request.getParameter("pw_id");
			
			result = m_service.searchPW(userID, name, phone);
			
			if(result.isEmpty())
			{
				request.setAttribute("msg", "noinfo");
			}
			else
			{
				request.setAttribute("msg", "findpw");
				request.setAttribute("pw", result);
			}
		}
		RequestDispatcher disp = request.getRequestDispatcher("findForm.jsp");
		disp.forward(request, response);
	}
}