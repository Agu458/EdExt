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
                <h2 class="card-header text-center text-white bg-dark">Alta de un Curso</h2>
                <div class="card-header" >
                    <div class="form-group">
                        <label for="instituto">Instituto</label>
                        <select id="instituto" class="form-control">
                            <option selected>Choose...</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <textarea class="form-control" id="descripcion"></textarea>
                    </div>
                    <div class="row">
                        <div class="col-sm">
                            <div class="form-group">
                                <label for="duracion">Duracion</label>
                                <input type="number" class="form-control" id="duracion">
                            </div>
                        </div>
                        <div class="col-sm">
                            <div class="form-group">
                                <label for="horas">Cantidad de Horas</label>
                                <input type="number" class="form-control" id="horas">
                            </div>
                        </div>
                        <div class="col-sm">
                            <div class="form-group">
                                <label for="creditos">Cantidad de Creditos</label>
                                <input type="number" class="form-control" id="creditos">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="url">URL</label>
                        <input type="url" class="form-control" id="url">
                    </div>
                    <div class="form-group">
                        <label for="previas">Previas</label>
                        <select multiple class="form-control" id="pervias">
                            
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="categorias">Categorias</label>
                        <select multiple class="form-control" id="categorias">
                            
                        </select>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-primary " >Crear Curso</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="http://localhost:8080/WebEduExt/Partials/js/altacurso.js" ></script>
        
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
