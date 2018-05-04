<%@page import="java.io.IOException"%>
<%@page import="java.util.TimerTask"%>
<%@page import="java.util.Timer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮箱验证成功</title>
<link rel="stylesheet" href="Css/bootstrap.min.css">
<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
<link rel="stylesheet" href="Css/main.css">
<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="Js/bootstrap.min.js"></script>
<script type="text/javascript" src="Js/main.js"></script>
</head>
<body>
		<!--  首页导航\搜索框   -->
		<div class="container-fluid nav-mydiy">
			<!--导航栏-->
			<div class="nav nav-myself navbar-header">
				<button type="button" class="navbar-toggle collapsed sr-onlyBlue" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				</button>
				<span class="spanName" style="color: #6495ED; line-height: 50px; margin-left: 10px;"><a href="index.jsp">SupSpider</a></span>
			</div>
			<div class="collapse navbar-collapse MobileMune" id="bs-example-navbar-collapse-1">
				<ul class="nav MobileMune_ul">
					<li><a href="login.jsp" class="buttonLogin" style="color: #6495ED">登录</a></li>
					<li><a href="#" class="buttonLogin" style="color: #6495ED">关于</a></li>
				</ul>
			</div>
		</div>
		<!-- 激活账号成功,自定转跳到登录页面  -->
		<div class="container-fluid">
			<div class="col-lg-6 col-md-6 col-sm-6 Verify-context">
				<span class="dui-icon"><h1>激活成功!</h1></span>
				<span class="dao-Time">正在为您转跳到登录页面,<strong style="color: red;">4</strong>秒后转跳...</span>
			</div>			
		</div>
		<%
			response.setHeader("refresh", "4;login.jsp");
		%>
</body>
</html>