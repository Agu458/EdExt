<%-- 
    Document   : ingresarResultado
    Created on : 27 nov. 2020, 16:21:09
    Author     : Agustín
--%>

<%@page import="Server.DataInscripcionEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <%
            DataUsuario usu = (DataUsuario) request.getAttribute("datosUsuario");
            DataInscripcionEdicion die = (DataInscripcionEdicion) request.getAttribute("datosInscripcion");
        %>

        <div class="container p-4">
            <div class="card p-4">
                <div class="form-group text-center">
                    <h2>Ingresar Nota del Estudiante</h2>
                </div>
                <form action="Calificacion" method="POST">
                    <div class="form-group">
                        <label for="#curso">Curso</label>
                        <input type="text" class="form-control" name="curso" id="curso" value="<%= die.getEdicion().getCurso() %>" readonly="">
                    </div>
                    <div class="form-group">
                        <label for="#edicion">Edicion</label>
                        <input type="text" class="form-control" name="edicion" id="edicion" value="<%= die.getEdicion().getNombre() %>" readonly="">
                    </div>
                    <div class="form-group">
                        <label for="#nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" value="<%= usu.getNombre()%>" disabled="">
                    </div>
                    <div class="form-group">
                        <label for="#apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" id="apellido" value="<%= usu.getApellido()%>" disabled="">
                    </div>
                    <div class="form-group">
                        <label for="#email">Email</label>
                        <input type="text" class="form-control" name="email" id="email" value="<%= usu.getEmail()%>" readonly="">
                    </div>
                    <div class="form-group">
                        <label for="#urlvideo">URL Video</label>
                        <input type="text" class="form-control" name="urlvideo" id="urlvideo" value="<%= die.getUrlVideo()%>" disabled="">
                    </div>
                    <%
                        if (!die.getUrlVideo().equals("")) {
                    %>
                    <div class="embed-responsive embed-responsive-16by9 rounded mb-4">
                        <iframe width="560" height="315" src="<%= die.getUrlVideo()%>" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </div>
                    <%
                        }
                    %>
                    <div class="form-group">
                        <label for="#calificacion">Calificacion</label>
                        <input type="number" class="form-control" name="calificacion" id="calificacion" value="<%= die.getCalificacion()%>" min="1" max="12">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-block btn-primary" name="ingresarNota" >Enviar</button>
                    </div>
                </form>
            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>