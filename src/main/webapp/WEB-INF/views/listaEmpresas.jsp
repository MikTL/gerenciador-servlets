<%@page import="java.util.ArrayList"%>
<%@page import="com.miktl.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de Empresas</title>
</head>
	<body>
		<c:import url="logout-parcial.jsp"></c:import>
		<h1> Usuario Logueado: ${loginUsuario.nombre} </h1>
		<c:if test="${not empty Empresa }">
			<p>Empresa <strong>${Empresa} </strong> registrada fecha: <fmt:formatDate value="${fechaApertura}" pattern="dd-MM-yyyy"/> </p>		
		</c:if>
		<p>Lista de empresas</p>
		<ul>
			<c:forEach var="empresa" items="${listaEmpresas}">
				<li>
					${empresa.nombre} - <fmt:formatDate value="${empresa.fechaApertura }" pattern="dd-MM-yyyy"/> 
					<a href="/gerenciador/entrada?accion=MostrarEmpresa&id=${empresa.id}">Editar</a>
					<a href="/gerenciador/entrada?accion=EliminarEmpresa&id=${empresa.id}">Eliminar</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>