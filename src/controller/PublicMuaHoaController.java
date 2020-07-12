package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

public class PublicMuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Hoa> listHoa = new ArrayList<>();

	public PublicMuaHoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("baitap/BT1/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String idStr = request.getParameter("aid");
		String tenHoa = request.getParameter("aten");
		String soLuongStr = request.getParameter("asoluong");
		String giaBanStr = request.getParameter("agia");
		
		if (idStr == "" || tenHoa == "" || soLuongStr == "" || giaBanStr == "") {
			out.print("<p style='color: red'>Vui lòng nhập đầy đủ thông tin vào!</p>");
			return;
		}
		int id = 0, soLuong = 0;
		float giaBan = 0;
		try {
			id = Integer.parseInt(idStr);
			if (id < 0)
				throw new Exception();
			soLuong = Integer.parseInt(soLuongStr);
			if (soLuong < 0)
				throw new Exception();
			giaBan = Float.parseFloat(giaBanStr);
			if (giaBan < 0)
				throw new Exception();
		} catch (Exception e) {
			out.print("<p style='color: red'>Yêu cầu nhập số nguyên lớn hơn hoặc bằng 0!</p>");
			return;
		}

		boolean check = false;
		for (Hoa itemHoa : listHoa) {
			if (itemHoa.getId() == id) {
				itemHoa.setSoLuong(soLuong + itemHoa.getSoLuong());
				check = true;
				break;
			}
		}

		if (!check) {
			Hoa hoa = new Hoa(id, tenHoa, soLuong, giaBan);
			listHoa.add(hoa);
		}

		HttpSession session = request.getSession();
		session.setAttribute("listHoa", listHoa);
		out.print("<p style='color: green'>Đã mua thành công: " + tenHoa + "</p>");
	}

}