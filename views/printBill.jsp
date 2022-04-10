<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>طباعة</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>		
      
      
</head>
<body  onload="window.print()" background="img/mv2_d_6.png">
		
		<br><br>
		<div style="width: 300px; margin-left: 10px;">
		<h4 align="center">WE HOPE YOU ENJOYED</h4>
		
		==============================
							<div align="center"> ${date} </div>
							
							<div align="center">Invoice: ${numberres} </div>
							<br>
			<div
				style="position: relative;">
				<table id="t2" class="" border="1" 
					style="width: 300px; border-color: white;">
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
				style="position: relative;">
				<table id="t2" class="" border="1" 
					style="width: 300px; border-color: white;">
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
				style="position: relative;">
				<table id="t2" class="" border="1" 
					style="width: 300px; border-color: white;">
					
					<tbody id="myTable" style="overflow: scroll;">
							<tr>
								<th width="50%">إجمالى الفاتورة</th>
								<td class="  badge-success">${totalInvo}</td>
							</tr>
					</tbody>
				</table>
			</div>	
	
	
		==============================
		<h1 class="display-5" align="center">Wait you again</h1>
				
</div>
</body>