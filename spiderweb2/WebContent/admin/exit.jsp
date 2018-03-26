<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>exit</title>
<style type="text/css">
	body,html{
		width: 100%;
		height: 100%;
	}
	.img{
		width: 300px;
		height: 300px;
		margin: 0 auto;
	}
	.text{
		width: auto;
		height: 200px;
		margin: 0 auto;
		margin-top: 30px;
		text-align: center;
	}
	.text h2{
		font-size: 30px;
		font-family: "new york";
	}
</style>
</head>
<body>
	<div class="img">
		<img src="../Img/byebye.gif" />
	</div>
	<div class="text">
		<h2><i>要 &nbsp;记 &nbsp;得 &nbsp;回 &nbsp;来 &nbsp;哟!</i></h2><br>
		<mark>页面两秒后转跳...</mark>
	</div>
	<%
		/*
		
			本页面用于注销账户登录信息
		
		*/
		if(session.getAttribute("username").equals("")){
			response.setHeader("refresh", "0;backstage.jsp");
		}else{
			session.removeAttribute("username");
			response.setHeader("refresh", "1;index.jsp");
		}
		
	%>
</body>
</html>