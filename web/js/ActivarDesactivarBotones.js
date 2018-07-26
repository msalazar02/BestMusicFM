
$(document).ready(function () {


    var botones = $("#botones").text();
    console.log(botones)

    if (botones == "Actualizar") {
        $("#Registrar").remove();
        $("#Actualizar").show();

    } else {
        $("#Registrar").remove();
        $("#Actualizar").remove();


    }


});
