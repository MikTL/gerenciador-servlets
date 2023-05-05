<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Modificar Empresa</title>
</head>
<body>
	
    <form action="${linkEntradaServlet}" method="post">
    	<label for="nombre">Nombre de la empresa</label>
    	<input type="text" id="nombre" name="nombre" value="${empresa.nombre }"/>
    	<br>
    	<label for="fecha"> Fecha Apertura</label>
    	<input type="text" id="fecha" name="fecha" value='<fmt:formatDate value="${empresa.fechaApertura}" pattern="dd-MM-yyyy"/>'/>
    	<br>
    	<label for="id">Id empresa: </label>
    	<input type="hidden" id="id" name="id" value='${empresa.id}' readonly/>
    	<br>
    	<input type="hidden" id="id" name="accion" value='ModificarEmpresa'/>

    	<input type="submit"/>
    </form>
</body>
</html>