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
	
	/*  查询信息返回分页判断  */
	var NowPage = $('#NowPage').val();
	var Next = $('#Next').val();
	var Last = $('#Last').val();
	if(NowPage>0){
		$('ul.pagination li:eq('+NowPage+')').attr('class','active');
	}
	$('ul.pagination li:eq('+NowPage+')').click(function(){
		return false;//阻止发送请求
	});
	if(Next==0&&Last==0){
		//只有一页,禁止下上一页		
		$('ul.pagination li:eq(0)').attr('class','disabled');
		$('ul.pagination li:last-child').attr('class','disabled');
	}else if(Next!=0&&Last==0){
		//在第一页页数不为一,静止上一个
		$('ul.pagination li:eq(0)').attr('class','disabled');
		$('ul.pagination li:last-child').attr('class','');
	}else if(Next==0&&Last!=0){
		//在最后一个,禁止最后一个
		$('ul.pagination li:eq(0)').attr('class','');
		$('ul.pagination li:last-child').attr('class','disabled');
	}else{
		//不在第一个也不在最后一个的位置
		$('ul.pagination li:eq(0)').attr('class','');
		$('ul.pagination li:last-child').attr('class','');
	}
	
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
						window.location.href="index";
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
	
	var user = $('#username').val();
	//用户登录判断等操作
	$('.MobileMune_ul li:eq(0)').css('display','none');
	if(user!=""){
		$('.MobileMune_ul li:eq(1)').css('display','none');
		$('.MobileMune_ul li:eq(0)').show();
	}
	//用户注销操作
	$('#userCancel').click(function(){
		var alertStr = "您确定注销用户?";
		if(confirm(alertStr)===true){
			window.location.href="user_UserCancel.action";
			//确定退出,转入注销
		}
	});
	
	//用户提交反馈
	$('input#feedback_send').click(function(){
		var title = $("#fTitle").val();
		var context = $('#fContext').val();
		var user = $('#username').val();
		if(user!=""){
			//判断标题或者内容是否为空
			if(title!=""||context!=""){
				$.ajax({
					type:"post",
					url:"user_UserFeedback.action",
					data: {"uName":user,"fTitle":title,"fContext":context},
					dataType: 'json',
					async:true,
					success: function(msgs){
						if(msgs==1){
							alert("提交我们已收到，感谢您对我们的反馈或建议。我们会尽快改正，望日后继续对网站进行反馈，谢谢!");
						}else if(msgs==2){
							alert("您的反馈我们已经收到,不要这么频繁嘛!");
						}
					},
					error: function(msgs){
						alert("服务器响应异常:"+msgs);
					}
				});	
			}else{
				alert("存在内容为空,不能提交!");
			}
		}else{
			var alertStr = "系统检测您尚未登录,是否转向登录页面?";
			if(confirm(alertStr)===true){
				window.location.href="login.jsp";
				//确定退出,转入注销
			}else{
				return false;
			}
			return false;
		}
	});
	
	//注册正确格式校验
	$('#reg-button').click(function(){
		var email=$('#email').val();
		var username=$('#username').val();
		var qpsw=$('#Qpsw').val();
		var psw=$('#psw').val();
		var agree=$('#agree').is(':checked');
		var send=false;
		if(email!=""){
			send=true;
			$('#div-email').attr('class','form-group input_style');	
		}else{
			$('#div-email').attr('class','form-group input_style has-error');
		}
		if(username!=""){
			send=true;
			$('#div-username').attr('class','form-group');			
		}else{
			$('#div-username').attr('class','form-group has-error');
		}
		if(psw!=""){
			send=true;
			$('#div-psw').attr('class','form-group');
		}else{
			$('#div-psw').attr('class','form-group has-error');
		}
		if(qpsw!=""){
			send=true;
			$('#div-qpsw').attr('class','form-group');
		}else{
			$('#div-qpsw').attr('class','form-group has-error');
		}
		if(!agree){
			$('#div-agree').attr('class','checkbox has-error');
		}else{
			send=true;
			$('#div-agree').attr('class','checkbox');
		}
		if(psw!=qpsw){
			$('.ul_rule li:eq(3)').css('color','red');
		}else{
			$('.ul_rule li:eq(3)').css('color','');
		}
		if(send){
			if(email!=""&&username!=""&&psw!=""&&qpsw!=""&&agree==true){
				return true;
			}
		}
		return false;
	});
	//密码输入框实时校验
//	$('input#psw').bind('input propertychange',function(){
//		var oneMatch="[0-9][^A-Za-z ]{1,12}";
//		var twoMatch="[a-zA-Z]{1,8}";
//		var threeMatch="[0-9a-zA-Z^   ]{8,12}";
//		var qpsw=$('#Qpsw').val();
//		var psw=$('#psw').val();
//		if(oneMatch.match(psw)){
//			alert(2+":::"+psw);
//			$('#div-psw').attr('class','form-group');
//			$('.ul_rule li:eq(0)').css('color','');
//		}else{
//			alert(1+":::"+psw);
//			$('#div-psw').attr('class','form-group has-error');
//			$('.ul_rule li:eq(0)').css('color','red');
//		}
//		if(!threeMatch.match(psw)){
//			alert(3);
//			$('#div-psw').attr('class','form-group has-error');
//			$('.ul_rule li:eq(2)').css('color','red');
//		}else{
//			alert(4+":::"+psw);
//			$('#div-psw').attr('class','form-group');
//			$('.ul_rule li:eq(2)').css('color','');
//		}
//	});
});
//首页回到页面顶部的操作
function toTop(){
	document.body.scrollTop = document.documentElement.scrollTop = 0;
};
