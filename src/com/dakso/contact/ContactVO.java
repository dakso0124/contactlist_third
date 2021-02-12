package com.dakso.contact;

public class ContactVO
{
	private int    memberID;		// unique
	private String name;			// Not Null
	private String phone;			// pk
	private String address;
	private String relation_name;	// not null
	private String userid;
	
	public ContactVO(int memberId, String name, String phone, String address, 
					 String relation_name, String userID)
	{
		this.memberID = memberId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.relation_name = relation_name;
		this.userid = userID;
	}
	
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
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getRelation_name()
	{
		return relation_name;
	}
	
	public void setRelation_name(String relation_name)
	{
		this.relation_name = relation_name;
	}
	
	public String getUserid()
	{
		return userid;
	}
	
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
}