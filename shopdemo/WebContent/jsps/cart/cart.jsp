	<%@page import="entitys.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<style type="text/css">
	a {
		text-decoration: none
	}
	.header,li{
		list-style: none;
		margin-right: 50px;
		font-size: 30px;
		float: left;
	}
</style>
</head>
<body>
	<div class="header">
		<ul>
			<li><a href="/shopdemo/querygoods">首页</a></li>
			<%User user = (User)request.getSession().getAttribute("usersession"); 
				if(user!=null){
			%>
			<li><a href="/shopdemo/jsps/user/selfinfo.jsp">个人中心</a></li>
			<li>欢迎你，${usersession.name}</li>
			<%}else{%>
			<li><a href="/shopdemo/jsps/user/login.jsp">登录</a></li>
			<%}%>
			<li><a href="/shopdemo/queryallcart">购物车</a></li>
		</ul>
		<hr>
	</div>
	
	<table border="1"   width="900px" height="100px" style="clear: both;float: left;text-align: center"  >
		<tr>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		<c:forEach var="item" items="${cartitemslist }">
			<tr>
				<td>${item.goodsname }</td>
				<td>￥${item.totalprice/item.count }</td>
				<td>${item.count }</td>
				<td>￥${item.totalprice }</td>
				<td><a href="/shopdemo/deletecartitem?id=${item.id }&userid=${usersession.id}">删除</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
	<a href="/shopdemo/GoodsServlet" style="font-size: 20px;float: left">   继续购买</a>
</body>
</html>