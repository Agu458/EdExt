<%-- 
    Document   : inscripcion_edicion
    Created on : 26 oct. 2020, 9:11:16
    Author     : Otro
--%>

<%@page import="Server.DataEdicion"%>
<%@page import="java.text.SimpleDateFormat"%>
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
                <h1>Inscripcion a Edicion de Curso</h1>
            </div>
        </div>
        <div class="container p-4">
            <%
                DataEdicion de = (DataEdicion) request.getAttribute("edicion");
                if (de == null) {
            %>
            <div class="card p-4">
                <h2 class="text-center"> Buscar por... </h2>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#instituto" role="tab" aria-controls="instituto" aria-selected="true">Instituto</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#categoria" role="tab" aria-controls="categoria" aria-selected="false">Categoria</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active p-4" id="instituto" role="tabpanel">
                        <label for="#selInstituto">Instituto</label>
                        <select class="form-control" id="selInstituto"></select>
                        <div class="card p-4 mt-4" id="listByInstituto">
                            <form action="Edicion" method="GET">
                                <div class="list-group" id="listCursosInstituto"></div>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane fade p-4" id="categoria" role="tabpanel">
                        <label for="#selCategoria">Categoria</label>
                        <select class="form-control" id="selCategoria"></select>
                        <div class="card p-4 mt-4" id="listByCategoria">
                            <form action="Edicion" method="GET">
                                <div class="list-group" id="listCursosCategoria"></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%
            } else {
            %>

            <div class="container p-4">
                <div class="card p-4">
                    <h2 class="text-center"> Datos de la Edicion </h2>
                    <form action="Edicion" method="POST">
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <input type="text" class="form-control" id="curso" name="curso" readonly="" value="<%= de.getCurso()%>">
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" disabled="" value="<%= de.getNombre()%>">
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechaini">Fecha de Inicio</label>
                                    <%
                                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                        String fechaIni = formato.format(de.getFechaIni().toGregorianCalendar().getTime());
                                    %>
                                    <input class="form-control" type="date" name="fechaini" disabled="" value="<%= fechaIni%>">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechafin">Fecha de Finalizacion</label>
                                    <%
                                        String fechaFin = formato.format(de.getFechaFin().toGregorianCalendar().getTime());
                                    %>
                                    <input class="form-control" type="date" name="fechafin" disabled="" value="<%= fechaFin%>">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechafin">Fecha de Publicación</label>
                                    <%
                                        String fechaReg = formato.format(de.getFechaPublicacion().toGregorianCalendar().getTime());
                                    %>
                                    <input class="form-control" type="date" name="fechafin" disabled="" value="<%= fechaReg%>">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="cupos">Cupos</label>
                                    <input type="number" class="form-control" id="cupos" name="cupos" disabled="" value="<%= de.getCupos()%>">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <%
                                        int cuposRestantes = 0;
                                        if(de.getCupos() != 0){
                                            cuposRestantes = (de.getCupos() - de.getAceptados());
                                        }
                                    %>
                                    <label for="cuposRestantes">Cupos Restantes</label>
                                    <input type="number" class="form-control" id="cuposRestantes" name="cuposRestantes" disabled="" value="<%= cuposRestantes%>">
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
                            <label for="estudiante">Estudiante</label>
                            <input type="text" class="form-control" id="nombre" name="estudiante" readonly="" value="<%= du.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <label for="video">URL video</label>
                            <input type="url" class="form-control" id="video" name="video" value="">
                        </div>
                        <%
                            if (de.getCupos() != 0 && cuposRestantes == 0) {
                        %>
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>No quedan cupos</strong> Prueba otro curso.
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <%
                        } else {
                            if (de.isActiva()) {
                        %>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="altaInscripcionEdicion">Inscribirse</button>
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
                    </form>
                </div>
            </div>

            <%
                }
            %>
        </div>

        <script>
            $('#listByInstituto').hide();
            $('#listByCategoria').hide();

            var selinstituto = $('#selInstituto');
            selinstituto.change(function () {
                $('#listByInstituto').show();
                var listCursosInstituto = $('#listCursosInstituto');
                listCursosInstituto.empty();
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
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="inscribirEdicionCurso" value="' + curso + '" >' + curso + '</button>';
                                listCursosInstituto.append(template);
                            });
                        }
                    }
                });
            });

            var selcategoria = $('#selCategoria');
            selcategoria.change(function () {
                $('#listByCategoria').show();
                var listCursosCategoria = $('#listCursosCategoria');
                listCursosCategoria.empty();
                let categoria = selcategoria.val();
                let accion = "cursosCategoria";
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion, categoria: categoria},
                    success: function (response) {
                        let cursos = JSON.parse(response);
                        if (cursos !== null) {
                            cursos.forEach(curso => {
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="inscribirEdicionCurso" value="' + curso + '" >' + curso + '</button>';
                                listCursosCategoria.append(template);
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

                var categorias = $('#selCategoria');
                categorias.empty();
                accion = "darCategorias";
                categorias.append(`<option value="vacio" selected> Seleccione Categoria... </option>`);
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
            });
        </script>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>