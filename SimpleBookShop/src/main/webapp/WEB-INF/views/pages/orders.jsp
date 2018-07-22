<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Order number</th>
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Address</th>
				<th scope="col">Book title</th>
				<th scope="col">Order date</th>
				<th scope="col">Count books</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="order">
				<tr>
					<th>${order.id }</th>
					<td>${order.firstName }</td>
					<td>${order.secondName }</td>
					<td>${order.address }</td>
					<td>${order.book.title }</td>
					<td>${order.dateTime }</td>
					<td>${order.bookCount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>