/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataEstudiante;
import Server.DataUsuario;
import Server.PublicadorServidorCentralService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class Comentario extends HttpServlet {

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
        HttpSession session = request.getSession();
        DataUsuario usuario = (DataUsuario) session.getAttribute("usuario");
        if (usuario != null) {
            if (usuario instanceof DataEstudiante) {
                List ediciones = port.edicionesEstudiante(usuario.getEmail());
                request.setAttribute("edicionesEst", ediciones);
                request.getRequestDispatcher("comentarEdicion.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "El usuario actual no es un estudiante");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "No hay ningun usuario logeado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String curso = request.getParameter("curso");
        String edicion = request.getParameter("edicion");
        String estudiante = request.getParameter("estudiante");
        String id = request.getParameter("id");

        if (estudiante != null && curso != null && edicion != null) {
            String cuerpo = request.getParameter("cuerpo");
            if (id != null) {
                if (cuerpo != null) {
                    port.agregarComentarioEdicionCurso(curso, edicion, estudiante, cuerpo, Login.GetXmlGregorianCalendar(new Date()), Long.parseLong(id));
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("msg", "Faltan Parametros");
                    request.getRequestDispatcher("Comentario").forward(request, response);
                }
            } else {
                if (cuerpo != null) {
                    port.agregarComentarioEdicionCurso(curso, edicion, estudiante, cuerpo, Login.GetXmlGregorianCalendar(new Date()), null);
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("msg", "Faltan Parametros");
                    request.getRequestDispatcher("Comentario").forward(request, response);
                }
            }
        } else {
            request.setAttribute("msg", "Faltan Parametros");
            request.getRequestDispatcher("Comentario").forward(request, response);
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
