/*
 * 分页功能封装  bootstarp风格 
 * auther: Nimo
 * 
 * */
var selects = null; //  选择器
var pageTotal = 0;  //  所有数据条数
var pageCurrent = 1;  //  当前所在页
var pageNumber = 5;   //  一页显示多少条数
var paginationNumber = 5;  //  默认分页标签数
var lastPager; // 循环后最后一页的页数
var startPager = 0; // 分页起始页数
var controller = ''; //前端控制器
var totalPages = 0;

function pagination(selects,controller,pageTotal,pageCurrent,pageNumber,paginationNumber){
	this.selects = selects;
	this.pageTotal = pageTotal;
	this.pageCurrent = pageCurrent;
	this.pageNumber = pageNumber;
	this.paginationNumber = paginationNumber; 
	this.controller = controller;
	
//	alert(selects+"   "+pageTotal+"   "+pageCurrent+"    "+pageNumber+"   "+paginationNumber);
	
	function getTotalPages(){
		return pageTotal/pageNumber;
	}//获取总页数
	
	this.init = function() {
		var a = getTotalPages();
		totalPages = parseInt(a);
		$("#"+selects+"").html(function(i){
			return '<i>i:'+i+'</i>';
		});
	}//显示分页
}
