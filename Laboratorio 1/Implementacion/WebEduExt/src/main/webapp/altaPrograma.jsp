<%-- 
    Document   : altaPrograma
    Created on : 26 oct. 2020, 13:57:07
    Author     : Otro
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
                <h2 class="card-header text-center text-white bg-warning">Alta de un Programa</h2>
                <div class="card-header" >
                    <form action="ProgramaFormacion" method="POST">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre" required="">
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción</label>
                            <textarea class="form-control" name="descripcion" id="descripcion" required=""></textarea>
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechaini">Fecha Inicio</label>
                                    <input type="date" class="form-control" name="fechaini" id="fechaini" required="">
                                </div>
                            </div>
                            <div class="col-sm">
                                <div class="form-group">
                                    <label for="fechafin">Fecha Fin</label>
                                    <input type="date" class="form-control" name="fechafin" id="fechafin" required="">
                                </div>
                            </div>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-primary" name="accion" value="altaPrograma" >Crear Programa</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
