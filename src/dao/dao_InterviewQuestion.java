package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.model_InterviewQuestion;

public class dao_InterviewQuestion
{
	public static dao_InterviewQuestion instance = null;
	private DBConnect db;
	
	public dao_InterviewQuestion()
	{
		db = DBConnect.getInstance();
	}
	
	public static dao_InterviewQuestion getInstance()
	{
		if(instance == null)
			instance = new dao_InterviewQuestion();
		return instance;
	}
	
	public void insert(model_InterviewQuestion i)
	{
		Connection conn = null;
		String sql = "insert into interviewquestion values(?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, i.getId());
			pstmt.setString(2, i.getCompanyName());
			pstmt.setString(3, i.getQuestion());
			
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
	
	public List<model_InterviewQuestion> select(String id)
	{
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from interviewquestion where id = ?";
		PreparedStatement pstmt = null;
		List<model_InterviewQuestion> list = new ArrayList<model_InterviewQuestion>();
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				model_InterviewQuestion i = new model_InterviewQuestion(rs.getString(1), rs.getString(2), rs.getString(3));
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
	
	public void update(model_InterviewQuestion i)
	{
		Connection conn = null;
		String sql = "update interviewquestion set company_name=?, question=? where id=?";
		PreparedStatement pstmt = null;
		
		try
		{
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, i.getCompanyName());
			pstmt.setString(2, i.getQuestion());
			pstmt.setString(3, i.getId());
			
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
		String sql = "delete from interviewquestion where id = ?";
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
