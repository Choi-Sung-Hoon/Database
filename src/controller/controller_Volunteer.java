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

import dao.dao_Volunteer;
import model.model_Volunteer;

@WebServlet("/controller_Volunteer")
public class controller_Volunteer extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_Volunteer()
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
		dao_Volunteer service = dao_Volunteer.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		String volunteer_name = request.getParameter("volunteer_name");
		Date start_date = Date.valueOf(request.getParameter("start_date"));
		Date end_date = Date.valueOf(request.getParameter("end_date"));
		
		// create member object with the parameters
		model_Volunteer v = new model_Volunteer(id, volunteer_name, start_date, end_date);
		
		// do the register action
		if(service.select(id).size() != 0)
			service.update(v);
		else
			service.insert(v);
		
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