<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>الصفحة الرئيسية</title>
<!-- <meta name="viewport" -->
<!-- 	content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- <script -->
<!-- 	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
<%@ include file="header.jsp"%>
</head>
<body onload="startTime()" background="img/playstation-game.png">
	<div class="">
		<button class="btn btn-primary float-left" type="button"
			data-toggle="collapse" data-target="#collapseExample"
			aria-expanded="false" aria-controls="collapseExample">
			<span class="badge badge-success" style="font-size: medium;">${Res}</span>&nbsp; الاجهزة المحجوزة 
		</button>

		<button class="btn btn-primary float-right" type="button"
			data-toggle="collapse" data-target="#collapseExample2"
			aria-expanded="false" aria-controls="collapseExample2">
			<span class="badge badge-info" style="font-size: medium;">${Empty}</span>&nbsp; الاجهزة الغير محجوزة  
		</button>
	</div>

	<div  id="accordionExample2" style="margin-top: 1%;">

		<div class="btn-group">
			<div id="collapseExample" class="collapse"
				data-parent="#accordionExample2">

				<form:form modelAttribute="line">
					<div
						style="height: 450px; width: 1360px; padding: 5px; overflow: auto;">
						<div class="card-columns">
							<c:forEach items="${listDVR}" var="lis">
								<div class="card" style="height: 450px; width: 310px;">
									<img src="img/PS3 Controller.jpg" class="card-img-top"
										alt="..." height="150px" width="50px">
									<div class="card-body">
										<div align="center"
											style="font-weight: bolder; background-color: success; padding-top: 2px; height: 30px;"
											class="text-white bg-warning">
											<form:label path="devicenum" class="card-title">${lis.number}</form:label>
										</div>
										<ul class="list-group list-group-flush">
											<li class="list-group-item ">حالة الجهاز:
												&nbsp;&nbsp;&nbsp; <span
												class="badge badge-pill badge-success">${lis.status}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<span class="badge badge-pill badge-success">${lis.typereser}</span>
											</li>
											<li class="list-group-item">وقت الحجز من:
												&nbsp;&nbsp;&nbsp;&nbsp; <span
												class="badge badge-pill badge-light">${lis.start}</span> 
												
													<button  class="btn btn-outline-info float-right"
														data-toggle="dropdown" role="button" aria-haspopup="true"
														aria-expanded="false" title="Convert to"></button>
													<div class="dropdown-menu" style="">
														<a class="dropdown-item"
															href="getconvert?devicenum=${lis.number}"
															onclick="if (!(confirm('هل تريد الانتقال إلى جهاز اخر؟'))) return false">الأنتقال
															إلى جهاز اخر</a>
														<div class="dropdown-divider"></div>

														<a class="dropdown-item"
															href="convertType?devicenum=${lis.number}&drinktotal=0.0&number=${lis.numberres}"
															onclick="if (!(confirm('هل تريد تغيير نوع الحجز؟'))) return false">تغيير
															نوع الحجز من ${lis.typereser} </a>
													</div>
												
											</li>
											<li class="list-group-item">المشروبات:
												&nbsp;&nbsp;&nbsp;&nbsp; <span
												class="badge badge-pill badge-light">${lis.drink}</span> 
												
													<a  class="btn btn-outline-danger float-right"
														title="Add Drink" href="EditDrink?number=${lis.number}"></a>
												
											</li>
										</ul>
										<div class="card-body" align="center">
											<a href="AddDrink?number=${lis.number}"
												class="btn btn-danger btn-sm">طلب مشروبات</a> &nbsp;&nbsp; <a
												href="endTime?devicenum=${lis.number}&numberres=${lis.numberres}"
												class="btn btn-success btn-sm"
												onclick="if (!(confirm('هل تريد إنهاء الحجز ؟'))) return false">إنهاء
												الحجز</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</form:form>

			</div>
		</div>

		<div class="btn-group">
			<div id="collapseExample2" class="collapse"
				data-parent="#accordionExample2">

				<form:form modelAttribute="line">
					<div
						style="height: 450px; width: 1360px; padding: 10px; overflow: auto;"
						align="center">
						<div class="card-columns">
							<c:forEach items="${listDVS}" var="lis">
								<div class="card" style="height: 220px; width: 200px;">
									<img src="img/PS3 Controller.jpg" class="card-img-top"
										alt="..." height="100px" width="30px">
									<div class="card-body">
										<div align="center"
											style="font-weight: bolder; background-color: success; padding-top: 2px; height: 30px;"
											class="text-white bg-warning">
											<form:label path="devicenum" class="card-title">${lis.number}</form:label>
										</div>

										<div class="card-body">
											<a href="getD?devicenum=${lis.number}"
												class="btn btn-info btn-sm" style="width: 100px;">بدء الحجز</a>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>
	<!-- 	Reserved -->


	<!-- 	Empty -->


</body>
</html>