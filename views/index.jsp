<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>تسجيل دخول</title>
</head>
<body  background="img/FormCover2.jpg" style="position: fixed;">

	

	<div style="margin: 335px 810px; width: 530px; height: 310px; padding: 20px 30px; 
 				">
		<h4>تسجيل دخول</h4>
		<form:form action="login" modelAttribute="Username" >
			<fieldset>
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input type="text" class="form-control" name="Username"
					placeholder="اسم المستخدم" style="width: 250px; text-align: right;" /><br> 
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input
					type="password" class="form-control" name="Password"
					placeholder="كلمة المرور" style="width: 250px; text-align: right;" /><br>
				 <button
					type="submit" class="btn btn-primary"
					style="width: 250px;">تسجيل دخول</button>
			</fieldset><br>
			<div class="alert-danger"  style="color: white; width: 250px;" align="center">${error}</div>
		</form:form>
	</div>
	
</body>
</html>