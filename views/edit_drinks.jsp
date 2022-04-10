<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>تعديل المشروبات</title>
<%@ include file="header.jsp"%>
</head>
<body background="img/Cocktail.jpg" onload="startTime()">


<form:form modelAttribute="drink" action="updateD?id=${drink.ID}" >
	
 
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">التسلسل:</label>
							<form:input  path="ID" disabled="true"  type="text" class="form-control" id="Name" />
						</div>	
					
					<div >
							
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">نوع المشروب:</label>
							<form:input  path="drinkType"  type="text" class="form-control" id="drinkType" />
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">السعر:</label>
							<form:input path="price" type="text" class="form-control" id="price"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">الملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
						</div>
					
				
				<div class="modal-footer">
					
						<button type="submit" class="btn btn-primary">حفظ</button>
						
				</div>
				
				</div>
						
	</form:form>
</body>
</html>