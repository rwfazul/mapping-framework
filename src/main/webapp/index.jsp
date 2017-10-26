<%-- 
    Document   : index
    Created on : Oct 26, 2017, 8:21:00 PM
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Isabella Sakis, Rhauani Fazul">
    <title>Palestras | Eventos</title>
    <link rel="stylesheet" href="recursos/_bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="recursos/_font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="recursos/_select2/select2.min.css">
    <link rel="stylesheet" href="recursos/_jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/menu-dashboard.css">
    <link rel="stylesheet" href="css/rodape-dashboard.css">
    <link rel="shortcut icon" href="img/icone.ico"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<header>   
    <!-- Navbar -->
    <t:menu-dashboard id="home"></t:menu-dashboard>
    <!-- /Navbar -->
</header>
    
<main>  
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h1 class="text-center">Palestras
                    <a class="btn btn-custom" data-toggle="modal" data-target="#novo">Adicionar
                        <i class="fa fa-plus-circle" aria-hidden="true"></i>
                    </a>          
                </h1>
                <hr/>     
            </div>
        </div>
    </div>      
                
    <div class="container">
        <ul class="nav nav-tabs nav-pills nav-justified">
            <li class="active"><a href="#futuros" data-toggle="tab">Futuras</a></li>
            <li><a href="#passados" data-toggle="tab">Passadas</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="futuros">
                <div class="table-responsive">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th><i class="fa fa-hashtag" aria-hidden="true"></i></th>
                            <th>Título</th>
                            <th><i class="fa fa-calendar-check-o" aria-hidden="true"></i> Data</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                </div>
            </div>
            <div class="tab-pane" id="passados">
                <div class="table-responsive">
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th><i class="fa fa-hashtag" aria-hidden="true"></i></th>
                            <th>Título</th>
                            <th><i class="fa fa-calendar-check-o" aria-hidden="true"></i> Data</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>Hemocentro Regional de Santa Maria</td>
                            <td>25/08/2017</td>
                            <td>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-refresh" aria-hidden="true"></i></a>
                                <a data-toggle="modal" data-target="#confirmacao"><i class="fa fa-trash" aria-hidden="true"></i></a>
                            </td>
                        </tr>
                    </tbody>
                </table>            
                </div>
            </div>
        </div>
        <hr/>
    </div>
    
    <div class="modal fade" id="confirmacao" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center">Confirmar exclusão</h4>
                </div>
                <div class="modal-body text-center">
                    <p>Tem certeza que deseja cancelar o agendamento de Nº #3?
                </div>
                <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-check" aria-hidden="true"></i> Manter</button>
                      <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times" aria-hidden="true"></i> Cancelar</button>
                </div>
            </div>
        </div>
    </div>
</main>

<footer>
    <!-- Rodape -->
    <c:import url="rodape.jsp" />
    <!-- /Rodape -->      
</footer>    
        
    <script src="recursos/_bootstrap/js/bootstrap.min.js"></script>
    <script src="recursos/_select2/select2.min.js"></script>
    <script src="recursos/_select2/pt-BR.js"></script>
    <script src="recursos/_jquery-ui/jquery-ui.min.js"></script>
    <script>
        $(function() {
            $(".select-search").select2( {            
                allowClear: true,
                placeholder: "Selecione um hemocentro",
                language: "pt-BR"
            });
        });
    </script>
    <script>
        $(function() {
            $("#data").datepicker( { 
                minDate: 0,
                dateFormat: "dd/mm/yy"
            });
        });
    </script>
</body>
</html>

    