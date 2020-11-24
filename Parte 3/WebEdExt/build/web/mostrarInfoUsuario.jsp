<%-- 
    Document   : mostrarInfoUsuario
    Created on : 26 oct. 2020, 17:31:52
    Author     : Otro
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DataUsuario usu = (DataUsuario) request.getAttribute("verDatosUsuario");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="all-title-box-perfil">
            <div class="container text-center">
                <h1>Perfil<span class="m_1"></span></h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <div class="form-group">
                    <%
                        byte[] imagen = usu.getImagen();
                        if (imagen != null) {
                            String base64Image = Base64.getEncoder().encodeToString(imagen);
                    %>
                    <div class="card" style="width: 102px">
                        <img id="imagen" src="data:image/jpg;base64,<%=base64Image%>" style="width:100px !important; height:100px !important"/>
                    </div>
                    <%
                    } else {
                    %>

                    <div class="card" style="width: 102px;">
                        <img id="imagen" src="https://www.bootdey.com/img/Content/avatar/avatar1.png" alt="" style="width:100px !important; height:100px !important"/>
                    </div>
                    <%
                        }
                    %>
                </div>
                <div class="form-group">
                    <label class="form-label">Nick</label>
                    <input id="nick" type="text" name="nick" class="form-control mb-1" value="<%= usu.getNick()%>" readonly="">
                </div>
                <div class="form-group">
                    <label class="form-label">Nombre</label>
                    <input id="nombre" type="text" name="nombre" class="form-control" value="<%= usu.getNombre()%>" readonly="">
                </div>
                <div class="form-group">
                    <label class="form-label">Apellido</label>
                    <input id="apellido" type="text" name="apellido" class="form-control" value="<%= usu.getApellido()%>" readonly="">
                </div>
                <div class="form-group">
                    <label class="form-label">E-mail</label>
                    <input id="email" type="text" name="email" class="form-control mb-1" value="<%= usu.getEmail()%>" readonly="">
                </div>
                <div class="form-group">
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaNac = formato.format(usu.getFechaNacimiento().toGregorianCalendar().getTime());
                    %>
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input id="fecha" type="date" class="form-control" name="fecha" value="<%= fechaNac%>" readonly="">
                </div>
            </div>
        </div>
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
