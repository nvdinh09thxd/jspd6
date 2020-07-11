<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Phim youtube</title>
	<meta name="description" content="Thiet ke website, dao tap lap trinh">
	<meta name="keywords" content="hiet ke website, dao tap lap trinh">
	<link href="<%=request.getContextPath()%>/baihoclop/activetin/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/baihoclop/activetin/js/jquery-2.1.1.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<!-- begin header -->
			<div id="header">
				<div class="header-left fl">
					<a href="index.html" title=""><img
						src="<%=request.getContextPath()%>/baihoclop/activetin/images/logo_edu.png"
						alt="" /></a>
				</div>
				<div class="header-right fr">
					<a href="index.html" title=""><img
						src="<%=request.getContextPath()%>/baihoclop/activetin/images/banner.jpg"
						alt="" /></a>
				</div>
				<div class="clr"></div>
			</div>
			<!-- end header -->
	
			<!-- begin menu -->
			<div id="menu">
				<ul>
					<li><a href="index.html" title="">Trang chủ</a></li>
					<li class="active"><a href="tintuc.html" title="">Tin tức</a></li>
					<li><a href="youtube.php" title="">Phim</a></li>
					<li><a href="lienhe.html" title="">Liên hệ</a></li>
				</ul>
				<div class="clr"></div>
			</div>
			<!-- end menu -->
	
			<!-- end content -->
			<div id="content">
				<div class="content-left fl">
					<h3>Danh mục tin</h3>
					<ul>
						<li><a href="#" title="">Tin trong nước</a></li>
						<li><a href="#" title="">Tin thế giới</a></li>
						<li><a href="#" title="">Tin thể thao</a></li>
						<li><a href="#" title="">Tin giải trí</a></li>
					</ul>
				</div>
				<div class="content-right fr">
					<h3>Tin tức</h3>
					<div class="main-content">
						<table border="1" cellpadding="5" cellspacing="1" width="100%">
							<tr>
								<th width="10%">ID</th>
								<th>Tên tin</th>
								<th width="20%">Trạng thái</th>
							</tr>
							<tr>
								<td>2</td>
								<td>Vài nét về phim Anh hùng xạ điêu</td>
								<td><a href="javascript:void(0)" title=""><img
										src="<%=request.getContextPath()%>/baihoclop/activetin/images/active.gif"
										alt="" /></a></td>
							</tr>
							<tr>
								<td>3</td>
								<td>Giới thiệu diễn viên Châu Tinh Trì</td>
								<td><a href="javascript:void(0)" title=""><img
										src="<%=request.getContextPath()%>/baihoclop/activetin/images/deactive.gif"
										alt="" /></a></td>
							</tr>
							<tr>
								<td>4</td>
								<td>Cuộc đời nhân vật chính phim Tây Du Ký</td>
								<td><a href="javascript:void(0)" title=""><img
										src="<%=request.getContextPath()%>/baihoclop/activetin/images/active.gif"
										alt="" /></a></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="clr"></div>
			</div>
			<!-- end content -->
	
			<div id="footer">
				<p>Trung tâm đào tạo Lập trình VinaEnter EDU</p>
				<p>
					Copyright &copy 2016 - Designed by <a href="" title="">VinaEnter</a>
				</p>
			</div>
		</div>
		<script>
		$("img").click(function(){
		    var image = $(this)
		    $.ajax({
				url: '<%=request.getContextPath()%>/active',
					type : 'POST',
					cache : false,
					data : {
						asrc : image.attr("src")
					},
					success : function(data) {
						image.attr("src", data)
					},
					error : function() {
						alert("Có lỗi xảy ra");
					}
				});
			});
		</script>
	</body>
</html>