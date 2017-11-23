/* global palestras, num_palestra */

$(function() {
    /* INSERIR PALESTRA */
    $("#palestra_publico").prop("required", false);
    var $form_palestra = $("#form-palestra");
    
    $("#salvar_palestra").click(function(event) {
        if (! $form_palestra[0].checkValidity() ) { // dados invalidos
            event.preventDefault(); 
            event.stopPropagation();
            $form_palestra.find(":submit").click();
            return false;
        }
        
        var nome       =  $("#form-palestra input[name='nome']").val();
        var sexo        = $("#form-palestra select[name='sexo']").val();
        var grau        = $("#form-palestra select[name='grau_academico']").val();
        var curso       = $("#form-palestra input[name='curso']").val();
        var instituicao = $("#form-palestra input[name='instituicao']").val();
        var palestrante = new Palestrante(nome, sexo, grau, curso, instituicao);
        
        var nome_sala   = $("#form-palestra input[name='sala']").val();
        var publico     = $("#form-palestra input[name='publico']").val();
        publico = (publico === "") ? 0 : parseInt(publico);
        var sala        = new Sala(nome_sala, publico);
        
        var titulo      = $("#form-palestra input[name='titulo']").val();
        var assunto     = $("#form-palestra input[name='assunto']").val();
        var descricao   = $("#form-palestra textarea[name='descricao']").val();
        var data        = $("#form-palestra input[name='data']").val();
        var inicio      = $("#form-palestra input[name='inicio']").val();
        var fim         = $("#form-palestra input[name='fim']").val();
        var palestra    = new Palestra(num_palestra, 0, titulo, assunto, descricao, data, inicio, fim, sala, palestrante);
        
        palestras.push( palestra );

        // add resumo da palestra no html
        $(".list_palestras").append(
            "<div id='palestra-"+ num_palestra +"' class='resumo_palestra col-md-4 pull left'>\
                <div class='panel panel-primary'>\
                    <div class='panel-heading'>Resumo\
                        <span class='palestra-btns pull-right'>\
                            <button value='"+ num_palestra + "' data-toggle='modal' data-target='#visualizar_palestra' class='visualizar-palestra btn btn-success'><span class='fa fa-search-plus'></span></button>\
                            <button value='"+ num_palestra + "' class='remover-palestra btn btn-danger'><span class='glyphicon glyphicon-trash'></span></button>\
                        </span>\
                    </div>\
                    <div class='panel-body'>\
                        <p><label>Título:</label> "+ titulo +"</p>\
                        <p><label>Data:</label> "+ inicio +"</p>\
                        <p><label>Palestrante:</label> "+ nome +"</p>\
                    </div>\
                </div>\
            </div>"
        );
        num_palestra++;       
    });

    /* VISUALIZAR PALESTRA */
    $("#palestras").on("click", ".resumo_palestra .visualizar-palestra", function() {
        var num_palestra_visualizar = parseInt( this.value );
        var div = $("#visualizacao-form-palestra");
        for(var i = 0; i < palestras.length; i++) {
            if (palestras[i].num_palestra === num_palestra_visualizar) {
                div.find("input[name='nome']").val(palestras[i].palestrante.nome).prop("disabled", true);
                div.find("select[name='sexo']").val(palestras[i].palestrante.sexo).prop("disabled", true);
                div.find("select[name='grau_academico']").val(palestras[i].palestrante.grauAcademico).prop("disabled", true);
                div.find("input[name='curso']").val(palestras[i].palestrante.cursoFormacao).prop("disabled", true);
                div.find("input[name='instituicao']").val(palestras[i].palestrante.instituicaoFormacao).prop("disabled", true);
                div.find("input[name='sala']").val(palestras[i].sala.nome).prop("disabled", true);
                div.find("input[name='publico']").val(palestras[i].sala.publicoPrevisto).prop("disabled", true);
                div.find("input[name='titulo']").val(palestras[i].titulo).prop("disabled", true);
                div.find("input[name='assunto']").val(palestras[i].assunto).prop("disabled", true);
                div.find("textarea[name='descricao']").val(palestras[i].descricao).prop("disabled", true);
                div.find("input[name='data']").val(palestras[i].data).prop("disabled", true);
                div.find("input[name='inicio']").val(palestras[i].inicio).prop("disabled", true);
                div.find("input[name='fim']").val(palestras[i].fim).prop("disabled", true);
            }
        }    
    });
    
    /* REMOVER PALESTRA */
    $("#palestras").on("click", ".resumo_palestra .remover-palestra", function() {
        var num_palestra_delete = parseInt( this.value );
        for(var i = 0; i < palestras.length; i++) {
            if (palestras[i].num_palestra === num_palestra_delete)
                palestras.splice(i, 1);
        }    
        $('#palestra-' + num_palestra_delete).remove(); // remove resumo da palestra no html
    });    
    
    /* LIMPAR CAMPOS DA MODAL AO FECHAR */
    $("#nova_palestra").on("hidden.bs.modal", function() {
        $form_palestra[0].reset(); 
        $("#palestrante_sexo, #palestrante_grau_academico").css("color", "#999");
    });

});