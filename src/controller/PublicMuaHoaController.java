package controller;

import java.io.IOException;
import java.util.ArrayList;

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
		request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String idStr = request.getParameter("aid");
		String tenHoa = request.getParameter("aten");
		String soLuongStr = request.getParameter("asoluong");
		String giaBanStr = request.getParameter("agia");
		
		request.setAttribute("idStr", idStr);
		request.setAttribute("tenHoa", tenHoa);
		request.setAttribute("soLuongStr", soLuongStr);
		request.setAttribute("giaBanStr", giaBanStr);
		
		int id = 0, soLuong = 0;
		float giaBan = 0;
		if (idStr == "") {
			request.setAttribute("err", "Vui lòng nhập ID!");
			request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
			return;
		} else {
			try {
				id = Integer.parseInt(idStr);
				if (id <= 0)
					throw new Exception();
			} catch (Exception e) {
				request.setAttribute("err", "Yêu cầu nhập ID phải là số lớn hơn 0!");
				request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
				return;
			}
		}

		if (tenHoa == "") {
			request.setAttribute("err", "Vui lòng nhập tên hoa!");
			request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
			return;
		}
		
		if (soLuongStr == "") {
			request.setAttribute("err", "Vui lòng nhập số lượng!");
			request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
			return;
		} else {
			try {
				soLuong = Integer.parseInt(soLuongStr);
				if (soLuong <= 0)
					throw new Exception();
			} catch (Exception e) {
				request.setAttribute("err", "Yêu cầu nhập số lượng phải là số lớn hơn 0!");
				request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
				return;
			}
		}

		if (giaBanStr == "") {
			request.setAttribute("err", "Vui lòng nhập giá bán!");
			request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
			return;
		} else {
			try {
				giaBan = Float.parseFloat(giaBanStr);
			} catch (Exception e) {
				request.setAttribute("err", "Yêu cầu nhập giá bán phải là số!");
				request.getRequestDispatcher("baitap/BT1/shop.jsp").forward(request, response);
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
		response.sendRedirect(request.getContextPath() + "/baitap/BT1/shop.jsp");
	}

}