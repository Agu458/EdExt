<%-- 
    Document   : consultarPrograma
    Created on : 26 oct. 2020, 14:16:38
    Author     : Otro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<String> programas = (List<String>) request.getAttribute("programas");
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
                <h1>Consultar Programa</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                <div class="list-group" id="listProgramas">
                    <form action="ProgramaFormacion" method="GET">
                        <%
                            for (String s : programas) {
                        %>
                        <button type="submit" class="list-group-item list-group-item-action" name="consultarPrograma" value="<%= s %>" ><%= s %></button>
                        <%
                            }
                        %>
                    </form>
                </div>

            </div>
        </div>

        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>