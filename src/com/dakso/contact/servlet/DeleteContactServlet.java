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

@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
    public DeleteContactServlet()
    {
        super();
        m_service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null)
		{
			request.setAttribute("msg", "timeout");
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
		}
		else
		{
			int result = m_service.deleteContact(request.getParameter("contactid"));
			
			if(result <= 0)			// 삭제에 실패
			{
				request.setAttribute("msg", "fail");
				RequestDispatcher disp = request.getRequestDispatcher("mainForm.jsp");
				disp.forward(request, response);
			}
			else
			{
				response.sendRedirect("MainServlet");	
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}
