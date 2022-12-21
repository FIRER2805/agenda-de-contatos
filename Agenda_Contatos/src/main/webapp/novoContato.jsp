<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agenda</title>
	</head>
	<body>
		<h1>Agenda</h1>
		<form name="formulario" action="novo_contato" onsubmit="return alerta();">
			<label>nome:</label>
			<input type="text" name="nome">
			<label>telefone:</label>
			<input type="text" name="telefone">
			<label>email:</label>
			<input type="text" name="email">
			<input type="submit" value="salvar">
		</form>
		<a href="index.jsp">voltar</a>
		<script src="scripts/valida_formulario.js"></script>
	</body>
</html>