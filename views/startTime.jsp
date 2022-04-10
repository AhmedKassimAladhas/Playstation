<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>بدء وقت الحجز</title>
<%@ include file="header.jsp"%>
</head>
<body onload="startTime(),starTime()" background="img/7ghwT9.jpg">

	<div >
<form:form action="start?drinktotal=0.0"  modelAttribute="res" method="post">
		<div style="width: 1360px; height: 450px; overflow: auto; " >
			<div >
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">حجز وقت جديد</h5>
				
				</div>
				<div class="modal-body" style="width: 500px;">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">رقم الحجز:</label>
							<form:input path="number" type="text" readonly="true" value="${num}" class="form-control"  id="number"/>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">جهاز رقم:</label>
							<form:input path="devicenum" type="text" readonly="true" class="form-control" value="${dev.number}" id="devicenum"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">نوع الحجز:</label>
							<form:select path="typeofres" class="form-control form-control-sm" id="typeofres">
								<form:option value="single"></form:option>
								<form:option value="multi"></form:option>
							</form:select>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">تاريخ الحجز:</label>
							<form:input path="dateof"  readonly="true" type="text" value="${date}" class="form-control" id="dateof"/>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">بدء وقت الحجز من:</label>
							<form:input path="resfrom" type="text" class="form-control" value="${time}" id="resfrom"/>
						</div>																
						<div class="form-group">
							<label for="message-text" class="col-form-label">ملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
						</div>
				</div>
				<div class="modal-footer">
					<a href="reservation" class="btn btn-secondary">رجوع</a>
						<button type="submit" class="btn btn-primary">بدء</button>					
				</div>				
			</div>
		</div>
	</form:form>	
</div>
</body>
</body>
</html>