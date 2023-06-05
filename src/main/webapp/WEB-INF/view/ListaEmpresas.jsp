<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, Modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty empresa}">
		Empresa ${ empresa }, cadastrada com sucesso!
	</c:if>
	</br>
	<h1>Bem vindo,  ${usuarioLogado.login}</h1>
	<h1>Lista de Empresas</h1>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li> ${empresa.nome} - <fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy"/>
			<a href="entrada?acao=RemoveEmpresas&id=${empresa.id}">remove</a>
			<a href="entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a></li>
			
		</c:forEach>
	</ul>
</body>
</html>