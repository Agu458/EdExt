<%-- 
    Document   : mostrarInfoPrograma
    Created on : 26 oct. 2020, 15:00:59
    Author     : Otro
--%>

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
                    <input type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= dpf.getNombre() %>">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <text type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= dpf.getNombre() %>">
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
                                String fechaIni = formato.format(dpf.getFechaIni());
                            %>
                            <input class="form-control" type="date" name="fechaini" readonly="" value="<%= fechaIni%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechafin">Fecha de Finalizacion</label>
                            <%
                                String fechaFin = formato.format(dpf.getFechaFin());
                            %>
                            <input class="form-control" type="date" name="fechafin" readonly="" value="<%= fechaFin%>">
                        </div>
                    </div>
                </div>
                    
        <%= dpf.getNombre() %>
        
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

