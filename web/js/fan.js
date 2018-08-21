$(document).ready(function () {


    var registroCompleto = $("#registroCompleto").text();
    console.log(registroCompleto)

    if (registroCompleto == "GeneroIngresado") {
        $("#Registro").show();
    } else {
        $(".alert").alert('close')
    }
});


