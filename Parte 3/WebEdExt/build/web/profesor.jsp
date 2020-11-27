<%-- 
    Document   : profesor
    Created on : 20 oct. 2020, 16:14:16
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


        <div class="all-title-box-prof">
            <div class="container text-center">
                <h1>PROFESOR <span class="m_1">Bienvenido a su espacio de trabajo.</span></h1>
            </div>
        </div>

        <div id="Profesor" class="section wb">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="altacurso.jsp">Alta Curso</a>
                                <span class="post">Crear un nuevo curso</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="altaEdicion.jsp">Alta Edición</a>
                                <span class="post">Crear una edición para un curso</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="altaPrograma.jsp">Alta Programa</a>
                                <span class="post" href="altaedicion.html">Crear un programa de formación</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="agregarCursoPrograma.jsp">Curso-Programa</a>
                                <span class="post">Agregar curso a un programa</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="seleccionarEstudiantesEdicion.jsp">Estudiantes-Edicion</a>
                                <span class="post">Agregar estudiantes a edición</span>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="estudiantesAceptados.jsp">Estudiantes Aceptados</a>
                                <span class="post">Inscripciones aceptadas en edicion</span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-6 col-md-6 col-12">
                        <div class="our-team">
                            <div class="team-content">
                                <a class="title" href="ingresarResultadosEdicion.jsp">Ingresar Resultados</a>
                                <span class="post">Ingresar resultados de evaluaciones de estudiantes</span>
                            </div>
                        </div>
                    </div>
                    
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end section -->	

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
