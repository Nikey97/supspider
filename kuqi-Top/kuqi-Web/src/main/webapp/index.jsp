<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发博客</title>
</head>
<body>
	<form action="admin/add_article.do" method="post">
		<input type="text" name="aId" /><p>
		<input type="text" name="aType"/><p>
		<input type="text" name="aTitle" /><p>
		<input type="text" name="aContent"/><p>
		<input type="submit" value="提交" /><p>
		<input type="reset" value="清空" /><p>
	</form>
</body>
</html>