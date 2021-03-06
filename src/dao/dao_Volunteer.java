package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Volunteer;

public class dao_Volunteer
{
	public static dao_Volunteer instance = null;
	private DBConnect db;
	
	public dao_Volunteer()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Volunteer getInstance()
	{
		if(instance == null)
			instance = new dao_Volunteer();
		return instance;
	}
	
	public void insert(model_Volunteer v)
	{
		Connection conn = null;
		String sql = "insert into volunteer values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getVolunteerName());
			pstmt.setDate(3, v.getStartDate());
			pstmt.setDate(4, v.getEndDate());
			
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
	
	public List<model_Volunteer> select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from volunteer where id = ?";
		PreparedStatement pstmt = null;
		List<model_Volunteer> list = new ArrayList<model_Volunteer>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Volunteer i = new model_Volunteer(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
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
	
	public void update(model_Volunteer i)
	{
		Connection conn = null;
		String sql = "update volunteer set volunteer_name=?, start_date=?, end_date=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, i.getVolunteerName());
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
