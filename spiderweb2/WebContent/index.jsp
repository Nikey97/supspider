<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="<s:property value="web_Keyword"/>"><!-- 3. -->
<meta name="Description" content="<s:property value="web_Introduce"/>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title><s:property value="web_Name"/></title>
	<link rel="icon" href="Img/spiderman.png" type="image/x-icon" />
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
	<div class="container-fluid searchDiv" id="SearchWarp">
		<!--  首页导航\搜索框   -->
		<nav class="navbar searchNav">
			<div class="container-fluid">
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed sr-only" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				  </button>
				  <div class="spanNameDiv">
					<a href="index"><span class="spanName">SupSpider</span></a>
				  </div>
				</div>
				<input type="hidden" id="username" value="<s:property value="username"/>">
				<div class="collapse navbar-collapse MobileMune" id="bs-example-navbar-collapse-1">
					<ul class="nav MobileMune_ul">
						<li><a href="javascript:void(0);" class="buttonLogin" id="userCancel">Hi&nbsp;!&nbsp;,&nbsp;<s:property value="username"/></a></li>
						<li><a href="login.jsp" class="buttonLogin">登录</a></li>
						<li><a href="#" class="buttonLogin">关于</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="col-md-12">
			<div class="col-md-6 div_center">
				<div class="Slogen_wrap">
					<h1>SupSpider</h1>
					<span>我们不生产资源,我们只是互联网资源的搬运工!</span>
					<span name="data">共收录了<mark>12890</mark>个资源</span>
				</div>
				<div class="div_search">
					<form action="user_QueryResultInfo.action" method="post">
						<input type="text" class="div_searchInput" placeholder="请输入电影名|音乐名|资源关键字" name="SearchName">
					</form>
				</div>
				<div class="div_HotSearch">
					<ul class="ul_normalize">
						<!--<li><a href="#"><span class="icon_hot">头牌玩家</span></a></li>-->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid fleshDiv" id="flashDiv">
		<!--  最新资源分享框  -->
		<h2>最新资源</h2>
		<div class="share_Music col-md-4 col-sm-4">
			<div class="Music_context">
				<table class="table table-hover" id="music">
					<caption style="text-align: center;"><span class="Music_icon"></span></caption>
					<thead>
						<tr>
							<td><b>文件名</b></td>
							<td><b>入库时间</b></td>
							<td><b>来源</b></td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="MusicList">
							<tr>
								<td><a href="user_QueryResultAllInfo.action?number=<s:property value="number"/>" style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 90px; display: block;" title="<s:property value="R_name"/>"><marquee scrollamount="5"><s:property value="R_name"/></marquee></a></td>
								<td><span style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 60px; display: block;" title="<s:property value="R_intotime"/>"><s:property value="R_intotime"/></span></td>
								<td><s:property value="R_from"/></td>
							</tr>
						</s:iterator>	
					</tbody>
				</table>
			</div>
		</div>
		<div class="share_Movie col-md-4 col-sm-4">
			<div class="Movie_context">
				<table class="table table-hover">
					<caption style="text-align: center;"><span class="Movie_icon"></span></caption>
					<thead>
						<tr>
							<td><b>文件名</b></td>
							<td><b>入库时间</b></td>
							<td><b>来源</b></td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="MovieList">
							<tr>
								<td><a href="user_QueryResultAllInfo.action?number=<s:property value="number"/>" style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 90px; display: block;" title="<s:property value="R_name"/>"><marquee scrollamount="5"><s:property value="R_name"/></marquee></a></td>
								<td><span style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 60px; display: block;" title="<s:property value="R_intotime"/>"><s:property value="R_intotime"/></span></td>
								<td><s:property value="R_from"/></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
		<div class="share_Other col-md-4 col-sm-4">
			<div class="Other_context">
				<table class="table table-hover">
					<caption style="text-align: center;"><span class="Other_icon"></span></caption>
					<thead>
						<tr>
							<td><b>文件名</b></td>
							<td><b>入库时间</b></td>
							<td><b>来源</b></td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="OtherList">
							<tr>
								<td><a href="user_QueryResultAllInfo.action?number=<s:property value="number"/>" style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 90px; display: block;" title="<s:property value="R_name"/>"><marquee scrollamount="5"><s:property value="R_name"/></marquee></a></td>
								<td><span style="text-overflow: ellipsis; font-size: 12px; overflow:hidden; white-space: nowrap; width: 60px; display: block;" title="<s:property value="R_intotime"/>"><s:property value="R_intotime"/></span></td>
								<td><s:property value="R_from"/></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="container-fluid Bottom_warp">
		<!--  底部栏 -->
		<span>Copyright © <a href="index" class="Bottom_warp_a">SupSpider资源搜索</a></span>
	</div>
	<div class="HideFloatWarp">
		<!-- 漂浮栏:反馈|返回顶部|关注官微|白色的导航栏 -->
			<div class="Float_Top">
				<a href="javascript:void(0);" onclick="toTop()" title="返回顶部">
					<span class="topicon">top</span>
				</a>
			</div>
			<div class="Float_QeCode">
				<a href="javascript:void(0);" title="关注官微"  data-toggle="modal" data-target="#myCQCode">
					<img src="Img/CGCode.png" />
				</a>
			</div>
		
			<div class="Float_feedback">
				<a href="javascript:void(0);" title="用户反馈" data-toggle="modal" data-target="#myfeedback">
					<img src="Img/email.png" />
				</a>
			</div>
	</div>
	
	<!--  关注官微的模态框弹出内容  -->
	<div class="modal fade" id="myCQCode" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h4 class="modal-title" id="myModalLabel">关注官微</h4>
		  </div>
		  <div class="modal-body">
			打开手机微博扫一扫,最新资源更新第一时间通知.
		  </div>
		  <div class="modal-footer">
		  </div>
		</div>
	  </div>
	</div>
	
	<!-- 用户反馈的模态框弹出内容 -->
	<!--<form action="user_UserFeedback.action" method="post" id="feedback_send">-->
		<div class="modal fade" id="myfeedback" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">用户反馈</h4>
				<!--<input type="hidden" name="uName" value="<s:property value="username"/>">-->
			  </div>
			  <div class="modal-body">
				<div class="form-group">
					<label for="exampleInputfeedbackt">反馈问题标题</label>
					<input type="text" class="form-control" id="fTitle" placeholder="请输入反馈标题">
				</div>
				<div class="form-group">
					<label for="exampleInputfeedbackm">描述反馈问题</label>
					<textarea class="form-control" rows="4" placeholder="请输入遇到的问题或建议" id="fContext" style="resize:none"></textarea>
				</div>
			  </div>
			  <div class="modal-footer">
				<input type="reset" class="btn btn-default" value="清空">
				<input type="submit" class="btn btn-primary" id="feedback_send" value="提交">
			  </div>
			</div>
		  </div>
		</div>	
	<!--</form>-->
</body>
</html>