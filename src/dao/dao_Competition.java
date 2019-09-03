package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Competition;

public class dao_Competition
{
	public static dao_Competition instance = null;
	private DBConnect db;
	
	public dao_Competition()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Competition getInstance()
	{
		if(instance == null)
			instance = new dao_Competition();
		return instance;
	}
	
	public void insert(model_Competition c)
	{
		Connection conn = null;
		String sql = "insert into competition values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getCompetitionName());
			pstmt.setString(3, c.getPrize());
			pstmt.setDate(4, c.getCompetitionDate());
			
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
	
	public List<model_Competition> select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from competition where id = ?";
		PreparedStatement pstmt = null;
		List<model_Competition> list = new ArrayList<model_Competition>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Competition c = new model_Competition(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
				list.add(c);
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
	
	public void update(model_Competition m)
	{
		Connection conn = null;
		String sql = "update competition set competition_name=?, prize=?, competition_date=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getCompetitionName());
			pstmt.setString(2, m.getPrize());
			pstmt.setDate(3, m.getCompetitionDate());
			pstmt.setString(4, m.getId());
			
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
		String sql = "delete from competition where id = ?";
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
