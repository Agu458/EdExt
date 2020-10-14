<%-- 
    Document   : login
    Created on : 13 oct. 2020, 17:24:16
    Author     : Agustin
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.ISistema"%>

<%
    ISistema is = Fabrica.getInstance().getISistema();
    List<String> institutos = is.listarInstitutos();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Registrarse" method="post">
            Nick: <input type="text" name="nick" required><br>
            Nombre: <input type="text" name="nombre" required><br>
            Apellido: <input type="text" name="apellido" required><br>
            Email: <input type="email" name="email" required><br>
            Contraseña: <input type="password" name="password" required><br>
            Repetir Contraseña: <input type="password" name="password2" required><br>
            Fecha nacimiento: <input type="date" name="fecha" required><br>
            Docente: <input type="checkbox" name="docente"><br>
            <select name="instituto">
                <option selected value="vacio">Seleccione...</option>
                <%
                    for(String s : institutos){ %>
                        <option value="<%= s %>"><%= s %></option>
                    <% }
                %>
            </select><br>
            <input type="submit">
        </form>
    </body>
</html>
