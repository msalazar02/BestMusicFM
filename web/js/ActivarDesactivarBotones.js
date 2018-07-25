/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {


    var botones = $("#botones").text();
    console.log(botones)

    if (botones == "Actualizar") {
        $("#Registrar").remove();
        $("#Actualizar").show();
        $("#Error").hide();
    }
    if (botones == "error") {
        $("#Error").show();
        $("#Registrar").show();
        $("#Actualizar").remove();

    } else {
        $("#Registrar").show();
        $("#Actualizar").remove();
        $("#Error").hide();

    }


});
