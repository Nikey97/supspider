<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../../Css/bootstrap.min.css" />
		<link rel="stylesheet" href="../../Css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../../Css/ManageStyle.css" />
		<script type="text/javascript" src="../../Js/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<header class="container-fluid header-style">
			<a href="feedback.jsp"><span class="glyphicon glyphicon-menu-left"></span></a>
		</header>	
		<div class="col-lg-12 col-md-12">
			<div class="col-lg-4 col-md-4 feedback-context">
				<span><h4>反馈标题：</h4><ins><s:property value="feedback.title"/></ins></span><p>
				<span><h4>反馈人：</h4><s:property value="feedback.userName"/></span><p>
				<span><h4>反馈时间：</h4><s:property value="feedback.submitTime"/></span><p>
				<span><h4>反馈内容：</h4><em><s:property value="feedback.context"/></em></span><p>
			</div>									
		</div>
	</body>
</html>
