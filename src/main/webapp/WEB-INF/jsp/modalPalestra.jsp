<%-- 
    Document   : modalPalestra
    Created on : Nov 17, 2017, 8:31:37 PM
    Author     : rhau
--%>

<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>  

<div id="nova_palestra" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Nova palestra</h4>
            </div>
            <div class="row modal-body">
                <form id="form-palestra">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Dados da palestra</div>
                        <div class="panel-body">
                            <t:input-text type="text" id="palestra_titulo" name="titulo" label="T�tulo" placeholder="T�tulo da palestra"></t:input-text>
                            <t:input-text type="text" id="palestra_assunto" name="assunto" label="Assunto" placeholder="�rea ou linha de pesquisa relacionada"></t:input-text>
                            <t:text-area id="palestra_descricao" name="descricao" label="Descri��o" placeholder="Resumo da palestra"></t:text-area>
                            <t:input-date tipo="date" id="palestra_data" name="data" label="Data" placeholder="Selecione a data"></t:input-date>
                            <div class="form-group">
                                <label for="palestra_inicio">Hor�rio</label>
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="input-group date timepickercustom">
                                            <input type='text' id="palestra_inicio" name="inicio" placeholder="In�cio" class="form-control timeinput" required />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>      
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="input-group date timepickercustom">
                                            <input type='text' id="palestra_fim" name="fim" placeholder="Fim" class="form-control timeinput" required />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>            
                                    </div>
                                </div>
                            </div>
                            <t:input-text type="text" id="palestra_sala" name="sala" label="Sala" placeholder="Sala onde ocorrer� a palestra"></t:input-text>
                            <t:input-text type="text" id="palestra_publico" name="publico" label="N�mero de pessoas" placeholder="P�blico previsto"></t:input-text>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Dados do palestrante</div>
                        <div class="panel-body">
                            <t:input-text type="text" id="palestrante_nome" name="nome" label="Nome" placeholder="Digite o nome do palestrante"></t:input-text>
                            <div class="form-group">
                                <label for="palestrante_sexo">Sexo</label>
                                <select id="palestrante_sexo" name="sexo" class="form-control" required>
                                    <option value="" selected disabled>Selecione</option>
                                    <option value="M">Masculino</option>
                                    <option value="F">Feminino</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="palestrante_grau_academico">Grau acad�mico</label>
                                <select id="palestrante_grau_academico" name="grau_academico" class="form-control" required>
                                    <option  value="" selected disabled>Selecione</option>
                                    <option value="Tecn�logo">Tecn�logo</option>
                                    <option value="Gradua��o">Gradua��o</option>
                                    <option value="P�s gradua��o">P�s gradua��o</option>
                                    <option value="Mestrado">Mestrado</option>
                                    <option value="Doutorado">Doutorado</option>
                                </select>                                              
                            </div>
                            <t:input-text type="text" id="palestrante_curso" name="curso" label="Curso de forma��o" placeholder="Curso de forma��o do palestrante"></t:input-text>
                            <t:input-text type="text" id="palestrante_instituicao" name="instituicao" label="Instui��o de forma��o" placeholder="Institui��o de forma��o do palestrante"></t:input-text>
                            <input type="submit" class="hidden" />
                            <img src="img/speaker.png" alt="Palestrante" class="img-responsive center-block" width="168">
                        </div>
                    </div>
                </div>
                </form>
            </div> <!-- ./modal-body -->
            <div class="modal-footer">
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" id="salvar_palestra" class="btn btn-primary" data-dismiss="modal">Salvar</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div> <!-- ./modal-content -->
    </div> <!-- ./modal-dialog -->
</div> <!-- ./modal -->