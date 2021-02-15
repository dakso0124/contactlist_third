package com.dakso.contact.service;

import java.util.ArrayList;

import com.dakso.contact.VO.ContactVO;
import com.dakso.contact.VO.RelationVO;
import com.dakso.contact.VO.UserVO;
import com.dakso.contact.dao.ContactDAO;

public class UserService 
{
	private ContactDAO m_dao = new ContactDAO();
	
	
	//////////////////////////////////////////////////////////////////////// contact
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
	
	public String checkContactPhone(String phone, String userid)
	{
		return m_dao.checkContactPhone(phone, userid);
	}
	
	public int insertContact(ContactVO contact)
	{
		return m_dao.insertContact(contact);
	}
	
	public int updateContact(ContactVO contact)
	{
		return m_dao.updateContact(contact);
	}
	
	public int deleteContact(String contactID)
	{
		return m_dao.deleteContact(contactID);
	}
	////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////// user
	public int addUser(UserVO member)
	{
		return m_dao.addUser(member);
	}
	
	public int updateUser(UserVO member)
	{
		return m_dao.updateUser(member);
	}

	public UserVO selectByID(String id, String pw)
	{
		return m_dao.login(id, pw);
	}
	
	public UserVO selectByName(String id, String name)
	{
		return m_dao.selectByID(id, name);
	}
	////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////// relation
	public ArrayList<RelationVO> searchRelationByUserID(String userID )
	{
		return m_dao.searchRelationByUserID(userID);
	}
	
	public int addRelation(String relation_name, String userID)
	{
		return m_dao.addRelation(relation_name, userID);
	}
	
	public RelationVO searchRelationByName(String relation_name, String userID)
	{
		return m_dao.searchRelationByName(relation_name, userID);
	}
	////////////////////////////////////////////////////////////////////////
}
