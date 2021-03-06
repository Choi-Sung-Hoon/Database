package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.model_Members;

public class dao_Members
{
	public static dao_Members instance = null;
	private DBConnect db;
	
	public dao_Members()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Members getInstance()
	{
		if(instance == null)
			instance = new dao_Members();
		return instance;
	}
	
	public void insert(model_Members m)
	{
		Connection conn = null;
		String sql = "insert into members values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setInt(3, m.getStudentNumber());
			pstmt.setString(4, m.getStudentName());
			pstmt.setInt(5, m.getDegree());
			pstmt.setString(6, m.getMajorName());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public model_Members select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from members where id = ?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return new model_Members(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void update(model_Members m)
	{
		Connection conn = null;
		String sql = "update members set password=?, student_number=?, student_name=?, degree=?, major_name=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getPassword());
			pstmt.setInt(2, m.getStudentNumber());
			pstmt.setString(3, m.getStudentName());
			pstmt.setInt(4, m.getDegree());
			pstmt.setString(5, m.getMajorName());
			pstmt.setString(6, m.getId());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String id)
	{
		Connection conn = null;
		String sql = "delete from members where id = ?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
