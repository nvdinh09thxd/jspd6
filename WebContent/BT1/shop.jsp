<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Hoa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Shop</title>
		<link href="<%=request.getContextPath() %>/BT1/css/reset.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/BT1/css/style.css" rel="stylesheet" type="text/css">
		<script src="<%=request.getContextPath() %>/BT1/js/jquery-3.3.1.min.js"></script>
		<script src="<%=request.getContextPath() %>/BT1/js/jquery.validate.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<h2>Mua hoa</h2>
			<div id="result"></div>
			<form action="javascript:void(0)">
				<label>ID</label>
				<input type="text" name="id" id="id" /><br /> <br />
				<label>Tên hoa</label>
				<input type="text" name="ten" id="ten" /><br /><br /> 
				<label>Số lượng</label><input type="text" name="soluong" id="soluong" /><br /> <br /> 
				<label>Giá bán</label><input type="text" name="gia" id="gia" /><br /> <br /> 
				<input type="submit" value="Mua" />
			</form>
			<a href="<%=request.getContextPath() %>/BT1/xemHoa.jsp"><button>Xem giỏ hàng</button></a>
		</div>
	</body>
	<script type="text/javascript">
			$('form').validate({
				rules: {
					"id": {
						required: true,
						digits: true,
					},	
					"ten": {
						required: true,
					},	
					"soluong": {
						required: true,
						digits: true,
					},	
					"gia": {
						required: true,
						number: true,
					},
				},
				messages: {
					"id": {
						required: "Yêu cầu nhập",
						digits: "Nhập số nguyên dương",
					},	
					"ten": {
						required: "Yêu cầu nhập",
					},	
					"soluong": {
						required: "Yêu cầu nhập",
						digits: "Nhập số nguyên dương",
					},	
					"gia": {
						required: "Yêu cầu nhập",
						number: "Phải là số",
					},
				},
				submitHandler: function(form) {
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
							$('#result').html(data);
						},
						error : function() {
							alert('Có lỗi xảy ra');
						}
					})
				  }
			});
	</script>
</html>