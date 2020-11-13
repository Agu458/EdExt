<%-- 
    Document   : estudiante
    Created on : 20 oct. 2020, 16:10:52
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="all-title-box-estu">
            <div class="container text-center">
                <h1>Estudiante<span class="m_1">Explora tus oportunidades.</span></h1>
            </div>
        </div>

        <div id="Profesor" class="section wb">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="inscripcion_edicion.jsp">Inscripcion a Edicion</a>
                                <span class="post">Inscribirse a edicion de curso.</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="inscripcionAPrograma.jsp">Inscripcion a Programa</a>
                                <span class="post">Inscribirse a programa de formación.</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="res_insc.html">Resultado de inscripciones</a>
                                <span class="post">Listar resultados de inscripciones a ediciones de cursos</span>
                            </div>
                        </div>
                    </div>
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end section -->

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>