<%-- 
    Document   : seleccionarEstudiantesEdicion
    Created on : 28 oct. 2020, 19:27:44
    Author     : Agustin
--%>

<%@page import="Server.DataInscripcionEdicion"%>
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
            List<DataInscripcionEdicion> inscriptos = (List<DataInscripcionEdicion>) request.getAttribute("inscriptos");
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
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Video motivacional</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="embed-responsive embed-responsive-16by9 rounded mb-4">
                            <iframe id="video" width="560" height="315" src="" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <div class="list-group">
                    <form action="Edicion" method="POST">
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <input type="text" class="form-control" id="curso" name="curso" readonly="" value="<%= de.getCurso()%>">
                        </div>
                        <div class="form-group">
                            <label for="edicion">Edicion</label>
                            <input type="text" class="form-control" id="edicion" name="edicion" readonly="" value="<%= de.getNombre()%>">
                        </div>
                        <div class="form-group">
                            <label class="">Inscriptos</label>
                            <div class="list-group">
                                <%
                                    if (inscriptos.isEmpty()) {
                                %>
                                <label class="list-group-item">No hay inscriptos...</label>
                                <%
                                } else {
                                    for (DataInscripcionEdicion die : inscriptos) {
                                %>
                                <div class="list-group-item">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1 font-weight-bold"><%= die.getEstudiante()%></h5>
                                    </div>
                                    <%
                                        if (!die.getUrlVideo().equals("")) {
                                    %>
                                    <div class="form-group">
                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="cargarVideo('<%= die.getUrlVideo()%>');">
                                            Ver video motivacional
                                        </button>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <div class="form-group text-center">
                                        <label for="#aceptar">Aceptar?</label>
                                        <input type="checkbox" class="form-control" id="aceptar" name="aceptados" value="<%= die.getEstudiante()%>">
                                    </div>
                                    <p class="mb-1"></p>
                                </div> 
                                <%
                                        }
                                    }
                                %> 
                            </div>
                        </div>
                        <%
                            if (!inscriptos.isEmpty()) {
                        %>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="aceptarEstudiantes">Aceptar Estudiantes</button>
                        </div>
                        <%
                            }
                        %>
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

            function cargarVideo(video) {
                $("#video").attr("src", video);
            }

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

