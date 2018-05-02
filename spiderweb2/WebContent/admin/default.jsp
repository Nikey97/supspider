<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理-登录</title>
		<link  type="text/css" href="../Css/ManageStyle.css" rel="stylesheet" />
		<link type="text/css" href="../Css/normalize.css" rel="stylesheet" />
		<script type="text/javascript" src="../Js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../Js/main.js" ></script>
		<script type="text/javascript" src="../Js/jquery.cookie.js"></script>
	</head>
	<body>
		<div id="allWarp">
		 	<div class="inputWarp">
		 		<img src="../Img/userlogo.png" />
		 		<div class="inputContent">
		 				<form method="post" action="ad_execute.action"> 
				 			<input type="text" name="name" placeholder="请输入管理员账户"/><p>
				 			<input type="password" name="password" placeholder="请输入密码"/><p>
				 			<input type="checkbox" name="remember" /><span>记住密码(7天免登录)</span><p>
				 			<input type="submit" name="send" value="登录"/><p>
			 			</form>
		 				<a href="../index">返回首页</a>
		 		</div>
		 	</div>
		 </div>
		 <%
		 	if(session.getAttribute("username")!=null){
		 		//当用户检测到存在用户值,提示注销后在返回此页面
		 		out.print("<script>alert('已存在用户,请注销后登录!');</script>");
		 		response.setHeader("refresh", "1;backstage.jsp");
		 	}
		 %>
	</body>
</html>