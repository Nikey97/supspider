<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>用户注册</title>
	<link rel="stylesheet" href="Css/bootstrap.min.css">
	<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="Css/main.css">
	<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
	<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/main.js"></script>
</head>
<body>
	<!-- 
		用户注册需求分析:
						1.邮箱地址
						2.用户名	
						3.密码
						4.确认密码
		-->
	<div class="container-fluid register_warp">
		<form id="reg_send" method="post" action="user_SignUp.action">
			<div class="reg_context col-lg-4 col-sm-4 col-md-4">
				<span class="span_name">SupSpider</span>
				<h3 class="h3_loginname">注册</h3>
				<div class="form-group input_style">
					<label for="email">电子邮件地址</label>
					<input type="email" class="form-control" id="email" name="Email" placeholder="例如:netspider@yeah.net">
				</div>
				<div class="form-group">
					<label for="username">用户名</label>
					<input type="text" class="form-control" id="username" name="UserName" placeholder="例如:feng123">
				</div>
				<div class="form-group">
					<label for="psw">密码</label>
					<input type="password"  class="form-control" id="psw" name="PassWord">
				</div>
				<div class="div_pswTip col-sm-12 col-md-12">
					<span><span class="glyphicon glyphicon-lock"></span>&nbsp;&nbsp;您的密码需要满足以下条件：</span>
					<ul class="ul_rule">
						<li>至少包括一个数字或一个符号。</li>
						<li>同时包括小写和大写拉丁字符。</li>
						<li>至少为 8 个字符长。</li>
						<li>与确认密码一致</li>
					</ul>
				</div>
				<div class="form-group">
					<label for="Qpsw">确认密码</label>
					<input type="password"  class="form-control" id="Qpsw" name="Qpassword">
				</div>
				<div class="checkbox">
					<label>
						<input type="checkbox" name="agree" value="1">&nbsp;&nbsp;我已阅读并接受<a href="#">使用条款</a>和<a href="#">隐私政策</a>。
					</label>
				</div>
				<div class="form-group">
					<input type="reset" value="清空" class="btn btn-default btn-radius">&nbsp;&nbsp;
					<input type="submit" value="注册" class="btn btn-primary btn-radius" id="register_send" >
				</div>
				<span class="span_TipLogin">已经有账号?&nbsp;&nbsp;<a href="login.jsp">登录</a></span>
			</div>
		</form>
		<!--返回首页 -->
		<a href="index.jsp">
			<img src="Img/index.png" class="div_position img-responsive">
		</a>
	</div>
</body>
</html>