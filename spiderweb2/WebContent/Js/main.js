$(function(){
	"use strict";
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
		if(top>height/2){
			$(".Float_Top").css('visibility','visible');
		}else{
			$(".Float_Top").css('visibility','hidden');
		}
	});
	
	/* 注册密码框选中时出现提示 */
	
	$("#psw").focusin(function(){
		$(".div_pswTip").fadeIn();
	});
	
	/* 登录页面的登录信息提交   */
	$("#login_send").click(function(){
		var email=$('#input_email').val();
		var psw=$("#input_psw").val();
		if(email==""||psw==""){
			$('#div_email').attr("class","form-group has-error input_style");
			$("#div_psw").attr('class','form-group has-error');
			return false;
		}else{
			$.ajax({
				type:"POST",
				url:"user_SignIn.action",
				async:true,
				dataType: 'json',
				data: {'Email':email,'PassWord':psw},
				success: function(msgs){
					if(msgs==1){
						//注册成功!
						$('#div_email').attr("class","form-group input_style");
						$("#div_psw").attr('class','form-group');
						window.location.href="index.jsp";
					}else if(msgs==0){
						$('.Tip-login').fadeIn();
						$('#div_email').attr("class","form-group has-error input_style");
						$("#div_psw").attr('class','form-group has-error');
					}
				},
				error: function(msgs){
					alert("服务器响应异常:"+msgs);
				}
			});
		}
	});
	
	
	/*结果返回页的鼠标移入的效果*/
	$(".bottom-ul-li-a").mouseenter(function(){
		$(this).css('background',"#337AB7");
		$(this).css('color','#fff');
	});
	$(".bottom-ul-li-a").mouseleave(function(){
		$(this).css('background',"");
		$(this).css('color','#959595');
	});
	/* 首页的悬浮框的鼠标移入效果 */
	$(".Float_Top,.Float_QeCode,.Float_feedback").mouseenter(function(){
		$(this).css('background','#F5F5F5');
	});
	$(".Float_Top,.Float_QeCode,.Float_feedback").mouseleave(function(){
		$(this).css('background','#fff');
	});
	
	//获取隐藏控件中 的数据做操作
});