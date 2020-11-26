<%-- 
    Document   : mostrarInfoCurso
    Created on : 12 nov. 2020, 15:12:24
    Author     : Agustín
--%>

<%@page import="Server.DataValoracion"%>
<%@page import="java.util.Date"%>
<%@page import="Server.DataCurso"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DataCurso dc = (DataCurso) request.getAttribute("curso");
    Double suma = 0.0;
    int cant1 = 0;
    int cant2 = 0;
    int cant3 = 0;
    int cant4 = 0;
    int cant5 = 0;

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
%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <%@include file="/Pages/Partials/head.jsp" %>

        <style>
            .glyphicon { margin-right:5px;}
            .rating .glyphicon {font-size: 22px;}
            .rating-num {font-size: 54px; }
        </style>
    </head>
    <body>

        <%@include file="/Pages/Partials/header.jsp" %>

        <div class="container p-4">
            <div class="card p-4">
                <h2 class="text-center"> Datos del Curso </h2>
                <div class="form-group">
                    <label for="instituto">Instituto</label>
                    <input type="text" class="form-control" id="instituto" name="instituto" readonly="" value="<%= dc.getInstituto()%>">
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" readonly="" value="<%= dc.getNombre()%>">
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <textarea class="form-control" id="descripcion" name="descripcion" readonly=""><%= dc.getDescripcion()%></textarea>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="duracion">Duracion</label>
                            <input type="number" class="form-control" id="duracion" name="duracion" readonly="" value="<%= dc.getDuracion()%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="horas">Cantidad de Horas</label>
                            <input type="number" class="form-control" id="horas" name="horas" readonly="" value="<%= dc.getHoras()%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="creditos">Cantidad de Creditos</label>
                            <input type="number" class="form-control" id="creditos" name="creditos" readonly="" value="<%= dc.getCreditos()%>">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="fechareg">Fecha de Publicación</label>
                            <%
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                String fechareg = formato.format(dc.getFechaRegistro().toGregorianCalendar().getTime());
                            %>
                            <input class="form-control" type="date" name="fechareg" readonly="" value="<%= fechareg%>">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="url">URL</label>
                    <input type="url" class="form-control" id="url" name="url" readonly="" value="<%= dc.getURL()%>">
                </div>
                <div class="form-group">
                    <label for="previas">Previas</label>
                    <form action="/EdExtMobile/Curso" method="GET">
                        <div class="list-group" id="previas">
                            <%
                                if (dc.getPrevias().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (String s : dc.getPrevias()) {
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="consultarCurso" value="<%= s%>" ><%= s%></button>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
                <div class="form-group">
                    <label for="categorias">Categorias</label>
                    <div class="list-group" id="categorias">
                        <%
                            if (dc.getCategorias().isEmpty()) {
                        %>
                        <label class="list-group-item"> No tiene ...</label>
                        <%
                            }
                            for (String s : dc.getCategorias()) {
                        %>
                        <label class="list-group-item"> <%= s%></label>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edicionActual">Edicion Actual</label>
                    <%
                        if (dc.getEdicionAgtual() != null) {
                    %>
                    <input type="text" class="form-control" id="edicionActual" name="edicionActual" readonly="" value="<%= dc.getEdicionAgtual().getNombre()%>">
                    <%
                    } else {
                    %>
                    <input type="text" class="form-control" id="edicionActual" name="edicionActual" readonly="" value="No tiene ...">
                    <%
                        }
                    %>
                </div>
                <div class="form-group">
                    <label for="ediciones">Ediciones</label>
                    <form action="/EdExtMobile/Edicion" method="GET">
                        <div class="list-group" id="ediciones">
                            <%
                                if (dc.getEdiciones().isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (DataEdicion de : dc.getEdiciones()) {
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="consultarEdicion" value="<%= de.getCurso()%>,<%= de.getNombre()%>" ><%= de.getNombre()%></button>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>

                <div class="form-group">
                    <label for="#valoracionCurso">Valoracion Del Curso</label>
                    <div class="card p-4 text-center" id="valoracionCurso">
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <div class="well well-sm">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-6 text-center">
                                            <h1 class="rating-num">
                                                <%= (suma / dc.getValoraciones().size())%></h1>
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
                                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= (cant5 * 100) / dc.getValoraciones().size()%>%">
                                                            <span class="sr-only"><%= (cant5 * 100) / dc.getValoraciones().size()%>%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- end 5 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 4
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= (cant4 * 100) / dc.getValoraciones().size()%>%">
                                                            <span class="sr-only"><%= (cant4 * 100) / dc.getValoraciones().size()%>%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- end 4 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 3
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= (cant3 * 100) / dc.getValoraciones().size()%>%">
                                                            <span class="sr-only"><%= (cant3 * 100) / dc.getValoraciones().size()%>%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- end 3 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 2
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="20"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= (cant2 * 100) / dc.getValoraciones().size()%>%">
                                                            <span class="sr-only"><%= (cant2 * 100) / dc.getValoraciones().size()%>%</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- end 2 -->
                                                <div class="col-xs-3 col-md-3 text-right">
                                                    <span class="fas fa-star"></span> 1
                                                </div>
                                                <div class="col-xs-8 col-md-9">
                                                    <div class="progress">
                                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80"
                                                             aria-valuemin="0" aria-valuemax="100" style="width: <%= (cant1 * 100) / dc.getValoraciones().size()%>%">
                                                            <span class="sr-only"><%= (cant1 * 100) / dc.getValoraciones().size()%>%</span>
                                                        </div>
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

            </div>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>

    </body>
</html>
