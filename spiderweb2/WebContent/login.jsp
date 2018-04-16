<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>用户登录</title>
	<link rel="stylesheet" href="Css/bootstrap.min.css">
	<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="Css/main.css">
	<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
	<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/main.js"></script>
</head>
<body>
	<div class="container-fluid login_warp">
		<form method="post" action="#">
			<div class="col-lg-4 col-sm-4 col-md-4 login_context">
				<span class="span_name">SupSpider</span>
				<h3 class="h3_loginname">登录</h3>
				<div class="form-group input_style">
					<input type="email" name="useremail" class="form-control" placeholder="电子邮件地址">
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control" placeholder="密码">
				</div>
				<div class="checkbox">
					<label>
						<input type="checkbox" checked="checked" name="holdBox" value="1">保持登录状态
					</label>
					<a href="#" style="float: right;">忘记了密码?</a>
				</div>
				<div class="form-group div_magintop">
					<input type="submit" value="登录" class="btn btn-radius btn-primary">
				</div>
				
				<div class="div_SignUp div_magintops">
					还没有账号?&nbsp;&nbsp;<a href="register.jsp">创建账号</a>
				</div>
			</div>
		</form>
	</div>
	<!--返回首页 -->
	<a href="index.jsp">
		<img src="Img/index.png" class="div_position img-responsive">
	</a>
</body>
</html>