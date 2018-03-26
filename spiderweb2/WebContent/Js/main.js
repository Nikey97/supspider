$(function(){
	
	$("header nav ul li a[target]").mouseenter(function(){
		$(this).css("background","#663366");
	});
	$("header nav ul li a[target]").mouseleave(function(){
		$(this).css("background","");
	});
	//鼠标移入移出登录注册效果
	$("footer .footerWarp p a").mouseenter(function(){
		$(this).css("color","#fff");		
	});
	$("footer .footerWarp p a").mouseleave(function(){
		$(this).css("color","#666");		
	});
	//当用户选中navHidden下的搜索框时,变成选中状态.
	$("#header .nav div section input").focusin(function(){
//		选中状态
		$("#header .nav div section").css("border","0.5px solid #0099CC");
	});
	$("#header .nav div section input").focusout(function(){
//		未选中状态
		$("#header .nav div section").css("border","0.5px solid #EDEDED");
	});
	//搜索结果页的每个结果鼠标移入移出
	$("#ResultAll .ResultWarp .ResultContent .ResultEveryOne div").mouseenter(function(){
		$(this).css("background","#EAEAEA");
	});
	$("#ResultAll .ResultWarp .ResultContent .ResultEveryOne div").mouseleave(function(){
		$(this).css("background","");
	});
	
	//管理页面的登录异步加载
//	$("#allWarp .inputContent input[name='send']").click(function(){
//		var name=$("#allWarp .inputContent input[name='name']").val();
//		var psw=$("#allWarp .inputContent input[name='psw']").val();
//		if(name==''||psw==''){
//			
//			alert("用户名或密码不能为空!");
//			
//		}else{
//			$.ajax({
//				type:"post",
//				url:"http://localhost:8080/spiderweb/login",
//				async:true,
//				dataType:"json",
//				data:{
//					name:$("#allWarp .inputContent input[name='name']").val(),
//					psw:$("#allWarp .inputContent input[name='psw']").val()
//				},
//				success: function(response){
//					if(response>0){
//						$.cookie("adminname","#allWarp .inputContent input[name='name']");
//						window.location.href="backstage.jsp";
//					}else{
//						alert("用户名或密码错误!");
//					}
//				}
//			});
//		}
//	});
//	if($.cookie("adminname")==="null"){
//		
//	}else{
//		alert("存在账户,请注销后才可登录.");
//		window.location.href="backstage.jsp";
//	}
	
});