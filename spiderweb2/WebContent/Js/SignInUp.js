$(function(){
	/*
	 登录校验
	 * */
	$("#signup-Warp .signup-Content .input-Content input[name='sendUp']").mousedown(function(){
		$(this).css("background","#1874CD");//点下注册时的效果
		/*  取得输入框中的值   */
		var userName=$("input[name='userName']").val();
		var loginName=$("input[name='loginName']").val();
		var psw=$("input[name='password']").val();
		var argenPsw=$("input[name='argenPsw']").val();
		var MacthuserName="[^ ]{2,15}";
		var MatchloginName="[0-9a-zA-Z]{2,15}@[0-9a-zA-Z]{2,8}.[a-zA-Z]{1,4}";
		var MatchPsw="[^   ]{6,15}";
		if(userName==""){
			$(".errorTipWarp section[name='TipName']").css("display","block");
			return;
		}else{
			$(".errorTipWarp section[name='TipName']").css("display","none");	
			if(userName.match(MacthuserName)){
				$(".trueTip section[name='trueNameTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueNameTip']").css("display","block");
			}
		}
		if(loginName==""){
			$(".errorTipWarp section[name='TipEmail']").css("display","block");
			return;
		}else{
			$(".errorTipWarp section[name='TipEmail']").css("display","none");	
			if(loginName.match(MatchloginName)){
				$(".trueTip section[name='trueEmailTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueEmailTip']").css("display","block");
			}
		}
		if(psw==""){
			$(".errorTipWarp section[name='TipPsw']").css("display","block");
			return;
		}else{
			$(".errorTipWarp section[name='TipPsw']").css("display","none");	
			if(psw.match(MatchPsw)){
				$(".trueTip section[name='truePswTip']").css("display","none");
			}else{
				$(".trueTip section[name='truePswTip']").css("display","block");
			}
		}
		if(argenPsw==""){
			$(".errorTipWarp section[name='TipAPsw']").css("display","block");
			return;
		}else{
			$(".errorTipWarp section[name='TipAPsw']").css("display","none");	
			if(argenPsw==psw){
				$(".trueTip section[name='trueAPswTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueAPswTip']").css("display","block");
			}
		}
	});
	$("#signup-Warp .signup-Content .input-Content input[name='sendUp']").mouseup(function(){
		$(this).css("background","#0099CC");
	});
	
	$("input[name='userName']").on('blur',function(){
		var userName=$("input[name='userName']").val();
		var MacthuserName="[^ ]{2,15}";
		if(userName==""){
			$(".errorTipWarp section[name='TipName']").css("display","block");
		}else{
			$(".errorTipWarp section[name='TipName']").css("display","none");	
			if(userName.match(MacthuserName)){
				$(".trueTip section[name='trueNameTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueNameTip']").css("display","block");
			}
		}
		//当该提示显示就隐藏其他三个
		if($(".errorTipWarp section[name='TipName']").is(":visible")){
			$(".errorTipWarp section[name='TipEmail']").css("display","none");
			$(".errorTipWarp section[name='TipPsw']").css("display","none");	
			$(".errorTipWarp section[name='TipAPsw']").css("display","none");	
		}
		
	});
	$("input[name='loginName']").on('blur',function(){
		var loginName=$("input[name='loginName']").val();
		var MatchloginName="[0-9a-zA-Z]{2,15}@[0-9a-zA-Z]{2,8}.[a-zA-Z]{1,4}";
		if(loginName==""){
			$(".errorTipWarp section[name='TipEmail']").css("display","block");
		}else{
			$(".errorTipWarp section[name='TipEmail']").css("display","none");	
			if(loginName.match(MatchloginName)){
				$(".trueTip section[name='trueEmailTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueEmailTip']").css("display","block");
			}
		}
		
		if($(".errorTipWarp section[name='TipEmail']").is(":visible")){
			$(".errorTipWarp section[name='TipName']").css("display","none");
			$(".errorTipWarp section[name='TipPsw']").css("display","none");	
			$(".errorTipWarp section[name='TipAPsw']").css("display","none");	
		}
	});
	
	$("input[name='password']").on('blur',function(){
		var psw=$("input[name='password']").val();
		var MatchPsw="[^   ]{6,15}";
		if(psw==""){
			$(".errorTipWarp section[name='TipPsw']").css("display","block");
		}else{
			$(".errorTipWarp section[name='TipPsw']").css("display","none");	
			if(psw.match(MatchPsw)){
				$(".trueTip section[name='truePswTip']").css("display","none");
			}else{
				$(".trueTip section[name='truePswTip']").css("display","block");
			}
		}
		if($(".errorTipWarp section[name='TipPsw']").is(":visible")){
			$(".errorTipWarp section[name='TipName']").css("display","none");
			$(".errorTipWarp section[name='TipEmail']").css("display","none");	
			$(".errorTipWarp section[name='TipAPsw']").css("display","none");	
		}
	});
	
	$("input[name='argenPsw']").on('blur',function(){
		var argenPsw=$("input[name='argenPsw']").val();
		if(argenPsw==""){
			$(".errorTipWarp section[name='TipAPsw']").css("display","block");
		}else{
			$(".errorTipWarp section[name='TipAPsw']").css("display","none");	
			if(argenPsw==psw){
				$(".trueTip section[name='trueAPswTip']").css("display","none");
			}else{
				$(".trueTip section[name='trueAPswTip']").css("display","block");
			}
		}
		
		if($(".errorTipWarp section[name='TipAPsw']").is(":visible")){
			$(".errorTipWarp section[name='TipName']").css("display","none");
			$(".errorTipWarp section[name='TipEmail']").css("display","none");	
			$(".errorTipWarp section[name='TipPsw']").css("display","none");		
		}
	});
	
	
	
});


$(function(){
	/* 	登录校验    */
	$("#signin-Warp .context div input[name='send']").mousedown(function(){
		$(this).css("background","#1874CD");
		var loginName=$("input[name='loginName']").val();
		var pswIn=$("input[name='password']").val();
		
		if(loginName==""){
			$(".errorTipInWarp section[name='TiploginName']").css("display","block");
			return;
		}else{
			$(".errorTipInWarp section[name='TiploginName']").css("display","none");	
		}
		
		if(pswIn==""){
			$(".errorTipInWarp section[name='Tippsw']").css("display","block");
			return;
		}else{
			$(".errorTipInWarp section[name='Tippsw']").css("display","none");	
		}
	});
	$("#signin-Warp .context div input[name='send']").mouseup(function(){
		$(this).css("background","#0099CC");		
	});
	
	$("input[name='loginName']").on('blur',function(){
		var loginName=$("input[name='loginName']").val();
		if(loginName==""){
			$(".errorTipInWarp section[name='TiploginName']").css("display","block");
		}else{
			$(".errorTipInWarp section[name='TiploginName']").css("display","none");	
		}
		
		if($(".errorTipInWarp section[name='TiploginName']").is(":visible")){
			$(".errorTipInWarp section[name='Tippsw']").css("display","none");		
		}
	});
	
	$("input[name='password']").on('blur',function(){
		var pswIn=$("input[name='password']").val();
		if(pswIn==""){
			$(".errorTipInWarp section[name='Tippsw']").css("display","block");
		}else{
			$(".errorTipInWarp section[name='Tippsw']").css("display","none");	
		}
		
		if($(".errorTipInWarp section[name='Tippsw']").is(":visible")){
			$(".errorTipInWarp section[name='TiploginName']").css("display","none");	
		}
	});

});