<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>تعديل الموظفين</title>
<%@ include file="header.jsp"%>
</head>
<body background="img/playstation-hd-wallpapers-33510-5216201.jpg" onload="startTime()">


<form:form modelAttribute="user" action="update?id=${user.id}" >
	
 
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">التسلسل:</label>
							<form:input  path="id" disabled="true" value="${user.id}" type="text" class="form-control" id="Name" />
						</div>	
					
					<div >
							
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">الاسم:</label>
							<form:input  path="Name" value="${user.name}" type="text" class="form-control" id="Name" />
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">إسم المستخدم:</label>
							<form:input path="Username" type="text" class="form-control" id="Username"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">كلمة المرور:</label>
							<form:input path="Password" type="text" class="form-control" id="Password"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">المرتب:</label>
							<form:input path="Salary" type="text" class="form-control" id="Salary"/>
						</div>
				<div class="modal-footer">
									
						<button type="submit" class="btn btn-primary">حفظ</button>
						
				</div>
				
				</div>
						
	</form:form>
</body>
</html>