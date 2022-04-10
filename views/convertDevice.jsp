<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>إنتغال لإلى جهاز اخر</title>
<%@ include file="header.jsp"%>
</head>
<body onload="startTime(),starTime()" background="img/7ghwT9.jpg">


<form:form action="convert"  modelAttribute="line">
	<div style="margin-top: 0px;">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				
				<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">رقم الفاتورة:</label>
							<form:input path="number"  type="text" value="${invo}" class="form-control" id="number"/>
							<input name="price"  type="text" value="${price}" hidden="true" class="form-control" id="number"/>
							<input name="drinktotal"  type="text" value="0.0" hidden="true" class="form-control" id="drinktotal"/>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">رقم الجهاز:  </label>
							<form:select path="devicenum" class="form-control form-control-sm"  id="devicenum">
							<c:forEach items="${listDV}" var="lis">
								<form:option  value="${lis.number}"></form:option>
							</c:forEach>	
							</form:select>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">نوع الحجز:</label>
							<form:select path="typeofres" var="dri" class="form-control form-control-sm"  id="typeofres">
								<form:option  value="single"></form:option>
								<form:option  value="multi"></form:option>
							</form:select>
						</div>						
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">بدء من:</label>
							<form:input path="resfrom" type="text" class="form-control" value="${time}" id="resfrom"/>
						</div>
						<div class="form-group">											
				</div>
				<div class="modal-footer">
					<a href="reservation" class="btn btn-secondary" >رجوع</a>					
						<button type="submit"  class="btn btn-primary">حفظ</button>											
				</div>				
			</div>
		</div>
	</div>
	</div>
	</form:form>
</body>
</html>