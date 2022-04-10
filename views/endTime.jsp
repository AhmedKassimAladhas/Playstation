<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>إنهاء الحجز</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>		

<script type = "table/javascript">
         <!--
         //-->
      </script>
<%@ include file="header.jsp"%>      
</head>
<body onload="startTime()">

	<div style="background-image: url('<spring:url value="/img/baddfdc.png"/>'); height: 700px; overflow: auto;">
		
		
		<div style="  " >
		<object align="right" style="margin-right: 30px; padding-top: 100px;">					
			
			
			<div
				style="position: relative; ">
				<table id="t2" class="table table-bordered table-hover mb2" border="1" 
					style="width: 700px; border-color: white;">
					<thead>
						<tr>
							<th>جهاز رقم</th>
							<th>نوع الحجز</th>
							<th>من</th>
							<th>إلى</th>
							<th>عدد اوقات الحجز</th>
							<th>السعر</th>							
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
							<c:forEach items="${line}" var="li" >
							<tr>
								<td >${li.devicenum}</td>
								<td >${li.typeofres}</td>
								<td >${li.resfrom}</td>
								<td >${li.resto}</td>
								<td >${li.timecount}</td>
								<td >${li.resprice}</td>
							</tr>
							</c:forEach>
							
					</tbody>
				</table>
			</div>	
			
			==============================
			<div
				style="position: relative; ">
				<table id="t2" class="table table-bordered table-hover mb2" border="1" 
					style="width: 700px; border-color: white;">
					<thead>
						<tr>
							<th style="color: maroon;font-weight: bold;">جهاز رقم</th>
							<th style="color: maroon;font-weight: bold;">نوع المشروب</th>
							<th style="color: maroon;font-weight: bold;">السعر</th>
							<th style="color: maroon;font-weight: bold;">العدد</th>
							<th style="color: maroon;font-weight: bold;">الاجمالي</th>							
						</tr>
					</thead>
					<tbody id="myTable" style="overflow: scroll;">
							<c:forEach items="${lineD}" var="li" >
							<tr>
								<td style="color: maroon;">${li.devicenum}</td>
								<td style="color: maroon;font-weight: bold;">${li.drinkt}</td>
								<td style="color: maroon;">${li.drinkprice}</td>
								<td style="color: maroon;">${li.drinkcount}</td>
								<td style="color: maroon;">${li.drinktotal}</td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>
			
			==============================
			<div
				style="position: relative; ">
				<table id="t2" class="table table-bordered table-hover mb2" border="1" 
					style="width: 700px; border-color: white;">
					
					<tbody id="myTable" style="overflow: scroll;">
							<tr>
								<th width="50%">إجمالي الفاتورة</th>
								<td class="  badge-success">${totalInvo}</td>
							</tr>
					</tbody>
				</table>
			</div>	
			
	</object>
			<div >
			<form:form action="save" method="get" modelAttribute="inv" >
				<div style=" padding-left: 10px; padding-top: 10px;">	
						<a href="print?numberres=${numberres}"  class="btn btn-primary" target="_blank">طباعة الفاتورة</a>
						
							<button type="submit"  class="btn btn-primary"
							onclick="if (!(confirm('هل تريد حفظ الفاتورة ؟'))) return false"
							>حفظ الفاتورة</button>	
									
				</div>
			
				
				<div class="modal-body" style="width: 500px;">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">جهاز رقم:</label>
							<input name="devicenum" type="text" readonly="readonly" value="${devicenum}" class="form-control"  id="devicenum"/>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">فاتورة رقم:</label>
							<form:input path="number" type="text" readonly="true" value="${numberres}" class="form-control"  id="number"/>
						</div>
						
						<div class="form-group">
							<label for="message-text" class="col-form-label">الموظف:</label>
							<form:input path="empinv" type="text" readonly="true" class="form-control" value="${name}" id="empinv"/>
						</div>
						<div class="form-group">
							<label for="message-text" class="col-form-label">إجمالي الفاتورة:</label>
							<form:input path="totalinv"  readonly="true" type="text" value="${totalInvo}" class="form-control" id="totalinv"/>
						</div>		
						<div class="form-group">
							<label for="message-text" class="col-form-label">ملاحظات:</label>
							<form:textarea path="notes" type="text" class="form-control" id="notes"/>
						</div>
				</div>
	</form:form>
			</div>		
		</div>
	
</div>	
