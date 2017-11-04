<%-- 
    Document   : dashboard
    Created on : 30/10/2017, 16:02:37
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
        <div class="jumbotron">
                <h2 class="text-center">Sistema Gerenciador de eventos UFSM</h2>
        </div>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Evento</div>
                        <div class="panel-body">
                            <p class="text-justify">Aqui você pode cadastrar um evento e então adicionar palestras a seu evento.</p>
                            <div class="col-md-6"><a href="eventoServlet" class="btn btn-success">Cadastrar evento</a></div>
                            <div class="col-md-6"><a href="eventoServlet" class="btn btn-success">Gerenciar evento</a></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Palestra</div>
                        <div class="panel-body">
                            <p class="text-justify">Aqui você pode cadastrar palestras avulsas, ou seja, sem um evento relacionado.</p>
                            <div class="col-md-6"><a href="palestraServlet" class="btn btn-success">Cadastrar palestra</a></div>
                            <div class="col-md-6"><a href="palestraServlet" class="btn btn-success">Gerenciar palestra</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
