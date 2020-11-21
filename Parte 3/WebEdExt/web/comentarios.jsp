<%-- 
    Document   : comentarios
    Created on : 21 nov. 2020, 17:13:00
    Author     : Agustín
--%>

<%@page import="Server.DataEdicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List ediciones = (List) request.getAttribute("edicionesEst");
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
                <h1>Ediciones de Curso a las que asisto</h1>
            </div>
        </div>
        <div class="container p-4">
            <div class="card p-4">
                    <div class="form-group">
                    <form action="Edicion" method="GET">
                        <div class="list-group" id="ediciones">
                            <%
                                if (ediciones.isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (Object o : ediciones) {
                                    DataEdicion de = (DataEdicion) o; 
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="consultarEdicion" value="<%= de.getCurso() %>,<%= de.getNombre()%>" ><%= de.getNombre() %></button>
                            <%
                                }
                            %>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="/Partials/footer.jsp" %>
    </body>
</html>
