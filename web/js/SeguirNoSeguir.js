$(document).ready(function () {


    var botones = $("#botones").text();
    console.log(botones);

    if (botones === "Seguir") {
        $("#no").remove();
        $("#si").show();
    } else {
        $("#no").show();
        $("#si").remove();


    }

});
