/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var selinsti = $('#selinsti');
    selinsti.hide();
    $('#docente').click(function () {
        selinsti.empty();
        selinsti.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
        selinsti.toggle();
        $.ajax({
            type: 'GET',
            url: 'Instituto',
            success: function (response) {
                let institutos = JSON.parse(response);
                institutos.forEach(instituto => {
                    let template = '<option value="' + instituto + '">' + instituto + '</option>';
                    $('#selinsti').append(template);
                });
            }
        });
    });


    var nickValido = $('#nickValido');
    var campoNick = $('#nick');
    nickValido.hide();
    $('#nick').keyup(function () {
        nickValido.hide();
        let nick = campoNick.val();
        let validar = 'validarNick';
        $.ajax({
            type: 'POST',
            data: {nick: nick, validar: validar},
            url: 'Validar',
            success: function (response) {
                let valido = JSON.parse(response);
                if (!valido) {
                    campoNick.addClass("text-danger");
                    nickValido.show();
                } else {
                    campoNick.removeClass("text-danger");
                    nickValido.hide();
                }
            }
        });
    });
});
