/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataEstudiante;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import com.google.gson.Gson;
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
 * @author Agustin
 */
public class Registrarse extends HttpServlet {

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
        
        List institutos = is.listarInstitutos();
        String json = new Gson().toJson(institutos);
        
        out.println(json);
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
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("password");
        String contrasenia2 = request.getParameter("password2");
        String fecha= request.getParameter("fecha");
        String docente = request.getParameter("docente");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formato.parse(fecha);
        } catch (Exception e) {
        }

        if (docente == null) {
            if (contrasenia.equals(contrasenia2)) {
                if (is.validarEmail(email) && is.validarNick(nick)) {
                    DataUsuario du = new DataEstudiante(nick, nombre, apellido, email, fechaNacimiento, contrasenia, null);
                    is.altaUsuario(du);
                }
            }
        } else {
            String instituto = request.getParameter("instituto");
            if (!instituto.equals("vacio")) {
                if (is.validarEmail(email) && is.validarNick(nick)) {
                    DataUsuario du = new DataProfesor(instituto, nick, nombre, apellido, email, fechaNacimiento, contrasenia, null);
                    is.altaUsuario(du);
                }
            }
        }

        response.sendRedirect("index.jsp");
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
