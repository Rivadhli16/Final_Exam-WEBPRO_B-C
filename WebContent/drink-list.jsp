<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Menu</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #d789d7">
			<div>
				<a href="#" class="navbar-brand"> List Of Menu </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Food Menu</a></li>
					
				<li><a href="<%=request.getContextPath()%>/list_drink"
					class="nav-link">Drink Menu</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Here's Our Drink Data</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new_drink" class="btn btn-success">Add
					New Drink</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Drink Name</th>
						<th>Release Date</th>
						<th>Category</th>
						<th>Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="drink" items="${listDrink}">

						<tr>
							<td><c:out value="${drink.foodname}" /></td>
							<td><c:out value="${drink.releasedate}" /></td>
							<td><c:out value="${drink.category}" /></td>
							<td><c:out value="${drink.description}" /></td>
							<td><a href="edit_drink?id=<c:out value='${drink.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete_drink?id=<c:out value='${drink.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
