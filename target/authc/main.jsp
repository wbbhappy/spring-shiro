<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title> 功能界面</title>
	</head>
	<body>
		<ul>
			<li>
				普通用户可访问<a href="<%=request.getContextPath()%>/member/queryMyUserInfo" target="_blank">用户信息页面</a>
			</li>
			<li>
				管理员可访问<a href="<%=request.getContextPath()%>/admin/queryAllUserInfo" target="_blank">用户列表页面</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/member/logout" target="_blank">Logout</a>
			</li>
		</ul>
	</body>
</html>