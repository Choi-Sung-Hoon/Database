package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao_Classes;
import dao.dao_Clubs;
import dao.dao_Licenses;
import model.model_Classes;
import model.model_Clubs;
import model.model_Licenses;

@WebServlet("/controller_MyPage")
public class controller_MyPage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public controller_MyPage()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<model_Classes> list_Classes = null;
		List<model_Clubs> list_Clubs = null;
		List<model_Licenses> list_Licenses = null;
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");

		dao_Classes service_Classes = dao_Classes.getInstance();
		dao_Clubs service_Clubs = dao_Clubs.getInstance();
		dao_Licenses service_Licenses = dao_Licenses.getInstance();
		
		list_Classes = service_Classes.select();
		list_Clubs = service_Clubs.select();
		list_Licenses = service_Licenses.select();
		
		request.setAttribute("list_Classes", list_Classes);
		request.setAttribute("list_Clubs", list_Clubs);
		request.setAttribute("list_Licenses", list_Licenses);
		
		// successful login
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mypage.jsp");
		if (dispatcher != null)
			dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
