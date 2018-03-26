<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>后台管理</title>
        <link rel="stylesheet" href="../Css/ManageStyle.css" type="text/css" />
        <link rel="stylesheet" href="../Css/normalize.css" type="text/css" />
        <script type="text/javascript" src="../Js/jquery-3.2.1.min.js" ></script>
        <script type="text/javascript" src="../Js/backmain.js" ></script>
        <script type="text/javascript" src="../Js/jquery.cookie.js"></script>
    </head>
    <!--
    	作者：13044926957@163.com
    	时间：2018-02-27
    	描述：该页面用于后台系统呈现:
    			主要功能:可以用于
    							1.启动和暂停spider进程
    							2.查询删除用户信息
    							3.网站主体信息查询修改
    							4.用户反馈信息查询
    							5.首页最新资源管理
    							6.广告内容的管理
    -->
    <body>
    <div id="head">
    <!--描述：头部-->
		<section>
			<h1>NetSpider后台管理 v1.0</h1>
		</section>
		<div>
			<div class="function">
				<ul>
					<li><img src="../Img/admessge.png" /><!--信息:用户进入管理系统,项服务器数据库发送查询最新的反馈--></li>
					<li><img src="../Img/adexit.png"/><!--退出管理系统--></li>
				</ul>
				<div>
					<div class="hidemessge">
						<!--隐藏的信息div-->
						
					</div>
					<div class="hideexit">
						<!--退出的div-->
						<span><a href="ad_exit.action">退出</a></span>
					</div>
				</div>
			</div>
		</div>
    </div>
    <div id="body">
    <!--描述：主体栏-->
    	<div class="leftwarp">
    	<!--左边导航栏-->
    		<div>
				<ul>
					<a href="#"><li>网站信息管理<i class="icon"></i></li></a>
					<a href="#"><li>用户信息管理<i class="icon"></i></li></a>
					<a href="#"><li>广告信息管理<i class="icon"></i></li></a>
					<a href="#"><li>用户反馈管理<i class="icon"></i></li></a>
					<a href="#"><li>邮件收发管理<i class="icon"></i></li></a>
					<a href="#"><li><span>欢迎${username}登录!</span><i class="icon"></i></li></a>
				</ul>    		
    		</div>
    	</div>
    	<iframe class="rightwarp" frameborder="0" scrolling="no">
    	<!--右边呈现栏:用于挨个呈现管理页面-->
    	</iframe>
    </div>
 	</body>
</html>