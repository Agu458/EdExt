/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

});
