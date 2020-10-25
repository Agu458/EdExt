<%-- 
    Document   : consultarUsuario
    Created on : 25 oct. 2020, 0:02:05
    Author     : Agustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<String> usuarios = (List<String>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/Partials/head.jsp" %>
    </head>
    <body>
        <%@include file="/Partials/header.jsp" %>

        <div class="all-title-box">
            <div class="container text-center">
                <h1>Consultar Usuarios</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <div class="list-group">
                    <%
                        for(String s : usuarios){
                    %>
                            <a href="#" class="list-group-item list-group-item-action"><%= s %></a>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
