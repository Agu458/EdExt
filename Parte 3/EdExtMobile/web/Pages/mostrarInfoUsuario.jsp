<%-- 
    Document   : mostrarInfoUsuario
    Created on : 24 nov. 2020, 10:39:07
    Author     : Agustín
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/Pages/Partials/head.jsp" %>

    <body>

        <%@include file="/Pages/Partials/header.jsp" %>
        
        <div class="container p-4">
            <div class="card p-4">
                <div class="card-body media align-items-center">
                    <%                                            byte[] imagen = du.getImagen();
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
                </div>
            </div>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>

    </body>
</html>

