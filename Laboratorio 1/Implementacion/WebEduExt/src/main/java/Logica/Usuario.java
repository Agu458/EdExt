/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Agustin
 */
public class Usuario extends HttpServlet {

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
        if (accion != null) {
            if (accion.equals("listarUsuarios")) {
                List<String> usuarios = is.listarUsuarios();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
            }
            if (accion.equals("verPerfil")) {
                HttpSession session = request.getSession();
                String email = (String) session.getAttribute("email");
                if (email != null) {
                    DataUsuario du = is.darDatosUsuario(email);
                    session.setAttribute("usuario", du);
                    request.getRequestDispatcher("perfil.jsp").forward(request, response);
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
        }

        String verDatosUsuario = request.getParameter("verDatosUsuario");
        if (verDatosUsuario != null) {
            DataUsuario du = is.darDatosUsuario(verDatosUsuario);
            request.setAttribute("verDatosUsuario", du);
            request.getRequestDispatcher("mostrarInfoUsuario.jsp").forward(request, response);
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
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fecha = request.getParameter("fecha");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formato.parse(fecha);
        } catch (Exception e) {
        }
        DataUsuario du = new DataUsuario(nick, nombre, apellido, email, fechaNacimiento, "", null);
        is.modificarUsuario(du);

        du = is.darDatosUsuario(email);
        if (du != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", du);
        }
        response.sendRedirect("perfil.jsp");
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
