package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_Members;
import model.model_Members;

@WebServlet("/controller_Members")
public class controller_Members extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_Members()
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
		dao_Members service = dao_Members.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		String password = request.getParameter("password");
		String student_number = request.getParameter("studentNumber");
		String student_name = request.getParameter("studentName");
		String degree = request.getParameter("degree");
		String major_name = request.getParameter("majorName");
		
		// create member object with the parameters
		model_Members m = new model_Members(id, password, Integer.valueOf(student_number), student_name, Integer.valueOf(degree), major_name);
		
		// do the register action
		service.update(m);
		
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
