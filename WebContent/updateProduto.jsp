<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.hibernatejpa.dao.*"%>
<%
	HttpSession sessao = request.getSession();

	sessao.getAttribute("produto");

	request.setAttribute("categoria", new CategoriaDao().findAll());
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO CATEGORIA</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" media="all">
<link rel="stylesheet" href="resources/css/bootstrap.css.map"
	media="all">


</head>
<body>
	<div class="container">

		<div class="col-4">
			<fieldset>

				<form action="updateProduto" method="post">

					<div class="form-group">
						<label for="_descricao">id</label> <input type="text"
							class="form-control" id="_id" value="${produto.id}"
							name="id" readonly="readonly" required>
					</div>
					
					<br>

					<div class="form-group">
						<label for="_descricao">nome</label> <input type="text"
							class="form-control" id="_descricao" value="${produto.nome}"
							name="nome" required>
					</div>

					<br>

					<div class="form-group">
						<label for="_descricao">tipo</label> <input type="text"
							class="form-control" id="_descricao" value="${produto.tipo}" name="tipo" required>
					</div>

					<br>

					<div class="form-group">
						<label>categoria</label> <select class="form-control"
							name="categorias">
							<c:forEach var="categoria" items="${categoria}">
								<option value="${categoria.id}">${categoria.descricao}</option>
							</c:forEach>
						</select>

					</div>



					<div class="form-group">
						<button class="btn btn-outline-primary">Cadastrar</button>
					</div>

				</form>

			</fieldset>

		</div>

		<hr>
	</div>

</body>
</html>