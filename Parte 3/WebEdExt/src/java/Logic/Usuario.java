/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataInscripcionEdicion;
import Server.DataUsuario;
import Server.Lista;
import Server.PublicadorServidorCentralService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Agustin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class Usuario extends HttpServlet {

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
            if (accion.equals("listarUsuarios")) {
                Lista data = port.listarUsuarios();
                List usuarios = data.getLista();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("consultarUsuario.jsp").forward(request, response);
            }
            if (accion.equals("verPerfil")) {
                HttpSession session = request.getSession();
                String email = (String) session.getAttribute("email");
                if (email != null) {
                    DataUsuario du = port.darDatosUsuario(email);
                    session.setAttribute("usuario", du);
                    request.getRequestDispatcher("perfil.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "No hay ningun usuario logeado");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        }

        String verDatosUsuario = request.getParameter("verDatosUsuario");
        if (verDatosUsuario != null) {
            DataUsuario du = port.darDatosUsuario(verDatosUsuario);
            request.setAttribute("verDatosUsuario", du);
            request.getRequestDispatcher("mostrarInfoUsuario.jsp").forward(request, response);
        }

        String verInscripcionUsuario = request.getParameter("verInscripcionUsuario");
        if (verInscripcionUsuario != null) {
            String estudiante = null;
            String edicion = null;
            String curso = null;
            String[] datos = null;
            try {
                datos = verInscripcionUsuario.split(",");
                estudiante = datos[0];
                edicion = datos[1];
                curso = datos[2];
            } catch (Exception e) {
            }
            if (estudiante != null && edicion != null && curso != null) {
                DataInscripcionEdicion die = port.darDatosInscripcionEdicion(estudiante, edicion, curso);
                request.setAttribute("datosInscripcion", die);
                DataUsuario du = port.darDatosUsuario(estudiante);
                request.setAttribute("datosUsuario", du);
                request.getRequestDispatcher("ingresarResultado.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Faltan Parametros");
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String fecha = request.getParameter("fecha");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        Part imagen = request.getPart("imagen");
        byte[] data = null;

        try {
            BufferedImage bImage = ImageIO.read(imagen.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            data = bos.toByteArray();
        } catch (Exception e) {

        }

        try {
            fechaNacimiento = formato.parse(fecha);
        } catch (Exception e) {
        }
        if(nick != null && nombre != null && apellido != null && email != null && fechaNacimiento != null){
            port.modificarUsuario(nick, nombre, apellido, email, Login.GetXmlGregorianCalendar(fechaNacimiento), "", data);
        } else {
            request.setAttribute("msg", "Faltan Parametros");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        DataUsuario du = port.darDatosUsuario(email);
        if (du != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", du);
        } else {
            request.setAttribute("msg", "No existe el usuario");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
