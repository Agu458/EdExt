/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataProfesor;
import Server.DataProgramaFormacion;
import Server.DataUsuario;
import Server.Lista;
import Server.PublicadorServidorCentralService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Otro
 */
public class ProgramaFormacion extends HttpServlet {

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
            if (accion.equals("listarProgramas")) {
                Lista data = port.listarProgramas();
                List programas = data.getLista();
                request.setAttribute("programas", programas);
                request.getRequestDispatcher("consultarPrograma.jsp").forward(request, response);
            }
            if (accion.equals("darProgramas")) {
                Lista data = port.listarProgramas();
                List programas = data.getLista();
                String json = new Gson().toJson(programas);
                out.println(json);
            }
        }

        String consultarPrograma = request.getParameter("consultarPrograma");
        if (consultarPrograma != null) {
            DataProgramaFormacion dpf = port.darProgramaFormacion(consultarPrograma);
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
                HttpSession session = request.getSession();
                DataUsuario du = (DataUsuario) session.getAttribute("usuario");
                if (du != null) {
                    if (du instanceof DataProfesor) {
                        String nombre = request.getParameter("nombre");
                        if (nombre != null && port.validarNombrePrograma(nombre)) {
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
                            if (descripcion != null && fechaIni != null && fechaFin != null) {
                                port.altaProgramaFormacion(nombre, descripcion, Login.GetXmlGregorianCalendar(fechaIni), Login.GetXmlGregorianCalendar(fechaFin));
                                response.sendRedirect("altaPrograma.jsp");
                            } else {
                                request.setAttribute("msg", "Faltan Parametros");
                                request.getRequestDispatcher("altaPrograma.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("msg", "Nombre de Programa Invalido");
                            request.getRequestDispatcher("altaPrograma.jsp").forward(request, response);
                        }
                    } else {
                        request.setAttribute("msg", "El usuario actual no es un profesor");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "No hay ningun usuario logeado");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            }
            if (accion.equals("agregarCursoPrograma")) {
                String programa = request.getParameter("programa");
                String curso = request.getParameter("curso");
                if (programa != null && !programa.equals("vacio") && curso != null && !curso.equals("vacio")) {
                    if (port.darEdicionActual(curso).getNombre().equals("")) {
                        request.setAttribute("msg", "El curso seleccionado no tiene ninguna edicion actual");
                        request.getRequestDispatcher("agregarCursoPrograma.jsp").forward(request, response);
                    } else {
                        if (port.conteneCurso(programa, curso)) {
                            request.setAttribute("msg", "El curso seleccionado ya pertenece al programa");
                            request.getRequestDispatcher("agregarCursoPrograma.jsp").forward(request, response);
                        } else {
                            port.agregarCursoAPrograma(programa, curso);
                            response.sendRedirect("agregarCursoPrograma.jsp");
                        }
                    }
                } else {
                    request.setAttribute("msg", "Faltan Parametros");
                    request.getRequestDispatcher("agregarCursoPrograma.jsp").forward(request, response);
                }
            }
            if (accion.equals("altaInscripcionPrograma")) {
                String estudiante = request.getParameter("estudiante");
                String programa = request.getParameter("programa");

                if (estudiante != null && programa != null && !programa.equals("vacio")) {
                    port.inscripcionAPrograma(programa, estudiante, Login.GetXmlGregorianCalendar(new Date()));
                    response.sendRedirect("inscripcionAPrograma.jsp");
                } else {
                    request.setAttribute("msg", "Faltan Parametros");
                    request.getRequestDispatcher("inscripcionAPrograma.jsp").forward(request, response);
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
