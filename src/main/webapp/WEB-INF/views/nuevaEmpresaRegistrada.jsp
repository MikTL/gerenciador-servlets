<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Empresa Registrada</title>
</head>
	<body>
		<c:import url="logout-parcial.jsp"></c:import>
		<h1>Este es un JSP que recibe datos de un servlet</h1>
	    
		     	<!-- Expression Language -->
		     	<c:if test="${not empty Empresa }">
			     	<p>Empresa <strong>${Empresa} </strong> registrada fecha: <fmt:formatDate value="${fechaApertura}" pattern="dd-MM-yyyy"/> </p>		
		     	</c:if>
		     	<c:if test="${empty Empresa }">
		     		<mark>Ninguna empresa registrada</mark>
		     	</c:if>
	</body>
</html>