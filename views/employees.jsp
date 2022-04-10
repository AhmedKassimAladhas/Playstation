<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>الموظفين</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("#myInput").on(
						"keyup",
						function() {
							var value = $(this).val().toLowerCase();
							$("#myTable tr").filter(
									function() {
										$(this).toggle(
												$(this).text().toLowerCase()
														.indexOf(value) > -1)
									});
						});
			});
</script>
<%@ include file="header.jsp"%>
</head>
<body background="img/playstation-hd-wallpapers-33510-5216201.jpg" onload="startTime()">

	

		<div style="margin: 0px 0px;">
			
			<button type="button"  class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">موظف جديد</button>						
	
		<form>		
			<div
				style="position: relative; height: 400px; overflow: auto; width: 720px;">
				<input class="form-control" id="myInput" type="text"
					placeholder="Search.."> <br>
				<table class="table table-bordered table-hover mb-0" border="1"
					style="width: 700px;">
					<thead>
						<tr>
							<th>التسلسل</th>
							<th>الاسم</th>
							<th>اسم المستحدم</th>
							<th>المرتب</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
						<c:forEach items="${list}" var="list">
							<tr>
								<td>${list.id}</td>
								<td>${list.name}</td>
								<td>${list.username}</td>
								<td>${list.salary}</td>
								<td>							
									<a href="edit?id=${list.id}" style="color: green;font-weight: bold;"
									onclick="if (!(confirm('هل تريد نعديل هذا الموظف ؟'))) return false" title="تعديل"
									><img src="img/icons8_edit_30px.png" width="30" height="30" alt=""></a>								
									 &nbsp;&nbsp;&nbsp;
									<a href="delete?id=${list.id}" style="color: maroon; font-weight: bold;"
									onclick="if (!(confirm('هل تريد حذف هذا الموظف؟'))) return false" title="حذف"
									><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a>
								</td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
			</div>
	</form>
		</div>

<form:form  action="save" method="post" modelAttribute="user">
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">تسجيل موظف جديد</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">الاسم:</label>
							<form:input path="Name" type="text" class="form-control" id="Name"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">اسم المستخدم:</label>
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
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">إلغاء</button>
						<button type="submit" class="btn btn-primary">حفظ</button>					
				</div>				
			</div>
		</div>
	</div>
	</form:form>
</body>
</html>