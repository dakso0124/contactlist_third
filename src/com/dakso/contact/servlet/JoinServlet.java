package com.dakso.contact.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dakso.contact.VO.UserVO;
import com.dakso.contact.service.UserService;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserService m_service;
	
    public JoinServlet()
    {
        super();
        m_service = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher disp = request.getRequestDispatcher("joinForm.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("first_digit") + request.getParameter("second_digit") 
						+ request.getParameter("third_digit");
		String address = request.getParameter("postcode") + "`" + request.getParameter("mainAddress") + "`" 
							+ request.getParameter("detailAddress");
		
		UserVO user = new UserVO(id, pw, name, phone, address);
		int addResult = m_service.addUser(user);
		
		
		if( addResult > 0)	// 가입 성공
		{
			response.sendRedirect("MainServlet");
		}
		else
		{
			if( addResult == -1)	// overflow
			{
				request.setAttribute("msg", "overflow");
				request.setAttribute("user", user);
				doGet(request, response);
			}
			else if( addResult == -2)
			{
				request.setAttribute("msg", "id_overlap");
				user.setUserid("");
				request.setAttribute("user", user);
				doGet(request, response);
			}
			else if( addResult == -3)
			{
				request.setAttribute("msg", "phone_overlap");
				user.setPhone("");
				request.setAttribute("user", user);
				doGet(request, response);
			}
		}
	}
}