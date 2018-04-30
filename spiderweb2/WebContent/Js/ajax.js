// JavaScript Document
$(function(){
	"use strict";
//	var a=0;

	$.ajax({
		type:"get",
		url:"ad_QueryWebInfo.action",
		async:true,
		cache:true,
		success: function(msgs){
			var Dmsgs=JSON.parse(msgs);
//			alert(Dmsgs[0].web_Name);
			$('#web_Name').attr('placeholder',Dmsgs[0].web_Name);
			$('#web_Keyword').attr('placeholder',Dmsgs[0].web_Keyword);
			$('#web_Introduce').attr('placeholder',Dmsgs[0].web_Introduce);
		}
	});
	
	//网站信息修改功能实现
	$("#send_info").click(function(){
			var name=$('#web_Name').val();
			var keys=$('#web_Keyword').val();
			var introduces=$('#web_Introduce').val();
			if(name==""||keys==""||introduces==""){
				alert("表单存在值为空!")
			}else{
				$.ajax({
					type:"post",
					url:"ad_SaveWebInfo.action",
					async:true,
					data:$('#sends').serialize(),
					timeout: 30000,
					success: function(msgs){
						if(msgs==1){
							alert("修改成功!")
						}else{
							alert("异常")
						}
					}
				});	
			}
	});
	
	
	
	
});
