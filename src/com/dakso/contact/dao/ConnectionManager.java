package com.dakso.contact.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionManager
{
	private static ConnectionManager instance;
	public static ConnectionManager getInstance()
	{
		if(instance == null)
			instance = new ConnectionManager();
		return instance;
	}
	
	private ConnectionManager()
	{
		
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ora_user";
		String pw = "hong";
		
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		try
		{
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}