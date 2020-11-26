<%-- 
    Document   : valorarCurso
    Created on : 24 nov. 2020, 11:48:44
    Author     : Agustín
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List cursos = (List) request.getAttribute("cursosEst");
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
                    <form action="" method="GET">
                        <div class="list-group" id="ediciones">
                            <%
                                if (cursos.isEmpty()) {
                            %>
                            <label class="list-group-item"> No tiene ...</label>
                            <%
                                }
                                for (Object o : cursos) {
                                    String c = (String) o; 
                            %>
                            <button type="submit" class="list-group-item list-group-item-action" name="valoracionCurso" value="<%= c %>,<%= du.getEmail() %>" ><%= c %></button>
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

