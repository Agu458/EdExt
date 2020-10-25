/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataCurso;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Agustin
 */
public class Curso extends HttpServlet {

    private Fabrica fab = Fabrica.getInstance();
    private ISistema is = fab.getISistema();

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

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("darCategorias")) {
                List categorias = is.listarCategorias();
                String json = new Gson().toJson(categorias);
                out.println(json);
            }
            if (action.equals("cursosInsti")) {
                String instituto = request.getParameter("insti");
                if (instituto != null) {
                    List cursos = is.listarCursosInstituto(instituto);
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
        }

        String validar = request.getParameter("validar");
        if (validar != null) {
            if (validar.equals("validarNombreCurso")) {
                String nombre = request.getParameter("nombre");
                if (nombre != null) {
                    Boolean valido = is.validarNombreCurso(nombre);
                    out.println(valido);
                }
            }
        }
        
        String consultarCurso = request.getParameter("consultarCurso");
        if(consultarCurso != null){
            DataCurso dc = is.darDatosCurso(consultarCurso);
            request.setAttribute("curso", dc);
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
            List<String> previas = new ArrayList();
            if (prevs != null) {
                previas = Arrays.asList(prevs);
            }

            String[] cats = request.getParameterValues("categorias");
            List<String> categorias = new ArrayList();
            if (cats != null) {
                categorias = Arrays.asList(cats);
            }

            DataCurso dc = new DataCurso(nombre, descripcion, duracion, horas, creditos, new Date(), url, previas, categorias);
            is.altaCurso(dc, instituto);
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
