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
        var sala        = new Sala(nome_sala, publico);
        
        var titulo      = $("#form-palestra input[name='titulo']").val();
        var assunto     = $("#form-palestra input[name='assunto']").val();
        var descricao   = $("#form-palestra textarea[name='descricao']").val();
        var data        = $("#form-palestra input[name='data']").val();
        var inicio      = $("#form-palestra input[name='inicio']").val();
        var fim         = $("#form-palestra input[name='fim']").val();
        var palestra    = new Palestra(num_palestra, titulo, assunto, descricao, data, inicio, fim, sala, palestrante);
        
        palestras.push( palestra );

        // add resumo da palestra no html
        $(".list_palestras").append(
            "<div id='palestra-"+ num_palestra +"' class='resumo_palestra col-md-4 pull left'>\
                <div class='panel panel-primary'>\
                    <div class='panel-heading'>Resumo\
                        <span class='palestra-btns pull-right'>\
                            <button value='"+ num_palestra + "' class='remover-palestra btn btn-danger'><span class='glyphicon glyphicon-trash'></span></button>\
                            <button value='"+ num_palestra + "' class='editar-palestra btn btn-warning'><span class='glyphicon glyphicon-pencil'></span></button>\
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

    /* REMOVER PALESTRA */
    $("#palestras").on("click", ".resumo_palestra .remover-palestra", function() {
        var id_palestra_delete = parseInt( this.value );
        for(var i = 0; i < palestras.length; i++) {
            if (palestras[i].num_palestra === id_palestra_delete)
                palestras.splice(i, 1);
        }    
        $('#palestra-' + id_palestra_delete).remove(); // remove resumo da palestra no html
    });

    /* EDITAR PALESTRA */
    
    
    /* LIMPAR CAMPOS DA MODAL AO FECHAR */
    $("#nova_palestra").on("hidden.bs.modal", function() {
        $form_palestra[0].reset(); 
        $("#palestrante_sexo, #palestrante_grau_academico").css("color", "#999");
    });

});