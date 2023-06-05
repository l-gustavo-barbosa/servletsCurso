<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var = "urlNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${urlNovaEmpresa}" method="post">
		<label for="name">Nome</label> 
		<input type="text" name="nome" />
		<label for="data">Data</label> 
		<input type="text" name="data" /> 
		<input type="hidden" name="acao" value="NovaEmpresa"/>
		<input type="submit"/>
	</form>
</body>
</html>