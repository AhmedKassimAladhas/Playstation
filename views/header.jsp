<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
<script>
	function startTime() {
		var today = new Date();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();
		
		m = checkTime(m);
		s = checkTime(s);		
		document.getElementById('txt').innerHTML = 
			h+":"+m+":"+s;
		t = setTimeout(function(){startTime()},500);
	}
	
	function checkTime(i)
	{
		if(i<10)
		{
			i = "0" + i;
		}
		return i;
	}
</script>
<title>YRRHELP</title>
</head>
<body onload="startTime()">
	<header>
		<div
			style="padding-top: 0px; height: 95px; background-image: url('<spring:url value="/img/ps-logo3.jpg"/>');">
			<form:form modelAttribute="user">
		
		</form:form>
		</div>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
			style="background-image: url('<spring:url value="/img/menus.jpg"/>'); width: 1365px;">
			<ul class="nav nav-tabs" style="height: 50px; ">
				<li><a href="home"> <img
						src="<spring:url value="/img/Playstation.jpg"/>" width="50"
						height="50" alt="">
				</a></li>

				<li class="nav-item" style="padding-left: 20px;"><a
					class="nav-link" href="home" style="height: 50px;">
					<img src="img/home_page_30px.png" width="20" height="20" alt="">
					الصفحة الرئيسية</a></li>
				<li class="nav-item"><a class="nav-link" href="reservation"
					style="height: 50px;">
					<img src="img/controller_filled_30px.png" width="20" height="20" alt="">
					الحجوزات</a></li>
				<li class="nav-item dropdown show"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="true"
					style="height: 50px;">
					<img src="img/settings_30px.png" width="20" height="20" alt="">
					الاعدادات</a>
					<div class="dropdown-menu " x-placement="bottom-start"
						style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 41px, 0px);">
						<form action="edit">
						<a class="dropdown-item" href="employees">الموظفين</a>
						</form>
						 <a
							class="dropdown-item" href="shifts">مواعيد العمل</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="drinks">المشروبات</a> <a
							class="dropdown-item" href="devices">الاجهزة</a>
					</div></li>
				<li class="nav-item dropdown show"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="true"
					style="height: 50px;">
					<img src="img/accounting_filled_30px.png" width="20" height="20" alt="">
					الحسابات</a>
					<div class="dropdown-menu " x-placement="bottom-start"
						style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 41px, 0px);">
						<a class="dropdown-item" href="expens">المصروفات</a> <a
							class="dropdown-item" href="endShift">تقفيل حساب اليوم</a>
					</div></li>
				<li style="margin-left: 120px; padding-top: 15px;  font-weight: bold; color: #6cc8e3; width: 250px;">			
					
				
      			<c:set var = "now" value = "<%=new java.util.Date()%>" />
      				<p><var id="txt"></var> &nbsp; <fmt:formatDate value = "${now}" 
         				type = "date"  dateStyle = "long" /></p>	
				</li>
				
				<li style=" " >					
						<a class="nav-link" href="Hello" 
					style="height: 50px; ">
					<img src="img/logout-left-30px.png" width="20" height="20" alt="">
					تسجيل خروج</a>										
				</li>
				<li  style=" margin-left: 5px; padding-top: 6px;  color: green; width: 150px;">
				<h5 align="right"  >		
				${name}
				</h5>
				</li>
			</ul>
			
		</nav>
	</header>

</body>
</html>