/* global palestras */

$(function() {
    
    $("#finalizar_evento").on("click", function() {
        // montar json
        var nome        = $("#form-evento input[name='nome']").val();
        var descricao   = $("#form-evento textarea[name='descricao']").val();
        var inicio      = $("#form-evento input[name='inicio']").val();
        var fim         = $("#form-evento input[name='fim']").val();
        var endereco    = $("#form-local select[name='endereco']").val();
        var nome_predio = $("#form-local [name='predio']").val(); 
        var predio      = new Predio(nome_predio);
        var evento      = new Evento(nome, descricao, endereco, inicio, fim, predio, palestras);
       
        $.post({
            url: 'eventoServlet',
            data: { eventoJson: JSON.stringify(evento) },
            success: function(data) {
                location = JSON.parse(data).url;
            }
        });       
    });
    
});