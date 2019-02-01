<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href = "<%=basePath%>">
        <title>验证码</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/res/js/jquery-1.11.3.min.js">
        </script>
    </head>
    <body>
        <script type="text/javascript">
            //生成验证码
            $(function(){
                $('#kaptchaImage').click(function () {
                $(this).hide().attr('src', '<%=path%>/member/captcha-image?' + Math.floor(Math.random()*100) ).fadeIn(); });
            });
            window.onbeforeunload = function(){
                //关闭窗口时自动退出
                if(event.clientX>360&&event.clientY<0||event.altKey){
                    alert(parent.document.location);
                }
            };
            //刷新
            function changeCode() {
                $('#kaptchaImage').hide().attr('src', '<%=path%>/member/captcha-image?' + Math.floor(Math.random()*100) ).fadeIn();
                event.cancelBubble=true;
            }
            /* $(document).ready(function() {

            }) */
            $("#kaptcha").change(function() {
	            alert("1111");
	            //location.href = "<%=path%>/member/checkCode";
	            //checkCode();
            });
            //$("#kaptcha").onblur()
            function checkCode() {
                //location.href = "<%=path%>/member/checkCode";
                alert($("#kaptcha").val());
                var codeByUser = $("#kaptcha").val();
                var codeBySystem = "${systemCode}";
                alert(codeBySystem);
                alert("${codesBy}");
                //$("systemCode").val();
                //alert("${checkCodes}");
                //var codeBySystem=${codeSystem};
                //var codeBySystem = session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                if(codeByUser !=null && codeBySystem!=null) {
                    if(codeBySystem ==(codeByUser)) {
                        alert("true");
                        $("#textSpan").text("验证通过");
                    }else {
                        alert("false");
                        $("#textSpan").text("验证未通过");
                    }
                }
            }
        </script>
        <div class="form-group">
            <label>验证码 </label>
            <!-- onchange="checkCode()" -->
            <form action="<%=path%>/member/checkCode">
                <input name="j_code" type="text" id="kaptcha" maxlength="4" class="form-control"  />
                <br/>
                <img src="<%=path%>/member/captcha-image" id="kaptchaImage"  style="margin-bottom: -3px"/>
                <a href="javascript:void(0)" onclick="changeCode()">看不清?换一张</a>
                <input type="submit" value="验证">
                <span id="textSpan">${checkCode }</span>
                <%-- <input type="text" value="${checkCodes}" class="systemCode"> --%>
            </form>
        </div>
        <%
            String c = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
            String parm = (String) request.getParameter("j_code");  
            out.println("Parameter: " + parm + " ? Session Key: " + c + " : ");  
            if (c != null && parm != null) {  
                if (c.equals(parm)) {  
                    out.println("<b>true</b>");  
                } else {  
                    out.println("<b>false</b>");  
                }  
            }  
        %>   
    </body>
</html>
