<%-- 
    Document   : consultaCurso
    Created on : 25 oct. 2020, 10:26:40
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

        <div class="all-title-box">
            <div class="container text-center">
                <h1>Consultar Curso</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <h2 class="text-center"> Buscar por... </h2>
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#instituto" role="tab" aria-controls="instituto" aria-selected="true">Instituto</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#categoria" role="tab" aria-controls="categoria" aria-selected="false">Categoria</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active p-4" id="instituto" role="tabpanel">
                        <label for="#selInstituto">Instituto</label>
                        <select class="form-control" id="selInstituto"></select>
                        <div class="card p-4 mt-4" id="listByInstituto">
                            <form action="Curso" method="GET">
                                <div class="list-group" id="listCursosInstituto"></div>
                            </form>
                        </div>
                    </div>
                    <div class="tab-pane fade p-4" id="categoria" role="tabpanel">
                        <label for="#selCategoria">Categoria</label>
                        <select class="form-control" id="selCategoria"></select>
                        <div class="card p-4 mt-4" id="listByCategoria">
                            <form action="Curso" method="GET">
                                <div class="list-group" id="listCursosCategoria"></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $('#listByInstituto').hide();
            $('#listByCategoria').hide();

            var selinstituto = $('#selInstituto');
            selinstituto.change(function () {
                $('#listByInstituto').show();
                var listCursosInstituto = $('#listCursosInstituto');
                listCursosInstituto.empty();
                let insti = selinstituto.val();
                let accion = "cursosInsti";
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion, insti: insti},
                    success: function (response) {
                        let cursos = JSON.parse(response);
                        if (cursos !== null) {
                            cursos.forEach(curso => {
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="consultarCurso" value="' + curso + '" >' + curso + '</button>';
                                listCursosInstituto.append(template);
                            });
                        }
                    }
                });
            });

            var selcategoria = $('#selCategoria');
            selcategoria.change(function () {
                $('#listByCategoria').show();
                var listCursosCategoria = $('#listCursosCategoria');
                listCursosCategoria.empty();
                let categoria = selcategoria.val();
                let accion = "cursosCategoria";
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion, categoria: categoria},
                    success: function (response) {
                        let cursos = JSON.parse(response);
                        if (cursos !== null) {
                            cursos.forEach(curso => {
                                let template = '<button type="submit" class="list-group-item list-group-item-action" name="consultarCurso" value="' + curso + '" >' + curso + '</button>';
                                listCursosCategoria.append(template);
                            });
                        }
                    }
                });
            });

            $(document).ready(function () {
                let accion = "listarInstitutos";
                selinstituto.empty();
                selinstituto.append(`<option value="vacio" selected> Seleccione Instituto... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'Instituto',
                    data: {accion: accion},
                    success: function (response) {
                        let institutos = JSON.parse(response);
                        institutos.forEach(instituto => {
                            let template = '<option value="' + instituto + '">' + instituto + '</option>';
                            selinstituto.append(template);
                        });
                    }
                });

                var categorias = $('#selCategoria');
                categorias.empty();
                accion = "darCategorias";
                categorias.append(`<option value="vacio" selected> Seleccione Categoria... </option>`);
                $.ajax({
                    type: 'GET',
                    url: 'Curso',
                    data: {accion: accion},
                    success: function (response) {
                        let cats = JSON.parse(response);
                        if (cats !== null) {
                            cats.forEach(categoria => {
                                let template = '<option value="' + categoria + '">' + categoria + '</option>';
                                categorias.append(template);
                            });
                        }
                    }
                });
            });
        </script>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

