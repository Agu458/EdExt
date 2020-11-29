/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.PublicadorServidorCentralService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Agustin
 */
public class Registrarse extends HttpServlet {

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

        String validar = (String) request.getParameter("validar");
        if (validar != null) {
            if (validar.equals("validarNick")) {
                String nick = request.getParameter("nick");
                if (nick != null) {
                    Boolean valido =  port.validarNick(nick);
                    out.println(valido);
                }
            }
            if (validar.equals("validarEmail")) {
                String email = request.getParameter("email");
                if (email != null) {
                    Boolean valido =  port.validarEmail(email);
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
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("password");
        String contrasenia2 = request.getParameter("password2");
        String fecha = request.getParameter("fecha");
        String docente = request.getParameter("docente");

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formato.parse(fecha);
        } catch (Exception e) {
        }

        if (docente == null) {
            if (contrasenia.equals(contrasenia2)) {
                if (port.validarEmail(email) && port.validarNick(nick)) {
                    
                    port.altaUsuario(null, nick, nombre, apellido, email, Login.GetXmlGregorianCalendar(fechaNacimiento), contrasenia, null);
                }
            }
        } else {
            String instituto = request.getParameter("instituto");
            if (!instituto.equals("")) {
                if (port.validarEmail(email) && port.validarNick(nick)) {
                    port.altaUsuario(instituto, nick, nombre, apellido, email, Login.GetXmlGregorianCalendar(fechaNacimiento), contrasenia, null);
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
