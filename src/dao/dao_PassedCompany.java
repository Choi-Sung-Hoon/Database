package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_PassedCompany;

public class dao_PassedCompany
{
	public static dao_PassedCompany instance = null;
	private DBConnect db;
	
	public dao_PassedCompany()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_PassedCompany getInstance()
	{
		if(instance == null)
			instance = new dao_PassedCompany();
		return instance;
	}
	
	public void insert(model_PassedCompany p)
	{
		Connection conn = null;
		String sql = "insert into passedcompany values(?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, p.getId());
			pstmt.setString(2, p.getCompanyName());
			
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
	
	public List<model_PassedCompany> select(String id, String company_name)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql;
		if(company_name == null)
			sql = "select * from passedcompany where id = ?";
		else
			sql = "select * from passedcompany where id = ? and company_name = ? ";
		PreparedStatement pstmt = null;
		List<model_PassedCompany> list = new ArrayList<model_PassedCompany>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(company_name == null)
				pstmt.setString(1, id);
			else
			{
				pstmt.setString(1, id);
				pstmt.setString(2, company_name);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_PassedCompany p = new model_PassedCompany(rs.getString(1), rs.getString(2));
				list.add(p);
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
	
	public void update(model_PassedCompany p)
	{
		Connection conn = null;
		String sql = "update passedcompany set company_name=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getCompanyName());
			pstmt.setString(2, p.getId());
			
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
		String sql = "delete from passedcompany where id = ?";
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
