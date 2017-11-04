<%-- 
    Document   : header
    Created on : 30/10/2017, 15:40:58
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Sistema Gerenciador de Eventos - UFSM</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Informações</a></li>
      <li><a href="#">Contato</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="usuarioServlet?action=cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="usuarioServlet?action=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> 
    </body>

</html>
