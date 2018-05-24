<%@page import="java.sql.ResultSet"%>
<%@page import="cn.supspider.Utils.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
	<link type="text/css" rel="stylesheet" href="../../Css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="../../Css/bootstrap-theme.min.css">
	<link type="text/css" href="../../Css/ManageStyle.css" rel="stylesheet" >
	<script type="text/javascript" src="../../Js/dropdown.js"></script>
	<script type="text/javascript" src="../../Js/jquery-3.2.1.min.js"></script>
</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 ad_paing">
				<h2 class="fontdis alert-info">用户反馈管理</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-offset-3 col-sm-6">
				<div class="col-sm-12">
					<div class="btn-group">
						<button type="button" class="btn btn-default">未读反馈</button>
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="user_dropdown">
							<span class="caret"></span>
							<span class="sr-only"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">已读反馈</a></li>
  						</ul>
					</div>
				</div>
				<div class="col-sm-12 col-lg-12 col-md-12">
					<ul class="ad_ullinomail" id="show_feedbacklist">
						<%!
							DBUtil dbUtil=new DBUtil();
							int intPageSize;//一页显示的记录数
							int intRowCount;//记录总数
							int intPageCount;//总页数
							int intPage;//带显示页码
							String strPage;
							int i;
							String str = null;
						%>
						<%
							String sql="select * from user_feedback where f_look=0;";
							intPageSize=6;  //一页中显示两条记录数
							strPage=request.getParameter("page");
							if(strPage==null){
								intPage=1;
							}else{
								intPage=Integer.parseInt(strPage);
								if(intPage<1)
									intPage=1;
							}
							ResultSet set = dbUtil.DBQuery(sql);
							set.last();
							intRowCount=set.getRow();  //获取记录总数
							intPageCount=(intRowCount+intPageSize-1)/intPageSize;
							if(intPage>intPageCount){
								intPage=intPageCount; //调整带显示页码
							}
							if(intPageCount>0){
								set.absolute((intPage-1)*intPageSize+1);
							}
							i=0;
						%>
						<%
							while(i<intPageSize && !set.isAfterLast()){
						%>
							<li>
								<div class="col-md-12 ad_listdiv ad_test">
									<a href="ad_QueryFeedBackInfo.action?feedback_id=<%=set.getString("f_id") %>">
										<span class="ad_spanTitleleft"><%=set.getString("f_title") %></span>
										<span class="ad_spanNameright"><%=set.getString("u_name") %></span>
									</a>
								</div>
							</li>
						<%
								set.next();
								i++;
							}
						%>
					</ul>
				</div>
				<div class="ad_navright col-lg-12 col-md-12">
						第<%=intPage %>页&nbsp;共<%=intPageCount %>
						<%
							if(intPage<intPageCount){
								%>
								<a href="user.jsp?page=<%=intPage+1%>">下一页</a>
								<%
							}
							if(intPage>1){
								%>
								<a href="user.jsp?page=<%=intPage-1%>">上一页</a>
								<%
							}
						%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
