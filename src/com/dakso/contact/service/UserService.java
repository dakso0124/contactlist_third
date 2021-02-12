package com.dakso.contact.service;

import java.util.ArrayList;

import com.dakso.contact.ContactVO;
import com.dakso.contact.RelationVO;
import com.dakso.contact.UserVO;
import com.dakso.contact.dao.ContactDAO;

public class UserService 
{
	private ContactDAO m_dao = new ContactDAO();
	
	public ArrayList<ContactVO> showAll(String userID)
	{
		return m_dao.showAll(userID);
	}
	
	public ArrayList<ContactVO> searchByName(String userID, String name)
	{
		return m_dao.searchByName(userID, name);
	}
	
	public ContactVO searchByContactID(String contactID)
	{
		return m_dao.searchByContactID(contactID);
	}
	
	////////////////////////////////////////////////////////////////////////
	public UserVO selectByID(String id, String pw)
	{
		return m_dao.login(id, pw);
	}
	
	public UserVO selectByName(String id, String name)
	{
		return m_dao.selectByID(id, name);
	}
	/////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<RelationVO> searchRelationByUserID(String userID )
	{
		return m_dao.searchRelationByUserID(userID);
	}
}
