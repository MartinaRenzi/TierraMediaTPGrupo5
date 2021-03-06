<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
<body>
	<div class="content-wrapper main">
		<div class="header">
			<h1>tierra media</h1>
		</div>
		<div class="login">
			<div class="image-container">
				<img src="../torre/assets/img/Login.png" alt="Imagen login" />
			</div>
			<div class="login-container">
			<c:if test="${flash != null}">
					<div class="alert alert-danger">
						<p>
							<c:out value="${flash}" />
						</p>
					</div>
				</c:if><!--Restaurar al valor inicial al actualizar la pagina-->
				<div class="login-buttons-top">
					<a class="button-left" href="#">Sign in</a> <a class="button-right"
						href="#">Sign up</a>
				</div>
				<form action="login" method="post">
					<div class="login-content">
						<div class="login-input">
							<h2>username</h2>
							<label for="username" class="form-label"></label> <input
								class="form-control" name="username">
						</div>
						<div class="login-checkbox">
							<input type="checkbox" href="#"></input>
							<p>
								I agree all statements in <a href="#">terms of service</a>
							</p>
						</div>
						<div class="login-buttons-bottom">
							<button type="submit" class="button">Sign In</button>
							<a class="member" href="#">I'm already member</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>