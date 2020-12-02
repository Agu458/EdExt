<%-- 
    Document   : ingresarResultadosEdicion
    Created on : 27 nov. 2020, 14:30:57
    Author     : Agustín
--%>

<%@page import="Server.DataInscripcionEdicion"%>
<%@page import="java.text.SimpleDateFormat"%>
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
                <h1>Ingresar Resultados a Edicion de Curso</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <%
                    DataEdicion de = (DataEdicion) request.getAttribute("edicion");
                    List aceptados = (List) request.getAttribute("aceptados");
                    String msg = (String) request.getAttribute("msg");

                    if (de == null && aceptados == null) {
                        if (msg != null) {
                %>
                <div class="form-group">
                    <div class="alert alert-danger" role="alert">
                        <%= msg%>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="form-group">
                    <label for="#selInstituto">Instituto</label>
                    <select class="form-control" id="selInstituto"></select>
                </div>
                <div class="form-group">
                    <label id="labelCurso" for="#selCurso">Curso</label>
                    <select class="form-control" id="selCurso"></select>
                </div>
                <div class="form-group">
                    <label id="labelList" for="#listByCurso">Ediciones</label>
                    <div class="card p-4" id="listByCurso">
                        <form action="Edicion" method="GET">
                            <div class="list-group" id="listEdsCurso"></div>
                        </form>
                    </div>
                </div>
                <%
                } else {
                %>
                <h2 class="text-center"> Datos de la Edicion </h2>
                <div class="form-group">
                    <label for="curso">Curso</label>
                    <input type="text" class="form-control" id="curso" name="curso" readonly="" value="<%= de.getCurso()%>">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= de.getNombre()%>">
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechaini">Fecha de Inicio</label>
                            <%
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String fechaIni = formato.format(de.getFechaIni().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechaini" readonly="" value="<%= fechaIni%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechafin">Fecha de Finalizacion</label>
                            <%
                                String fechaFin = formato.format(de.getFechaFin().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechafin" readonly="" value="<%= fechaFin%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechafin">Fecha de Publicación</label>
                            <%
                                String fechaReg = formato.format(de.getFechaPublicacion().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechafin" readonly="" value="<%= fechaReg%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="cupos">Cupos</label>
                            <input type="number" class="form-control" id="cupos" name="cupos" readonly="" value="<%= de.getCupos()%>">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="profesores">Profesores</label>
                    <ul class="list-group" id="profesores">
                        <%
                            if (de.getProfesores().isEmpty()) {
                        %>
                        <li class="list-group-item">No tiene ...</li>
                            <%
                                }
                                for (String s : de.getProfesores()) {
                            %>
                        <li class="list-group-item"><%= s%></li>
                            <%
                                }
                            %>
                    </ul>
                </div>
                <div class="form-group">
                    <label for="estudiantes">Estudiantes</label>
                    <div class="list-group" id="estudiantes">
                        <form action="Usuario" method="GET">
                            <%
                                if (aceptados.isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (Object o : aceptados) {
                                    DataInscripcionEdicion die = (DataInscripcionEdicion) o;
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="verInscripcionUsuario" value="<%= die.getEstudiante()%>,<%= de.getNombre() %>,<%= de.getCurso()%>"><%= die.getEstudiante() %></button>
                            <%
                                }
                            %>
                        </form>
                    </div>
                </div>
                <%
                    if (de.isActiva()) {
                %>
                <div class="form-group text-right">
                    <form action="Edicion" method="POST">
                        <button type="submit" class="btn btn-danger" name="finalizarEdicion" value="<%= de.getCurso()%>,<%= de.getNombre() %>" >Finalizar Edicion de Curso</button>
                    </form>
                </div>
                <%
                } else {
                %>
                <div class="form-group">
                    <div class="alert alert-warning" role="alert">
                        <strong>Edicion de curso finalizada </strong>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>

        <script>
            $('#listByCurso').hide();
            $('#selCurso').hide();
            $('#labelCurso').hide();
            $('#labelList').hide();

            var selinstituto = $('#selInstituto');
            selinstituto.change(function () {
                $('#labelCurso').show();
                $('#selCurso').show();
                var selCurso = $('#selCurso');
                selCurso.empty();
                selCurso.append(`<option value="vacio" selected> Seleccione Curso... </option>`);
                let insti = selinstituto.val();
                let accion = "cursosInstiConEdicion";
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

            var selCurso = $('#selCurso');
            selCurso.change(function () {
                $('#labelList').show();
                $('#listByCurso').show();
                var listEdsCurso = $('#listEdsCurso');
                listEdsCurso.empty();
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
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="ingresarResultados" value="' + curso + ',' + edicion + '" >' + edicion + '</button>';
                                listEdsCurso.append(template);
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
