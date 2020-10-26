<%-- 
    Document   : altaEdicion
    Created on : 25 oct. 2020, 14:39:09
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="container p-4">
            <div class="card">
                <h2 class="card-header text-center text-white bg-warning">Alta de una Edicion</h2>
                <div class="card-header" >
                    <form action="Edicion" method="POST">
                        <div class="form-group">
                            <label for="instituto">Instituto</label>
                            <select id="instituto" class="form-control" required="" name="instituto">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <select id="curso" class="form-control" required="" name="curso">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" required="" name="nombre">
                            <div class="alert alert-danger mt-4" id="nombreValido" role="alert"> El nombre de la edicion se encuentra en uso ... </div>
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechaini">Fecha de Inicio</label>
                                    <input class="form-control" type="date" name="fechaini" required>
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechafin">Fecha de Finalizacion</label>
                                    <input class="form-control" type="date" name="fechafin" required>
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="cupos">Cupos</label>
                                    <input type="number" class="form-control" id="cupos" name="cupos">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="profesores">Profesores</label>
                            <select multiple class="form-control" id="profesores" name="profesores" required=""></select>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="altaEdicion">Crear Edicion</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script>
            $('#nombreValido').hide();

            $(document).ready(function () {
                let accion = "listarInstitutos";
                var selinsti = $('#instituto');
                selinsti.empty();
                selinsti.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'Instituto',
                    data: {accion: accion},
                    success: function (response) {
                        let institutos = JSON.parse(response);
                        institutos.forEach(instituto => {
                            let template = '<option value="' + instituto + '">' + instituto + '</option>';
                            $('#instituto').append(template);
                        });
                    }
                });

                var selprofesores = $('#profesores');
                var selcurso = $('#curso');
                selinsti.change(function () {
                    selcurso.empty();
                    selcurso.append(`<option value="vacio" selected> Seleccione Curso... </option>`);
                    let insti = selinsti.val();
                    let accion = "cursosInsti";
                    $.ajax({
                        type: 'GET',
                        url: 'Curso',
                        data: {accion: accion, insti: insti},
                        success: function (response) {
                            let cursos = JSON.parse(response);
                            if (cursos !== null) {
                                cursos.forEach(curso => {
                                    let template = '<option value="' + curso + '">' + curso + '</option>';
                                    selcurso.append(template);
                                });
                            }
                        }
                    });

                    selprofesores.empty();
                    accion = "listarProfesoresInstituto";
                    $.ajax({
                        type: 'GET',
                        url: 'Instituto',
                        data: { accion:accion , instituto:insti},
                        success: function (response) {
                            let profesores = JSON.parse(response);
                            if (profesores !== null) {
                                profesores.forEach(profesor => {
                                    let template = '<option value="' + profesor + '">' + profesor + '</option>';
                                    selprofesores.append(template);
                                });
                            }
                        }
                    });
                });
            });
        </script>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
