<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script src="resources/js/jquery.js" type="text/javascript" ></script>
	</head>
	
	<body>
	
		<script type="text/javascript">
		    function finalizaAgora(id) {
		      $.post("finalizaTarefa", {'id' : id}, function(resposta) {
		        // selecionando o elemento html através da 
		        // ID e alterando o HTML dele 
		        $("#tarefa_"+id).html("Finalizado");
		        $("#tarefa_data_"+id).html(resposta);
		      });
		    }
		 </script>
				
		<table>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizado</th>
				<th>Data de finalização</th>
			</tr>
			
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					
					<c:if test="${tarefa.finalizado eq true}"><td>Finalizado</td></c:if>
					<c:if test="${tarefa.finalizado eq false}">
					  <td id="tarefa_${tarefa.id}">
					      <a href="#" onClick="finalizaAgora(${tarefa.id})">
						      Finalizar</a></td></c:if>
					
					<td id="tarefa_data_${tarefa.id}">
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					
					<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
					
					<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
					
				</tr>
			</c:forEach>
		</table>
		
		<br /><br />
		
		<a href="novaTarefa">Criar nova tarefa</a>
		
	</body>
</html>