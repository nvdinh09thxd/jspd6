package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Comment> listCmt = new ArrayList<>();

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
		if (!"".equals(fullName) && !"".equals(comment)) {
			listCmt.add(new Comment(0, fullName, comment));
			request.getSession().setAttribute("listCmt", listCmt);
		}
	}

}