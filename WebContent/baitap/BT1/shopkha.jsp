<%@page import="bean.Hoa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mua hoa</title>
		<link href="<%=request.getContextPath()%>/baitap/BT1/css/stylekha.css"	type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<h4>Form mua hoa</h4>
			<form action="javascript:void(0)" method="post" id="formMuaHoa">
				<label>ID hoa: </label>
				<input type="text" name="idhoa" id="idhoa" /><br><br>
				<label>Tên hoa: </label>
				<input type="text" name="tenhoa" id="tenhoa" /><br> <br>
				<label>Số lượng: </label>
				<input type="text" name="soluong" id="soluong" /><br> <br> 
				<label>Giá:</label>
				<input type="text" name="giaban" id="giaban" /><br> <br> 
				<input type="submit" value="Mua hoa" onclick="muahoa()"><br> <br>
			</form>
			<h3 style="color: red" id="msg"></h3>
		</div>
		<div id="ketqua">
			<%
				if (session.getAttribute("listHoa") != null) {
				@SuppressWarnings("unchecked")
				ArrayList<Hoa> listHoa = (ArrayList<Hoa>) session.getAttribute("listHoa");
			%>
			<h4>Danh sách hoa</h4>
			<table border="2" width="500px">
				<tr>
					<th>Tên sản phẩm</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Tổng tiền</th>
				</tr>
				<%
					float sum = 0f;
						for (Hoa hoa : listHoa) {
							float thanhTien = hoa.getGiaBan() * hoa.getSoLuong();
							sum += (hoa.getGiaBan() * hoa.getSoLuong());
				%>
				<tr>
					<td><%=hoa.getTenHoa()%></td>
					<td><%=hoa.getGiaBan()%></td>
					<td><%=hoa.getSoLuong()%></td>
					<td><%=String.format("%.0f", thanhTien)%></td>
				</tr>
				<%
					}
				%>
	
				<tr>
					<td colspan="3">Tổng tiền:</td>
					<td><%=String.format("%.0f", sum)%></td>
				</tr>
	
	
			</table>
			<%
				} else {
			%>
			<p>Không có sản phẩm nào!!!</p>
			<%
				}
			%>
		</div>
		<script type="text/javascript">
			function muahoa() {
				var idhoa = $("#idhoa").val(); 
				var tenhoa = $("#tenhoa").val();
				var soluong = $("#soluong").val();
				var giaban = $("#giaban").val();			
				
				$.ajax({
					url: '<%=request.getContextPath()%>/muahoakha',
					type : 'POST',
					cache : false,
					data : {
						aid : idhoa,
						aten : tenhoa,
						asoluong : soluong,
						agia : giaban
					},
					success : function(data) {
						//alert(data);
						$("#msg").html(data);
						//Nếu thành công thì reset các ô input
						if(data.includes("thành công")){
							$("#idhoa").val("");
							$("#tenhoa").val("");
							$("#soluong").val("");
							$("#giaban").val("");
						}
						$("#ketqua").load(" #ketqua");
					},
					error : function() {
						alert('Có lỗi xảy ra');
					}
				});
				return false;
			}
		</script>
	</body>
</html>