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

@WebServlet("/InsertContactServlet")
public class InsertContactServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
	
    public InsertContactServlet()
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
			contact.setName(name);
			contact.setPhone(phone);
			contact.setRelation_name(relation_name);
			contact.setMemo(memo);
			
			if(relation_name == null)										// 그룹 입력 x
			{
				request.setAttribute("contact", contact);
				request.setAttribute("msg", "relation_null");
				doGet(request, response);
				return;
			}

			if(m_service.checkContactPhone(phone, id).getContactID() != 0 )	// 전화번호 중복
			{
				request.setAttribute("contact", contact);
				request.setAttribute("msg", "overlap");
				doGet(request, response);
				return;
			}

			RelationVO relation = m_service.searchRelationByName(relation_name, id);
			
			if(relation.getRelation_name() == null)					// 입력한 이름의 그룹이 존재하지 않을때
			{
				int addRelationResult = m_service.addRelation(relation_name, id); 
				
				if(addRelationResult > 0)							// 그룹 추가
				{
					relation = m_service.searchRelationByName(relation_name, id);
					contact.setRealation_key(relation.getRealation_key());
					contact.setUserid(id);
					
					insertContact(contact, id, request, response);
				}
				else												// 그룹 추가 실패
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
				insertContact(contact, id, request, response);
			}
		}
	}
	
	private void insertContact(ContactVO contact, String id, HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException
	{
		int addResult = m_service.insertContact(contact);		// 연락처 추가
		
		if( addResult > 0)
		{
			response.sendRedirect("MainServlet");
		}
		else if(addResult == -1)
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