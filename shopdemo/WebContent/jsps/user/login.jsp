<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

    
</head>
<body>
<form action="/shopdemo/LoginServlet" method="post">
	<div class="dowebok">
        <div class="logo"></div>
            <div class="form-item">
                <input id="username" type="text" name="username" autocomplete="off" placeholder="账户名">
            </div>
            <div class="form-item">
                <input id="password" type="password" name="password" autocomplete="off" placeholder="登录密码">
            </div>
        <div class="form-item">
        <button id="submit">登 录</button>
        </div>
        <div class="reg-bar">
            
            <!--
            <a class="reg" href="javascript:">立即注册</a>
            <a class="forget" href="javascript:">忘记密码</a> 
            -->
            <input type="checkbox" name="auto" id="auto" checked="checked">自动登录
        </div>
    </div>
</form>
</body>
</html>
    <script>
		var msg ='<%=request.getParameter("msg") %>';
			if(msg==0){
				alert("账号或密码错误,请重新登录!");
			}		
	</script>




