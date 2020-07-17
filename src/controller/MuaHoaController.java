package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/muahoalop")
public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("baihoclop/muahoa/muahoa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// xư lý mua hoa
		PrintWriter out = response.getWriter();
		// lấy tenhoa, soluong, gia ban, => tính thanh tien = soluong* giaban;
		String tenHoa = request.getParameter("tenHoa");
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		float donGia = Float.parseFloat(request.getParameter("donGia"));
		float thanhTien = soLuong * donGia;
		out.print("<h3>Thông tin đơn hàng:</h3>");
		out.print("<p>Tên hoa : <strong style='color: green'>" + tenHoa + "</strong></p>");
		out.print("<p>Số lượng : <strong style='color: blue'>" + soLuong + "</strong></p>");
		out.print("<p>Giá bán : <strong style='color: yellow'>" + donGia + "</strong></p>");
		out.print("<p>Thành tiền : <strong style='color: pink'>" + thanhTien + "</strong></p>");

	}

}
