package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

@WebServlet("/muahoakha")
public class MuaHoaKhaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Hoa> listHoa = new ArrayList<>();

	public MuaHoaKhaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("baitap/BT1/shopkha.jsp").forward(request, response);
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
		int id = 0, soLuong = 0;
		float giaBan = 0;
		if ("".equals(idStr)) {
			out.print("Vui lòng nhập ID!");
			return;
		} else {
			try {
				id = Integer.parseInt(idStr);
				if (id <= 0)
					throw new Exception();
			} catch (Exception e) {
				out.print("Nhập ID phải là số dương!");
				return;
			}
		}

		if ("".equals(tenHoa)) {
			out.print("Vui lòng nhập tên hoa!");
			return;
		}

		if ("".equals(soLuongStr)) {
			out.print("Vui lòng nhập số lượng!");
			return;
		} else {
			try {
				soLuong = Integer.parseInt(soLuongStr);
				if (soLuong <= 0)
					throw new Exception();
			} catch (Exception e) {
				out.print("Nhập số lượng phải là số dương!");
				return;
			}
		}

		if ("".equals(giaBanStr)) {
			out.print("Vui lòng nhập giá bán!");
			return;
		} else {
			try {
				giaBan = Float.parseFloat(giaBanStr);
			} catch (Exception e) {
				out.print("Nhập giá bán phải là số!");
				return;
			}
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
		out.print("Đã mua hoa thành công!");
	}

}
