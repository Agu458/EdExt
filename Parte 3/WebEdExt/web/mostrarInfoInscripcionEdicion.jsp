<%-- 
    Document   : mostrarInfoInscripcionEdicion
    Created on : 28 oct. 2020, 18:41:09
    Author     : Agustin
--%>

<%@page import="Server.EstadoInscripcion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Server.DataInscripcionEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataInscripcionEdicion die = (DataInscripcionEdicion) request.getAttribute("datosInscripcion");
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
                <h2 class="text-center"> Datos de la Inscripcion a la Edicion </h2>
                <div class="form-group">
                    <label for="edicion">Edicion</label>
                    <form action="Edicion" method="GET">
                        <button type="submit" class="list-group-item list-group-item-action" name="consultarEdicion" value="<%= die.getEdicion().getCurso()%>,<%= die.getEdicion().getNombre()%>" > <%= die.getEdicion().getNombre()%> </button>
                    </form>
                </div>
                <%
                    if (!die.getEdicion().isActiva()) {
                %>
                <div class="form-group">
                    <div class="alert alert-warning" role="alert">
                        <strong>Edicion de curso finalizada </strong>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="form-group">
                    <label for="nombre">Estudiante</label>
                    <input type="text" class="form-control" id="estudiante" name="estudiante" readonly="" value="<%= die.getEstudiante()%>">
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <input type="text" class="form-control" id="estado" name="nombre" readonly="" value="<%= die.getEstado()%>">
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha</label>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha = formato.format(die.getFecha().toGregorianCalendar().getTime());
                    %>
                    <input class="form-control" type="date" name="fecha" readonly="" value="<%= fecha%>">
                </div>
                <div class="form-group">
                    <label for="calificacion">Calificacion</label>
                    <input type="text" class="form-control" id="calificacion" name="calificacion" readonly="" value="<%= die.getCalificacion()%>">
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

                    if (die.getEstado() == EstadoInscripcion.INSCRIPTO) {
                %>
                <form action="Edicion" method="POST">
                    <button type="submit" class="btn btn-danger" name="desistirDeInscripcion" value="<%= die.getEstudiante()%>,<%= die.getEdicion().getNombre()%>,<%= die.getEdicion().getCurso()%>" >Desistir de inscripcion</button>
                </form>
                <%
                    }
                %>

            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
