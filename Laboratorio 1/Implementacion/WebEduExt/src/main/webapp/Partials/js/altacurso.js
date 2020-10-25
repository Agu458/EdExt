/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#nombreValido').hide();

function validarAltaCurso() {
    let nombre = $('#nombre').val();
    let validarNombre = "validarNombreEdicion";
    $.ajax({
        type: 'GET',
        url: 'Curso',
        data: {validar: validarNombre, nombre: nombre},
        success: function (response) {
            let nombreValido = JSON.parse(response);
            if (!nombreValido) {
                $('#nombreValido').show();
            } else {
                $('#nombreValido').hide();
            }
        }
    });
    if ($('#nombreValido').is(":visible")) {
        return true;
    } else {
        return false;
    }
}

$(document).ready(function () {

    var selinsti = $('#instituto');
    selinsti.hide();
    selinsti.empty();
    selinsti.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
    selinsti.toggle();
    let action = "listarInstitutos";
    $.ajax({
        type: 'GET',
        url: 'Instituto',
        data: {action:action},
        success: function (response) {
            let institutos = JSON.parse(response);
            institutos.forEach(instituto => {
                let template = '<option value="' + instituto + '">' + instituto + '</option>';
                $('#instituto').append(template);
            });
        }
    });

    var categorias = $('#categorias');
    categorias.empty();
    let action = "darCategorias";
    $.ajax({
        type: 'GET',
        url: 'Curso',
        data: {action: action},
        success: function (response) {
            let cats = JSON.parse(response);
            if (cats !== null) {
                cats.forEach(categoria => {
                    let template = '<option value="' + categoria + '">' + categoria + '</option>';
                    categorias.append(template);
                });
            }
        }
    });

    var previas = $('#previas');
    selinsti.change(function () {
        previas.empty();
        let insti = selinsti.val();
        let action = "cursosInsti";
        $.ajax({
            type: 'GET',
            url: 'Curso',
            data: {action: action, insti: insti},
            success: function (response) {
                let cursos = JSON.parse(response);
                if (cursos !== null) {
                    cursos.forEach(curso => {
                        let template = '<option value="' + curso + '">' + curso + '</option>';
                        previas.append(template);
                    });
                }
            }
        });
    });

    $('#verificar').click(function () {
        var nombre = $('#nombre');
        let action = "validarNombreCurso";
        var campoNombre = $('#nombre');
        var nombreValido = $('#nombreValido');
        $.ajax({
            type: 'GET',
            url: 'Curso',
            data: {action: action, nombre: nombre},
            success: function (response) {
                let valido = JSON.parse(response);
                if (!valido) {
                    console.log(valido);
                    campoNombre.addClass("text-danger");
                    nombreValido.show();
                    return false;
                } else {
                    campoNombre.removeClass("text-danger");
                    nombreValido.hide();
                    return true;
                }
            }
        });
    });
});
