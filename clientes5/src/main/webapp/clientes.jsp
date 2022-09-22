<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    /*
    for(int i = 0; i < lista.size();i++){
    	out.println(lista.get(i).getIdcon());
    	out.println(lista.get(i).getNome());
    	out.println(lista.get(i).getFone());
    	out.println(lista.get(i).getEmail());
    }*/
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<link rel="icon" href="imagens/clientes1.pgg" >
<link rel="stylesheet" type="text/css" href="style.css" media="all">
</head>
<body>

<style>
#tabela{
	margin-top: 30px;
	border-collapse: collapse;
}

#tabela th{
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
	background-color: #66bbff;
	color: #fff;
}

#tabela td{
	border: 1px solid #ddd;
	padding: 10px;
	}
</style>

	<h1>Lista de Clientes</h1>
	<a href="novo.html"  class="Config">Novo Contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
			</tr>
		
		</thead>
		
		<tbody>
			<%for(int i = 0; i < lista.size();i++){ %>
			<tr>
				<td><%=lista.get(i).getIdcon() %></td>
				<td><%=lista.get(i).getNome() %></td>
				<td><%=lista.get(i).getFone() %></td>
				<td><%=lista.get(i).getEmail() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>