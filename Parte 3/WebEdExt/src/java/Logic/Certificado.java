/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataInscripcionEdicion;
import Server.DataUsuario;
import Server.PublicadorServidorCentralService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Agustín
 */
public class Certificado extends HttpServlet {

    private Server.PublicadorServidorCentralService service = new PublicadorServidorCentralService();
    private Server.PublicadorServidorCentral port = service.getPublicadorServidorCentralPort();

    //Genera el PDF con los datos
    public void generaraPDF(DataUsuario du, List<DataInscripcionEdicion> inscripciones) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

        //El outputstream para el fichero donde creamos el pdf
        FileOutputStream ficheroPDF = new FileOutputStream(getServletContext().getRealPath("/") + "\\Certificado.pdf");

        //Se asocia el documento de output
        PdfWriter.getInstance(documento, ficheroPDF);

        //Se abre el documento
        documento.open();

        //Parrafo
        Paragraph titulo = new Paragraph("Certificado de Aprobacion \n\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.CYAN));
        documento.add(titulo);

        Paragraph est = new Paragraph("Estudiante: " + du.getNombre() + " " + du.getApellido() + "\n");
        documento.add(est);

        Paragraph correo = new Paragraph("Correo: " + du.getEmail() + "\n\n");
        documento.add(correo);

        Paragraph aprobado = new Paragraph("\n\nAprobado \n\n", FontFactory.getFont("arial", 16, Font.BOLD, BaseColor.GREEN));
        documento.add(aprobado);
        
        Paragraph cursos = new Paragraph("Cursos: \n");
        documento.add(cursos);

        //Creamos una tabla
        PdfPTable table = new PdfPTable(3);
        table.addCell("Curso");
        table.addCell("Calificacion");
        table.addCell("Fecha de aprobacion");

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        for (DataInscripcionEdicion inscripcion : inscripciones) {
            table.addCell(inscripcion.getEdicion().getCurso());
            table.addCell(Float.toString(inscripcion.getCalificacion()));
            table.addCell(format.format(inscripcion.getFechaAprobado().toGregorianCalendar().getTime()));
        }

        // Se añade la abla
        documento.add(table);

        //Se cierra el documento
        documento.close();
    }

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
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("generarCertificado")) {
                HttpSession session = request.getSession();
                if (session != null) {
                    if (session.getAttribute("email") != null) {
                        response.sendRedirect("certificado.jsp");
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
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
            throws ServletException, IOException, FileNotFoundException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String estudiante = (String) session.getAttribute("email");
        String programa = request.getParameter("programa");
        if (estudiante != null) {
            if (programa != null && !programa.equals("vacio")) {
                List<DataInscripcionEdicion> inscripciones = port.darDatosCertificado(estudiante, programa);
                if (inscripciones.size() > 0) {
                    DataUsuario du = (DataUsuario) session.getAttribute("usuario");
                    if (du != null) {
                        try {
                            generaraPDF(du, inscripciones);
                        } catch (DocumentException ex) {
                            ex.printStackTrace();
                        }
                        request.setAttribute("msg", "generado");
                        request.getRequestDispatcher("certificado.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    request.setAttribute("msg", "No se pudo generar el certificado faltan cursos por aprobar");
                    request.getRequestDispatcher("certificado.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("msg", "No se selecciono programa");
                request.getRequestDispatcher("certificado.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
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
