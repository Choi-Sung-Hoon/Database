package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Clubs;

public class dao_Clubs
{
	public static dao_Clubs instance = null;
	private DBConnect db;
	
	public dao_Clubs()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Clubs getInstance()
	{
		if(instance == null)
			instance = new dao_Clubs();
		return instance;
	}
	
	public List<model_Clubs> select()
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from clubs";
		PreparedStatement pstmt = null;
		List<model_Clubs> list = new ArrayList<model_Clubs>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Clubs c = new model_Clubs(rs.getString(1));
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
