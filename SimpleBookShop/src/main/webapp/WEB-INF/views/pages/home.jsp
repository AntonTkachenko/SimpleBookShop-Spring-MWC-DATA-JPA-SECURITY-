<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<h1 class="display-2">BookShop</h1>
</div>
<c:set var="count" value="1"></c:set>
<div class="row">
	<div class="col-sm-2">
		<form action="${pageContext.request.contextPath}/filter" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			<div class="form-group">
				<label for="genders">Genres</label> <select class="form-control"
					id="genders" name="genresId" multiple="multiple">
					<c:forEach items="${genres}" var="genre">
						<option value="${genre.id }">${genre.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="authorsId">Authors</label> <select multiple
					class="form-control" id="authorsId" name="authorsId">
					<c:forEach items="${authors }" var="author">
						<option value="${author.id }">${author.firstName }
							${author.secondName }</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Filter</button>
		</form>
	</div>
	<div class="col col-sm-8">
		<div class="row">
			<c:forEach var="book" items="${books }">
				<div class="col mb-1 mt-1">
					<div class="card text-center w-100 p-3">
						<div class="card-body">
							<h5 class="card-title">${book.title }</h5>
							<p class="card-text">
								<textarea
									style="background-color: white; border: 0px; white-space: normal; text-align: justify; -moz-text-align-last: center; text-align-last: center;"
									class="form-control" readonly="readonly" wrap="hard" rows="3"
									cols="6">${book.description }</textarea>
							</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Price: ${book.price } $</li>
						</ul>
						<div class="card-body">
							<a href="${pageContext.request.contextPath}/order/${book.id}/new"
								class="card-link btn btn-outline-success">Buy</a>
						</div>
					</div>
				</div>
				<c:if test="${(count % 3) == 0 }">
					<div class="w-100"></div>
				</c:if>
				<c:set var="count" value="${count + 1 }"></c:set>
			</c:forEach>
		</div>
	</div>
</div>