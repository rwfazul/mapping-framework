<%-- 
    Document   : palestras
    Created on : 29/10/2017, 22:27:32
    Author     : isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/_css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>    
        <div class="container">
            <h1 class="text-center">Gerenciamento de palestras</h1>
            <form action="palestraServlet" method="POST">
                <div class="row"><div class="col-md-6 col-md-offset-3 well">
                        <legend>Cadastro de palestras</legend>                
                        <div class="form-group">
                            <label class="control-label">Titulo:</label>
                            <input class="form-control" required type="text" name="titulo"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Assunto:</label>
                            <input class="form-control" required type="text" name="assunto"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Palestrante:</label>
                            <input class="form-control" required type="text" name="nomePalestrante"/>
                        </div>
                    <button type="submit" class="btn btn-primary">Cadastrar palestra</button>
                </div></div>
            </form>
        </div>
    </body>
</html>
