<%-- 
    Document   : seleccionarEstudiantesEdicion
    Created on : 28 oct. 2020, 19:27:44
    Author     : Agustin
--%>

<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="all-title-box">
            <div class="container text-center">
                <h1>Seleccionar estudiantes para una Edicion de Curso</h1>
            </div>
        </div>
        <%
            List<String> inscriptos = (List<String>) request.getAttribute("inscriptos");
            DataEdicion de = (DataEdicion) request.getAttribute("edicion");
            if (inscriptos == null) {
        %>
        <div class="container p-4">    
            <div class="card p-4">
                <label for="#selInstituto">Instituto</label>
                <select class="form-control" id="selInstituto"></select>
                <label for="#selCurso">Curso</label>
                <select class="form-control" id="selCurso"></select>
                <label for="#listEdicionesCurso">Edicion</label>
                <form action="Edicion" method="GET">
                    <div class="list-group" id="listEdicionesCurso"></div>
                </form>
            </div>
        </div>
        <%
        } else {
        %>
        <div class="container p-4">
            <div class="card p-4">
                <div class="list-group">
                    <form action="Edicion" method="POST">
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <input type="text" class="form-control" id="curso" name="curso" readonly="" value="<%= de.getCurso() %>">
                        </div>
                        <div class="form-group">
                            <label for="edicion">Edicion</label>
                            <input type="text" class="form-control" id="edicion" name="edicion" readonly="" value="<%= de.getNombre() %>">
                        </div>
                        <div class="form-group">
                            <label class="">Inscriptos</label>
                            <%
                                for (String s : inscriptos) {
                            %>
                            <div class="list-group-item">
                                <div class="">
                                    <input type="checkbox" class="" name="aceptados" value="<%= s%>">
                                    <label class=""><%= s%></label>
                                </div>
                            </div>    
                            <%
                                }
                            %> 
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="aceptarEstudiantes">Aceptar Estudiantes</button>
                        </div>   
                    </form>
                </div>
            </div>
        </div> 
        <%
            }
        %>
        <script>
            var selCurso = $('#selCurso');
            var selinstituto = $('#selInstituto');
            selinstituto.change(function () {
                selCurso.empty();
                selCurso.append(`<option value="vacio" selected> Seleccione Curso... </option>`);
                let insti = selinstituto.val();
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
                                selCurso.append(template);
                            });
                        }
                    }
                });
            });

            selCurso.change(function () {
                var listEdicionesCurso = $('#listEdicionesCurso');
                listEdicionesCurso.empty();
                let curso = selCurso.val();
                let accion = "listarEdicionesCurso";
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion, curso: curso},
                    success: function (response) {
                        let ediciones = JSON.parse(response);
                        if (ediciones !== null) {
                            ediciones.forEach(edicion => {
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="seleccionarInscriptosEdicion" value="' + curso + "," + edicion + '" >' + edicion + '</button>';
                                listEdicionesCurso.append(template);
                            });
                        }
                    }
                });
            });

            $(document).ready(function () {
                let accion = "listarInstitutos";
                selinstituto.empty();
                selinstituto.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'Instituto',
                    data: {accion: accion},
                    success: function (response) {
                        let institutos = JSON.parse(response);
                        institutos.forEach(instituto => {
                            let template = '<option value="' + instituto + '">' + instituto + '</option>';
                            selinstituto.append(template);
                        });
                    }
                });
            });
        </script>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

