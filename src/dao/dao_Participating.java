package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Participating;

public class dao_Participating
{
	public static dao_Participating instance = null;
	private DBConnect db;
	
	public dao_Participating()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Participating getInstance()
	{
		if(instance == null)
			instance = new dao_Participating();
		return instance;
	}
	
	public void insert(model_Participating p)
	{
		Connection conn = null;
		String sql = "insert into participating values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getClubName());
			pstmt.setDate(3, p.getStartDate());
			pstmt.setDate(4, p.getEndDate());
			
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
	
	public List<model_Participating> select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from participating where id = ?";
		PreparedStatement pstmt = null;
		List<model_Participating> list = new ArrayList<model_Participating>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Participating i = new model_Participating(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4));
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
	
	public void update(model_Participating p)
	{
		Connection conn = null;
		String sql = "update participating set club_name=?, start_date=?, end_date=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getClubName());
			pstmt.setDate(2, p.getStartDate());
			pstmt.setDate(3, p.getEndDate());
			pstmt.setString(4, p.getId());
			
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
		String sql = "delete from participating where id = ?";
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
