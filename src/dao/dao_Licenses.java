package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_Licenses;

public class dao_Licenses
{
	public static dao_Licenses instance = null;
	private DBConnect db;
	
	public dao_Licenses()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_Licenses getInstance()
	{
		if(instance == null)
			instance = new dao_Licenses();
		return instance;
	}
	
	public List<model_Licenses> select()
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from licenses";
		PreparedStatement pstmt = null;
		List<model_Licenses> list = new ArrayList<model_Licenses>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_Licenses c = new model_Licenses(rs.getString(1));
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
