<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>VinaEnter EDU</title>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/muahoa/jquery-2.1.1.min.js"></script>
		<style>
			.ketqua{
				padding: 50px;
				border: 3px solid green;
				width: 300px;
				margin-top: 30px;
			}
			
			.ketqua:hover{
				background: pink;
			}
		</style>
	</head>
	<body>
		<h1>JQuery - ajax</h1>	
		
		<div class="jquery-demo-input">
			Tên hoa: Hoa hồng <br />
			Đơn giá: 200.000 VNĐ<br />			
			Số lượng hoa: 
			<input type="text" value="" id="soluong" />
			<a href="javascript:void(0)" title="" onclick="xulyMuaHoa()">Mua</a>
			
			<div class="ketqua">
				dữ liệu lấy từ file ajax
			</div>			
		</div>		
	</body>
	<script type="text/javascript">
		$( ".ketqua" ).hide();//display: none;
		function xulyMuaHoa(){
			var tenHoa = "Hoa hồng";
			var donGia = 200000;
			var soLuong = $("#soluong").val();
			$.ajax({
				url: '<%=request.getContextPath()%>/muahoalop',
				type: 'POST',
				cache: false,
				data: {
					tenHoa: tenHoa,
					donGia: donGia,
					soLuong: soLuong
				},
				success: function(data){
					$( ".ketqua" ).show();
					$(".ketqua").html(data);
				},
				error: function (){
					alert('Có lỗi xảy ra');
				}
			});
			return false;//xử lý xong thì dừng lại luôn
		}
	</script>
</html>