<%-- 
    Document   : buscar
    Created on : 26 oct. 2020, 15:45:28
    Author     : Otro
--%>

<%@page import="Server.Lista"%>
<%@page import="Server.PublicadorServidorCentralService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Server.PublicadorServidorCentralService service = new PublicadorServidorCentralService();
            Server.PublicadorServidorCentral port = service.getPublicadorServidorCentralPort();
            
            List<String> lis = new ArrayList();
            Lista data = port.listarCursos();
            List lcur = data.getLista();
            data = port.listarProgramas();
            List lpf = data.getLista();

            String txt = request.getParameter("Busqueda");

            // Sin Filtro
            String filtro = (String) request.getAttribute("Filtrado");
            if (filtro == null) {
                for (Object o : lcur) {
                    String strc = (String) o;
                    if (strc.contains(txt)) {
                        lis.add(strc);
                    }
                }

                for (Object o : lpf) {
                    String strp = (String) o;
                    if (strp.contains(txt)) {
                        lis.add(strp);
                    }
                }
            } else {
                // Fin Sin Filtro 

                //Filtrado por Curso
                if (filtro.equals("Cursos")) {
                    for (Object o : lcur) {
                        String strc = (String) o;
                        if (strc.contains(txt)) {
                            lis.add(strc);
                        }
                    }
                    //Fin Filtrado por Curso
                }
                
                //Filtrado por Programa
                if (filtro.equals("Programa")) {
                    for (Object o : lpf) {
                        String strp = (String) o;
                        if (strp.contains(txt)) {
                            lis.add(strp);
                        }
                    }
                }

            }
        %> 

        <br/><br/>
        <ul id="lista">
            <%
                for (String str : lis) {
            %>
            <li><%= str%></li>
                <%
                    }
                %>
        </ul>

    </body>
</html>
