<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>إضافة مشروبات</title>
<%@ include file="header.jsp"%>
</head>
<body onload="startTime(),starTime()" background="img/7ghwT9.jpg">

	<div >
<form:form action="addDr2"  modelAttribute="line">
		<div style="width: 1360px; height: 450px; overflow: auto; " >
			<div >
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">إضافة مشروبات</h5>
				
				</div>
				<div class="modal-body" style="width: 500px;">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">فاتورة رقم:</label>
							<form:input path="number"  type="text" value="${numb}" class="form-control" id="number"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">نوع المشروب:</label>
							<form:select path="drinkt" var="dri" class="form-control form-control-sm"  id="drinkt">
							<c:forEach items="${listDR}" var="lis">
								<form:option  value="${lis.drinkType}">${lis.drinkType} : ${lis.price}</form:option>
							</c:forEach>	
							</form:select>
						</div>
<!-- 						<div class="form-group"> -->
<!-- 							<label for="recipient-name" class="col-form-label">Price: </label> -->
<%-- 							<form:input path="drinkprice" type="text"  class="form-control" id="drinkprice"/> --%>
<!-- 						</div> -->
						<div class="form-group">
							<label for="message-text" class="col-form-label">العدد:</label>
							<form:input path="drinkcount" type="text" class="form-control" id="drinkcount"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">ملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
						</div>
				</div>
				<div class="modal-footer">
					<a href="reservation" class="btn btn-secondary">رجوع</a>
						<button type="submit" class="btn btn-primary">حفظ</button>					
				</div>				
			</div>
		</div>
	</form:form>	
</div>
</body>
</html>