<%-- 
    Document   : buscar
    Created on : 26 oct. 2020, 15:45:28
    Author     : Otro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.ProgramaFormacion"%>
<%@page import="Logica.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.ISistema"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ISistema s = null;
            Fabrica f = Fabrica.getInstance();
            s = f.getISistema();

            List<String> lis = new ArrayList();
            List<String> lcur = s.listarCursos();
            List<String> lpf = s.listarProgramas();

            String txt = request.getParameter("Busqueda");

            // Sin Filtro
            String filtro = (String) request.getAttribute("Filtrado");
            if (filtro == null) {
                for (String strc : lcur) {
                    if (strc.contains(txt)) {
                        lis.add(strc);
                    }
                }

                for (String strp : lpf) {
                    if (strp.contains(txt)) {
                        lis.add(strp);
                    }
                }
            } else {
                // Fin Sin Filtro 

                //Filtrado por Curso
                if (filtro.equals("Cursos")) {
                    for (String strc : lcur) {
                        if (strc.contains(txt)) {
                            lis.add(strc);
                        }
                    }
                    //Fin Filtrado por Curso
                }
                
                //Filtrado por Programa
                if (filtro.equals("Programa")) {
                    for (String strp : lpf) {
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
