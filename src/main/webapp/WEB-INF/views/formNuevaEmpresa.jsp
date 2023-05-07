<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServerNuevaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	
    <form action="${linkServerNuevaEmpresa}" method="post">
    	<label for="nombre">Nombre de la empresa</label>
    	<input type="text" id="nombre" name="nombre"/>
    	<br>
    	<label for="fecha"> Fecha Apertura</label>
    	<input type="date" id="fecha" name="fecha"/>
    	<br>
    	<input type="hidden" name="accion" value="NuevaEmpresa"/>
    	
    	<!-- <label for="contrasenia">Password</label>
    	<input type="password" id="contrasenia" name="password"/> -->
    	<input type="submit"/>
    </form>
</body>
</html>