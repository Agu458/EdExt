/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.DataUsuario;
import Server.PublicadorServidorCentralService;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * @author Agustin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Server.PublicadorServidorCentralService service = new PublicadorServidorCentralService();
    private Server.PublicadorServidorCentral port = service.getPublicadorServidorCentralPort();
    
     /**
     * Devuelve un objeto XMLGregorianCalendar a partir de un objeto Date.
     * @param fecha Objeto Date
     * @return 
     */
    public static XMLGregorianCalendar GetXmlGregorianCalendar(Date fecha)
    {
        GregorianCalendar calendario = new GregorianCalendar();
        XMLGregorianCalendar xmlCalendario = null;
        
        calendario.setTime(fecha);
        
        try {
            xmlCalendario = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
            return xmlCalendario;
        } catch (DatatypeConfigurationException ex) {
            System.out.println(ex.toString());
            return null;
        }        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("password");
        
        DataUsuario du = port.darDatosUsuario(email);
        if(!du.getEmail().equals("") && du.getContrasenia().equals(contrasenia)){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("usuario", du);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("msg", "El usuario o la contraseña son incorrectos...");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
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
