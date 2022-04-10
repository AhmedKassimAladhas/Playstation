<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- <meta charset="utf-8"> -->
<title>إنهاء حساب اليوم</title>
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
<body onload="startTime()" background="img/baddfdc.png">
	<div
		>

		<div align="left" style="width: 1340px;">

			<button type="button" class="btn btn-dark" data-toggle="modal"
				data-target="#exampleModal">إنهاء حساب اليوم</button>


			<form>
				<div
					style="position: relative; height: 400px; overflow: auto; ">
					<input class="form-control" id="myInput" type="date"
						placeholder="Search.."> <br>
					<table class="table table-bordered table-hover mb-0" border="1"
						>
						<thead>
							<tr>
								<th>التسلسل</th>
								<th>التاريخ</th>
								<th>رقم موعد العمل</th>
								<th>الموظف</th>
								<th>المصروفات</th>
								<th>الفواتير</th>
								<th>إجمالي  اليوم</th>
								<th>الملاحظات</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="myTable" style="overflow: scroll;">
							<c:forEach items="${listEn}" var="li">
								<tr>
									<td style="color: maroon; font-weight: bold;">${li.ID}</td>
									<td style="color: blue; font-weight: bold;">${li.dateofacc}</td>
									<td style="color: blue; font-weight: bold;">${li.shiftnum}</td>
									<td style="color: blue; font-weight: bold;">${li.empname}</td>
									<td style="color: blue; font-weight: bold;">${li.exp}</td>
									<td style="color: blue; font-weight: bold;">${li.invtotal}</td>
									<td style="color: blue; font-weight: bold;">${li.total}</td>
									<td style="color: blue; font-weight: bold;">${li.notes}</td>
									<td><a href="deleteEn?id=${li.ID}" title="حذف"  
										style="color: maroon; font-weight: bold;"
										onclick="if (!(confirm('هل تريد حذف هذا الحساب؟'))) return false"
										><img src="img/icons8_delete_bin_30px.png" width="30" height="30" alt=""></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
		</div>

		<form:form action="saveEn"  modelAttribute="daily">
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-scrollable" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">إنهاء حسابات اليوم</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="message-text" class="col-form-label">التاريخ:</label>
								<form:input path="dateofacc" type="text" readonly="true"
									class="form-control" value="${dateof}" id="dateofacc" />
							</div>
							<div class="form-group">
								<label for="recipient-name" class="col-form-label">رقم معاد العمل:</label>
								<form:input path="shiftnum" type="text" readonly="true"
								 class="form-control" value="${shiftNum}" id="shiftnum" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">الموظف:</label>
								<form:input path="empname" type="text" readonly="true"
								 class="form-control" value="${name}" id="empname" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">المصروفات:</label>
								<form:input path="exp" type="text" readonly="true"
									class="form-control" value="${exp}" id="exp" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">الفواتير:</label>
								<form:input path="invtotal" type="text" readonly="true"
									class="form-control" value="${invototal}" id="invtotal" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">إجمالي فواتير اليوم:</label>
								<form:input path="total" type="text" readonly="true"
									class="form-control" value="${total}" id="total" />
							</div>
							<div class="form-group">
								<label for="message-text" class="col-form-label">ملاحظات:</label>
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