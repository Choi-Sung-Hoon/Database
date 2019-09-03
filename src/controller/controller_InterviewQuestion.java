package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_InterviewQuestion;
import model.model_InterviewQuestion;

@WebServlet("/controller_InterviewQuestion")
public class controller_InterviewQuestion extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_InterviewQuestion()
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
		dao_InterviewQuestion service = dao_InterviewQuestion.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		String company_name = request.getParameter("company_name");
		String question = request.getParameter("question");
		
		// create member object with the parameters
		model_InterviewQuestion p = new model_InterviewQuestion(id, company_name, question);
		
		// do the register action
		if(service.select(id).size() != 0)
			service.update(p);
		else
			service.insert(p);
		
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