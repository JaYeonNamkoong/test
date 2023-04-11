<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm mybgColor">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/main"
				class="nav-link active">Home</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/myboard/boardlist"
				class="nav-link">Board</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/upload/upboardList"
				class="nav-link">List(Upload)</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/mail/emailForm"
				class="nav-link">email</a></li>
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/web/survey/surveyForm"
				class="nav-link">survey</a></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"> chart </a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/studentchart">bar_chart</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/donutchart">donut_chart</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/deptJsonDemo">deptJsonDemo</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/memberlistJson">memberlistJson</a></li>
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/chart/surveyDonutChartAjax">surveyDonutChartAjax</a></li>
					<li><hr class="dropdown-divider"></li>
				</ul></li>


			<li class="nav-item"><a href="#" class="nav-link">Profile</a></li>
			<li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
			
			
			<!-- test ¹× semi Àû¿ë -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"> TourChart </a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="${pageContext.request.contextPath}/web/tchart/busan">Busan</a></li>

					<li><hr class="dropdown-divider"></li>
				</ul></li>
			
			
		</ul>
		<form class="d-flex">
			<input class="form-control me-2" type="text" placeholder="Search"
				name="searchv" id="searchv">
			<button class="btn btn-primary" type="button">Search</button>
		</form>
	</div>
</nav>