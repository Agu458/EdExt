<%-- 
    Document   : estudiantesAceptados
    Created on : 29 oct. 2020, 1:12:30
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
                <h1>Estudiantes aceptados a una Edicion de Curso</h1>
            </div>
        </div>
        <%
            List<DataEstudiante> aceptados = (List<DataEstudiante>) request.getAttribute("aceptados");
            DataEdicion de = (DataEdicion) request.getAttribute("edicion");
            if (aceptados == null) {
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
                    <div class="form-group">
                        <label for="curso">Curso</label>
                        <input type="text" class="form-control" id="curso" name="curso" disabled="" value="<%= de.getCurso()%>">
                    </div>
                    <div class="form-group">
                        <label for="edicion">Edicion</label>
                        <input type="text" class="form-control" id="edicion" name="edicion" disabled="" value="<%= de.getNombre()%>">
                    </div>
                    <div class="form-group">
                        <label class="">Estudiantes Aceptados</label>
                        <div class="card">
                            <table class="table table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Correo</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for (DataEstudiante est : aceptados) {
                                    %>
                                    <tr>
                                        <th scope="row"><%= est.getEmail()%></th>
                                        <td><%= est.getNombre()%></td>
                                        <td><%= est.getApellido()%></td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="darAceptadosAEdicion" value="' + curso + "," + edicion + '" >' + edicion + '</button>';
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

