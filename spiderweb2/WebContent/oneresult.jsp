<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title><s:property value="ResourceAll.R_name"/></title>
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
			<span class="spanName" style="color: #6495ED; line-height: 50px; margin-left: 10px;"><a href="index">SupSpider</a></span>
		</div>
		<div class="collapse navbar-collapse MobileMune" id="bs-example-navbar-collapse-1">
			<ul class="nav MobileMune_ul">
				<li><a href="login.jsp" class="buttonLogin" style="color: #6495ED">登录</a></li>
				<li><a href="#" class="buttonLogin" style="color: #6495ED">关于</a></li>
			</ul>
		</div>
	</div>
	
	<div class="container-fluid One-Context-warp">
		<!--内容框-->
		<div class="One-context col-lg-12 col-md-12 col-sm-12">
			<h3 class="context-h3"><s:property value="ResourceAll.R_name"/></h3>
			<div class="Context-allinfo col-lg-12 col-md-12 col-sm-12">
				<div class="Context-info col-lg-8 col-md-8 col-sm-8">
					<ul class="Context-ul-normalize">
						<li>入库时间：<span class="info-span"><s:property value="ResourceAll.R_intotime"/></span></li>
						<li>文件大小：<span class="info-span"><s:property value="ResourceAll.R_size"/></span></li>	
						<li>文件类型：<span class="info-span"><s:property value="ResourceAll.R_type"/></span></li>
						<li>资源来源：<span class="info-span"><s:property value="ResourceAll.R_from"/></span></li>	
						<li>资源描述：<span class="info-span">欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。欢迎来到 Firefox！ 我们将展示给你所有基本的 Firefox 知识，这样你就可以从容开始。当你需要更进一步时，我们也留给你一系列有用的链接。</span></li>	
						<!--  点击传送至重定向页  -->
						<li>资源链接：<span class="btn btn-success"><a href="#" class="info-a">点击下载</a></span></li>	
					</ul>
				</div>
				<div class="Context-ad col-lg-4 col-md-4 col-sm-4">
					<!-- 广告二号栏:1|2-->
					<div class="col-lg-12 col-md-12 col-sm-12 One-ad-1 visible-lg-block visible-md-block">
						
					</div>
					<div class="col-lg-12 col-md-12 One-ad-2 visible-lg-block visible-md-block">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid Comment-wrap">
		<!--评论区框-->
		<div class="col-lg-12 col-md-12 col-sm-12 Comment-context">
			<h3  class="context-h3">评论区</h3>
			<div class="row col-lg-5 col-md-5 col-sm-5 textarea-style">
				<div class="form-group">
					<textarea placeholder="输入不得有与内容无关的内容，比如:广告、辱骂他人、网站链接。" class="form-control" rows="4" name="Comment" style="resize: none;"></textarea>
					<input type="submit" style="margin-top: 10px;" class="form-control btn btn-primary" value="提交">
				</div>
			</div>
			<div class="Comment-list col-lg-10 col-sm-10 col-md-10">
				<!--  评论列表框 -->
				<div class="dateNone">
					<!--数据为空显示-->
					<span>还没有人评论,快抢占沙发吧!</span>
				</div>
				<div class="one-comment col-lg-12 col-md-12 col-sm-12">
					<div class="col-lg-2 col-md-2 col-sm-2 userinfo-wrap">
						<span class="user-icon"></span>
						<span class="span-name"><a href="#">admin</a></span>
					</div>
					<div class="col-lg-10 col-md-10 col-sm-10 context-wrap">
						<span class="comment-context">这是内容这是内容这是内容这是内容这是内容</span>
					</div>
					<span class="date-warp">1楼&nbsp;&nbsp;2018-09-17 00:23</span>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部栏 -->
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
			Copyright © <a href="index" class="Bottom_warp_a">SupSpider资源搜索</a>
		</span>
	</div>
</body>
</html>