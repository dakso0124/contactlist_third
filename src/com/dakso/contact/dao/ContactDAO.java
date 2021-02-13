package com.dakso.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.dakso.contact.VO.ContactVO;
import com.dakso.contact.VO.RelationVO;
import com.dakso.contact.VO.UserVO;

public class ContactDAO
{
	public int addUser(UserVO member)
	{
		int result = 0;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into userinfo										");
		sql.append("values( ? , ? , ? , ? , ? , TO_CHAR(SYSDATE, 'YYYYMMDD'))	");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			
			result = pstmt.executeUpdate();
		}
		catch (SQLTimeoutException e)
		{
			System.out.println("TimeOut Exception");
		}
		catch (SQLException e)
		{
			if(e.getMessage().contains("value too large"))	// value overflow
			{
				
			}
			else
			{
				Logger.getGlobal().warning("연락처 추가 도중 문제가 발생하였습니다." + e.getMessage());	
			}
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public int updateUser(UserVO member)
	{
		int result = 0;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		
		sql.append("update userinfo		");
		sql.append("   set name = ?		");
		sql.append("     , phone = ?	");
		sql.append("     , address = ?	");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddress());
			
			result = pstmt.executeUpdate();
		}
		catch (SQLTimeoutException e)
		{
			System.out.println("TimeOut Exception");
		}
		catch (SQLException e)
		{
			if(e.getMessage().contains("value too large"))	// value overflow
			{
				
			}
			else
			{
				Logger.getGlobal().warning("연락처 추가 도중 문제가 발생하였습니다." + e.getMessage());	
			}
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public UserVO login(String id, String pw)
	{
		UserVO result = null;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select userid			");
		sql.append("     , password 		");
		sql.append("     , name				");
		sql.append("     , phone			");
		sql.append("     , address 			");
		sql.append("     , join_date		");
		sql.append("  from userinfo			");
		sql.append(" where userid = ?		");
		sql.append("   and password = ?		");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				result = new UserVO(rs.getString("userid"), rs.getString("password"), rs.getString("name")
												, rs.getString("phone"), rs.getString("address")
												, rs.getString("join_date"));
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("로그인 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public UserVO selectByID(String id, String name)
	{
		UserVO result = null;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select userid			");
		sql.append("     , password 		");
		sql.append("     , name				");
		sql.append("     , phone			");
		sql.append("     , address 			");
		sql.append("     , join_date		");
		sql.append("  from userinfo			");
		sql.append(" where userid = ?		");
		sql.append("   and name = ?			");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				result = new UserVO(rs.getString("userid"), rs.getString("password"), rs.getString("name")
												, rs.getString("phone"), rs.getString("address")
												, rs.getString("join_date"));
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("로그인 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public UserVO modify()
	{
		UserVO result = null;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select count(userid)	");
		sql.append("  from userinfo			");
		sql.append(" where userid = ?		");
		sql.append("   and password = ?		");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				result = new UserVO(rs.getString("userid"), rs.getString("password"), rs.getString("name")
												, rs.getString("phone"), rs.getString("address")
												, rs.getString("join_date"));
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("로그인 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//////////////////////////// contact 
	// 모든 연락처 보기
	public ArrayList<ContactVO> showAll(String userID)
	{
		ArrayList<ContactVO> result = new ArrayList<ContactVO>();
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select c.contactid						");
		sql.append("	 , c.name							");
		sql.append("	 , c.phone							");
		sql.append("	 , c.memo							");
		sql.append("	 , r.relation_key					");
		sql.append("	 , r.relation_name					");
		sql.append("	 , i.userid							");
		sql.append("  from contactlist c					");
		sql.append(" inner join userinfo i					");
		sql.append("    on c.userid = i.userid				");
		sql.append(" inner JOIN relation r					");
		sql.append("    on c.relation_key = r.relation_key	");

		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				ContactVO contact = new ContactVO(rs.getInt("contactid"), rs.getString("name"), rs.getString("phone")
												, rs.getString("memo"), rs.getString("relation_key"),
												rs.getString("relation_name"), rs.getString("userid"));
				
				result.add(contact);
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("연락처 검색중 문제가 발생하였습니다. " + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 이름으로 검색
	public ArrayList<ContactVO> searchByName(String userID, String name)
	{
		ArrayList<ContactVO> result = new ArrayList<ContactVO>();
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;

		StringBuilder sql = new StringBuilder();
		sql.append("select c.contactid						");
		sql.append("	 , c.name							");
		sql.append("	 , c.phone							");
		sql.append("	 , c.memo							");
		sql.append("	 , r.relation_key					");
		sql.append("	 , r.relation_name					");
		sql.append("	 , i.userid							");
		sql.append("  from contactlist c					");
		sql.append(" inner join userinfo i					");
		sql.append("    on c.userid = i.userid				");
		sql.append(" inner JOIN relation r					");
		sql.append("    on c.relation_key = r.relation_key	");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				ContactVO contact = new ContactVO(rs.getInt("contactid"), rs.getString("name"), rs.getString("phone")
												, rs.getString("memo"), rs.getString("relation_key"),
												rs.getString("relation_name"), rs.getString("userid"));

				result.add(contact);
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("연락처 검색 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// contactid로 연락처 검색 ( 수정 )
	public ContactVO searchByContactID(String contactID )
	{
		ContactVO result = null;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;

		StringBuilder sql = new StringBuilder();
		sql.append("select c.contactid						");
		sql.append("	 , c.name							");
		sql.append("	 , c.phone							");
		sql.append("	 , c.memo							");
		sql.append("	 , r.relation_key					");
		sql.append("	 , r.relation_name					");
		sql.append("	 , i.userid							");
		sql.append("  from contactlist c					");
		sql.append(" inner join userinfo i					");
		sql.append("    on c.userid = i.userid				");
		sql.append(" inner JOIN relation r					");
		sql.append("    on c.relation_key = r.relation_key	");
		sql.append(" where c.contactid = ?					");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, contactID);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				result = new ContactVO(rs.getInt("contactid"), rs.getString("name"), rs.getString("phone")
												, rs.getString("memo"), rs.getString("relation_key"),
												rs.getString("relation_name"), rs.getString("userid"));
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("연락처 검색 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	// 연락처 추가
	public int insertContact(ContactVO contact, String userID)
	{
		int result = 0;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		
		// 회원번호는 가장큰수를 select하여 거기에 +1로 지정
		sql.append("insert into contactlist						");
		sql.append("values( NVL( (select max(contactid)			");
		sql.append("				from contactlist) + 1, 1 ) 	");
		sql.append("      , ? , ? , ? , ? , ? )					");
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getPhone());
			pstmt.setString(3, contact.getMemo());
			pstmt.setString(4, contact.getRealation_key());
			pstmt.setString(5, contact.getUserid());
			
			result = pstmt.executeUpdate();
			
			/*
			 * if(result > 0) { result = 1; }
			 */
		}
		catch (SQLTimeoutException e)
		{
			System.out.println("TimeOut Exception");
		}
		catch (SQLException e)
		{
			if(e.getMessage().contains("value too large"))	// value overflow
			{
				result = -1;
			}
			else
			{
				Logger.getGlobal().warning("연락처 추가 도중 문제가 발생하였습니다." + e.getMessage());	
			}
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, null);
		}
		
		return result;
	}
	
	// contactid로 연락처 삭제
	public int deleteContact(String contactID )
	{
		int result = 0;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("delete from contactlist	"); 
		sql.append(" where contactid = ?	");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, contactID);
			result = pstmt.executeUpdate();
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("연락처 삭제 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, null);
		}
		
		return result;
	}
	////////////////////////////////// end contact
	
	//////////////////////// relation
	public int addRelation(String relation_name, String userID)
	{
		int result = 0;
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		
		// 회원번호는 가장큰수를 select하여 거기에 +1로 지정
		sql.append("insert into relation									");
		sql.append("values (NVL(LPAD((select max(relation_key)				");
		sql.append("					from relation) + 1, 3, 0), '001')	");
		sql.append("	 , ? , ? )											");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, relation_name);
			pstmt.setString(2, userID);
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
			{
				result = 1;
			}
		}
		catch (SQLTimeoutException e)
		{
			System.out.println("TimeOut Exception");
		}
		catch (SQLException e)
		{
			if(e.getMessage().contains("value too large"))	// value overflow
			{
				
			}
			else
			{
				Logger.getGlobal().warning("그룹 추가 도중 문제가 발생하였습니다." + e.getMessage());	
			}
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public ArrayList<RelationVO> searchRelationByUserID(String userID )
	{
		ArrayList<RelationVO> result = new ArrayList<RelationVO>();
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;

		StringBuilder sql = new StringBuilder();
		sql.append("select relation_key		");
		sql.append("     , relation_name	");
		sql.append("     , userid			");
		sql.append("  from relation			");
		sql.append(" where userid = ? 		");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				 RelationVO relation = new RelationVO(rs.getString("relation_key"), rs.getString("relation_name"), rs.getString("userid"));
				 
				 result.add(relation);
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("그룹리스트 검색 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public RelationVO searchRelationByName(String relation_name, String userID)
	{
		RelationVO result = new RelationVO();
		
		Connection conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;

		StringBuilder sql = new StringBuilder();
		sql.append("select relation_key		");
		sql.append("     , relation_name	");
		sql.append("     , userid			");
		sql.append("  from relation			");
		sql.append(" where userid = ? 		");
		sql.append("   and relation_name = ? 		");
		
		try
		{
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userID);
			pstmt.setString(2, relation_name);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				result = new RelationVO(rs.getString("relation_key"), rs.getString("relation_name"), rs.getString("userid"));
			}
		}
		catch (SQLTimeoutException e)
		{
			Logger.getGlobal().warning("TimeOut Exception 발생");
		}
		catch (SQLException e)
		{
			Logger.getGlobal().warning("그룹 검색 도중 문제가 발생하였습니다." + e.getMessage());
		}
		finally
		{
			ConnectionManager.getInstance().close(conn, pstmt, rs);
		}
		
		return result;
	}
	////////////////////////////////////////// end relation
}