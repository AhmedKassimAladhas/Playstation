<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html >
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

<title>المشروبات</title>
<%@ include file="header.jsp"%>
</head>
<body onload="startTime()" background="" >


<div style="background-image: url('img/Cocktail2.jpg'); height: 768px;">
<div align="right" style="margin-right: 10px;">
			
			<button type="button"  class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">مشروب جديد</button>
					
	
	<form>		
			<div
				style="position: relative; height: 400px; overflow: auto; width: 600px;">
				<input class="form-control" id="myInput" type="text"
					placeholder="Search.."> <br>
				<table class="table table-bordered table-hover mb-0" border="1"
					style="width: 600px;">
					<thead>
						<tr>
							<th>التسلسل</th>
							<th>نوع المشروب</th>
							<th>السعر</th>
							<th>ملاحظات</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
						<c:forEach items="${listD}" var="li">
							<tr>
								<td style="color: maroon;font-weight: bold;">${li.ID}</td>
								<td style="color: blue; font-weight: bold;">${li.drinkType}</td>
								<td style="color: blue; font-weight: bold;">${li.price}</td>
								<td style="color: blue; font-weight: bold;">${li.notes}</td>
								<td>
							
									<a href="editD?id=${li.ID}" style="color: green;font-weight: bold;"
									onclick="if (!(confirm('هل تريد تعديل هذا المشروب؟'))) return false" title="تعديل"
									><img src="img/icons8_edit_30px.png" width="30" height="30" alt=""></a>
								
									&nbsp;&nbsp;&nbsp;
									<a href="deleteD?id=${li.ID}" style="color: maroon; font-weight: bold;"
									onclick="if (!(confirm('هل تريد حذف هذا المشروب؟'))) return false" title="حذف"
									><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a>
								</td>							
							</tr>
						</c:forEach>				
					</tbody>
				</table>
			</div>
	</form>
		</div>
		
		<form:form  action="saveD" method="post" modelAttribute="drink">
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">مشروب جديد</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">نوع المشروب:</label>
							<form:input path="drinkType" type="text" class="form-control" id="drinkType"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">السعر:</label>
							<form:input path="price" type="text" class="form-control" id="price"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">ملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
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
</div>
</body>
</html>