<%-- 
    Document   : mostrarInfoPrograma
    Created on : 26 oct. 2020, 15:00:59
    Author     : Otro
--%>

<%@page import="Server.DataProgramaFormacion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataProgramaFormacion dpf = (DataProgramaFormacion) request.getAttribute("dataPrograma");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="container p-4">
            <div class="card p-4">
                <h2 class="text-center"> Datos del Programa de Formacion </h2>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= dpf.getNombre()%>">
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" readonly=""><%= dpf.getDescripcion()%></textarea>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechaini">Fecha de Inicio</label>
                            <%
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String fechaIni = formato.format(dpf.getFechaIni().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechaini" readonly="" value="<%= fechaIni%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechafin">Fecha de Finalizacion</label>
                            <%
                                String fechaFin = formato.format(dpf.getFechaFin().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechafin" readonly="" value="<%= fechaFin%>">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="cursos">Cursos</label>
                    <form action="Curso" method="GET">
                        <div class="list-group" id="cursos">
                            <%
                                if (dpf.getCursos().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (String s : dpf.getCursos()) {
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="consultarCurso" value="<%= s%>" ><%= s%></button>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
                <div class="form-group">
                    <label for="categorias">Categorias</label>
                    <div class="list-group" id="categorias">
                        <%
                            if (dpf.getCategorias().isEmpty()) {
                        %>
                        <label class="list-group-item"> No tiene ...</label>
                        <%
                            }
                            for (String s : dpf.getCategorias()) {
                        %>
                        <label class="list-group-item"> <%= s%></label>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

