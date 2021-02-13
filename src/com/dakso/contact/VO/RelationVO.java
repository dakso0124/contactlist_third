package com.dakso.contact.VO;

public class RelationVO
{
	private String relation_key;
	private String relation_name;
	private String userid;
	
	public RelationVO()
	{
		
	}
	
	public RelationVO(String realation_key, String relation_name, String userid)
	{
		this.relation_key = realation_key;
		this.relation_name = relation_name;
		this.userid = userid;
	}
	
	public String getRelation_name()
	{
		return relation_name;
	}
	
	public void setRelation_name(String relation_name)
	{
		this.relation_name = relation_name;
	}
	
	public String getRealation_key()
	{
		return relation_key;
	}
	
	public void setRealation_key(String realation_key)
	{
		this.relation_key = realation_key;
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
