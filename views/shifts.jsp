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

<title>مواعيد العمل</title>
<%@ include file="header.jsp"%>
</head>
<body background="img/playstation-4-hd.jpg" onload="startTime()">


<div align="left" style="margin-right: 10px;">
			
			<button type="button"  class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">موعد جديد</button>
						
	<form>		
			<div
				style="position: relative; height: 400px; overflow: auto; width: 800px;">
				<input class="form-control" id="myInput" type="date"
					placeholder="Search.."> <br>
				<table class="table table-bordered table-hover mb-0" border="1"
					style="width: 800px;">
					<thead>
						<tr>
							<th>التسلسل</th>
							<th>موعد رقم</th>
							<th>التاريخ</th>
							<th>من</th>
							<th>إلى</th>
							<th>الموظف</th>
							<th>ملاحظات</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
						<c:forEach items="${listSH}" var="li">
							<tr>
								<td style="color: maroon;font-weight: bold;">${li.ID}</td>
								<td style="color: blue; font-weight: bold;">${li.number}</td>
								<td style="color: blue; font-weight: bold;">${li.dateofshift}</td>
								<td style="color: blue; font-weight: bold;">${li.shiftfrom}</td>
								<td style="color: blue; font-weight: bold;">${li.shiftto}</td>
								<td style="color: blue; font-weight: bold;">${li.emp}</td>
								<td style="color: blue; font-weight: bold;">${li.notes}</td>
								<td>
							
									<a href="editSH?id=${li.ID}" style="color: green;font-weight: bold;" title="تعديل"
									onclick="if (!(confirm('Are you sure you want to edit this shift?'))) return false"
									><img src="img/icons8_edit_30px.png" width="30" height="30" alt=""></a>
								
									&nbsp;&nbsp;&nbsp;
									<a href="deleteSH?id=${li.ID}" style="color: maroon; font-weight: bold;" title="حذف"
									onclick="if (!(confirm('Are you sure you want to delete this shift?'))) return false"
									><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a>
								</td>							
							</tr>
						</c:forEach>				
					</tbody>
				</table>
			</div>
	</form>
		</div>
		
		<form:form  action="saveSH" method="post" modelAttribute="shift">
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">موعد جديد</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">رقم الموعد:</label>
							<form:input path="number" type="text" class="form-control" id="number"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">التاريخ:</label>
							<form:input path="dateofshift" type="date" class="form-control" id="dateofshift"/>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">من:</label>
							<form:input path="shiftfrom" type="time" class="form-control" id="shiftfrom"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">إلى:</label>
							<form:input path="shiftto" type="time" class="form-control" id="shiftto"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">الموظف:</label>
							<form:select path="emp" class="form-control form-control-sm" id="emp">
							<c:forEach items="${list}" var="lis">
								<form:option value="${lis.name}">${lis.name}</form:option>
							</c:forEach>	
							</form:select>
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
</body>
</html>