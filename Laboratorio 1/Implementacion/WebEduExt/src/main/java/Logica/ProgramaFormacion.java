/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataProgramaFormacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Otro
 */
public class ProgramaFormacion extends HttpServlet {

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
        
        String accion = request.getParameter("accion");
        if(accion != null){
            if(accion.equals("listarProgramas")){
                List programas = is.listarProgramas();
                request.setAttribute("programas", programas);
                request.getRequestDispatcher("consultarPrograma.jsp").forward(request, response);
            }
        }
        
        String consultarPrograma = request.getParameter("consultarPrograma");
        if(consultarPrograma != null){
            DataProgramaFormacion dpf = is.darProgramaFormacion(consultarPrograma);
            request.setAttribute("dataPrograma", dpf);
            request.getRequestDispatcher("mostrarInfoPrograma.jsp").forward(request, response);
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
        
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("altaPrograma")) {
                String nombre = request.getParameter("nombre");
                if (nombre != null && is.validarNombrePrograma(nombre)) {
                    String fecha1 = request.getParameter("fechaini");
                    String fecha2 = request.getParameter("fechafin");
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaIni = null;
                    Date fechaFin = null;
                    try {
                        fechaIni = formato.parse(fecha1);
                        fechaFin = formato.parse(fecha2);
                    } catch (Exception e) {
                    }
                    String descripcion = request.getParameter("descripcion");
                    
                    DataProgramaFormacion dpf = new DataProgramaFormacion(nombre, descripcion, fechaIni, fechaFin);
                    is.altaProgramaFormacion(dpf);
                    
                    response.sendRedirect("altaPrograma.jsp");
                }
            }
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
