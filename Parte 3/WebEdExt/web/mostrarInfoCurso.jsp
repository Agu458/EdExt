<%-- 
    Document   : mostrarInfoCurso
    Created on : 25 oct. 2020, 12:58:57
    Author     : Agustin
--%>

<%@page import="Server.DataEdicion"%>
<%@page import="Server.DataCurso"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataCurso dc = (DataCurso) request.getAttribute("curso");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>
        <div class="all-title-box">
            <div class="container text-center">
                <h1>Consultar Curso</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <h2 class="text-center"> Datos del Curso </h2>
                <div class="form-group">
                    <label for="instituto">Instituto</label>
                    <input type="text" class="form-control" id="instituto" name="instituto" readonly="" value="<%= dc.getInstituto()%>">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= dc.getNombre()%>">
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" readonly=""><%= dc.getDescripcion()%></textarea>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="duracion">Duracion</label>
                            <input type="number" class="form-control" id="duracion" name="duracion" readonly="" value="<%= dc.getDuracion()%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="horas">Cantidad de Horas</label>
                            <input type="number" class="form-control" id="horas" name="horas" readonly="" value="<%= dc.getHoras()%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="creditos">Cantidad de Creditos</label>
                            <input type="number" class="form-control" id="creditos" name="creditos" readonly="" value="<%= dc.getCreditos()%>">
                        </div>
                    </div>
                        <div class="col-sm">
                        <div class="form-group">
                            <label for="fechareg">Fecha de Publicación</label>
                            <%
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String fechareg = formato.format(dc.getFechaRegistro().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechareg" readonly="" value="<%= fechareg%>">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="url">URL</label>
                    <input type="url" class="form-control" id="url" name="url" readonly="" value="<%= dc.getURL()%>">
                </div>
                <div class="form-group">
                    <label for="previas">Previas</label>
                    <form action="Curso" method="GET">
                        <div class="list-group" id="previas">
                            <%
                                if (dc.getPrevias().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (String s : dc.getPrevias()) {
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
                    <form action="Curso" method="GET">
                        <div class="list-group" id="categorias">
                            <%
                                if (dc.getCategorias().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (String s : dc.getCategorias()) {
                            %>
                            <label class="list-group-item"> <%= s%></label>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
                <div class="form-group">
                    <label for="edicionActual">Edicion Actual</label>
                    <%
                        if (dc.getEdicionAgtual() != null) {
                    %>
                    <input type="text" class="form-control" id="edicionActual" name="edicionActual" readonly="" value="<%= dc.getEdicionAgtual().getNombre()%>">
                    <%
                        } else {
                    %>
                    <input type="text" class="form-control" id="edicionActual" name="edicionActual" readonly="" value="No tiene ...">
                    <%
                        }
                    %>
                </div>
                <div class="form-group">
                    <label for="ediciones">Ediciones</label>
                    <form action="Edicion" method="GET">
                        <div class="list-group" id="ediciones">
                            <%
                                if (dc.getEdiciones().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (DataEdicion de : dc.getEdiciones()) {
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="consultarEdicion" value="<%= de.getCurso() %>,<%= de.getNombre()%>" ><%= de.getNombre() %></button>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
