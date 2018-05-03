<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>账号注册成功</title>
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
		<!-- 提示注册成功页面,提示用户必须邮箱验证才能使用  -->
		<div class="container-fluid">
			<div class="col-lg-6 col-md-6 col-sm-6 success-warp">
				<span><h1>注册成功!</h1></span>		
				<span style="color: #575757; line-height: 20px;"><em>在您注册的同时,我们的邮箱机器人.向您的邮箱发送了一封验证邮件,请在<strong>30分钟内</strong>登录您的邮箱完成账号激活
					.由于我们还处于测试阶段,不对游客开放,必须激活账号才能享受所有的服务哦!</em></span>
					
				<h3>我们为您准备了快速通道!</h3>
				<a class="btn btn-default" style="margin-top: 10px;" href="<s:property value="ToEmailaddress"/>">赶去激活</a><br />
				<a class="btn btn-default" style="margin-top: 15px;" href="index">返回首页</a>
			</div>
		</div>
</body>
</html>