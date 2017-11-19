/* global palestras */

$(function() {
    
    $("#finalizar_evento").on("click", function() {
        // montar json
        var nome        = $("#form-evento input[name='nome']").val();
        var descricao   = $("#form-evento textarea[name='descricao']").val();
        var inicio      = $("#form-evento input[name='inicio']").val();
        var fim         = $("#form-evento input[name='fim']").val();
        var endereco    = $("#form-local select[name='enderecoSel]'").val();
        var nome_predio = $("#form-local [name='predio']").val(); 
        var predio      = new Predio(nome_predio);
        var evento      = new Evento(nome, descricao, endereco, inicio, fim, predio, palestras);
        
        console.log(JSON.stringify(evento));
        // ajax post     json > servlet
    
        // formato fica = ao json vindo do mongo, entao da pra usar a funcao EventoConversor.toModel(eventoDocument)
        // tem uns campos pra corrigir no back
        
    });
    
});