package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Has;

public class dao_Has
{
	public static dao_Has instance = null;
	private DBConnect db;
	
	public dao_Has()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Has getInstance()
	{
		if(instance == null)
			instance = new dao_Has();
		return instance;
	}
	
	public void insert(model_Has h)
	{
		Connection conn = null;
		String sql = "insert into has values(?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, h.getId());
			pstmt.setString(2, h.getLicenseName());
			pstmt.setInt(3, h.getScore());
			
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
	
	public List<model_Has> select(String id, String license_name)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql;
		if(license_name == null)
			sql = "select * from has where id = ?";
		else
			sql = "select * from has where id = ? and license_name = ?";
		PreparedStatement pstmt = null;
		List<model_Has> list = new ArrayList<model_Has>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(license_name == null)
				pstmt.setString(1, id);
			else
			{
				pstmt.setString(1, id);
				pstmt.setString(2, license_name);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Has c = new model_Has(rs.getString(1), rs.getString(2), rs.getInt(3));
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
	
	public void update(model_Has h)
	{
		Connection conn = null;
		String sql = "update has set license_name=?, score=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, h.getLicenseName());
			pstmt.setInt(2, h.getScore());
			pstmt.setString(3, h.getId());
			
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
		String sql = "delete from has where id = ?";
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
