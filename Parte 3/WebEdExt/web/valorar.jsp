<%-- 
    Document   : valorar
    Created on : 23 nov. 2020, 15:02:16
    Author     : Silvia
--%>


<%@page import="Server.DataValoracion"%>
<%@page import="Server.DataCurso"%>
<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataCurso dc = (DataCurso) request.getAttribute("datosCurso");
    DataValoracion dv = (DataValoracion) request.getAttribute("datosValoracionEst");

    Double suma = 0.0;
    int cant1 = 0;
    int cant2 = 0;
    int cant3 = 0;
    int cant4 = 0;
    int cant5 = 0;
    int porcentaje = 0;
    Double promedio = 0.0;

    for (DataValoracion val : dc.getValoraciones()) {
        suma = suma + val.getValoracion();
        if (val.getValoracion() == 1) {
            cant1++;
        } else {
            if (val.getValoracion() == 2) {
                cant2++;
            } else {
                if (val.getValoracion() == 3) {
                    cant3++;
                } else {
                    if (val.getValoracion() == 4) {
                        cant4++;
                    } else {
                        cant5++;
                    }
                }
            }
        }
    }
    
    if(!dc.getValoraciones().isEmpty()){
        promedio = (suma / dc.getValoraciones().size());
    }
    
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
        <style>
            #form label {
                font-size: 20px;
            }

            input[type="radio"] {
                display: none;
            }

            #est {
                color: grey;
                font-size: x-large;
            }

            .valoracion {
                direction: rtl;
                unicode-bidi: bidi-override;
            }

            #est:hover,
            #est:hover ~ label {
                color: orange;
            }

            input[type="radio"]:checked ~ #est {
                color: orange;
            }

            .glyphicon { margin-right:5px;}
            .rating .glyphicon {font-size: 22px;}
            .rating-num {font-size: 54px; }
        </style>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="all-title-box">
            <div class="container text-center">
                <h1>Valorar un curso</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">

                <h2 class="text-center"><%= dc.getNombre()%></h2>

                <div class="form-group">
                    <label for="#valoracionCurso">Valoracion Del Curso</label>
                    <div class="card p-4 text-center" id="valoracionCurso">
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <div class="well well-sm">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-6 text-center">
                                            <h1 class="rating-num"><%= promedio %></h1>
                                            <div>
                                                <span class="fas fa-user"></span> <%= dc.getValoraciones().size()%>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-md-6">
                                            <div class="row rating-desc">
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 5
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress progress-striped">
                                                        <%
                                                            if(dc.getValoraciones().size() != 0){
                                                                porcentaje = (cant5 * 100) / dc.getValoraciones().size();
                                                            }
                                                        %>
                                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                            aria-valuemin="0" aria-valuemax="100" style="width: <%= porcentaje %>%">
                                                            <span class="sr-only"><%= porcentaje %>%</span>
                                                        </div>
                                                        <% porcentaje = 0; %>
                                                    </div>
                                                </div>
                                                <!-- end 5 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 4
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <%
                                                            if(dc.getValoraciones().size() != 0){
                                                                porcentaje = (cant4 * 100) / dc.getValoraciones().size();
                                                            }
                                                        %>
                                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= porcentaje %>%">
                                                            <span class="sr-only"><%= porcentaje %>%</span>
                                                        </div>
                                                        <% porcentaje = 0; %>
                                                    </div>
                                                </div>
                                                <!-- end 4 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 3
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <%
                                                            if(dc.getValoraciones().size() != 0){
                                                                porcentaje = (cant3 * 100) / dc.getValoraciones().size();
                                                            }
                                                        %>
                                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= porcentaje %>%">
                                                            <span class="sr-only"><%= porcentaje %>%</span>
                                                        </div>
                                                        <% porcentaje = 0; %>
                                                    </div>
                                                </div>
                                                <!-- end 3 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 2
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <%
                                                            if(dc.getValoraciones().size() != 0){
                                                                porcentaje = (cant2 * 100) / dc.getValoraciones().size();
                                                            }
                                                        %>
                                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= porcentaje %>%">
                                                            <span class="sr-only"><%= porcentaje %>%</span>
                                                        </div>
                                                        <% porcentaje = 0; %>
                                                    </div>
                                                </div>
                                                <!-- end 2 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 1
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <%
                                                            if(dc.getValoraciones().size() != 0){
                                                                porcentaje = (cant1 * 100) / dc.getValoraciones().size();
                                                            }
                                                        %>
                                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= porcentaje %>%">
                                                            <span class="sr-only"><%= porcentaje %>%</span>
                                                        </div>
                                                        <% porcentaje = 0; %>
                                                    </div>
                                                </div>
                                                <!-- end 1 -->
                                            </div>
                                            <!-- end row -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="card p-4">
                        <%
                            if (dv.getEstudiante().equals("")) {
                        %>
                        <label>Curso no valorado</label>     
                        <%
                        } else {
                        %>
                        <label for="#valoracionActual">Valoracion Actual</label>
                        <input id="valoracionActual" type="text" class="form-control" name="valoracionActual" value="<%= dv.getValoracion()%>" readonly="">
                        <%
                            }
                        %>
                        <div class="form-group text-center pt-4">
                            <form action="Valoracion" method="POST">
                                <input type="text" name="estudiante" hidden="" value="<%= du.getEmail()%>">
                                <input type="text" name="curso" hidden="" value="<%= dc.getNombre()%>">
                                <p class="valoracion">
                                    <input id="radio1" type="radio" name="estrellas" value="5"><label id="est" for="radio1"><i class="fas fa-star"></i></label>
                                    <input id="radio2" type="radio" name="estrellas" value="4"><label id="est" for="radio2"><i class="fas fa-star"></i></label>
                                    <input id="radio3" type="radio" name="estrellas" value="3"><label id="est" for="radio3"><i class="fas fa-star"></i></label>
                                    <input id="radio4" type="radio" name="estrellas" value="2"><label id="est" for="radio4"><i class="fas fa-star"></i></label>
                                    <input id="radio5" type="radio" name="estrellas" value="1"><label id="est" for="radio5"><i class="fas fa-star"></i></label>
                                </p>
                                <button type="submit" class="btn btn-primary mt-4">Enviar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>

