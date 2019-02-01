<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title> admin界面</title>
	</head>
	<body>
		<h3>
			你是管理员，有权限访问该页面!!! ${userList }
		</h3>
		<br/>
		<a href="<%=request.getContextPath()%>/member/logout" target="_blank">Logout</a>  
	</body>
</html>