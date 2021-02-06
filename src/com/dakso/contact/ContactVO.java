package com.dakso.contact;

public class ContactVO
{
	private int    memberID;		// unique
	private String name;			// Not Null
	private String phone;			// pk
	private String relation_type;	// fk
	private String relation_name;	// not null
	
	public int getMemberID()
	{
		return memberID;
	}
	
	public void setMemberID(int memberID)
	{
		this.memberID = memberID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getRelation_type()
	{
		return relation_type;
	}
	
	public void setRelation_type(String relation_type)
	{
		this.relation_type = relation_type;
	}
	
	public String getRelation_name()
	{
		return relation_name;
	}
	
	public void setRelation_name(String relation_name)
	{
		this.relation_name = relation_name;
	}
}