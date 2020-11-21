<%-- 
    Document   : mostrarInfoEdicion
    Created on : 25 oct. 2020, 21:52:29
    Author     : Agustin
--%>

<%@page import="Server.DataComentario"%>
<%@page import="Server.DataEdicion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataEdicion de = (DataEdicion) request.getAttribute("datosEdicion");
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
                    <div class="list-group" id="profesores">
                        <%
                            if (de.getProfesores().isEmpty()) {
                        %>
                        <label class="list-group-item"> No tiene ...</label>
                        <%
                            }
                            for (String s : de.getProfesores()) {
                        %>
                        <label class="list-group-item"> <%= s%></label>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="form-group">
                    <label for="comentarios">Comentarios</label>
                </div>
            </div>
        </div>
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
