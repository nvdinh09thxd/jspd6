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
		RequestDispatcher rd = request.getRequestDispatcher("/BT1/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("aid"));
		String tenHoa = request.getParameter("aten");
		int soLuong = Integer.valueOf(request.getParameter("asoluong"));
		float giaBan = Float.valueOf(request.getParameter("agia"));

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

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<p>Đã mua hoa thành công!" + tenHoa + "</p>");
	}

}