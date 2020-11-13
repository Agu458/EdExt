<%-- 
    Document   : home
    Created on : 8 nov. 2020, 15:14:40
    Author     : Agustín
--%>

<%@page import="Server.DataUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
    <%@include file="/Pages/Partials/head.jsp" %>
    
    <body>
        
        <%@include file="/Pages/Partials/header.jsp" %>

        <div class="container pt-4">
            <div class="list-group">
                <a href="consultarCurso.jsp" class="list-group-item list-group-item-action">Consultar Curso</a>
            </div>
        </div>

        <%@include file="/Pages/Partials/footer.jsp" %>
        
    </body>
</html>
