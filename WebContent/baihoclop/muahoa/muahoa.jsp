<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>VinaEnter EDU</title>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/muahoa/jquery-2.1.1.min.js"></script>
	</head>
	<body>
		<h1>JQuery - ajax</h1>	
		
		<div class="jquery-demo-input">
			Tên hoa: Hoa hồng <br />
			Đơn giá: 200.000 VNĐ<br />			
			Số lượng hoa: 
			<input type="text" value="" id="soluong" />
			<a href="javascript: void(0)" title="" onclick="return xuLyMuaHoa()">Mua</a>
			
			<div class="ketqua">dữ liệu lấy từ file ajax</div>			
		</div>
		
	</body>
	<script type="text/javascript">
		function xuLyMuaHoa(){
			var tenHoa ="Hoa hồng";
			var donGia =200000;
			var soLuong = $("#soluong").val();
			$.ajax({
				url: '<%=request.getContextPath()%>/xuly-muahoa',
				type: 'POST',
				cache: false,//không cho lưu kết quả lại trên trình duyệt
				data: {
					atenHoa: tenHoa,
					adonGia: donGia,
					asoLuong: soLuong
				},
				success: function(data){
					$(".ketqua").html(data);
				},
				error: function (){
					alert('Có lỗi xảy ra');
				}
			});
			return false;
		}
		</script>
</html>