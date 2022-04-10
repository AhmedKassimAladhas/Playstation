<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<link  type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<title>Hello</title>
</head>
<body background='<spring:url value="img/FormCover2.jpg"/>' style="position: fixed;"> 
	
	<div
		style="margin: 335px 810px; width: 530px; height: 310px; padding: 20px 30px;">
		
		<h1 class="display-5">Hello, My Friend 
		<img src="img/hearts_48px.png" width="40" height="40" alt="">
		</h1>
		  <p></p>
		  <p class="lead">Never listen that you can't
		  <img src="img/trust_filled_50px.png" width="20" height="20" alt="">
		  </p>
		  <p >The Best Dreams Happen When Your Awake
		  <img src="img/easy_50px.png" width="20" height="20" alt="">
		  </p>
		  <p class="lead">You Can 
		  <img src="img/ok_hand_50px.png" width="20" height="20" alt="">
		  </p>
		<form action="index">
		<br>	<button type="submit" class="btn btn-primary" >Go To Login</button>
		</form>
	</div>
</body>
</html>