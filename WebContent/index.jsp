<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.hibernatejpa.dao.*"%>
<%
	request.setAttribute("lista", new CategoriaDao().findAll());
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO CATEGORIA</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" media="all">
<link rel="stylesheet" href="resources/css/bootstrap.css.map" media="all">


</head>
<body>
	<div class="container">

		<div class="col-4">
			<fieldset>

				<form action="save" method="post">

					<div class="form-group">
						<label for="_descricao">Descrição</label> <input type="text"
							class="form-control" id="_descricao" name="descricao" required>
					</div>

					<div class="form-group">
						<button class="btn btn-outline-primary">Cadastrar</button>
					</div>

				</form>

			</fieldset>

		</div>

		<hr>
			
			<a href="produto.jsp" class="btn btn-outline-success">Produtos</a>
		
		<hr>

		<div class="mt-5">
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>DESCRIÇÃO</th>
				</tr>

				<c:forEach items="${lista}" var="lista">
					<tr>

						<td>${lista.id}</td>
						<td>${lista.descricao}</td>
						<td><a href="list?id=${lista.id}" class="btn btn-outline-dark">Editar</a></td>
						<td><a href="remove?id=${lista.id}" class="btn btn-outline-danger">Excluir</a></td>

					</tr>
				</c:forEach>
			</table>

		</div>

	</div>

</body>
</html>