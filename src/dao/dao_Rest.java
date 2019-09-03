package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.model_Rest;

public class dao_Rest
{
	public static dao_Rest instance = null;
	private DBConnect db;
	
	public dao_Rest()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Rest getInstance()
	{
		if(instance == null)
			instance = new dao_Rest();
		return instance;
	}
	
	public void insert(model_Rest r)
	{
		Connection conn = null;
		String sql = "insert into rest values(?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, r.getId());
			pstmt.setDate(3, r.getStartDate());
			pstmt.setDate(4, r.getEndDate());
			
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
	
	public model_Rest select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from rest where id = ?";
		PreparedStatement pstmt = null;
		model_Rest r = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				r = new model_Rest(rs.getString(1), rs.getDate(2), rs.getDate(3));
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
				return r;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void update(model_Rest r)
	{
		Connection conn = null;
		String sql = "update rest set start_date=?, end_date=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, r.getStartDate());
			pstmt.setDate(2, r.getEndDate());
			pstmt.setString(3, r.getId());
			
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
		String sql = "delete from rest where id = ?";
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
