<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>تعديل مواعيد العمل</title>
<%@ include file="header.jsp"%>
</head>
<body background="img/Cocktail.jpg" onload="startTime()">


<form:form modelAttribute="shift" action="updateSH?id=${shift.ID}" >
	
 
				<div class="form-group">
						<label for="recipient-name" class="col-form-label">التسلسل:</label>
						<form:input  path="ID" disabled="true"  type="text" class="form-control" id="Name" />
				</div>	
							
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
							<label for="message-text" class="col-form-label">الموظغ:</label>
							<form:select path="emp" class="form-control form-control-sm" id="emp">
							<c:forEach items="${list}" var="lis">
								<form:option value="${lis.name}"></form:option>
							</c:forEach>	
							</form:select>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">ملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
						</div>	
				
				<div class="modal-footer">
						<button type="submit" class="btn btn-primary">حفظ</button>						
				</div>
						
	</form:form>

</body>
</html>