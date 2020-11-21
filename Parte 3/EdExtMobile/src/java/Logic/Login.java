/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.SessionState;
import Server.DataUsuario;
import Server.DataEstudiante;
import Server.PublicadorServidorCentralService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Agustín
 */
public class Login extends HttpServlet {

    private Server.PublicadorServidorCentralService service = new PublicadorServidorCentralService();
    private Server.PublicadorServidorCentral port = service.getPublicadorServidorCentralPort();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null) {
            DataUsuario usuario = port.darDatosUsuario(email);
            if (usuario instanceof DataEstudiante) {
                if (!usuario.getEmail().equals("")) {
                    if (usuario.getContrasenia().equals(password)) {
                        session.setAttribute("SessionState", SessionState.LOGGED);
                        session.setAttribute("email", usuario.getEmail());
                        session.setAttribute("usuario", usuario);
                    } else {
                        session.setAttribute("SessionState", SessionState.LOGIN_FAILED);
                    }
                } else {
                    session.setAttribute("SessionState", SessionState.LOGIN_FAILED);
                }
            } else {
                session.setAttribute("SessionState", SessionState.LOGIN_FAILED);
            }
        } else {
            session.setAttribute("SessionState", SessionState.LOGIN_FAILED);
        }
        request.getRequestDispatcher("Home").forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
