<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Phim youtube</title>
	<meta name="description" content="Thiet ke website, dao tap lap trinh">
	<meta name="keywords" content="hiet ke website, dao tap lap trinh">
	<link href="<%=request.getContextPath() %>/BT3/style.css" rel="stylesheet" type="text/css">
	<script src="<%=request.getContextPath() %>/BT3/js/jquery-2.1.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- begin header -->
		<div id="header">
			<div class="header-left fl">
				<a href="index.html" title=""><img src="<%=request.getContextPath() %>/BT3/images/logo_edu.png" alt="" /></a>
			</div>
			<div class="header-right fr">
				<a href="index.html" title=""><img src="<%=request.getContextPath() %>/BT3/images/banner.jpg" alt="" /></a>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end header -->
		
		<!-- begin menu -->
		<div id="menu">
			<ul>
				<li><a href="index.html" title="">Trang chủ</a></li>
				<li><a href="tintuc.html" title="">Tin tức</a></li>
				<li class="active"><a href="youtube.php" title="">Phim</a></li>
				<li><a href="lienhe.html" title="">Liên hệ</a></li>
			</ul>
			<div class="clr"></div>
		</div>
		<!-- end menu -->
		
		<!-- end content -->
		<div id="content">
			<div class="content-left fl">
				<h3>Học tiếng Anh qua phim Extra</h3>
				<ul>
				<%
				for(int i=1; i<=5; i++){
				%>
					<li>
						<a href="javascript:void(0)" title="" onclick="getPhim(<%=i%>)">Học tiếng Anh qua phim (Tập <%=i %>)</a>
					</li>
				<%} %>
				</ul>
			</div>
			<div class="content-right fr">
				<h3>Học tiếng Anh qua phim Extra</h3>
				<div class="main-content">
					<div id="video-youtube">
						<iframe width="670" height="377" src="https://www.youtube.com/embed/1VbufbrV1Cg" frameborder="0" allowfullscreen></iframe>
					</div>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end content -->
		
		<div id="footer">
			<p>Trung tâm đào tạo Lập trình VinaEnter EDU</p>
			<p>Copyright & copy 2016 - Designed by <a href="" title="">VinaEnter</a></p>
		</div>
	</div>
	<script type="text/javascript">
		function getPhim(id) {
			$.ajax({
				url: '<%=request.getContextPath()%>/phim',
				type: 'POST',
				data: {aid: id},
				success: function(data){
					$('iframe').attr("src", data);
				},
				error: function (){
					alert('Có lỗi xảy ra');
				}
			});
			return false;
		}
	</script>
</body>
</html>
