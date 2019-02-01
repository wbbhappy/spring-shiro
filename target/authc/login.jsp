<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("home", path);
%>
<!DOCTYPE HTML>
<html lang="en-US">
	<script type="text/javascript" src="<%=request.getContextPath()%>/res/login/prefixfree.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/res/js/jquery-1.11.3.min.js"></script>
	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/res/login/login.css" type="text/css"></link>
		<script type="text/javascript">
			var home = "${home}";
			var msg = "${login_msg }";
			//生成验证码
			$(function(){
			    $('#verifyCodeImage').click(function () {  
			    $(this).hide().attr('src', '<%=path%>/member/getVerifyCodeImage?' + Math.floor(Math.random()*100) ).fadeIn(); });      
			});
			window.onbeforeunload = function(){  
			    //关闭窗口时自动退出  
			    if(event.clientX>360&&event.clientY<0||event.altKey){     
			        alert(parent.document.location);  
			    }  
			};
			//刷新
			function changeCode() {
			    $('#verifyCodeImage').hide().attr('src', '<%=path%>/member/getVerifyCodeImage?' + Math.floor(Math.random()*100) ).fadeIn();  
			    event.cancelBubble=true;  
			}
			if(msg!="") {
				alert(msg);
			}
		</script>
	</head>
	<body>
	   	<div class="content">
           	<form action="<%=request.getContextPath()%>/member/toLogin" method="post" class="login-form">
               	<div class="username">
                   	<input type="text" name="username" placeholder="emma.watson@gmail.com" autocomplete="on" />
					<div id="loginMsg"></div>
					<span class="user-icon icon">u</span>
               	</div>
               	<div class="password">
                   	<input type="password" name="password" placeholder="*******" />
                   	<span class="password-icon icon">p</span>
               	</div>
              	<div class="code-div">
                	<input type="text" name="verifyCode" placeholder="请输入验证码" />
		        	<img id="verifyCodeImage"  src="<%=request.getContextPath()%>/member/getVerifyCodeImage"/>
		      		<!--   <a href="javascript:void(0)" onclick="changeCode()">看不清?换一张</a>  -->
              	</div>
               	<div class="account-control">
                   	<input type="checkbox" name="rememberMe" id="Remember me" value="Remember me" checked="checked" />
                   	<label for="Remember me" data-on="c" class="check"></label>
                   	<label for="Remember me" class="info">Remember me</label>
                  	<!--  <input type="hidden" name="rememberMe" value="true"> -->
                   	<button type="submit">Login</button>
              	</div>
				<p class="not-registered">Not a registered user yet?<a>Sign up now!</a></p>
           	</form>
	   	</div>
	</body>
</html>