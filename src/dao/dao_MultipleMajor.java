package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.model_MultipleMajor;

public class dao_MultipleMajor
{
	public static dao_MultipleMajor instance = null;
	private DBConnect db;
	
	public dao_MultipleMajor()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_MultipleMajor getInstance()
	{
		if(instance == null)
			instance = new dao_MultipleMajor();
		return instance;
	}
	
	public void insert(model_MultipleMajor m)
	{
		Connection conn = null;
		String sql = "insert into multiplemajor values(?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getMajorName());
			
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
	
	public model_MultipleMajor select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from multiplemajor where id = ?";
		PreparedStatement pstmt = null;
		model_MultipleMajor m = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				m = new model_MultipleMajor(rs.getString(1), rs.getString(2));
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
				return m;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void update(model_MultipleMajor m)
	{
		Connection conn = null;
		String sql = "update multiplemajor set major_name=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMajorName());
			pstmt.setString(2, m.getId());
			
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
		String sql = "delete from multiplemajor where id = ?";
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
