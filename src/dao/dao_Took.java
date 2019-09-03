package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Took;

public class dao_Took
{
	public static dao_Took instance = null;
	private DBConnect db;
	
	public dao_Took()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Took getInstance()
	{
		if(instance == null)
			instance = new dao_Took();
		return instance;
	}
	
	public void insert(model_Took t)
	{
		Connection conn = null;
		String sql = "insert into took values(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, t.getId());
			pstmt.setString(2, t.getCode());
			pstmt.setString(3, t.getClassName());
			pstmt.setString(4, t.getGrade());
			
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
	
	public List<model_Took> select(String id, String class_name)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql;
		if(class_name == null)
			sql = "select * from took where id = ?";
		else
			sql = "select * from took where id = ? and class_name=?";
		PreparedStatement pstmt = null;
		List<model_Took> list = new ArrayList<model_Took>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(class_name == null)
				pstmt.setString(1, id);
			else
			{
				pstmt.setString(1, id);
				pstmt.setString(2, class_name);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Took i = new model_Took(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
	
	public void update(model_Took t)
	{
		Connection conn = null;
		String sql = "update took set class_code=?, class_name=?, grade=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, t.getCode());
			pstmt.setString(2, t.getClassName());
			pstmt.setString(3, t.getGrade());
			pstmt.setString(4, t.getId());
			
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
		String sql = "delete from took where id = ?";
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
