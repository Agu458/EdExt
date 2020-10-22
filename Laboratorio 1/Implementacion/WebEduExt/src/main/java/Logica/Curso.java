/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        if(action != null){
            if(action.equals("darCurso")){
                
            }
            if(action.equals("cursosInsti")){
                
                String instituto = request.getParameter("insti");
                if(instituto != null){
                    List cursos = is.listarCursosInstituto(instituto);
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
            if(action.equals("validarNombreCurso")){
                String nombre = request.getParameter("nombre");
                if (nombre != null) {
                    Boolean valido =  is.validarNombreCurso(nombre);
                    out.println(valido);
                }
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
