/*
 * 分页功能封装  bootstarp风格 
 * auther: Nimo
 * 
 * */
var selects = null; //  选择器
var pageTotal = 0;  //  所有数据条数
var pageCurrent;  //  当前所在页
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
	
	function getTotalPages(){
		return pageTotal/pageNumber;
	}//获取总页数
	
	this.show = function(){
		var a = getTotalPages();
		totalPages = parseInt(a);
		
		var html = '';
		html += '<nav aria-label="Page navigation example">';
		html += '<ul class="pagination">';
		
		var previousCurrent = pageCurrent;
		previousCurrent--;
		if(pageCurrent == 1){
			html += '<li class="page-item disabled"><a class="page-link" href="'+controller+'?pager='+previousCurrent+'">Previous</a></li>';
		}else{
			html += '<li class="page-item"><a class="page-link" href="'+controller+'?pager='+previousCurrent+'">Previous</a></li>';
		}
		
		for(var i = 1;i <= totalPages+1;i++){
			if(pageCurrent == i){
				html += '<li class="page-item active"><a class="page-link" href="'+controller+'?pager='+i+'">'+i+'</a></li>';
			}else{
				html += '<li class="page-item"><a class="page-link" href="'+controller+'?pager='+i+'">'+i+'</a></li>';
			}
		}
		
		var nextCurrent = pageCurrent;
		nextCurrent++;
		if(pageCurrent == totalPages+1){ 
			html += '<li class="page-item disabled"><a class="page-link" href="'+controller+'?pager='+nextCurrent+'">Next</a></li>';
		}else{
			html += '<li class="page-item"><a class="page-link" href="'+controller+'?pager='+nextCurrent+'">Next</a></li>';
		}
		html += '</ul>';
		html += '</nav>';
		$('#'+selects).html(function(){
			return html;
		});
	}
}
