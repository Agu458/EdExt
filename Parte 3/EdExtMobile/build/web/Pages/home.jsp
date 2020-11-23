<%-- 
    Document   : home
    Created on : 8 nov. 2020, 15:14:40
    Author     : Agustín
--%>

<%@page import="Server.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%@include file="/Pages/Partials/head.jsp" %>

    <style>
        #bienvenida {
            padding: 156px 0 100px;
        }
    </style>
    <body>

        <%@include file="/Pages/Partials/header.jsp" %>

        <div id="bienvenida" class="bg-success text-white">
            <div class="container text-center">
                <h1 class="text-white">Bienvenido a EdExt Mobile</h1>
                <p class="lead"><%= du.getNick() %></p>
            </div>
        </div>

        <div class="container p-4">
            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="window.location.href='consultarCurso.jsp'">Consultar Curso</button>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>

    </body>
</html>
