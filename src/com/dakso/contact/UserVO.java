package com.dakso.contact;

public class UserVO
{
	private String userid;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String join_date;
	
	public UserVO()
	{
		
	}
	
	public UserVO(String userid, String password, String name, String phone, String address, String join_date)
	{
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.join_date = join_date;
	}
	
	public String getUserid()
	{
		return userid;
	}
	
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
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
		return phone.substring(0, 3);
	}
	
	public String getPhone2()
	{
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
		return phone.substring(phone.length() - 4);
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getZipcode()
	{
		return address.split("`")[0];
	}
	
	public String getMainaddress()
	{
		return address.split("`")[1];
	}
	
	public String getDetailaddress()
	{
		return address.split("`")[2];
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getJoin_date()
	{
		return join_date;
	}
	
	public void setJoin_date(String join_date)
	{
		this.join_date = join_date;
	}
}
