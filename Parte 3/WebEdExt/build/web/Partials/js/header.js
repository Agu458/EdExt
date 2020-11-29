/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarNick() {
    var btnRegistrar = $('#btnRegistrar');
    let validarNick = "validarNick";
    let nick = $('#nick').val();
    $.ajax({
        type: 'GET',
        url: 'Registrarse',
        data: {validar: validarNick, nick: nick},
        success: function (response) {
            let nickValido = JSON.parse(response);
            if (!nickValido) {
                $('#nickValido').show();
                btnRegistrar.attr("disabled", true);
            } else {
                $('#nickValido').hide();
                if (!$('#contraseniaValida').is(":visible") && !$('#emailValido').is(":visible")) {
                    btnRegistrar.attr("disabled", false);
                }
            }
        }
    });
}

function validarEmail() {
    var btnRegistrar = $('#btnRegistrar');
    let email = $('#email').val();
    let validarEmail = "validarEmail";
    $.ajax({
        type: 'GET',
        url: 'Registrarse',
        data: {validar: validarEmail, email: email},
        success: function (response) {
            let emailValido = JSON.parse(response);
            if (!emailValido) {
                $('#emailValido').show();
                btnRegistrar.attr("disabled", true);
            } else {
                $('#emailValido').hide();
                if (!$('#nickValido').is(":visible") && !$('#contraseniaValida').is(":visible")) {
                    btnRegistrar.attr("disabled", false);
                }
            }
        }
    });
}

function validarContrasenia() {
    var btnRegistrar = $('#btnRegistrar');
    let contrasenia = $('#contrasenia').val();
    let contrasenia2 = $('#contrasenia2').val();

    if (contrasenia2 !== contrasenia) {
        $('#contraseniaValida').show();
        btnRegistrar.attr("disabled", true);
    } else {
        $('#contraseniaValida').hide();
        if (!$('#nickValido').is(":visible") && !$('#emailValido').is(":visible")) {
            btnRegistrar.attr("disabled", false);
        }
    }
}

function seleccionarInstituto(valor){
    $('#selinsti').val(valor);
}

$(document).ready(function () {
    $('#contraseniaValida').hide();
    $('#nickValido').hide();
    $('#emailValido').hide();
    $('#loginValido').hide();

    $('#nick').keyup(function () {
        validarNick();
    });

    $('#email').keyup(function () {
        validarEmail()();
    });

    $('#contrasenia2').keyup(function () {
        validarContrasenia();
    });

    var selinsti = $('#selinsti');
    var institutosList = $('#institutosList');
    
    selinsti.hide();
    institutosList.hide();
    
    $('#docente').click(function () {
        
        selinsti.empty();
        selinsti.toggle();
        institutosList.empty();
        institutosList.toggle();
        
        let accion = "listarInstitutos";
        
        $.ajax({
            type: 'GET',
            url: 'Instituto',
            data: {accion: accion},
            success: function (response) {
                let institutos = JSON.parse(response);
                institutos.forEach(instituto => {
                    let template = '<button type="button" class="list-group-item list-group-item-action" onClick="seleccionarInstituto(this.innerHTML);" value="' + instituto + '">' + instituto + '</button>';
                    institutosList.append(template);
                });
            }
        });
    });
});
