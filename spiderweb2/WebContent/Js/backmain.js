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
	//第三项管理的点击
	$("#body .leftwarp div ul li:eq(2)").click(function(){
		$("#body .rightwarp").attr("src","ajax/ads.html");
	});
	//第四项管理的点击
	$("#body .leftwarp div ul li:eq(3)").click(function(){
		$("#body .rightwarp").attr("src","ajax/feedback.html");
	});
	/*
		提示信息与退出按钮实现
	*/
	$("#tipdate").click(function(){
		$("#body .rightwarp").attr("src","ajax/feedback.html");
	});
	$("#Exit").click(function(){
		//用户注销操作
		var alertStr = "您确定注销用户?";
		if(confirm(alertStr)===true){
			alert(1);
			//确定退出
		}else{
			alert(2);
			//不确定退出
		}
	});
});