package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("baihoclop/comment/comment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fullName = request.getParameter("afullName");
		String comment = request.getParameter("acmt");
		PrintWriter out = response.getWriter();
		out.print("<p class='name-cmt'>" + fullName + "</p>");
		out.print("<p class='content-cmt'>" + comment + "</p>");
		out.print("<p class=time-cmt>10PM 29/09/2015</p>");
	}

}