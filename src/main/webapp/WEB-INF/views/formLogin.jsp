<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServerNuevaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Gerenciador</title>
</head>
<body style="background-color:#02121c; color:white; ">
  <div style="display: flex; flex-direction: column; align-items: center;">
    <h1 style="font-size: 2rem; font-weight: bold; margin-bottom: 2rem;">Login</h1>
    <form action="${linkServerNuevaEmpresa}" method="post" style="display: flex; flex-direction: column;" >
      <div style="display: flex; flex-direction: column; margin-bottom: 1rem;">
        <label style="font-size: 1.2rem; font-weight: bold; margin-bottom: 0.5rem;" for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" style="background-color: #f5f5f5; border: none; padding: 0.5rem; border-radius: 5px;">
      </div>
      <div style="display: flex; flex-direction: column; margin-bottom: 1rem;">
        <label style="font-size: 1.2rem; font-weight: bold; margin-bottom: 0.5rem;">Password</label>
        <input type="password" name="contrasena" style="background-color: #f5f5f5; border: none; padding: 0.5rem; border-radius: 5px;">
      </div>
      <input type="hidden" name="accion" value="Login"/>
      <button type="submit" style="background-color: #0079BF; color: #fff; border: none; padding: 0.5rem 1rem; border-radius: 5px; cursor: pointer; font-size: 1.2rem; font-weight: bold;">Login</button>
    </form>
  </div>
</body>
</html>
