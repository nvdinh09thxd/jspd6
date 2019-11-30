package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PublicActiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicActiveController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/activetin/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String src = request.getParameter("asrc");
		PrintWriter out = response.getWriter();
		int idx = src.lastIndexOf("/");
		String firstName = src.substring(0, idx + 1);
		String lastName = src.substring(idx + 1);
		String fileName = "";
		if (lastName.equals("active.gif")) {
			fileName = firstName + "deactive.gif";
		} else {
			fileName = firstName + "active.gif";
		}
		out.print(fileName);
	}

}
