package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Internship;

public class dao_Internship
{
	public static dao_Internship instance = null;
	private DBConnect db;
	
	public dao_Internship()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Internship getInstance()
	{
		if(instance == null)
			instance = new dao_Internship();
		return instance;
	}
	
	public void insert(model_Internship i)
	{
		Connection conn = null;
		String sql = "insert into internship values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, i.getId());
			pstmt.setString(2, i.getCompanyName());
			pstmt.setDate(3, i.getStartDate());
			pstmt.setDate(4, i.getEndDate());
			
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
	
	public List<model_Internship> select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from internship where id = ?";
		PreparedStatement pstmt = null;
		List<model_Internship> list = new ArrayList<model_Internship>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Internship i = new model_Internship(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
				list.add(i);
			}
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
				return list;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void update(model_Internship i)
	{
		Connection conn = null;
		String sql = "update internship set company_date=?, start_date=?, end_date=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, i.getCompanyName());
			pstmt.setDate(2, i.getStartDate());
			pstmt.setDate(3, i.getEndDate());
			pstmt.setString(4, i.getId());
			
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
		String sql = "delete from internship where id = ?";
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
