/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#contraseniaValida').hide();
    $('#nickValido').hide();
    $('#emailValido').hide();
    
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
    
    function validarNick(){
        let valido = true;
        let validarNick = "validarNick";
        let nick = $('#nick').val();
        $.ajax({
            type: 'GET',
            url: 'Registrarse',
            data: {validar: validarNick, nick: nick},
            success: function (response) {
                let nickValido = JSON.parse(response);
                if (!nickValido) {
                    valido = false;
                    $('#nickValido').show();
                } else {
                    $('#nickValido').hide();
                }
            }
        });
        return valido;
    }

    function validarEmail(){
        let valido = true;
        let email = $('#email').val();
        let validarEmail = "validarEmail";
        
        $.ajax({
            type: 'GET',
            url: 'Registrarse',
            data: {validar: validarEmail, email: email},
            success: function (response) {
                let emailValido = JSON.parse(response);
                if (!emailValido) {
                    valido = false;
                    $('#emailValido').show();
                } else {
                    $('#emailValido').hide();
                }
            }
        });
        return valido;
    }

    function validarRegistro() {
        let valido = true;
        let contrasenia = $('#contrasenia').val();
        let contrasenia2 = $('#contrasenia2').val();

        valido = validarNick();

        valido = validarEmail();
        
        if (contrasenia2 !== contrasenia) {
            valido = false;
            $('#contraseniaValida').show();
        } else {
            $('#contraseniaValida').hide();
        }

        return valido;
    }

});
