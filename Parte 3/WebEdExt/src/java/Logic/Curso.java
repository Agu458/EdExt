/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataCurso;
import Server.Lista;
import Server.PublicadorServidorCentralService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Agustin
 */
public class Curso extends HttpServlet {

    private Server.PublicadorServidorCentralService service = new PublicadorServidorCentralService();
    private Server.PublicadorServidorCentral port = service.getPublicadorServidorCentralPort();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");

        if (accion != null) {
            if (accion.equals("darCategorias")) {
                Lista data = port.listarCategorias();
                List categorias = data.getLista();
                String json = new Gson().toJson(categorias);
                out.println(json);
            }
            if (accion.equals("cursosInsti")) {
                String instituto = request.getParameter("insti");
                if (instituto != null) {
                    Lista data = port.listarCursosInstituto(instituto);
                    List cursos = data.getLista();
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
            if (accion.equals("cursosInstiConEdicion")) {
                String instituto = request.getParameter("insti");
                if (instituto != null) {
                    Lista data = port.listarCursosConEdicionInstituto(instituto);
                    List cursos = data.getLista();
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
            if (accion.equals("cursosCategoria")) {
                String categoria = request.getParameter("categoria");
                if (categoria != null) {
                    Lista data = port.listarCursosCategoria(categoria);
                    List cursos = data.getLista();
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
            if (accion.equals("listarCursos")) {
                Lista data = port.listarCursos();
                List cursos = data.getLista();
                String json = new Gson().toJson(cursos);
                out.println(json);
            }
            if (accion.equals("listarCursosTendencia")) {
                List<String> cursos = port.listarCursosTendencia();
                String json = new Gson().toJson(cursos);
                out.println(json);
            }
            if (accion.equals("listarEdicionesCurso")) {
                String curso = request.getParameter("curso");
                if (curso != null) {
                    Lista data = port.listarEdiciones(curso);
                    List ediciones = data.getLista();
                    String json = new Gson().toJson(ediciones);
                    out.println(json);
                }

            }
        }

        String validar = request.getParameter("validar");
        if (validar != null) {
            if (validar.equals("validarNombreCurso")) {
                String nombre = request.getParameter("nombre");
                if (nombre != null) {
                    Boolean valido = port.validarNombreCurso(nombre);
                    out.println(valido);
                }
            }
        }

        String consultarCurso = request.getParameter("consultarCurso");
        if (consultarCurso != null) {
            DataCurso dc = port.darDatosCurso(consultarCurso);
            request.setAttribute("curso", dc);
            port.agregarVisita(dc.getNombre());
            request.getRequestDispatcher("mostrarInfoCurso.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        if (accion.equals("altaCurso")) {
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String instituto = request.getParameter("instituto");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            int horas = Integer.parseInt(request.getParameter("horas"));
            int creditos = Integer.parseInt(request.getParameter("creditos"));
            String url = request.getParameter("url");

            String[] prevs = request.getParameterValues("previas");
            List previas = new ArrayList();
            if (prevs != null) {
                previas = Arrays.asList(prevs);
            }

            String[] cats = request.getParameterValues("categorias");
            List categorias = new ArrayList();
            if (cats != null) {
                categorias = Arrays.asList(cats);
            }

            GregorianCalendar calendario = new GregorianCalendar();
            XMLGregorianCalendar xmlCalendario = null;

            calendario.setTime(new Date());

            try {
                xmlCalendario = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
            } catch (DatatypeConfigurationException ex) {
                ex.printStackTrace();
            }
            
            port.altaCurso(nombre, descripcion, duracion, horas, creditos, Login.GetXmlGregorianCalendar(new Date()), url, previas, categorias, instituto);
            response.sendRedirect("altacurso.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
