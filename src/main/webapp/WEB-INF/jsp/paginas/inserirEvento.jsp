<%-- 
    Document   : inserirEvento
    Created on : 30/10/2017, 01:37:26
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
        <form action="eventoServlet" method="POST">
            <div class="container panel panel-default">
                <h1 class="text-center">Cadastro de eventos</h1>
                <div class="panel-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Dados do evento</div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="control-label">Nome:</label>
                                    <input class="form-control" required type="text" name="nome"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Descrição:</label>
                                    <input class="form-control" required type="text" name="descricao"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Data início:</label>
                                    <input class="form-control" required type="text" name="data_inicio"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Data fim:</label>
                                    <input class="form-control" required type="text" name="data_fim"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Dados do local</div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="control-label">Local:</label>
                                    <select class="form-control" id="local">
                                        <option>Escolha o Local</option>
                                        <option value="ufsm">Na UFSM</option>
                                        <option value="outrolocal">Fora da UFSM</option>
                                    </select>
                                </div> 
                                <div class="form-group">
                                    <label class="control-label">Rua:</label>
                                    <input class="form-control"  type="text" disabled id="rua" name="rua"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Bairro:</label>
                                    <input class="form-control"  type="text" disabled name="bairro" id="bairro"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Número:</label>
                                    <input class="form-control" type="text" disabled name="numero" id="numero"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Pŕedio:</label>
                                    <input class="form-control" type="text" disabled name="predio" id="predio"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row"> <div class="col-md-2 col-md-offset-5">
                        <button type="submit" class="btn btn-primary">Cadastrar evento</button>
                    </div></div>
                </div>
            </div></form>
        <script>
            $(document).ready(function () {

                $('#local').change(function () {
                    var selLocal = document.getElementById('local');
                    var selLocalValor = selLocal.options[selLocal.selectedIndex].value;

                    var $rua = $("#rua");
                    var $bairro = $("#bairro");
                    var $numero = $("#numero");
                    var $predio = $("#predio");

                    $rua.prop('disabled', false);
                    $bairro.prop('disabled', false);
                    $numero.prop('disabled', false);
                    $predio.prop('disabled', false);

                    if (selLocalValor === "ufsm") {
                        $rua.val("Av. Roraima");
                        $bairro.val("Camobi");
                        $numero.val("1000");

                    } else if (selLocalValor === "outrolocal") {
                        $rua.val("");
                        $bairro.val("");
                        $numero.val("");
                    }
                });

            });
        </script>
    </body>
</html>
