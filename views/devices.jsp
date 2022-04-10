<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>الاجهزة</title>
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
<body onload="startTime()">
	
	<div
		style="background-image: url('<spring:url value="/img/ps4-controller.jpg"/>'); height: 768px; width: 1350px;">

	<div align="center" style="margin-right: 10px;">
			
			<button type="button"  class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">جهاز جديد</button>
					
	
	<form>		
			<div
				style="position: relative; height: 600px; overflow: auto; width: 600px;">
				<input class="form-control" id="myInput" type="text"
					placeholder="Search.."> <br>
				<table class="table table-bordered table-hover mb-0" border="1"
					style="width: 600px;">
					<thead>
						<tr>
							<th>التسلسل</th>
							<th>نوع الجهاز</th>
							<th>رقم الجهاز</th>
							<th>السعر سنجل</th>
							<th>السعر ملتي</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
						<c:forEach items="${listDV}" var="li">
							<tr>
								<td style="color: maroon;font-weight: bold;">${li.ID}</td>
								<td style="color: blue; font-weight: bold;">${li.typeps}</td>
								<td style="color: blue; font-weight: bold;">${li.number}</td>
								<td style="color: blue; font-weight: bold;">${li.price_single}</td>
								<td style="color: blue; font-weight: bold;">${li.price_multi}</td>
								<td>
							
									<a href="editDV?id=${li.ID}" style="color: green;font-weight: bold;" title="تعديل"
									onclick="if (!(confirm('Are you sure you want to edit this device?'))) return false"
									><img src="img/icons8_edit_30px.png" width="30" height="30" alt=""></a>
								
									&nbsp;&nbsp;&nbsp;
									<a href="deleteDV?id=${li.ID}" style="color: maroon; font-weight: bold;" title="حذف"
									onclick="if (!(confirm('Are you sure you want to delete this device?'))) return false"
									><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a>
								</td>							
							</tr>
						</c:forEach>				
					</tbody>
				</table>
			</div>
	</form>
		</div>
		
		<form:form  action="saveDV" method="post" modelAttribute="device">
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">جهاز جديد</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">نوع الجهاز:</label>
							<form:input path="typeps" type="text" class="form-control" id="typeps"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">رقم الجهاز:</label>
							<form:input path="number" type="text" value="${num}" class="form-control" id="number"/>
							<form:input path="start" hidden="true" value="" type="text" class="form-control" id="start"/>
							<form:input path="status" hidden="true" value="" type="text" class="form-control" id="status"/>
<%-- 							<form:input path="status" hidden="true" value="" type="text" class="form-control" id="status"/> --%>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">السعر سنجل:</label>
							<form:input path="price_single" type="text" class="form-control" id="price_single"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">السعر ملتي:</label>
							<form:input path="price_multi" type="text" class="form-control" id="price_multi"/>
						</div>
						<form:input path="drink" hidden="true" type="text" value="" class="form-control" id="price_multi"/>
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