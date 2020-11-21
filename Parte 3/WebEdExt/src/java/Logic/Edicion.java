/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataEdicion;
import Server.DataInscripcionEdicion;
import Server.Lista;
import Server.PublicadorServidorCentralService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Edicion extends HttpServlet {

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

        String accion = request.getParameter("action");
        if (accion != null) {
            if (accion.equals("validarNombreEdicion")) {
                String nombre = request.getParameter("nombre");
                if (nombre != null) {
                    String curso = request.getParameter("curso");
                    if (curso != null) {
                        Boolean valido = port.validarNombreEdicion(curso, nombre);
                        out.println(valido);
                    }
                }
            }
        }

        String seleccionarInscriptosEdicion = request.getParameter("seleccionarInscriptosEdicion");
        if (seleccionarInscriptosEdicion != null) {
            String edicion = null;
            String curso = null;
            String[] datos = null;
            try {
                datos = seleccionarInscriptosEdicion.split(",");
                curso = datos[0];
                edicion = datos[1];
            } catch (Exception e) {
            }
            if (edicion != null && curso != null) {
                Lista data = port.listarInscriptosAEdicion(curso, edicion);
                List inscriptos = data.getLista();
                DataEdicion de = port.darDatosEdicion(curso, edicion);
                request.setAttribute("inscriptos", inscriptos);
                request.setAttribute("edicion", de);
                request.getRequestDispatcher("seleccionarEstudiantesEdicion.jsp").forward(request, response);
            }
        }

        String darAceptadosAEdicion = request.getParameter("darAceptadosAEdicion");
        if (darAceptadosAEdicion != null) {
            String edicion = null;
            String curso = null;
            String[] datos = null;
            try {
                datos = darAceptadosAEdicion.split(",");
                curso = datos[0];
                edicion = datos[1];
            } catch (Exception e) {
            }
            if (edicion != null && curso != null) {
                Lista data = port.listarAceptadosAEdicion(curso, edicion);
                List inscriptos = data.getLista();
                DataEdicion de = port.darDatosEdicion(curso, edicion);
                request.setAttribute("aceptados", inscriptos);
                request.setAttribute("edicion", de);
                request.getRequestDispatcher("estudiantesAceptados.jsp").forward(request, response);
            }
        }

        String consultarEdicion = request.getParameter("consultarEdicion");
        if (consultarEdicion != null) {
            String nombre = null;
            String curso = null;
            String[] datos = null;
            try {
                datos = consultarEdicion.split(",");
                curso = datos[0];
                nombre = datos[1];
            } catch (Exception e) {
            }
            if (nombre != null && curso != null) {
                DataEdicion de = port.darDatosEdicion(curso, nombre);
                request.setAttribute("datosEdicion", de);
                request.getRequestDispatcher("mostrarInfoEdicion.jsp").forward(request, response);
            }
        }

        String inscribirEdicionCurso = request.getParameter("inscribirEdicionCurso");
        if (inscribirEdicionCurso != null) {
            DataEdicion de = port.darEdicionActual(inscribirEdicionCurso);
            request.setAttribute("edicion", de);
            request.getRequestDispatcher("inscripcion_edicion.jsp").forward(request, response);
        }
        
        String consultarInscripcionEdicion = request.getParameter("consultarInscripcionEdicion");
        if(consultarInscripcionEdicion != null){
            String estudiante = null;
            String edicion = null;
            String[] datos = null;
            try {
                datos = consultarInscripcionEdicion.split(",");
                estudiante = datos[0];
                edicion = datos[1];
            } catch (Exception e) {
            }
            if (estudiante != null && edicion != null) {
                DataInscripcionEdicion die = port.darDatosInscripcionEdicion(estudiante, edicion);
                request.setAttribute("datosInscripcion", die);
                request.getRequestDispatcher("mostrarInfoInscripcionEdicion.jsp").forward(request, response);
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
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("altaEdicion")) {
                String instituto = request.getParameter("instituto");
                if (instituto != null) {
                    String curso = request.getParameter("curso");
                    if (curso != null) {
                        String nombre = request.getParameter("nombre");
                        if (nombre != null && port.validarNombreEdicion(curso, nombre)) {
                            String cupo = request.getParameter("cupos");
                            int cupos = 0;
                            if (!cupo.equals("")) {
                                cupos = Integer.parseInt(cupo);
                            }

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

                            String[] profs = request.getParameterValues("profesores");
                            List profesores = new ArrayList();
                            if (profs != null) {
                                profesores = Arrays.asList(profs);
                            }

                            port.altaEdicionCurso(nombre, Login.GetXmlGregorianCalendar(fechaIni), Login.GetXmlGregorianCalendar(fechaFin), cupos, Login.GetXmlGregorianCalendar(new Date()), profesores, curso);
                        }
                    }
                }
                response.sendRedirect("altaEdicion.jsp");
            }

            if (accion.equals("altaInscripcionEdicion")) {
                String curso = request.getParameter("curso");
                if (curso != null) {
                    String estudiante = request.getParameter("estudiante");
                    if (estudiante != null) {
                        String video = request.getParameter("video");
                        port.inscripcionEdicion(curso, estudiante, Login.GetXmlGregorianCalendar(new Date()), video);
                    }
                }
                response.sendRedirect("inscripcion_edicion.jsp");
            }

            if (accion.equals("aceptarEstudiantes")) {
                String[] acep = request.getParameterValues("aceptados");
                List aceptados = new ArrayList();
                if (acep != null) {
                    aceptados = Arrays.asList(acep);
                }

                String curso = request.getParameter("curso");
                String edicion = request.getParameter("edicion");

                if (curso != null && edicion != null && !aceptados.isEmpty()) {
                    port.aceptarInscripciones(curso, edicion, aceptados);
                    response.sendRedirect("seleccionarEstudiantesEdicion.jsp");
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
