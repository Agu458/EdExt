<%-- 
    Document   : agregarCursoPrograma
    Created on : 26 oct. 2020, 16:35:31
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
                <h2 class="card-header text-center text-white bg-warning">Agregar Curso a un Programa de Formacion</h2>
                <div class="card-header" >
                    <form action="ProgramaFormacion" method="POST">
                        <div class="form-group">
                            <label for="programa">Programa de Formacion</label>
                            <select id="programa" class="form-control" required="" name="programa"></select>
                        </div>
                        <div class="form-group">
                            <label for="curso">Curso</label>
                            <select id="curso" class="form-control" required="" name="curso"></select>
                        </div>
                        <div class="form-group text-center">
                            <button type="submit" name="accion" class="btn btn-primary" value="agregarCursoPrograma">Agregar Curso</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <script>            
            $(document).ready(function () {
                let accion = "darProgramas";
                var selprograma = $('#programa');
                selprograma.empty();
                selprograma.append(`<option value="vacio" selected> Seleccione un Programa... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'ProgramaFormacion',
                    data: {accion: accion},
                    success: function (response) {
                        let programas = JSON.parse(response);
                        programas.forEach(programa => {
                            let template = '<option value="' + programa + '">' + programa + '</option>';
                            selprograma.append(template);
                        });
                    }
                });
                
                accion = "listarCursos";
                var selcurso = $('#curso');
                selcurso.empty();
                selcurso.append(`<option value="vacio" selected> Seleccione un Curso... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion},
                    success: function (response) {
                        let cursos = JSON.parse(response);
                        cursos.forEach(curso => {
                            let template = '<option value="' + curso + '">' + curso + '</option>';
                            selcurso.append(template);
                        });
                    }
                });
            });
        </script>
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
