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
				<a href="#" class="navbar-brand"> List Of Drink </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${drink != null}">
					<form action="update_drink" method="post">
				</c:if>
				<c:if test="${drink == null}">
					<form action="insert_drink" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${list_of_food != null}">
            			Edit Drink
            		</c:if>
						<c:if test="${drink == null}">
            			Add New Drink Data
            		</c:if>
					</h2>
				</caption>

				<c:if test="${drink != null}">
					<input type="hidden" name="id" value="<c:out value='${drink.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Drink Name</label> <input type="text"
						value="<c:out value='${drink.drinkname}' />" class="form-control"
						name="drinkname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Release Date</label> <input type="text"
						value="<c:out value='${drink.releasedate}' />" class="form-control"
						name="releasedate">
				</fieldset>

				<fieldset class="form-group">
					<label>Category</label> <input type="text"
						value="<c:out value='${drink.category}' />" class="form-control"
						name="category">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out value='${drink.description}' />" class="form-control"
						name="description">
				</fieldset>
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
