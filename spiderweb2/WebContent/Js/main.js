$(function(){
	"use strict";
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
	
	/*  搜索框选中和不选中效果 */
	$(".div_searchInput").focusin(function(){
		$(".div_search").css('box-shadow','0px 0px 6px rgba(0,0,0,0.6)');
		$(".div_search").css('-webkit-box-shadow','0 0 6px rgba(0,0,0,.6)');
	});
	$(".div_searchInput").focusout(function(){
		$(".div_search").css('box-shadow','');
		$(".div_search").css('-webkit-box-shadow','');
	});
	
	/*  当鼠标滑动离开搜索div显示回到底部的按钮 */
	var height=$(window).height();
	$(window).bind('scroll', function(){
		var top = $(this).scrollTop(); 
		if(top>height){
			$(".Float_Top").css('visibility','visible');
		}else{
			$(".Float_Top").css('visibility','hidden');
		}
	});
	
	/* 注册密码框选中时出现提示 */
	
	$("#psw").focusin(function(){
		$(".div_pswTip").show();
	});

	var jsondata=[{"docname":"羞羞的铁拳","time":"一天前","form":"新浪云"},{"docname":"闪灵","time":"一天前","form":"百度云"},{"docname":"风火玉林","time":"三天前","form":"磁力"},{"docname":"风玉林","time":"二天前","form":"百度云"}];
	
	
	/* 页面数据渲染 */
	var vm=new Vue({
		el: '#music',
		data: {
			til : jsondata
		}
	});
	
	
	
});