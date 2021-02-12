package com.dakso.contact;

public class RelationVO
{
	private String realation_type;
	private String relation_name;
	private String userid;
	
	public RelationVO()
	{
		
	}
	
	public RelationVO(String relation_type, String relation_name, String userid)
	{
		this.realation_type = relation_type;
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
	
	public String getRealation_type()
	{
		return realation_type;
	}
	
	public void setRealation_type(String realation_type)
	{
		this.realation_type = realation_type;
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
