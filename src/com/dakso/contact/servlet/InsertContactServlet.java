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
import com.dakso.contact.VO.UserVO;
import com.dakso.contact.service.UserService;

@WebServlet("/InsertContactServlet")
public class InsertContactServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service = new UserService();
    public InsertContactServlet()
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
			ArrayList<RelationVO> relations = m_service.searchRelationByUserID(id);
			
			request.setAttribute("relations", relations);
			RequestDispatcher disp = request.getRequestDispatcher("insertForm.jsp");
			disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");

		if(id == null)
		{
			response.sendRedirect("MainServlet");
		}
		else
		{
			String name = request.getParameter("name");
			String phone = request.getParameter("first_digit") + request.getParameter("second_digit") 
							+ request.getParameter("third_digit");
			String addRelation = request.getParameter("relation_name");
			String relation_name = (addRelation == null)? request.getParameter("group") : addRelation;
			String memo = request.getParameter("memo");
			
			ContactVO contact = new ContactVO();
			RelationVO relation = m_service.searchRelationByName(relation_name, id);
			
			if(relation.getRelation_name() == null)
			{
				if(m_service.addRelation(relation_name, id) > 0)
				{
					relation = m_service.searchRelationByName(relation_name, id);
					contact = new ContactVO(name, phone, memo,  relation.getRealation_key(),relation_name, id);
					
					if(m_service.insertContact(contact, id) > 0)
					{
						response.sendRedirect("MainServlet");
					}
					else
					{
						// 팝업띄울것!
						System.out.println("tq");
					}
				}
				else
				{
					// 팝업띄울것!
				}
			}
			else
			{
				contact = new ContactVO(name, phone, memo,  relation.getRealation_key(),relation_name, id);
				if(m_service.insertContact(contact, id) > 0)
				{
					response.sendRedirect("MainServlet");
				}
				else
				{
					// 팝업띄울것!
				}
			}
		}
	}
}