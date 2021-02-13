package com.dakso.contact.servlet;

import java.io.IOException;
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
		response.sendRedirect("joinForm.html");
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
		
		UserVO member = new UserVO(id, pw, name, phone, address);
		m_service.addUser(member);
		
		response.sendRedirect("MainServlet");
	}
}