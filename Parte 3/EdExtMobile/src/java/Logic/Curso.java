/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Server.Lista;
import Server.DataCurso;
import Server.PublicadorServidorCentralService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Agustín
 */
public class Curso extends HttpServlet {

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
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("listarInstitutos")) {
                Lista data = port.listarInstitutos();
                List institutos = data.getLista();
                String json = new Gson().toJson(institutos);

                out.println(json);
            }
            if (accion.equals("darCategorias")) {
                Lista data = port.listarCategorias();
                List categorias = data.getLista();
                String json = new Gson().toJson(categorias);
                out.println(json);
            }
            if (accion.equals("cursosInsti")) {
                String instituto = request.getParameter("insti");
                if (instituto != null) {
                    Lista data = port.listarCursosInstituto(instituto);
                    List cursos = data.getLista();
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
            if(accion.equals("cursosCategoria")){
                String categoria = request.getParameter("categoria");
                if(categoria != null){
                    Lista data = port.listarCursosCategoria(categoria);
                    List cursos = data.getLista();
                    String json = new Gson().toJson(cursos);
                    out.println(json);
                }
            }
        }
        
        String consultarCurso = request.getParameter("consultarCurso");
        if(consultarCurso != null){
            DataCurso dc = port.darDatosCurso(consultarCurso);
            if(dc != null){
                port.agregarVisita(dc.getNombre());
            }
            request.setAttribute("curso", dc);
            request.getRequestDispatcher("/Pages/mostrarInfoCurso.jsp").forward(request, response);
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
