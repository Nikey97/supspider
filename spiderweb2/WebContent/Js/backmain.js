$(function(){
	/*
	 默认点中第一项
	 * */
	$("#body .rightwarp").attr("src","ajax/allmanage.html");
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
		$("#body .rightwarp").attr("src","ajax/allmanage.html");
	});
	//第二项管理的点击
	$("#body .leftwarp div ul li:eq(1)").click(function(){
		$("#body .rightwarp").attr("src","ajax/user.html");
	});
	
	
	
});