
$(document).ready(function () {


    var botones = $("#aviso").text();
    console.log(botones);

    if (botones === "error") {
        $("#Error").show();



    } else {
        $("#Error").hide();

    }
});