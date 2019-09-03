package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao_Took;
import model.model_Took;

@WebServlet("/controller_Took")
public class controller_Took extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public controller_Took()
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
		dao_Took service = dao_Took.getInstance();
		
		// create session
		HttpSession session = request.getSession(false);

		// read login data
		String id = (String)session.getAttribute("id");
		
		// read parameters
		String class_code = request.getParameter("class_code");
		String class_name = request.getParameter("class_name");
		String grade = request.getParameter("grade");
		
		// create member object with the parameters
		model_Took p = new model_Took(id, class_code, class_name, grade);
		
		// do the register action
		if(service.select(id, class_name).size() != 0)
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