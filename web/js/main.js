



$(document).ready(function () {
    

    var registroCompleto = $("#registroCompleto").text();
    console.log(registroCompleto)
    
    if (registroCompleto == "RegistroCompletado") {
        $("#Registro").show();
        $("#Error").hide();
        $("#Eliminado").hide();

    } else if (registroCompleto == "login") {
        $("#Registro").hide();
        $("#Error").show();
        $("#Eliminado").hide();
        
    } else if (registroCompleto == "Eliminado") {
        $("#Registro").hide();
        $("#Error").hide();
        $("#Eliminado").show();
        
    } else {
        $(".alert").alert('close')
    }
});


