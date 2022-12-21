<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Contatos_JB" %>
    <%
    Contatos_JB contato = (Contatos_JB) request.getAttribute("contato");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edição de contato</title>
		
		<!-- estilo para o formulário -->
		<style>
			.grande
			{
				width: 300px
			}
		</style>
	</head>
	<body>
		<form action="contato_editado" method="post">
			<input type="hidden" name="id" value="<%=contato.getIdcontato()%>">
			<label>nome:</label>
			<input type="text" name="nome" value="<%=contato.getNome()%>" class="grande">
			<label>telefone:</label>
			<input type="text" name="telefone" value="<%=contato.getFone()%>" class="medio">
			<label>e-mail:</label>
			<input type="text" name="email" value="<%=contato.getEmail()%>" class="grande">
			<input type="submit" value="salvar">
		</form>
		<a href="contatos">voltar</a>
	</body>
</html>