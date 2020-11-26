/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataCurso;
import Server.DataValoracion;
import Server.PublicadorServidorCentralService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Agustín
 */
public class Valoracion extends HttpServlet {

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
        
        String cursosEstudiante = (String) request.getParameter("cursosEstudiante");
        if(cursosEstudiante != null){
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            List cursos = port.cursosEstudiante(email);
            request.setAttribute("cursosEst", cursos);
            request.getRequestDispatcher("valorarCurso.jsp").forward(request, response);
        }
        
        String valoracionCurso = (String) request.getParameter("valoracionCurso");
        if(valoracionCurso != null){
            String estudiante = null;
            String curso = null;
            String[] datos = null;
            try {
                datos = valoracionCurso.split(",");
                curso = datos[0];
                estudiante = datos[1];
            } catch (Exception e) {
            }
            
            if(estudiante != null && curso != null){
                DataCurso dc = port.darDatosCurso(curso);
                DataValoracion dv = port.darValoracionEst(curso,estudiante);
                request.setAttribute("datosCurso", dc);
                request.setAttribute("datosValoracionEst", dv);
                request.getRequestDispatcher("valorar.jsp").forward(request, response);
            }
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
        String estrellas = request.getParameter("estrellas");
        String estudiante = request.getParameter("estudiante");
        String curso = request.getParameter("curso");
        port.valorarCurso(curso, new Double(estrellas), estudiante);
        response.sendRedirect("Valoracion?cursosEstudiante");
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
