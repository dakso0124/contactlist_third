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
	private UserService m_service = new UserService();
	
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
			request.setAttribute("msg", "timeout");
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
		}
		else
		{
			// membervo request에 담아야함
			UserService m_service = new UserService();
			ArrayList<RelationVO> relations = m_service.searchRelationByUserID(id);
			ContactVO contact = m_service.searchByContactID(request.getParameter("contactid"));
			contact.setContactID(Integer.parseInt(request.getParameter("contactid")));
			request.setAttribute("contact", contact);
			request.setAttribute("relations", relations);
			
			RequestDispatcher disp = request.getRequestDispatcher("modifyContactForm.jsp");
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
			request.setAttribute("msg", "timeout");
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
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
			contact.setContactID(Integer.parseInt(request.getParameter("contactid")));
			contact.setName(name);
			contact.setPhone(phone);
			contact.setRelation_name(relation_name);
			contact.setMemo(memo);
			
			if(relation_name == null)							// 그룹 입력 x
			{
				request.setAttribute("contact", contact);
				request.setAttribute("msg", "relation_null");
				doGet(request, response);
				return;
			}
			
			if(m_service.checkContactPhone(phone, id).isEmpty())	// 전화번호 중복
			{
				request.setAttribute("contact", contact);
				request.setAttribute("msg", "overlap");
				doGet(request, response);
				return;
			}
			
			RelationVO relation = m_service.searchRelationByName(relation_name, id);
			
			if(relation.getRelation_name() == null)		// 그룹 첫입력
			{
				int addRelationResult = m_service.addRelation(relation_name, id); 
				
				if(addRelationResult > 0)
				{
					relation = m_service.searchRelationByName(relation_name, id);
					contact.setRealation_key(relation.getRealation_key());
					contact.setUserid(id);
					
					m_service.updateContact(contact);
					
					response.sendRedirect("MainServlet");
				}
				else
				{
					contact.setUserid(id);
					
					if(addRelationResult == -1)
					{
						request.setAttribute("contact", contact);
						request.setAttribute("msg", "overflow");
						doGet(request, response);
					}
					else
					{
						request.setAttribute("contact", contact);
						request.setAttribute("msg", "fail");
						doGet(request, response);
					}
				}
			}
			else
			{
				contact = new ContactVO(name, phone, memo,  relation.getRealation_key(),relation_name, id);
				m_service.updateContact(contact);
				
				response.sendRedirect("MainServlet");
			}
		}
	}
}