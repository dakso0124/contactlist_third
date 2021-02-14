package com.dakso.contact.VO;

public class ContactVO
{
	private int    contactID;		// unique
	private String name;			// Not Null
	private String phone;			// pk
	private String memo;
	private String relation_name;	// not null
	private String relation_key;	// not null
	private String userid;
	
	public ContactVO()
	{
		
	}
	
	public ContactVO(int memberId, String name, String phone, String memo, String relation_key,
					 String relation_name, String userID)
	{
		this.contactID = memberId;
		this.name = name;
		this.phone = phone;
		this.memo = memo;
		this.relation_key = relation_key;
		this.relation_name = relation_name;
		this.userid = userID;
	}
	
	public ContactVO(String name, String phone, String memo, String relation_key,
			 String relation_name, String userID)
	{
		this.name = name;
		this.phone = phone;
		this.memo = memo;
		this.relation_key = relation_key;
		this.relation_name = relation_name;
		this.userid = userID;
	}
	
	public int getContactID()
	{
		return contactID;
	}
	
	public void setContactID(int contactID)
	{
		this.contactID = contactID;
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
	
	public String getPhone1()
	{
		if(phone.isEmpty())
			return null;
		
		return phone.substring(0, 3);
	}
	
	public String getPhone2()
	{
		if(phone.isEmpty())
			return null;
		
		if(phone.length() == 11)
		{
			return phone.substring(3, 7);
		}
		else
		{
			return phone.substring(3, 6);
		}
	}
	
	public String getPhone3()
	{
		if(phone.isEmpty())
			return null;
		
		return phone.substring(phone.length() - 4);
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getMemo()
	{
		return memo;
	}
	
	public void setMemo(String memo)
	{
		this.memo = memo;
	}
	
	public String getRealation_key()
	{
		return relation_key;
	}
	
	public void setRealation_key(String realation_key)
	{
		this.relation_key = realation_key;
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