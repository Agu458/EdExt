<%-- 
    Document   : comentarios
    Created on : 23 nov. 2020, 0:21:42
    Author     : Agustín
--%>

<%@page import="Server.DataComentario"%>
<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataEdicion de = (DataEdicion) request.getAttribute("datosEdicion");
    if (de != null) {
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>

        <!-- Estilo de los comentarios -->
        <link rel="stylesheet" href="/WebEdExt/Partials/css/comentarios.css">
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="container p-4">
            <div class="card p-4">
                <h2 class="text-center"><%= de.getNombre()%></h2>
                <div class="form-group">
                    <label for="comentarios">Comentarios</label>
                    <!-- Contenedor Principal -->


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
                                        <div class="comment-avatar"><img src="https://www.bootdey.com/img/Content/avatar/avatar1.png" alt=""></div>
                                        <!-- Contenedor del Comentario -->
                                        <div class="comment-box">
                                            <div class="comment-head">
                                                <h6 class="comment-name"><a href="#"><%= dc.getEstudiante()%></a></h6>
                                                <span><%= dc.getFechaPublicacion().toGregorianCalendar().getTime()%></span>
                                                <i class="fa fa-reply"></i>
                                            </div>
                                            <div class="comment-content">
                                                <%= dc.getCuerpo()%>
                                            </div>
                                        </div>
                                    </div>
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

                <div class="form-group">
                    <label>Danos tu opinion</label>
                    <div class="card p-4">
                        <form action="Comentario" method="POST">
                            <input type="text" class="form-control" name="curso" readonly="" hidden="" value="<%= de.getCurso()%>">
                            <input type="text" class="form-control" name="edicion" readonly="" hidden="" value="<%= de.getNombre()%>">
                            <input type="text" class="form-control" name="estudiante" readonly="" hidden="" value="<%= du.getEmail()%>">
                            <textarea class="form-control" type="textarea" name="cuerpo" placeholder="Comentario" rows="5" required=""></textarea>
                            <button type="submit" class="btn btn-success mt-4">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

<%
    }
%>