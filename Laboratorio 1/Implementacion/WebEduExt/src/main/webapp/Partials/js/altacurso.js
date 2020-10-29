/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#nombreValido').hide();

function validarNombre() {
    var btnAltaCurso = $('#btnAltaCurso');
    let validar = "validarNombreCurso";
    let nombre = $('#nombre').val();
    $.ajax({
        type: 'GET',
        url: 'Curso',
        data: {validar: validar, nombre: nombre},
        success: function (response) {
            let nombreValido = JSON.parse(response);
            if (!nombreValido) {
                $('#nombreValido').show();
                btnAltaCurso.attr("disabled", true);
            } else {
                $('#nombreValido').hide();
                btnAltaCurso.attr("disabled", false);
            }
        }
    });
}

$(document).ready(function () {
    
    $('#nombre').keyup(function () {
        validarNombre();
    });
    
    var selinsti = $('#instituto');
    selinsti.empty();
    selinsti.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
    let accion = "listarInstitutos";
    $.ajax({
        type: 'GET',
        url: 'Instituto',
        data: {accion:accion},
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
    accion = "darCategorias";
    $.ajax({
        type: 'GET',
        url: 'Curso',
        data: {accion: accion},
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
        accion = "cursosInsti";
        $.ajax({
            type: 'GET',
            url: 'Curso',
            data: {accion: accion, insti: insti},
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
});
