<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="eventoServlet" method="POST">
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">

                <div class="container-fluid">
                    <h2>Cadastro de eventos</h2>
                    <ul class="nav nav-tabs">
                        <li class="active" id="tab_evento"><a>Dados do evento</a></li>
                        <li id="tab_local"><a>Dados do local</a></li>
                        <li id="tab_palestra"><a>Palestras</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="evento" class="tab-pane fade in active">

                            <h2 class="titulo-destaque">Informações do evento</h2>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Dados do evento</div>
                                            <div class="panel-body">
                                                <div class="form-group">
                                                    <label class="control-label">Nome:</label>
                                                    <input class="form-control" required type="text" name="nome"/>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label">Descrição:</label>
                                                    <textarea class="form-control" required type="text" name="descricao"></textarea>
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

                                </div>
                                <div class="row pull-right"> 
                                    <a data-toggle="tab" href="#local" id="next_evento" class="btn btn-lg btn-primary">Pŕoximo <span class="glyphicon glyphicon-chevron-right"></span></a>
                                </div>
                            </div>

                        </div>
                        <div id="local" class="tab-pane fade">
                            <h2 class="titulo-destaque">Informações do local</h2>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">Dados do local</div>
                                            <div class="panel-body">
                                                <div class="form-group">
                                                    <label class="control-label">Endereço:</label>
                                                    <select class="form-control" name="endereco" id="enderecoSel">
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
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row"> 
                                    <div class="pull-left"><a data-toggle="tab" href="#evento" class="btn btn-lg btn-primary" id="previous_local"><span class="glyphicon glyphicon-chevron-left"></span> Anterior</a></div>
                                    <div class="pull-right"><a data-toggle="tab" href="#palestra" class="btn btn-lg btn-primary" id="next_local">Próximo  <span class="glyphicon glyphicon-chevron-right"></span></a></div>
                                </div>

                            </div>

                        </div>

                        <div id="palestra" class="tab-pane fade">
                            <h2 class="titulo-destaque">Palestras</h2>                            

                            <div class="panel-body">
                                <div class="row col-md-12">
                                    <div class="list_palestras">

                                    </div>
                                    <div class="col-md-4">
                                        <button type="button" data-toggle="modal" data-target="#nova_palestra" class="btn btn-default btn-lg" style="width: 200px; height: 200px;">
                                            <span class="glyphicon glyphicon-plus "> </span>
                                        </button> 
                                    </div>
                                </div>

                                <div class="row"> 
                                    <div class="pull-left"><a data-toggle="tab" href="#local" class="btn btn-lg btn-primary" id="previous_palestra"><span class="glyphicon glyphicon-chevron-left"></span> Anterior</a></div>
                                    <div class="pull-right"><button type="submit" class="btn btn-lg btn-success" id="next_local">Finalizar <span class="glyphicon glyphicon-ok"></span> </button></div>

                                </div>
                            </div>


                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</form>

<div id="nova_palestra" class="modal fade" role="dialog">
    <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Nova Palestra</h4>
                </div>
                <div class="modal-body">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Dados da palestra</div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="control-label">Título:</label>
                                    <input class="form-control" required type="text" name="titulo" id="titulo"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Assunto:</label>
                                    <textarea class="form-control" required type="text" name="assunto" id="assunto"></textarea>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Descrição:</label>
                                    <textarea class="form-control" required type="text" name="descricao" id="descricao"></textarea>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Sala:</label>
                                    <input class="form-control" required type="text" name="sala" id="sala"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Data início:</label>
                                    <input class="form-control" required type="text" name="inicio" id="inicio"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Data fim:</label>
                                    <input class="form-control" required type="text" name="fim" id="fim"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Dados do palestrante</div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="control-label">Nome Palestrante:</label>
                                    <input class="form-control" required type="text" name="nome_palestrante" id="nome_palestrante"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Sexo:</label>
                                    <select class="form-control" required name="sexo" id="sexo">
                                        <option value="masculino">Masculino</option>
                                        <option value="feminino">Feminino</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Grau acadêmico:</label>
                                    <select class="form-control" required name="grau_academico" id="grau_academico">
                                        <option value="Tecnólogo">Tecnólogo</option>
                                        <option value="Graduação">Graduação</option>
                                        <option value="Pós graduação">Pós graduação</option>
                                        <option value="Mestrado">Mestrado</option>
                                        <option value="Doutorado">Doutorado</option>
                                    </select>                                                </div>
                                <div class="form-group">
                                    <label class="control-label">Curso Formação:</label>
                                    <input class="form-control" required type="text" name="curso" id="curso"/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Instituição Formação:</label>
                                    <input class="form-control" required type="text" name="instituicao" id="instituicao"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="salvar_palestra" class="btn btn-default palestra" data-dismiss="modal">Salvar</button>
                </div>
            </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        var $predioSel = $("#predioSel");
        var $enderecoSel = $("#enderecoSel");   
        $predioSel.hide();
        var $predio = $("#predio");
        $('#enderecoSel').change(function () {
            var endSel = document.getElementById('enderecoSel');
            var endSelVal = endSel.options[endSel.selectedIndex].value;
            if (endSelVal === "R. Floriano Peixoto, 1184 - Centro") {
                $predioSel.hide();
                $predioSel.prop("name", null);
                $predio.show();
                $predio.prop("name", "predio");
                $predio.val("99 - Centro de Ciências Sociais e Humanas");
            } else {
                $predio.hide();
                $predio.prop("name", null);
                $predioSel.show();
                $predioSel.prop("name", "predio");
            }
        });

        $(".tab-content a").click(function () {
            var id = $(this).attr('id');
            if (id === "next_evento") {
                $("#tab_local").prop("class", "active");
                $("#tab_evento").prop("class", " ");
            } else if (id === "next_local") {
                $("#tab_palestra").prop("class", "active");
                $("#tab_local").prop("class", " ");
            } else if (id === "previous_local") {
                $("#tab_evento").prop("class", "active");
                $("#tab_local").prop("class", " ");
            } else if (id === "previous_palestra") {
                $("#tab_local").prop("class", "active");
                $("#tab_palestra").prop("class", " ");
            }
        });

        var Palestrante = function (nome, sexo, grau, curso, instituicao) {
            this.nome = nome;
            this.sexo = sexo;
            this.grau = grau;
            this.curso = curso;
            this.instituicao = instituicao;
        };
        var Palestra = function (titulo, assunto, descricao, inicio, fim, sala, palestrante) {
            this.titulo = titulo;
            this.assunto = assunto;
            this.descricao = descricao;
            this.inicio = inicio;
            this.fim = fim;
            this.sala = sala;
            this.palestrante = palestrante;
        };
        
     

        var list = {palestras:[]};
        
        $("#salvar_palestra").click(function () {
            var $titulo = $("#titulo").val();
            var $assunto = $("#assunto").val();
            var $descricao = $("#descricao").val();
            var $inicio = $("#inicio").val();
            var $fim = $("#fim").val();
            var $sala = $("#sala").val();
            var $palestrante = $("#nome_palestrante").val();
            var $sexo = $("#sexo").val();
            var $grau = $("#grau_academico").val();
            var $curso = $("#curso").val();
            var $instituicao = $("#instituicao").val();
            
            var palestrante = new Palestrante($palestrante, $sexo, $grau, $curso, $instituicao);
            var palestra = new Palestra($titulo, $assunto, $descricao, $inicio, $fim, $sala, palestrante);
            list.palestras.push(palestra);

            console.log(list.palestras);

            //$(".list_palestras").append($("#resumo_palestra").clone());   //jeito de fazer se div está no html
             
            //jeito de fazer com div dentro de uma string
            var div = "<div id='resumo_palestra' class='col-md-4 pull left'>\n\
                       <div class='panel panel-primary'>\
                       <div class='panel-heading' style='height: 50px;'>Resumo da palestra\n\
                            <div class='col-md-2 pull-right'><button id='remover_palestra' class='btn btn-danger'><span class='glyphicon glyphicon-trash'></span></button></div>\
                             <div class='col-md-2 pull-right'><button id='editar_palestra' class='btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></button></div></div>\
                       <div class='panel-body'>\
                            <div class='form-group'><label>Titulo: </label>"+ $titulo +"</div>\
                            <div class='form-group'><label>Data início: </label>"+ $inicio +"</div>\
                            <div class='form-group'><label>Palestrante: </label>"+ $palestrante +"</div>\
                       </div></div></div>";
            $(".list_palestras").append(div);
            
        });
    });
</script>
