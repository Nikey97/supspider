$(function(){
	"use strict";
	/*
	 默认点中第一项
	 * */
	$("#body .rightwarp").attr("src","ajax/welcome.jsp");
	$("#body .leftwarp div ul li:eq(0)").css("background","#fff");
	/*
	 管理页导航的
	 * */
	$("#body .leftwarp div ul li").mouseenter(function(){
		$(this).css("background","#fff");	
	});
	$("#body .leftwarp div ul li").mouseleave(function(){
		$(this).css("background","#F8F8F8");
	});
	
	//第一项管理的点击
	$("#body .leftwarp div ul li:eq(0)").click(function(){
		$("#body .rightwarp").attr("src","ajax/welcome.jsp");
	});
	//第二项管理的点击
	$("#body .leftwarp div ul li:eq(1)").click(function(){
		$("#body .rightwarp").attr("src","ajax/allmanage.html");
	});
	//第三项管理的点击
	$("#body .leftwarp div ul li:eq(2)").click(function(){
		$("#body .rightwarp").attr("src","ajax/user.jsp");
	});
	//第四项管理的点击
	$("#body .leftwarp div ul li:eq(3)").click(function(){
		$("#body .rightwarp").attr("src","ajax/ads.html");
	});
	//第五项管理的点击
	$("#body .leftwarp div ul li:eq(4)").click(function(){
		$("#body .rightwarp").attr("src","ajax/feedback.jsp");
	});
	
	
	/*
		提示信息与退出按钮实现
	*/
	$("#tipdate").click(function(){
		$("#body .rightwarp").attr("src","ajax/feedback.jsp");
	});
	$("#Exit").click(function(){
		//用户注销操作
		var alertStr = "您确定注销用户?";
		if(confirm(alertStr)===true){
			window.location.replace("ad_exit.action");
			//确定退出,转入注销
		}else{
			//不确定退出
		}
	});
	
	/*
	 *  点击删除用户:先提示 
	 * */
	
	$('.delete_icon_a').click(function(){
		var alertStr = "您确定删除该用户?";
		if(confirm(alertStr)===true){
			return true;
			//确定删除,get方式id请求删除
		}else{
			//不确定删除 
			return false;
		}
	});
	/*
	 *  点击查询 
	 * */
	$('#send_search').click(function(){
		var search_name=$('.ad_input').val();
		window.location.href("user.jsp?search_input="+search_name);
	});
	
	/*
	 * 
	 * */
});