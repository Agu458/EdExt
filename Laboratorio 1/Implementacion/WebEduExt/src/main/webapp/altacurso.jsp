<%-- 
    Document   : altacurso
    Created on : 20 oct. 2020, 17:34:25
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

        <div class="container p-4">
            <div class="card">
                <h2 class="card-header text-center text-white bg-warning">Alta de un Curso</h2>
                <div class="card-header" >
                    <form action="Curso" method="POST">
                        <div class="form-group">
                            <label for="instituto">Instituto</label>
                            <select id="instituto" class="form-control" required="" name="instituto">
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" required="" name="nombre">
                            <div class="alert alert-danger mt-4" id="nombreValido" role="alert"> El nombre del curso se encuentra en uso ... </div>
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción</label>
                            <textarea class="form-control" id="descripcion" name="descripcion" required=""></textarea>
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="duracion">Duracion</label>
                                    <input type="number" class="form-control" id="duracion" name="duracion" required="">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="horas">Cantidad de Horas</label>
                                    <input type="number" class="form-control" id="horas" name="horas" required="">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="creditos">Cantidad de Creditos</label>
                                    <input type="number" class="form-control" id="creditos" name="creditos" required="">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="url">URL</label>
                            <input type="url" class="form-control" id="url" name="url" required="">
                        </div>
                        <div class="form-group">
                            <label for="previas">Previas</label>
                            <select multiple class="custom-select" id="previas" name="previas"></select>
                        </div>
                        <div class="form-group">
                            <label for="categorias">Categorias</label>
                            <select multiple class="form-control" id="categorias" name="categorias"></select>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="altaCurso">Crear Curso</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="http://localhost:8080/WebEduExt/Partials/js/altacurso.js" ></script>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>