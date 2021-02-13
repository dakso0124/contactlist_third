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
import com.dakso.contact.VO.RelationVO;
import com.dakso.contact.service.UserService;

@WebServlet("/ModifyContactServlet")
public class ModifyContactServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public ModifyContactServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id == null)
		{
			response.sendRedirect("MainServlet");
		}
		else
		{
			// membervo request에 담아야함
			UserService m_service = new UserService();
			ArrayList<RelationVO> relations = m_service.searchRelationByUserID(id);
			ContactVO contact = m_service.searchByContactID(request.getParameter("contactid"));
			request.setAttribute("contact", contact);
			request.setAttribute("relations", relations);
			
			RequestDispatcher disp = request.getRequestDispatcher("modifyContactForm.jsp");
			disp.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}