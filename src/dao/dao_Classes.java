package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Classes;

public class dao_Classes
{
	public static dao_Classes instance = null;
	private DBConnect db;
	
	public dao_Classes()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Classes getInstance()
	{
		if(instance == null)
			instance = new dao_Classes();
		return instance;
	}
	
	public List<model_Classes> select()
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from classes";
		PreparedStatement pstmt = null;
		List<model_Classes> list = new ArrayList<model_Classes>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Classes c = new model_Classes(rs.getString(1), rs.getString(2));
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
}
