<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>搜索结果-(传过来的数值)</title>
	<link rel="stylesheet" href="Css/bootstrap.min.css">
	<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="Css/main.css">
	<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
	<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/main.js"></script>
	<script type="text/javascript" src="Js/collapse.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
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
	<div class="container-fluid search-mydiv">
		<!-- 附搜索框div-->
		<form action="#" method="post">
			<div class="col-lg-6 col-md-6 col-sm-6 search-context">
				<div class="form-group search-input">
					<input type="text" name="SearchName" class="form-control search-input-diy" placeholder="请输入电影名|音乐名|资源关键字">
				</div>
			</div>
		</form>
	</div>
	<div class="container-fluid resut-fluid">
		<!-- 搜索结果列表 -->
		<div class="col-lg-8 col-md-8 col-sm-8 result-warp">
			<!-- 结果列表 -->
			<ul class="doc-list-normalize">
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
				<li>
					<div class="list-diy">
						<span class="doc-title"><a href="#">头牌玩家</a></span>
						<span class="doc-form">来源平台：百度云</span>
					</div>
				</li>
			</ul>
			<nav aria-label="Page navigation nav-right">
			  <ul class="pagination">
				<li>
				  <a href="#" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				  </a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
				  <a href="#" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				  </a>
				</li>
			  </ul>
			</nav>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 ad-warp">
			<!-- 创收广告-->
			<div class="col-lg-12 col-md-12 col-sm-12 ad-frist">
				广告框一
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 ad-second">
				广告框二
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
					<li><a href="#" class="bottom-ul-li-a">百度</a></li>
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
		<span class="Copey-span">
			Copyright © <a href="index.jsp" class="Bottom_warp_a">SupSpider资源搜索</a>
		</span>
	</div>
</body>
</html>