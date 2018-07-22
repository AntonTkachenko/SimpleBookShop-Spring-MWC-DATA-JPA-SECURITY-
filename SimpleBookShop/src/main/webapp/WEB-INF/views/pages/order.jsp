<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm">
		<div class="card text-center w-100">
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
				<li class="list-group-item"><h6>Genre</h6> <br> <c:forEach
						items="${book.genres }" var="genre">
							${genre.name }<br>
					</c:forEach></li>
				<li class="list-group-item"><h6>Authors</h6> <br> <c:forEach
						items="${book.authors }" var="author">
							${author.firstName } ${author.secondName }<br>
					</c:forEach></li>
			</ul>
		</div>
	</div>
	<div class="col-sm">
		<form action="${pageContext.request.contextPath}/order/saveOrder"
			method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="hidden" value="${book.id }"
				name="bookId">
			<div class="form-group row">
				<label for="firstName">First name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstName"
						placeholder="Enter your first name" name="firstName"
						required="required">
				</div>
			</div>
			<div class="form-group row">
				<label for="secondName">Last name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="secondName"
						placeholder="Enter your last name" name="secondName"
						required="required">
				</div>
			</div>
			<div class="form-group row">
				<label for="address">Address</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address"
						placeholder="Enter your address" name="address"
						required="required">
				</div>
			</div>
			<div class="form-group row">
				<label for="countBooks">Count books</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="countBooks"
						placeholder="How many you want to buy" name="countBooks"
						required="required" min="1" step="1">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>