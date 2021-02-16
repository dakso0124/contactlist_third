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

import com.dakso.contact.VO.UserVO;
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
			request.setAttribute("msg", "timeout");
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
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
		request.setCharacterEncoding("utf-8");
		/* response.setCharacterEncoding("utf-8"); */
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");

		if(id == null || pw == null)
		{
			request.setAttribute("msg", "timeout");
			RequestDispatcher disp = request.getRequestDispatcher("MainServlet");
			disp.forward(request, response);
		}
		else
		{
			UserService m_service = new UserService();
			
			UserVO user = m_service.selectByID(id, pw);
			
			if(user == null)
			{
				request.setAttribute("msg", "invalid");
				
				doGet(request, response);
			}
			else
			{
				String name = request.getParameter("name");
				String phone = request.getParameter("first_digit") + request.getParameter("second_digit") 
								+ request.getParameter("third_digit");
				String address = request.getParameter("postcode") + "`" + request.getParameter("mainAddress") + "`" 
									+ request.getParameter("detailAddress");
				
				UserVO member = new UserVO();
				member.setUserid(id);
				member.setName(name);
				member.setPhone(phone);
				member.setAddress(address);
				
				int updateResult = m_service.updateUser(member); 
				
				if( updateResult > 0)		// 정보 수정하고 id, 이름 새로 저장
				{
					session.setAttribute("id", member.getUserid());
					session.setAttribute("name", member.getName());
					
					response.sendRedirect("MainServlet");
				}
				else if(updateResult == -1)
				{
					request.setAttribute("msg", "overflow");
					doGet(request, response);
				}
				else if(updateResult == -2)
				{
					request.setAttribute("msg", "phone_overlap");
					
					doGet(request, response);
				}
				else
				{
					request.setAttribute("msg", "fail");
					
					doGet(request, response);
				}
			}
		}
	}
}