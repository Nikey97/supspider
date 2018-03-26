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
	/*
	 点击显示的菜单
	 * */
	var i=0;
	$("#head div .function ul li:nth-child(1)").click(function(){
		/*
		 点击第一个元素的显隐藏
		 * */
		i++;
		if($("#head div .function .hideexit").is(":visible")){
			/*当点击一个元素,第二个元素要是显示的就把它隐藏*/
			$("#head div .function .hideexit").hide();
			$("#head div .function ul li:nth-last-child(1)").css("background","#F8F8F8");
			$("#head div .function ul li:nth-last-child(1)").css("border-top","");
			$("#head div .function ul li:nth-last-child(1)").css("border-left","");
			$("#head div .function ul li:nth-last-child(1)").css("border-right","");
		}
		if(i===1){
			$(this).css("background","#F0F0F0");
			$("#head div .function .hidemessge").show();
			$(this).css("border-top","0.5px solid #E7E7E7");
			$(this).css("border-left","0.5px solid #E7E7E7");
			$(this).css("border-right","0.5px solid #E7E7E7");
		}
		else{
			$("#head div .function .hidemessge").hide();
			$(this).css("background","#F8F8F8");
			$(this).css("border-bottom","0.5px solid #E7E7E7");
			$(this).css("border-top","");
			$(this).css("border-left","");
			$(this).css("border-right","");
			i=0;
		}
	});
	$("#head div .function ul li:nth-last-child(1)").click(function(){
		i++;
		if(i===1){
			$("#head div .function .hideexit").show();
			$(this).css("background","#F0F0F0");
			$(this).css("border-top","0.5px solid #E7E7E7");
			$(this).css("border-left","0.5px solid #E7E7E7");
			$(this).css("border-right","0.5px solid #E7E7E7");
		}
		else{
			$("#head div .function .hideexit").hide();
			$(this).css("background","#F8F8F8");
			$(this).css("border-bottom","0.5px solid #E7E7E7");
			$(this).css("border-top","");
			$(this).css("border-left","");
			$(this).css("border-right","");
			i=0;
		}
		if($("#head div .function .hidemessge").is(":visible")){
			/*当点击二个元素,第一个元素要是显示的就把它隐藏*/
			$("#head div .function .hidemessge").hide();
			$("#head div .function ul li:nth-child(1)").css("background","#F8F8F8");
			$("#head div .function ul li:nth-child(1)").css("border-top","");
			$("#head div .function ul li:nth-child(1)").css("border-left","");
			$("#head div .function ul li:nth-child(1)").css("border-right","");
		}
	});
	
	//第一项管理的点击
	$("#body .leftwarp div ul li:eq(0)").click(function(){
		$("#body .rightwarp").attr("src","ajax/allmanage.html");
	});
	
	
	
	
});