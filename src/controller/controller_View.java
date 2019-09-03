package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao_Competition;
import dao.dao_Has;
import dao.dao_Internship;
import dao.dao_InterviewQuestion;
import dao.dao_Members;
import dao.dao_MultipleMajor;
import dao.dao_Participating;
import dao.dao_PassedCompany;
import dao.dao_Rest;
import dao.dao_Took;
import dao.dao_Volunteer;
import model.model_Competition;
import model.model_Has;
import model.model_Internship;
import model.model_InterviewQuestion;
import model.model_Members;
import model.model_MultipleMajor;
import model.model_Participating;
import model.model_PassedCompany;
import model.model_Rest;
import model.model_Took;
import model.model_Volunteer;

@WebServlet("/controller_View")
public class controller_View extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public controller_View()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		model_Members member = null;
		List<model_Competition> list_Competition = null;
		List<model_Internship> list_Internship = null;
		List<model_Volunteer> list_Volunteer = null;
		model_Rest rest = null;
		model_MultipleMajor multipleMajor = null;
		List<model_PassedCompany> list_PassedCompany = null;
		List<model_InterviewQuestion> list_InterviewQuestion = null;
		List<model_Took> list_Took = null;
		List<model_Participating> list_Participating = null;
		List<model_Has> list_Has = null;
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		dao_Members service_Members = dao_Members.getInstance();
		dao_Competition service_Competition = dao_Competition.getInstance();
		dao_Internship service_Internship = dao_Internship.getInstance();
		dao_Volunteer service_Volunteer = dao_Volunteer.getInstance();
		dao_Rest service_Rest = dao_Rest.getInstance();
		dao_MultipleMajor service_MultipleMajor = dao_MultipleMajor.getInstance();
		dao_PassedCompany service_PassedCompany = dao_PassedCompany.getInstance();
		dao_InterviewQuestion service_InterviewQuestion = dao_InterviewQuestion.getInstance();
		dao_Took service_Took = dao_Took.getInstance();
		dao_Participating service_Participating = dao_Participating.getInstance();
		dao_Has service_Has = dao_Has.getInstance();
		
		// read parameter
		String author = request.getParameter("author");
		
		member = service_Members.select(author);
		list_Competition = service_Competition.select(author);
		list_Internship = service_Internship.select(author);
		list_Volunteer = service_Volunteer.select(author);
		rest = service_Rest.select(author);
		multipleMajor = service_MultipleMajor.select(author);
		list_PassedCompany = service_PassedCompany.select(author, null);
		list_InterviewQuestion = service_InterviewQuestion.select(author);
		list_Took = service_Took.select(author, null);
		list_Participating = service_Participating.select(author);
		list_Has = service_Has.select(author, null);
		
		request.setAttribute("member", member);
		request.setAttribute("list_Competition", list_Competition);
		request.setAttribute("list_Internship", list_Internship);
		request.setAttribute("list_Volunteer", list_Volunteer);
		request.setAttribute("rest", rest);
		request.setAttribute("multipleMajor", multipleMajor);
		request.setAttribute("list_PassedCompany", list_PassedCompany);
		request.setAttribute("list_InterviewQuestion", list_InterviewQuestion);
		request.setAttribute("list_Took", list_Took);
		request.setAttribute("list_Participating", list_Participating);
		request.setAttribute("list_Has", list_Has);
		
		// successful login
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
		if (dispatcher != null)
			dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
