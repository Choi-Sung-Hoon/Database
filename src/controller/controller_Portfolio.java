package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_Article;
import model.model_Article;

@WebServlet("/controller_Portfolio")
public class controller_Portfolio extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public controller_Portfolio()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		dao_Article service = dao_Article.getInstance();

		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
	
		List<model_Article> list = service.select();
		
		request.setAttribute("id", id);
		request.setAttribute("list", list);
		
		// index.jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/portfolio.jsp");
		if (dispatcher != null)
			dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
