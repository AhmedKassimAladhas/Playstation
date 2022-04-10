<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>تعديل الاجهزة</title>
<%@ include file="header.jsp"%>
</head>
<body background="img/ps4-controller.jpg" onload="startTime()">


<form:form modelAttribute="device" action="updateDV?id=${device.ID}" >
	
 
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">التسلسل:</label>
							<form:input  path="ID" disabled="true"  type="text" class="form-control" id="Name" />
						</div>	
					
					<div >
							
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">نوع الجهاز:</label>
							<form:input path="typeps" type="text" value="${device.typeps}" class="form-control" id="typeps"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">رقم الجهاز:</label>
							<form:input path="number" type="text" class="form-control" id="number"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">سعر السنجل:</label>
							<form:input path="price_single" type="text" class="form-control" id="price_single"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">سعر الملتي:</label>
							<form:input path="price_multi" type="text" class="form-control" id="price_multi"/>
						</div>
					
				
				<div class="modal-footer">
					
						<button type="submit" class="btn btn-primary">حفظ</button>
						
				</div>
				
				</div>
						
	</form:form>
</body>
</html>