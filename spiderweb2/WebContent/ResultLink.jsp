<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="ResourceAll.R_name"/></title>
	<link rel="stylesheet" href="Css/bootstrap.min.css">
	<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="Css/main.css">
	<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
	<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/collapse.js"></script>
	<script type="text/javascript" src="Js/main.js"></script>
</head>
<body>
	<div class="container-fluid nav-mydiy">
		<!--导航栏-->
		<div class="nav nav-myself navbar-header">
			<button type="button" class="navbar-toggle collapsed sr-onlyBlue" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			</button>
			<span class="spanName" style="color: #6495ED; line-height: 50px; margin-left: 10px;"><a href="index">SupSpider</a></span>
		</div>
		<div class="collapse navbar-collapse MobileMune" id="bs-example-navbar-collapse-1">
			<input type="hidden" id="username" value="<s:property value="username"/>">
			<ul class="nav MobileMune_ul">
				<li><a href="javascript:void(0);" class="buttonLogin" style="color: #6495ED" id="userCancel">Hi&nbsp;!&nbsp;,&nbsp;<s:property value="username"/></a></li>
				<li><a href="login.jsp" class="buttonLogin" style="color: #6495ED">登录</a></li>
				<li><a href="#" class="buttonLogin" style="color: #6495ED">关于</a></li>
			</ul>
		</div>
	</div>
	
	<div class="container-fluid Link-Context-Wrap">
		<div class="col-lg-4 col-md-4 col-sm-4">
	 	<!--左边广告栏 -->
	 		<div class="col-lg-12 col-md-12 col-sm-12 L-adDiv-One visible-lg-block visible-md-block">
	 			
	 		</div>
	 		<div class="col-lg-12 col-md-12 col-sm-12 L-adDiv-Two visible-lg-block visible-md-block">
	 			
	 		</div>
	 		
	 	</div>
		<div class="col-lg-4 col-md-4 col-sm-4">
		<!--中间内容栏 -->
		 	<div class="col-lg-12 col-md-12 col-sm-12 Link-Context">
	 			<div class="col-lg-12 col-md-12 col-sm-12">
	 				<span><span class="glyphicon glyphicon-hand-down"></span>资源链接：</span>
	 				<div class="Link-warp">
	 					<a href="<s:property value="ResourceAll.R_link"/>"><s:property value="ResourceAll.R_link"/></a>
	 				</div>
	 				
	 				
	 			</div>
	 		</div>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4">
		<!--右边广告栏 -->
		 	<div class="col-lg-12 col-md-12 col-sm-12 R-adDiv-One visible-lg-block visible-md-block">
	 			
	 		</div>
	 		<div class="col-lg-12 col-md-12 col-sm-12 R-adDiv-Two visible-lg-block visible-md-block">
	 			
	 		</div>
		</div>
	</div>
	<div class="container-fluid div-bottom">
		<!-- 底部栏-->
		<div class="col-lg-4 col-md-4 col-sm-4 friend-warp">
			<!-- 友链 -->
			<h4 class="friend-h4">友情链接</h4>
			<div class="col-lg-12 col-md-12 col-sm-12 friend-context">
				<ul class="bottom-ul-normalize">
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
				</ul>
			</div>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 skill-warp">
			<!-- 技术-->
			<h4 class="friend-h4">用到的技术</h4>
			<div class="col-lg-12 col-md-12 col-sm-12 skill-context">
				<ul class="bottom-ul-normalize">
					<li><a href="http://webmagic.io/" class="bottom-ul-li-a">WebMagic</a></li>
					<li><a href="index.jsp" class="bottom-ul-li-a">SSH</a></li>
					<li><a href="http://www.bootcss.com/" class="bottom-ul-li-a">Bootstrap</a></li>
					<li><a href="https://jquery.com/" class="bottom-ul-li-a">Jquery</a></li>
					<li><a href="https://cn.vuejs.org/" class="bottom-ul-li-a">Vue.js</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid Copey-div">
	<!--底部栏-->
		<span class="Copey-span">
			Copyright © <a href="index" class="Bottom_warp_a">SupSpider资源搜索</a>
		</span>
	</div>
</body>
</html>