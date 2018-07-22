<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form method="post"
		action="${pageContext.request.contextPath}/admin/saveBook">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="form-group">
			<label for="bookTitle">Title</label> <input type="text"
				class="form-control" id="bookTitle" placeholder="Book title"
				name="bookTitle" required="required">
		</div>
		<div class="form-group">
			<label for="bookDescription">Description</label>
			<textarea class="form-control" id="bookDescription" rows="3"
				name="bookDescription" required="required"></textarea>
		</div>
		<div class="form-group">
			<label for="bookPrice">Price</label> <input type="number"
				required="required" class="form-control" step="0.1" min="10"
				name="bookPrice" id="bookPrice" placeholder="Book price">
		</div>
		<div class="form-group">
			<label for="authorsId">Authors</label> <select class="form-control"
				id="authorsId" name="authorsId" multiple="multiple"
				required="required">
				<c:forEach items="${authors}" var="author">
					<option value="${author.id }">${author.firstName }
						${author.secondName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="bookGenres">Genres</label> <select multiple
				class="form-control" id="bookGenres" name="genresId"
				required="required">
				<c:forEach items="${genres}" var="genre">
					<option value="${genre.id }">${genre.name}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>