<%-- 
    Document   : accesoDenegado
    Created on : 22 oct. 2020, 12:28:01
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/Partials/head.jsp" %>
        <style>
            body {
                background: #4b6cb7;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #182848, #4b6cb7);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #182848, #4b6cb7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                display: flex;
                flex-flow: row wrap;
                justify-content: center;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <div class="page-wrap d-flex flex-row align-items-center">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-md-12 text-center text-white">
                        <span class="display-1 d-block">403</span>
                        <div class="mb-4 h2 text-white"><i class="fas fa-lock"></i></div>
                        <div class="mb-4 h3 text-white">Acceso Denegado</div>
                        <div class="mb-4 lead text-white">No se poseen los permisos nesesarios para acceder a la pagina.</div>
                        <a href="index.jsp" role="button" class="btn btn-light btn-lg" ><i class="fas fa-home"></i> Ir a Inicio</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
