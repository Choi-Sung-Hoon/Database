package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_Rest;
import model.model_Rest;

@WebServlet("/controller_Rest")
public class controller_Rest extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_Rest()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// set encoding of request and response
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		
		// create service object
		dao_Rest service = dao_Rest.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		Date start_date = Date.valueOf(request.getParameter("start_date"));
		Date end_date = Date.valueOf(request.getParameter("end_date"));
		
		// create member object with the parameters
		model_Rest r = new model_Rest(id, start_date, end_date);
		
		// do the register action
		if(service.select(id) != null)
			service.update(r);
		else
			service.insert(r);
		
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