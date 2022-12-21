<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Contatos_JB" %>
    <%@ page import="java.util.ArrayList" %>
<%
	ArrayList<Contatos_JB> contatos = (ArrayList<Contatos_JB>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Contatos</title>
		
		<!-- estilo para a tabela de contatos -->
		<style>
		table, th, td
		{
			border: 1px solid black;
		}
		.info
		{
			padding: 0 10px;
		}
		h1
		{
			text-align: center;
		}
		.voltar
		{
			text-align: right;
			margin: 20px 10px 0 0;
		}
		.conteudo
		{
			margin: 0 auto;
			width: fit-content;
		}
		</style>
	</head>
	<body>
	
	<h1>Contatos</h1>

	<div class="conteudo">
		<table>
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>telefone</th>
			<th>e-mail</th>
			<th colspan="2" class="opcoes">opções</th>
		</tr>
		<%for(int i = 0; i < contatos.size(); i++)
			{%>
			<tr>
			<form action="editar" method="post">
				<td class="info">
				<label><%= contatos.get(i).getIdcontato()%></label>
				<input type="hidden" name="id" value="<%= contatos.get(i).getIdcontato()%>">
				</td>
				<td class="info">
				<label><%= contatos.get(i).getNome() %></label>
				<input type="hidden" name="nome" value="<%= contatos.get(i).getNome() %>">
				</td>
				<td class="info">
				<label><%= contatos.get(i).getFone() %></label>
				<input type="hidden" name="telefone" value="<%= contatos.get(i).getFone() %>">
				</td>
				<td>
				<label class="info"><%= contatos.get(i).getEmail() %></label>
				<input type="hidden" name="email" value="<%= contatos.get(i).getEmail() %>">
				</td>
				<td>
				<input type="submit" value="editar">
				</td>
			</form>
				<td class="opcoes">
			<form action="deletar" method="post" name="deletar" onsubmit="return verificacao();">
				<input type="hidden" name="id" value="<%= contatos.get(i).getIdcontato()%>">
				<input type="submit" value="deletar">
			</form>
				</td>
			</tr>
			<%}%>
			</table>
			<div class="voltar">
				<a href="index.jsp">voltar</a>
			</div>
		</div>
		
		<!-- função de confirmação para deletar o contato -->
		<script>
		function verificacao()
		{
			if(!confirm("Você tem certeza que quer deletar este contato? se sim, clique em 'ok'"))
			{
				return false;	
			}
			alert("contato deletado");
		}
		</script>
	</body>
</html>