$(function() {
    var $enderecoSel = $("#enderecoSel");   
    var $predio      = $("#predio");
    var $predioSel   = $("#predioSel");
    if ($enderecoSel.val() === null)
        $predioSel.hide();
    $('#enderecoSel').change(function() {
        if ($enderecoSel.val() === "R. Floriano Peixoto, 1184 - Centro") {
            $predioSel.hide();
            $predioSel.prop('selectedIndex', 0);
            $predioSel.prop("required", false);
            $predioSel.prop("name", null);
            $predio.show();
            $predio.prop("name", "predio");
            $predio.val("99 - Centro de Ciências Sociais e Humanas");
        } else {
            $predio.hide();
            $predio.prop("name", null);
            $predioSel.show();
            $predioSel.prop("name", "predio");
            $predioSel.prop("required", true);
        }
    });
    
    // correcao option default selects
    $("#palestrante_sexo, #palestrante_grau_academico").css("color", "#999");
    $("#palestrante_sexo, #palestrante_grau_academico").on("click change", function() {
        $( this ).css("color", "#555");
    });
    
});