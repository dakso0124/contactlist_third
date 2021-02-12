package com.dakso.contact;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dakso.contact.service.UserService;

@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
       
    public ModifyUserServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		
		if(id == null)
		{
			response.sendRedirect("MainServlet");
			return;
		}
		else
		{
			UserService m_service = new UserService();
			UserVO user = m_service.selectByName(id, name);
			request.setAttribute("user", user);
			
			RequestDispatcher disp = request.getRequestDispatcher("modifyUserForm.jsp");
			disp.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}