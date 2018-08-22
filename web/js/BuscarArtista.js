
$(document).ready(function () {


    var aviso = $("#aviso").text();
    console.log(aviso);

    if (aviso === "error") {
        $("#Error").hide();
        $("#Completo").show();

    }

    if (aviso === "completo") {
        $("#Error").hide();
        $("#Completo").show();

    } else {
        $("#Error").hide();
        $("#Completo").hide();

    }
})


