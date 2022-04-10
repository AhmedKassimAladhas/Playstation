<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
<meta charset="utf-8">
<title>المصروفات</title>
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
		style="background-image: url('<spring:url value="/img/JsKFy.png"/>'); height: 590px;">

		<div align="left" style="margin-right: 10px;">

			<button type="button" class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">مصروف جديد</button>


			<form>
				<div
					style="position: relative; height: 400px; overflow: auto; width: 700px;">
					<input class="form-control" id="myInput" type="text"
						placeholder="Search.."> <br>
					<table class="table table-bordered table-hover mb-0" border="1"
						style="width: 700px;">
						<thead>
							<tr>
								<th>التسلسل</th>
								<th>التاريخ</th>
								<th>المصروف</th>
								<th>السعر</th>
								<th>الموظف</th>
								<th>الملاحظات</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="myTable" style="overflow: scroll;">
							<c:forEach items="${listEX}" var="li">
								<tr>
									<td style="color: maroon; font-weight: bold;">${li.ID}</td>
									<td style="color: blue; font-weight: bold;">${li.expdate}</td>
									<td style="color: blue; font-weight: bold;">${li.expname}</td>
									<td style="color: blue; font-weight: bold;">${li.expprice}</td>
									<td style="color: blue; font-weight: bold;">${li.expemp}</td>
									<td style="color: blue; font-weight: bold;">${li.notes}</td>
									<td><a href="deleteEX?id=${li.ID}" title="حذف"
									onclick="if (!(confirm('هل تريد حذف هذا المصروف'))) return false"
										style="color: maroon; font-weight: bold;"><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
		</div>

		<form:form action="saveEX" method="post" modelAttribute="exp">
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">مصروف جديد</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="message-text" class="col-form-label">التاريخ:</label>
								<form:input path="expdate" type="text" readonly="true"
									class="form-control" value="${date}" id="expdate" />
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">المصروف:</label>
								<form:input path="expname" type="text" class="form-control"
									id="expname" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">السعر:</label>
								<form:input path="expprice" type="text" class="form-control"
									id="expprice" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">الموظف:</label>
								<form:input path="expemp" type="text" readonly="true"
									class="form-control" value="${name}" id="expemp" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">الملاحظات:</label>
								<form:textarea path="notes" type="text" class="form-control"
									id="notes" />
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