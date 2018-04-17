<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
	<link rel="stylesheet" href="Css/bootstrap.min.css">
	<link rel="stylesheet" href="Css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="Css/main.css">
	<link rel="stylesheet" href="Css/normalize.css" type="text/css" />
	<script type="text/javascript" src="Js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/collapse.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script type="text/javascript">
		$(function(){
			var user=[{"name":"甘松和","age":30,"adrees":"江西"},{"name":"熊文浩","age":18,"adrees":"江西"},{"name":"冯单珣","age":20,"adrees":"江西"},{"name":"熊造型","age":31,"adrees":"胡建"},{"name":"张小二","age":19,"adrees":"江西"},{"name":"蝴蝶谷","age":19,"adrees":"江西"},{"name":"胶泥露露","age":19,"adrees":"江西"},{"name":"风谷怕怕","age":19,"adrees":"江西"},{"name":"王二麻子","age":19,"adrees":"江西"},{"name":"东林顾子","age":19,"adrees":"江西"},{"name":"欧阳锋子","age":19,"adrees":"江西"},{"name":"多多","age":19,"adrees":"江西"},{"name":"嘻嘻","age":19,"adrees":"江西"},{"name":"滚滚滚","age":19,"adrees":"江西"},{"name":"来来来","age":19,"adrees":"江西"},{"name":"去去去","age":19,"adrees":"江西"},{"name":"大大","age":19,"adrees":"江西"},{"name":"疯子","age":19,"adrees":"江西"},{"name":"光子","age":19,"adrees":"甜美"}];
	
			var count=Object.keys(user).length;
			var pCount=parseInt(count/8);
			if(pCount<1){
				pCount=0;
			}
			var vm=new Vue({
				el: '#list',
				data: {
					userinfo : user
				}
			});
			var vm1=new Vue({
				el: '#listpage',
				data: {
					activeNumber: 1,
					pageCount: pCount
				}
			});
			
		});
	</script>
</head>
<body>
	<div class="container">
		<table class="table" id="list">
			<thead>
				<tr>
					<td><b>name</b></td>
					<td><b>age</b></td>
					<td><b>adrees</b></td>
				</tr>
			</thead>
			<tbody>
				<tr v-for="(info,index) in userinfo" v-if="index <= 7">
					<td>{{ info.name }}</td>
					<td>{{ info.age }}</td>
					<td>{{ info.adrees }}</td>
				</tr>
			</tbody>
		</table>
		<nav aria-label="Page navigation" id="listpage">
		  <ul class="pagination">
			<li>
			  <a href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			  </a>
			</li>
			<li v-for="n in pageCount">
				<a href="javascripit:void(0)" v-bind:class="activeNumber === n + 1 ? 'active' : ''">{{ n + 1 }}</a>
			</li>
			<li>
			  <a href="#" aria-label="Next">
				<span aria-hidden="true">&raquo;</span>
			  </a>
			</li>
		  </ul>
		</nav>
	</div>
</body>
</html>