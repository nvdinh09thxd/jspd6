package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Hoa;

@WebServlet("/muahoakha")
@MultipartConfig
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String idStr = request.getParameter("idhoa");
		String tenHoa = request.getParameter("tenhoa");
		String soLuongStr = request.getParameter("soluong");
		String giaBanStr = request.getParameter("giaban");

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

		Part filePart = request.getPart("hinhanh");
		String fileName = filePart.getSubmittedFileName();
		if ("".equals(fileName)) {
			out.print("Vui lòng chọn hình ảnh!");
			return;
		}
		String fileType = filePart.getContentType();
		if (!fileType.startsWith("image")) {
			out.print("File bạn chọn không phải là file ảnh!");
			return;
		}

		// Xử lý upload ảnh
		String appPath = request.getServletContext().getRealPath("");
		String dirPath = appPath + "files";
		File saveDir = new File(dirPath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		String portal = fileName.split("\\.")[0];
		String extra = fileName.split("\\.")[1];
		long time = System.currentTimeMillis();
		fileName = portal + "_" + time + "." + extra;
		String filePath = dirPath + File.separator + fileName;
		filePart.write(filePath);

		boolean check = false;
		for (Hoa itemHoa : listHoa) {
			if (itemHoa.getId() == id) {
				itemHoa.setSoLuong(soLuong + itemHoa.getSoLuong());
				check = true;
				break;
			}
		}

		if (!check) {
			Hoa hoa = new Hoa(id, tenHoa, soLuong, giaBan, fileName);
			listHoa.add(hoa);
		}

		HttpSession session = request.getSession();
		session.setAttribute("listHoa", listHoa);
		out.print("Đã mua hoa thành công!");
	}

}
