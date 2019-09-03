package controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_Article;
import model.model_Article;

@WebServlet("/controller_Article")
public class controller_Article extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public controller_Article()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		// create service object
		dao_Article service = dao_Article.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		int count = service.getRowCount();
		String article_name = request.getParameter("article_name");
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
		
		// create member object with the parameters
		
		// do the register action
	    model_Article a;
		if(service.select(id) != null)
		{
			a = new model_Article(id, count, article_name, id, date);
			service.update(a);
		}
		else
		{
			a = new model_Article(id, count + 1, article_name, id, date);
			service.insert(a);
		}
		
		// set attribute of the request
		request.setAttribute("id", id);
		
		// index.jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/controller_MyPage");
		if (dispatcher != null)
			dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}