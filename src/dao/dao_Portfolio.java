package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Article;

public class dao_Portfolio
{
	public static dao_Portfolio instance = null;
	private DBConnect db;
	
	public dao_Portfolio()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Portfolio getInstance()
	{
		if(instance == null)
			instance = new dao_Portfolio();
		return instance;
	}
	
	public List<model_Article> select()
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from article";
		PreparedStatement pstmt = null;
		List<model_Article> list = new ArrayList<model_Article>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Article a = new model_Article(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				list.add(a);
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
}
