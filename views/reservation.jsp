<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>الحجوزات</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script>
	function starTime() {
		var today = new Date();
		var h = today.getHours();
		var m = today.getMinutes();
		var s = today.getSeconds();

		m = checkTime(m);
		s = checkTime(s);
		document.getElementById('tim').innerHTML = h + ":" + m + ":" + s;
		t = setTimeout(function() {
			statTime()
		}, 500);
	}

	function checkTime(l) {
		if (l < 10) {
			l = "0" + l;
		}
		return l;
	}
</script>
<%@ include file="header.jsp"%>
</head>
<body onload="startTime(),starTime()" background="img/7ghwT9.jpg">


	<form:form modelAttribute="line">
		<div
			style="height: 500px; width: 1360px; padding: 10px; 10 px; overflow: auto;">
			<div class="card-columns">
				<c:forEach items="${listDV}" var="lis">
					<div class="card">
						<img src="img/PS3 Controller.jpg" class="card-img-top" alt="..."
							height="200px">
						<div class="card-body">
							<div align="center"
								style="font-weight: bolder; background-color: success; padding-top: 2px; height: 30px;"
								class="text-white bg-warning">
								<form:label path="devicenum" class="card-title">${lis.number}</form:label>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">حالة الجهاز:
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
									class="badge badge-pill badge-success">${lis.status}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<span class="badge badge-pill badge-success">${lis.typereser}</span>
								</li>
								<li class="list-group-item">وقت الحجز من:
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
									class="badge badge-pill badge-light">${lis.start}</span> <object
										align="right">
										<button style="height: 30px;" class="btn btn-outline-info"
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
									</object>
								</li>
								<li class="list-group-item">المشروبات:
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
									class="badge badge-pill badge-light">${lis.drink}</span> <object
										align="right">
										<a style="height: 30px;" class="btn btn-outline-danger"
											title="Add Drink" href="EditDrink?number=${lis.number}"></a>
									</object>
								</li>
							</ul>
							<div class="card-body">

								<a href="getD?devicenum=${lis.number}" class="btn btn-info">بدء
									الحجز</a> &nbsp; <a href="AddDrink?number=${lis.number}"
									class="btn btn-danger">طلب مشروبات</a> &nbsp; <a
									href="endTime?devicenum=${lis.number}&numberres=${lis.numberres}"
									class="btn btn-success"
									onclick="if (!(confirm('هل تريد إنهاء الحجز ؟'))) return false">إنهاء
									الحجز</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form:form>

</body>
</html>