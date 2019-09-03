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

import dao.dao_Competition;
import model.model_Competition;

@WebServlet("/controller_Competition")
public class controller_Competition extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_Competition()
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
		dao_Competition service = dao_Competition.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		String competitionName = request.getParameter("competitionName");
		String prize = request.getParameter("prize");
		Date competitionDate = Date.valueOf(request.getParameter("competitionDate"));
		
		// create member object with the parameters
		model_Competition c = new model_Competition(id, competitionName, prize, competitionDate);
		
		// do the register action
		if(service.select(id).size() != 0)
			service.update(c);
		else
			service.insert(c);
		
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