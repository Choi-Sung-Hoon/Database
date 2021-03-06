package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.model_Article;

public class dao_Article
{
	public static dao_Article instance = null;
	private DBConnect db;
	
	public dao_Article()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Article getInstance()
	{
		if(instance == null)
			instance = new dao_Article();
		return instance;
	}
	
	public void insert(model_Article a)
	{
		Connection conn = null;
		String sql = "insert into article values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, a.getId());
			pstmt.setInt(2, a.getArticleNumber());
			pstmt.setString(3, a.getArticleName());
			pstmt.setString(4, a.getAuthor());
			pstmt.setDate(5, a.getWriteDate());
			
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
	
	public model_Article select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from article where id = ?";
		PreparedStatement pstmt = null;
		model_Article a = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				a = new model_Article(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5));
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
				return a;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void update(model_Article a)
	{
		Connection conn = null;
		String sql = "update article set article_number = ?, article_name = ?, author = ?, write_date = ? where id = ? and article_number = ?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, a.getArticleNumber());
			pstmt.setString(2, a.getArticleName());
			pstmt.setString(3, a.getAuthor());
			pstmt.setDate(4, a.getWriteDate());
			pstmt.setString(5, a.getId());
			pstmt.setInt(6, a.getArticleNumber());
			
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
		String sql = "delete from article where id = ?";
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
	
	public int getRowCount()
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select count(*) from article";
		PreparedStatement pstmt = null;
		int count = 0;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
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
				return count;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return count;
	}
}
