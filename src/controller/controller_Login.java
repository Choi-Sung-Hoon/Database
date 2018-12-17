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

	// see HttpServlet #HttpServlet()
	public controller_Login()
	{
		super();
	}

	// see HttpServlet #doGet()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// set encoding of request and response
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		// 기능제공을 위한 서비스 객체 생성
		dao_Members service = new dao_Members();
		boolean flag = false;
		// 세션 생성
		HttpSession session = request.getSession();

		// 로그인 요청 data읽기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("aaaaaa: " + id + " " + password);
		
		// id로 멤버 검색
		model_Members m = service.select(id);
		if (m != null && password.equals(m.getPassword()))
		{
			session.setAttribute("id", id);
			flag = true;
		}
		session.setAttribute("flag", flag);

		// index.jsp로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		if (dispatcher != null)
		{
			dispatcher.forward(request, response);
		}
	}

	// see HttpServlet #doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}