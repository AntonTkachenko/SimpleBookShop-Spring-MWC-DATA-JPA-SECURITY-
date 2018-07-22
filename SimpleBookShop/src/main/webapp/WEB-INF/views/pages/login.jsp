<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form action="login" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="form-group">
			<label for="exampleInputEmail">Login</label> <input type="text"
				class="form-control" id="exampleInputEmail"
				placeholder="Enter login" name="j_username">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword"
				placeholder="Enter password" name="j_password">
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
</div>