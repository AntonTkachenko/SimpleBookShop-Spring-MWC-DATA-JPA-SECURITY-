<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<c:if test="${not empty request }">
		<c:if test="${ false == request.result}">
			<div class="alert alert-warning alert-dismissible fade show"
				role="alert">
				<span>${request.message }</span>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<c:if test="${true == request.result }">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<span>${request.message }</span>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
	</c:if>
	<div class="table-responsive">
		<table id="escalation" class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Genres</th>
					<th>Authors</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td>${book.title}</td>
						<td>${book.description}</td>
						<td><c:forEach items="${book.genres }" var="genre">
							${genre.name }<br>
							</c:forEach></td>
						<td><c:forEach items="${book.authors }" var="author">
							${author.firstName } ${author.secondName }<br>
							</c:forEach></td>
						<td>${book.price}</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/admin/deleteBook"
								id="formDelete_${book.id }" method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input type="hidden" name="bookId"
									value="${book.id}">
							</form>
							<form action="${pageContext.request.contextPath}/admin/editBook"
								id="formEdit_${book.id }" method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input type="hidden" name="bookId"
									value="${book.id}">
							</form>
							<div class="input-group-append">
								<button form="formEdit_${book.id }" type="submit"
									class="btn btn-outline-secondary">Edit</button>
								<button type="button" class="btn btn-outline-danger"
									data-toggle="modal" data-target="#confirmDelete_${book.id }">Delete</button>
							</div>
						</td>
					</tr>
					<!-- Modal -->
					<div class="modal fade" id="confirmDelete_${book.id }"
						tabindex="-1" role="dialog"
						aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">Confirm
										deleting</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<span>Are you sure you want to delete the book?</span><br>
									<p class="font-weight-bold text-danger">${book.title }</p>
								</div>
								<div class="modal-footer">
									<div class="container">
										<button type="button" class="btn btn-outline-secondary"
											data-dismiss="modal">Cancel</button>
										<button form="formDelete_${book.id }" type="submit"
											class="btn btn-outline-danger">Submit</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>