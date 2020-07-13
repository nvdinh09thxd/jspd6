<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Shop</title>
		<link href="<%=request.getContextPath() %>/baitap/BT1/css/reset.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/baitap/BT1/css/style.css" rel="stylesheet" type="text/css">
		<script src="<%=request.getContextPath() %>/baitap/BT1/js/jquery-3.3.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/baitap/BT1/js/jquery.validate.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<h2>Mua hoa</h2>
			<p>${err}</p>
			<form action="javascript:void(0)">
				<label>ID</label><input type="text" name="id" id="id" value="${idStr}" /><br /> <br />
				<label>Tên hoa</label><input type="text" name="ten" id="ten" value="${tenHoa}" /><br /><br /> 
				<label>Số lượng</label><input type="text" name="soluong" id="soluong" value="${soLuongStr}" /><br /> <br /> 
				<label>Giá bán</label><input type="text" name="gia" id="gia" value="${giaBanStr}" /><br /> <br /> 
				<input type="submit" value="Mua" />
			</form>
		</div>
		
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
	<script type="text/javascript">
			$('form').submit(function(){
				var id = $("#id").val();
				var ten = $("#ten").val();
				var soluong = $("#soluong").val();
				var gia = $("#gia").val();
				$.ajax({
					url: '<%=request.getContextPath()%>/muahoa',
					type : 'POST',
					data : {
						aid : id,
						asoluong : soluong,
						aten : ten,
						agia : gia
					},
					success : function(data) {
						$('body').html(data);
					},
					error : function() {
						alert('Có lỗi xảy ra');
					}
				})
		  	})
	</script>
</html>