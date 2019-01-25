(function($) {
  "use strict"; // Start of use strict

  // Toggle the side navigation
  $("#sidebarToggle").on('click',function(e) {
    e.preventDefault();
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
  });

  // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
        delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });

  // Scroll to top button appear
  $(document).on('scroll',function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  // Smooth scrolling using jQuery easing
  $(document).on('click', 'a.scroll-to-top', function(event) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    event.preventDefault();
  });

	// 登录状态的消息反馈
	var msg = $("#msg-status").val();
	if(msg !== ""){
		$('#MsgStatus').modal("show");
	}
	
	//客户端登录账户密码校验
	

	//文章分类操作点击显示操作框
	$("#classfiy-dropdown").click(function(){
			$('.classfiy-operty-content').slideToggle();
	});
	
	//文章分类操作全选/全取消
	$("input[name='classfiys']").change(function(){
		if($("input[name='classfiys']").is(":checked")){
			$("input[name='classfiy']").prop("checked",true);
		}else{
			$("input[name='classfiy']").prop("checked",false);
		}
	});
	
	//文章分类--添加
	$("#classfiy-add-button").click(function(){
			var classfiyName = $("input[name='classfiyName']").val();
			var classfiyDescription = $("textarea[name='classfiyDescription']").val();
			if(classfiyName !== "" && classfiyDescription !== "") 
			{
				ClassfiyAddSubmit();
			}
			else if(classfiyName === "")
			{
				$("#exampleInputEmail1").attr("class","form-control is-invalid");
			}
			else if(classfiyDescription === "")
			{
				$("#exampleInputEmail2").attr("class","form-control is-invalid");
			}
	});
	
	//文章分类--修改
	$("#classfiy-updata").click(function(){
		var	obj = document.getElementsByName("classfiy");
		var classfiys = [];
		for (var i = 0; i < obj.length; i++) {
			if(obj[i].checked)
			{
				classfiys.push(obj[i].value);
			}
		}
		//选择了多个分类（禁止）
		if(classfiys.length > 1)
		{
			alert("只能修改一个文章分类");
		}
		else if(classfiys.length == 0)
		{
			alert("至少要选择一个文章分类");
		}
		else
		{
			$.ajax({
				type:"post",
				url:"query_classfiy.do",
				async:true,
				data:{"number":classfiys[0]},
				success: function(data){
					$("#classfiy-name-updata").attr("placeholder",data.acClassfiyname);
					$("#classfiy-description-updata").attr("placeholder",data.acRemark);
					$("#classfiy-number-updata").attr("value",data.acNumber);
					$("#ClassfiyUpdataModalCenter").modal('show');
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					// 状态码
			    console.log(XMLHttpRequest.status);
			    // 状态
			    console.log(XMLHttpRequest.readyState);
			    // 错误信息   
			    console.log(textStatus);
				}
			});
		}
	});
	
	//提交修改
	$("#classfiy-updata-button").click(function(){
		var classfiyName = $("input[name='classfiyNameUpdata']").val();
		var classfiyDescription = $("textarea[name='classfiyDescriptionUpdata']").val();
		if(classfiyName !== "" && classfiyDescription !== "") 
		{
			ClassfiyUpdataSubmit();
		}
		else if(classfiyName === "")
		{
			$("#classfiy-name-updata").attr("class","form-control is-invalid");
		}
		else if(classfiyDescription === "")
		{
			$("#classfiy-description-updata").attr("class","form-control is-invalid");
		}
		
	});
	
	//文章分类--删除
	$("#classfiy-del").click(function(){
	  var	obj = document.getElementsByName("classfiy");
		var classfiys = [];
		for (var i = 0; i < obj.length; i++) {
			if(obj[i].checked)
			{
				classfiys.push(obj[i].value);
			}
		}
		if(classfiys.length === 0) 
		{
			alert("请选择最少一个文章分类...");
		}
		else
		{
			var confum = confirm("您确定要删除这" + classfiys.length + "个文章分类？");
			if(confum === true)
			{
				$.ajax({
					type:"post",
					url:"delete_classfiy.do",
					async:true,
					data: {"classfiyList" : classfiys},
					success: function(data){
						alert(data.msg);
						window.location.href="classfiy";
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){
						// 状态码
				    console.log(XMLHttpRequest.status);
				    // 状态
				    console.log(XMLHttpRequest.readyState);
				    // 错误信息   
				    console.log(textStatus);
				    
				    console.log(classfiys);
					}
				});
			}
		}
	});
	
	//消息回传提示
	var msgs = $("#msgs").val();
	if(msgs != "" && msgs != undefined)
	{
		alert(msgs);
		window.location.href="classfiy";
	}
	
	/*
	 * 友情链接：添加
	 * */
	$("#addFriendLink").click(function(){
		$('#loadFriendLink').modal('toggle');
	});
	
})(jQuery); // End of use strict


////文章分类--添加--提交
function ClassfiyAddSubmit(){
		document.getElementById("classfiy-add-form").submit();
}
//文章分类--添加--清空
function ClassfiyAddReset(){
		document.getElementById("classfiy-add-form").reset();
}
////文章分类--添加--提交
function ClassfiyUpdataSubmit(){
		document.getElementById("classfiy-updata-form").submit();
}
//文章分类--添加--清空
function ClassfiyUpdataReset(){
		document.getElementById("classfiy-updata-form").reset();
}

