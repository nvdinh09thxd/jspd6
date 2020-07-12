package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XuLyMuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XuLyMuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("baihoclop/muahoa/muahoa.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String tenHoa = request.getParameter("atenHoa");
		int soLuong = Integer.parseInt(request.getParameter("asoLuong"));
		double donGia = Double.parseDouble(request.getParameter("adonGia"));
		double thanhTien = soLuong * donGia;

		out.print("<h3>Thanh toán sản phẩm</h3>");
		out.print("<p>Tên hoa: " + tenHoa + "</p>");
		out.print("<p>Số lượng: " + soLuong + "</p>");
		out.print("<p>Giá bán: " + donGia + "</p>");
		out.print("<p>Thành tiền: " + thanhTien + "</p>");
	}

}
