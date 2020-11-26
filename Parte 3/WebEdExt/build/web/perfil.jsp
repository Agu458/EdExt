<%-- 
    Document   : perfil
    Created on : 20 oct. 2020, 16:22:27
    Author     : Agustin
--%>

<%@page import="java.util.Base64"%>
<%@page import="Server.DataProgramaFormacion"%>
<%@page import="Server.DataEdicion"%>
<%@page import="Server.DataProfesor"%>
<%@page import="Server.EstadoInscripcion"%>
<%@page import="Server.DataInscripcionEdicion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>
        
        <div class="all-title-box-perfil">
            <div class="container text-center">
                <h1>Mi Perfil<span class="m_1"></span></h1>
            </div>
        </div>
        <div class="container light-style flex-grow-1 container-p-y">

            <h4 class="font-weight-bold py-3 mb-4">

            </h4>

            <div class="card overflow-hidden p-4">
                <div class="row no-gutters row-bordered row-border-light">
                    <div class="col-md-3 pt-0">
                        <div class="list-group list-group-flush account-settings-links">
                            <a class="list-group-item list-group-item-action active" data-toggle="list" href="#account-general">General</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list" href="#account-change-password">Cambiar Contraseña</a>
                            <a class="list-group-item list-group-item-action" data-toggle="list" href="#account-editions">Ediciones</a>
                            <%
                                if (du instanceof DataEstudiante) {
                            %>
                            <a class="list-group-item list-group-item-action" data-toggle="list" href="#account-programs">Programas</a>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            <div class="tab-pane fade active show" id="account-general">
                                <form action="Usuario" method="POST" enctype="multipart/form-data">
                                    <div class="card-body media align-items-center">
                                        <%
                                            byte[] imagen = du.getImagen();
                                            if (imagen != null) {
                                                String base64Image = Base64.getEncoder().encodeToString(imagen);
                                        %>
                                        <div class="card">
                                            <img id="imagen" src="data:image/jpg;base64,<%=base64Image%>" style="width:100px !important; height:100px !important"/>
                                        </div>
                                        <%
                                        } else {
                                        %>
                                        
                                        <div class="card">
                                            <img id="imagen" src="https://www.bootdey.com/img/Content/avatar/avatar1.png" alt="" style="width:100px !important; height:100px !important"/>
                                        </div>
                                        <%
                                            }
                                        %>
                                        <div class="media-body ml-4">
                                            <label class="btn btn-outline-primary">
                                                Editar Foto
                                                <input id="imgPath" type="file" class="account-settings-fileinput" name="imagen">
                                            </label> &nbsp;
                                            <button type="button" class="btn btn-default md-btn-flat" onclick="borrarImagen()">Reset</button>

                                            <div class="text-light small mt-1">Allowed JPG, GIF or PNG. Max size of 800K</div>
                                        </div>
                                    </div>
                                    <hr class="border-light m-0">

                                    <div class="card-body">

                                        <div class="form-group">
                                            <label class="form-label">Nick</label>
                                            <input id="nick" type="text" name="nick" class="form-control mb-1" value="<%= du.getNick()%>" readonly="">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Nombre</label>
                                            <input id="nombre" type="text" name="nombre" class="form-control" value="<%= du.getNombre()%>">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Apellido</label>
                                            <input id="apellido" type="text" name="apellido" class="form-control" value="<%= du.getApellido()%>">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">E-mail</label>
                                            <input id="email" type="text" name="email" class="form-control mb-1" value="<%= du.getEmail()%>" readonly="">
                                        </div>
                                        <div class="form-group">
                                            <%
                                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                                String fechaNac = formato.format(du.getFechaNacimiento().toGregorianCalendar().getTime());
                                            %>
                                            <label class="form-label">Fecha de Nacimiento</label>
                                            <input id="fecha" type="date" class="form-control" name="fecha" value="<%= fechaNac%>">
                                        </div>
                                        <div class="text-right mt-3">
                                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>&nbsp;
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="account-change-password">
                                <div class="card-body pb-2">

                                    <div class="form-group">
                                        <label class="form-label">Contraseña Actual</label>
                                        <input type="password" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label class="form-label">Nueva Contraseña</label>
                                        <input type="password" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label class="form-label">Nueva Contraseña</label>
                                        <input type="password" class="form-control">
                                    </div>
                                    <div class="text-right mt-3">
                                        <button type="button" class="btn btn-primary">Guardar Cambios</button>&nbsp;
                                        <button type="button" class="btn btn-default">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="account-editions">
                                <div class="form-group p-4">
                                    <div class="list-group" id="ediciones">
                                        <form action="Edicion" method="GET">
                                            <%
                                                if (du instanceof DataEstudiante) {
                                                    DataEstudiante de = (DataEstudiante) du;
                                                    for (DataInscripcionEdicion edicion : de.getInscripcionEdiciones()) {
                                                        if (edicion.getEstado() == EstadoInscripcion.ACEPTADO) {
                                            %>
                                            <button type="submit" class="list-group-item list-group-item-action list-group-item-success" name="consultarInscripcionEdicion" value="<%= edicion.getEstudiante()%>,<%= edicion.getEdicion().getNombre()%>" > <%= edicion.getEdicion().getNombre()%> </button>
                                            <%
                                            } else {
                                                if (edicion.getEstado() == EstadoInscripcion.RECHASADO) {
                                            %>
                                            <button type="submit" class="list-group-item list-group-item-action list-group-item-danger" name="consultarInscripcionEdicion" value="<%= edicion.getEstudiante()%>,<%= edicion.getEdicion().getNombre()%>" > <%= edicion.getEdicion().getNombre()%> </button>
                                            <%
                                            } else {
                                            %>
                                            <button type="submit" class="list-group-item list-group-item-action list-group-item-primary" name="consultarInscripcionEdicion" value="<%= edicion.getEstudiante()%>,<%= edicion.getEdicion().getNombre()%>" > <%= edicion.getEdicion().getNombre()%> </button>
                                            <%
                                                        }
                                                    }
                                                }
                                            } else {
                                                DataProfesor dp = (DataProfesor) du;
                                                for (DataEdicion edicion : dp.getEdiciones()) {
                                            %>
                                            <button type="submit" class="list-group-item list-group-item-action" name="consultarEdicion" value="<%= edicion.getCurso()%>,<%= edicion.getNombre()%>" > <%= edicion.getNombre()%> </button>
                                            <%
                                                    }
                                                }
                                            %>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <%
                                if (du instanceof DataEstudiante) {
                                    DataEstudiante de = (DataEstudiante) du;
                            %>
                            <div class="tab-pane fade" id="account-programs">
                                <div class="form-group p-4">
                                    <div class="list-group" id="ediciones">
                                        <form action="ProgramaFormacion" method="GET">
                                            <%
                                                for (DataProgramaFormacion programa : de.getInscripcionProgramas()) {
                                            %>
                                            <button type="submit" class="list-group-item list-group-item-action" name="consultarPrograma" value="<%= programa.getNombre()%>" > <%= programa.getNombre()%> </button>
                                            <%
                                                }
                                            %>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <h4 class="font-weight-bold py-3 mb-4">
                EduExt2020
            </h4>
        </div>
                        <script>
                            function borrarImagen(){
                                $("#imgPath").attr("value","");
                            }
                        </script>
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
