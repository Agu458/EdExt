/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#nombreValido').hide();

$(document).ready(function () {

    var selinstituto = $('#instituto');
    selinstituto.empty();
    selinstituto.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
    $.ajax({
        type: 'GET',
        url: 'Instituto',
        success: function (response) {
            let institutos = JSON.parse(response);
            institutos.forEach(instituto => {
                let template = '<option value="' + instituto + '">' + instituto + '</option>';
                selinstituto.append(template);
            });
        }
    });
    
    var previas = $('#previas');
    selinstituto.change(function(){
        previas.empty();
        let insti = selinstituto.val();
        let action = "cursosInsti";
        $.ajax({
            type: 'GET',
            url: 'Curso',
            data: {action: action, insti: insti},
            success: function(response){
                let cursos = JSON.parse(response);
                cursos.forEach(curso => {
                    let template = '<option value="' + curso + '">' + curso + '</option>';
                    previas.append(template);
                });
            }
        });
    });
    
    $('#verificar').click(function(){
        var nombre = $('#nombre');
        let action = "validarNombreCurso";
        var campoNombre = $('#nombre');
        var nombreValido = $('#nombreValido');
        $.ajax({
            type: 'GET',
            url: 'Curso',
            data: {action: action, nombre: nombre},
            success: function(response){
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
