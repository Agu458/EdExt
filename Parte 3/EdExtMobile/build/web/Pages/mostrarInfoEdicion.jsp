<%-- 
    Document   : mostrarInfoEdicion
    Created on : 19 nov. 2020, 14:07:41
    Author     : Agustín
--%>

<%@page import="Server.DataComentario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataEdicion de = (DataEdicion) request.getAttribute("datosEdicion");
%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%@include file="/Pages/Partials/head.jsp" %>

        <!-- Estilo de los comentarios -->
        <link rel="stylesheet" href="/EdExtMobile/Src/CSS/comentarios.css">
    </head>
    <body>

        <%@include file="/Pages/Partials/header.jsp" %>

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

                    <%
                        if (de.getComentarios().isEmpty()) {
                    %>
                    <div class="list-group-item">
                        No hay comentarios...
                    </div>
                    <%
                    } else {
                    %>
                    <div class="card" id="comentarios">
                        <div class="comments-container">
                            <ul id="comments-list" class="comments-list">

                                <%
                                    for (DataComentario dc : de.getComentarios()) {
                                %>
                                <li>
                                    <div class="comment-main-level">
                                        <!-- Avatar -->
                                        <div class="comment-avatar"><img src="https://i.pinimg.com/736x/49/c8/e4/49c8e403cd1929e9e7b02126824ff831.jpg" alt=""></div>
                                        <!-- Contenedor del Comentario -->
                                        <div class="comment-box">
                                            <div class="comment-head">
                                                <h6 class="comment-name"><a href="#"><%= dc.getEstudiante()%></a></h6>
                                                <span><%= dc.getFechaPublicacion().toGregorianCalendar().getTime()%></span>
                                            </div>
                                            <div class="comment-content">
                                                <%= dc.getCuerpo()%>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Respuestas de los comentarios -->
                                    <ul class="comments-list reply-list">
                                        <%
                                            for (DataComentario reply : dc.getRespuestas()) {
                                        %>

                                        <li>
                                            <!-- Avatar -->
                                            <div class="comment-avatar"><img src="https://i.pinimg.com/736x/49/c8/e4/49c8e403cd1929e9e7b02126824ff831.jpg" alt=""></div>
                                            <!-- Contenedor del Comentario -->
                                            <div class="comment-box">
                                                <div class="comment-head">
                                                    <h6 class="comment-name"><a href="#=<%= reply.getEstudiante()%>"><%= reply.getEstudiante()%></a></h6>
                                                    <span><%= reply.getFechaPublicacion().toGregorianCalendar().getTime()%></span>
                                                </div>
                                                <div class="comment-content">
                                                    <%= reply.getCuerpo()%>
                                                </div>
                                            </div>
                                        </li>

                                        <%
                                            }
                                        %>
                                    </ul>
                                </li>
                                <%
                                    }
                                %>

                            </ul>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>

    </body>
</html>
