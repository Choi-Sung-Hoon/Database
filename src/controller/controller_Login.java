package controller;

import dao.dao_Members;
import model.model_Members;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controller_Login")
public class controller_Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public controller_Login()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		dao_Members service = dao_Members.getInstance();

		// create session
		boolean flag = false;
		HttpSession session = request.getSession();

		// read login data
		String id = request.getParameter("loginId");
		String password = request.getParameter("loginPassword");
		
		// search member with id
		model_Members m = service.select(id);
		
		// same id & same password = success 
		if (m != null && password.equals(m.getPassword()))
		{
			session.setAttribute("id", id);
			flag = true;
		}
		session.setAttribute("flag", flag);
		
		// successful login
		if(flag)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			if (dispatcher != null)
				dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			if (dispatcher != null)
				dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}