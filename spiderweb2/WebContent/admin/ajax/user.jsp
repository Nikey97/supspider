<%@page import="java.sql.ResultSet"%>
<%@page import="cn.supspider.Utils.DBUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="antlr.collections.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
	<link type="text/css" rel="stylesheet" href="../../Css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="../../Css/bootstrap-theme.min.css">
	<link type="text/css" href="../../Css/ManageStyle.css" rel="stylesheet" >
	<script type="text/javascript" src="../../Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="../../Js/backmain.js"></script>
</head>	
	<body>
	<%
    String path = request.getContextPath();//对应就是myproject，即我的web工程名
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    %>
    <%! DBUtil dbUtil=new DBUtil();
	    int intPageSize;//一页显示的记录数
		int intRowCount;//记录总数
		int intPageCount;//总页数
		int intPage;//带显示页码
		String strPage;
		int i;
		String str = null;
    %>
		<div class="container-fluid heightfull">
			<div class="row">
				<div class="col-lg-2 ad_paing">
					<h2 class="fontdis alert-info">用户信息管理</h2>
				</div>
			</div>
			<div class="row">
				<form id="send_searchName">
					<div class="col-md-7 col-xs-offset-3">
						<div class="form-group ad_sreachinput">
							<div class="ad_sleftwrap">
								<span class="glyphicon glyphicon-user ad_spanico"></span>
								<input type="text" placeholder="用户ID|用户名|邮箱" name="search_input" class="ad_input" />
							</div>
							<a href="javascript:void(0);" class="ad_jsspan" id="send_search">检索</a>
						</div>
					</div>
				</form>
			</div>
			<!-- è¡¨æ ¼ -->
			<div class="table-responsive ad_divtable">
				<table class="table table-striped table-bordered table-hover">
					<caption style="text-align: center;"><h4 style="margin: 0;padding: 0;">用户信息</h4></caption>
					<tbody>
						<thead>
							<tr>
								<th>ID</th>
								<th>UserName</th>
								<th>Email</th>
								<th>SignInTime</th>
								<th>SignUpTime</th>
								<th>Danned</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody id="show_userlist">
						<%
							if(request.getParameter("search_input")==null){
							%>
								<%
								String sql="select * from userinfo;";
								intPageSize=4;  //一页中显示两条记录数
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
								<% while(i<intPageSize && !set.isAfterLast()){ %>
								<tr>
									<td><%=set.getString("u_id") %></td>
									<td><%=set.getString("u_name") %></td>
									<td><%=set.getString("u_email") %></td>
									<td><%=set.getString("u_signint") %></td>
									<td><%=set.getString("u_signupt") %></td>
									<td><a href="javascript:void(0);"><span class="jurisdiction_icon"></span></a></td>
									<td><a href="<%=basePath%>/ad_DeleteUserInfo?userid=<%=set.getString("u_id") %>" class="delete_icon_a"><span class="delete_icon"></span></a></td>
								</tr>
								<%
								set.next();
								i++;
								} %>
							<%
							}else{
								str = request.getParameter("search_input");
								if(!str.equals("")){
									
									String sql="select * from userinfo where u_name='"+str+"';";
									ResultSet set=dbUtil.DBQuery(sql);
									if(set.next()){
										set.close();
										%>
											<% 
											
												ResultSet set1=dbUtil.DBQuery(sql);
												while(set1.next()){
											
											%>
												<tr>
													<td><%=set1.getString("u_id") %></td>
													<td><%=set1.getString("u_name") %></td>
													<td><%=set1.getString("u_email") %></td>
													<td><%=set1.getString("u_signint") %></td>
													<td><%=set1.getString("u_signupt") %></td>
													<td><a href="javascript:void(0);"><span class="jurisdiction_icon"></span></a></td>
													<td><a href="<%=basePath%>/ad_DeleteUserInfo?userid=<%=set1.getString("u_id") %>" class="delete_icon_a"><span class="delete_icon"></span></a></td>
												</tr>
											<%} %>
										<%
									}
									
									String Emailsql="select * from userinfo where u_email='"+str+"';";
									ResultSet setEmail=dbUtil.DBQuery(Emailsql);
									if(setEmail.next()){
										%>
										setEmail.close();
											<% 
											ResultSet setEmail1=dbUtil.DBQuery(Emailsql);
											while(setEmail1.next()){
											%>
											<tr>
												<td><%=setEmail1.getString("u_id") %></td>
												<td><%=setEmail1.getString("u_name") %></td>
												<td><%=setEmail1.getString("u_email") %></td>
												<td><%=setEmail1.getString("u_signint") %></td>
												<td><%=setEmail1.getString("u_signupt") %></td>
												<td><a href="javascript:void(0);"><span class="jurisdiction_icon"></span></a></td>
												<td><a href="<%=basePath%>/ad_DeleteUserInfo?userid=<%=setEmail1.getString("u_id") %>" class="delete_icon_a"><span class="delete_icon"></span></a></td>
											</tr>
											<%} %>
										<%
										
									}
									String Idsql="select * from userinfo where u_id='"+str+"';";
									ResultSet setId=dbUtil.DBQuery(Idsql);
									if(setId.next()){
										setId.close();	
										%>
											<% 
												ResultSet setId1=dbUtil.DBQuery(Idsql);
												while(setId1.next()){ 
											%>
											<tr>
												<td><%=setId1.getString("u_id") %></td>
												<td><%=setId1.getString("u_name") %></td>
												<td><%=setId1.getString("u_email") %></td>
												<td><%=setId1.getString("u_signint") %></td>
												<td><%=setId1.getString("u_signupt") %></td>
												<td><a href="javascript:void(0);"><span class="jurisdiction_icon"></span></a></td>
												<td><a href="<%=basePath%>/ad_DeleteUserInfo?userid=<%=setId1.getString("u_id") %>" class="delete_icon_a"><span class="delete_icon"></span></a></td>
											</tr>
											<%} %>
										<%
									}
								}
							}
						%>
						</tbody>
				</table>
			</div>
			<div class="ad_paingStyle">
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
	</body>
</html>
