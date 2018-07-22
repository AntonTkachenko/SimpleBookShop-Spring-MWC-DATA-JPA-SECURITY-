<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">BookShop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/panel">Admin</a></li>
			<li class="nav-item"><sec:authorize access="!isAuthenticated()">
					<a class="nav-link" href="${pageContext.request.contextPath}/login"
						role="button">Login</a>
				</sec:authorize> <sec:authorize access="isAuthenticated()">
					<a class="nav-link"
						href="${pageContext.request.contextPath}/logout">Exit</a>
				</sec:authorize>
			</li>
		</ul>
	</div>
</nav>