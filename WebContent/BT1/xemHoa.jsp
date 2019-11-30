<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xem Hoa</title>
<link href="<%=request.getContextPath() %>/BT1/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/BT1/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<Hoa> listHoa = (ArrayList<Hoa>) session.getAttribute("listHoa");
		if (listHoa != null) {
	%>
	<table>
		<tr>
			<th>Tên sản phẩm</th>
			<th>Giá</th>
			<th>Số lượng</th>
			<th>Tổng tiền</th>
		</tr>
		<%
			float thanhTien = 0;
				for (Hoa itemHoa : listHoa) {
					thanhTien += itemHoa.getGiaBan() * itemHoa.getSoLuong();
		%>
		<tr>
			<td id="tensanpham"><%=itemHoa.getTenHoa()%></td>
			<td><%=itemHoa.getGiaBan()%></td>
			<td><%=itemHoa.getSoLuong()%></td>
			<td><%=itemHoa.getGiaBan() * itemHoa.getSoLuong()%></td>
		</tr>
		<%
			}
		%>
		<tr id="thanhtien">
			<td colspan="3" style="text-align: right">Thành tiền</td>
			<td><%=thanhTien%></td>
		</tr>

	</table>
	<%
		} else {
	%>
	<p>Giỏ hàng rỗng!</p>
	<%
		}
	%>
</body>
</html>