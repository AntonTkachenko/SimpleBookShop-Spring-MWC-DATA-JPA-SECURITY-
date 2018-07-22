<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="counter" value="0"></c:set>
<div class="container">
	<form method="post"
		action="${pageContext.request.contextPath}/admin/editBook/saveChanges">
		<input type="hidden" value="${book.id }" name="bookId">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="form-group">
			<label for="bookTitle">Title</label> <input type="text"
				class="form-control" id="bookTitle" placeholder="Book title"
				name="bookTitle" required="required" value="${book.title }">
		</div>
		<div class="form-group">
			<label for="bookDescription">Description</label>
			<textarea class="form-control" id="bookDescription" rows="3"
				name="bookDescription" required="required">${book.description }</textarea>
		</div>
		<div class="form-group">
			<label for="bookPrice">Description</label> <input type="number"
				required="required" class="form-control" step="0.1" min="10"
				name="bookPrice" id="bookPrice" value="${book.price }">
		</div>
		<div class="form-group">
			<label for="authorsId">Authors</label> <select class="form-control"
				id="authorsId" name="authorsId" multiple="multiple"
				required="required">
				<c:forEach items="${authors}" var="author">
					<c:forEach items="${book.authors }" var="bookAuthor">
						<c:choose>
							<c:when test="${author eq  bookAuthor}">
								<option id="${author.id }" value="${author.id }"
									selected="selected">${author.firstName }
									${author.secondName }</option>
								<c:set var="counter" value="1"></c:set>
							</c:when>
							<c:otherwise>
								<c:if test="${counter == 0 }">
									<option id="${author.id }" value="${author.id }">${author.firstName }
										${author.secondName }</option>
									<c:set var="counter" value="1"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:set var="counter" value="0"></c:set>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="bookGenders">Genres</label> <select multiple
				class="form-control" id="bookGenres" name="genresId"
				required="required">
				<c:forEach items="${genres}" var="genre">
					<c:forEach items="${book.genres }" var="bookGenre">
						<c:choose>
							<c:when test="${genre eq  bookGenre}">
								<option id="${genre.id }" value="${genre.id }"
									selected="selected">${genre.name }</option>
								<c:set var="counter" value="1"></c:set>
							</c:when>
							<c:otherwise>
								<c:if test="${counter == 0 }">
									<option id="${genre.id }" value="${genre.id }">${genre.name }</option>
									<c:set var="counter" value="1"></c:set>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:set var="counter" value="0"></c:set>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>