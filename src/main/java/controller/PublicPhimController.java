package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PublicPhimController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicPhimController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("baitap/BT3/youtube.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("aid"));
		PrintWriter out = response.getWriter();
		switch (id) {
		case 1:
			out.print("https://www.youtube.com/embed/NVFQ8eRHJsk");
			break;
		case 2:
			out.print("https://www.youtube.com/embed/BSrWy-8-XBw");
			break;
		case 3:
			out.print("https://www.youtube.com/embed/NVFQ8eRHJsk");
			break;
		case 4:
			out.print("https://www.youtube.com/embed/BSrWy-8-XBw");
			break;
		case 5:
			out.print("https://www.youtube.com/embed/NVFQ8eRHJsk");
			break;
		}
	}

}
