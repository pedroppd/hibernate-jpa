<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.hibernatejpa.dao.*"%>
<link rel="stylesheet" href="resources/css/bootstrap.css" media="all">
<link rel="stylesheet" href="resources/css/bootstrap.css.map"
	media="all">
<meta charset="ISO-8859-1">
<title>Update Categoria</title>
</head>
<%
HttpSession sessao = request.getSession();
sessao.getAttribute("categoria");

%>
<body>

<div class="container">
	<hr>

		<div class="col-4">
			<fieldset>

				<form action="update" method="post">
				
					<div class="form-group">
						<label for="_descricao">id</label>
						 <input type="text" readonly="readonly" value="${categoria.id}" class="form-control" id="_descricao" name="id" required>
					</div><br>

					<div class="form-group">
						<label for="_descricao">Descrição</label>
						 <input type="text" value="${categoria.descricao}" class="form-control" id="_descricao" name="descricao" required>
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