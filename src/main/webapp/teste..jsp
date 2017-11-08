
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">
    <title>Teste</title>
    <link rel="stylesheet" href="recursos/_bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="recursos/_font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/menu-dashboard.css">
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                                        <label class="control-label">Endereço:</label>
                                        <input class="form-control"  type="text" disabled id="endereco"/>
                                        <select class="form-control" id="enderecoSel">
                                            <option>Escolha o endereço</option>
                                            <option value="Av. Roraima, 1000 - Camobi">Campus</option>
                                            <option value="R. Floriano Peixoto, 1184 - Centro">Antiga Reitoria</option>
                                        </select>

                                    </div>                                
                                    <div class="form-group">
                                        <label class="control-label">Pŕedio:</label>
                                        <input class="form-control" type="text" disabled id="predio"/>
                                        <select class="form-control" id="predioSel">
                                            <option>Escolha o Prédio</option>
                                            <option value="5">05 - CTISM - Colégio Técnico de Industrial Santa Maria</option>
                                            <option value="7">07 - Centro de tecnologia</option>
                                            <option value="13">13 - Centro de Ciências Naturais e Exatas</option>
                                            <option value="16">16 - Centro de Educação </option>
                                            <option value="26">26 - Centro de Ciências da Saúde </option>
                                            <option value="40">40 - Centro de Artes e Letras </option>
                                            <option value="42">42 - Centro de Ciências Rurais</option>
                                            <option value="48">48 - Centro de Processamento de Dados</option>
                                            <option value="51">51 - Centro de Educação Física e Desportos</option>
                                            <option value="70">70 - Colégio Politécnico</option> 
                                            <option value="74">74 - Centro de Ciências Sociais e Humanas</option>
                                            <option value="Reitoria">Reitoria</option>
                                            <option value="Espaço Multiuso">Espaço Multiuso</option>
                                            <option value="Centro de Convenções">Centro de Convenções</option>
                                            <option value="Centro de Eventos">Centro de Eventos</option>
                                                                                     
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Sala:</label>
                                        <input class="form-control" type="text" disabled name="sala" id="sala"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row"> <div class="col-md-2 col-md-offset-5">
                            <button type="submit" class="btn btn-primary">Cadastrar evento</button>
                        </div></div>
                </div>
            </div></form> <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="recursos/_bootstrap/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                var $predioSel = $("#predioSel");
                var $enderecoSel = $("#enderecoSel");
                $predioSel.hide();
                $enderecoSel.hide();
                var $endereco = $("#endereco");
                var $predio = $("#predio");
                var $sala = $("#sala");
                $('#local').change(function () {      
                    var selLocal = document.getElementById('local');
                    var selLocalValor = selLocal.options[selLocal.selectedIndex].value;
                    $sala.prop('disabled', false);
                    $endereco.prop('disabled', false);
                    $predio.prop('disabled', false);
                    if (selLocalValor === "ufsm") {
                        $endereco.hide();
                        $endereco.prop("name", null);                     
                        $enderecoSel.show();
                        $enderecoSel.prop("name", "endereco");
                    } else if (selLocalValor === "outrolocal") { 
                        $enderecoSel.hide();
                        $enderecoSel.prop("name", null);
                        $endereco.show();
                        $endereco.prop("name", "endereco");
                        $predioSel.hide();
                        $predioSel.prop("name", null);
                        $predio.show();
                        $predio.val("");                       
                        $predio.prop("name", "predio");          
                    }
                });
                $('#enderecoSel').change(function () {
                    var endSel = document.getElementById('enderecoSel');
                    var endSelVal = endSel.options[endSel.selectedIndex].value;
                    if (endSelVal === "R. Floriano Peixoto, 1184 - Centro") {
                        $predioSel.hide();
                        $predioSel.prop("name", null);
                        $predio.show();
                        $predio.prop("disabled", false);
                        $predio.prop("name", "predio");
                        $predio.val("99");
                    } else {
                        $predio.hide();
                        $predio.prop("name", null);
                        $predioSel.show();
                        $predioSel.prop("name", "predio");                       
                    }
                });
            });
        </script>
    </body>
</html>
