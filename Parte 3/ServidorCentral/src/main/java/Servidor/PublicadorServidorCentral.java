/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataProfesor;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import DataTypes.Lista;
import Logica.Fabrica;
import Logica.ISistema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Agustín
 */
@WebService
@SOAPBinding
public class PublicadorServidorCentral {

    private final ISistema sistema = Fabrica.getInstance().getISistema();
    private Endpoint endpoint = null;

    //Constructor
    public PublicadorServidorCentral() {
    }

    //Metodos a publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9129/WS/ServidorCentral", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public boolean validarNombreInstituto(String nombre) {
        return sistema.validarNombreInstituto(nombre);
    }

    @WebMethod
    public void altaInstituto(String nombre) {
        sistema.altaInstituto(nombre);
    }

    @WebMethod
    public Lista listarInstitutos() {
        return new Lista(sistema.listarInstitutos());
    }

    @WebMethod
    public boolean validarEmail(String email) {
        return sistema.validarEmail(email);
    }

    @WebMethod
    public boolean validarNick(String nick) {
        return sistema.validarNick(nick);
    }

    @WebMethod
    public void altaUsuario(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia, String imagen) {
        DataUsuario du;
        if (instituto == null) {
            du = new DataEstudiante(nick, nombre, apellido, email, fechaNacimiento, contrasenia, imagen);
        } else {
            du = new DataProfesor(instituto, nick, nombre, apellido, email, fechaNacimiento, contrasenia, imagen);
        }
        sistema.altaUsuario(du);
    }

    @WebMethod
    public Lista listarUsuarios() {
        return new Lista(sistema.listarUsuarios());
    }

    @WebMethod
    public DataUsuario darDatosUsuario(String email) {
        DataUsuario du = sistema.darDatosUsuario(email);
        if (du == null) {
            du = new DataUsuario("", "", "", "", null, "", "");
        }
        return du;
    }

    @WebMethod
    public Lista listarEstudiantes() {
        return new Lista(sistema.listarEstudiantes());
    }

    @WebMethod
    public Lista listarProfesores() {
        return new Lista(sistema.listarEstudiantes());
    }

    @WebMethod
    public void modificarUsuario(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia, String imagen) {
        DataUsuario du = new DataUsuario(nick, nombre, apellido, email, fechaNacimiento, contrasenia, imagen);
        sistema.modificarUsuario(du);
    }

    @WebMethod
    public boolean validarNombreCurso(String nombre) {
        return sistema.validarNombreCurso(nombre);
    }

    @WebMethod
    public void altaCurso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String url, List previas, List categorias, String instituto) {
        DataCurso dc = new DataCurso(nombre, descripcion, duracion, horas, creditos, fechaRegistro, url, previas, categorias);
        sistema.altaCurso(dc, instituto);
    }

    @WebMethod
    public Lista listarCursosInstituto(String instituto) {
        return new Lista(sistema.listarCursosInstituto(instituto));
    }

    @WebMethod
    public Lista listarCursosConEdicionInstituto(String instituto){
        return new Lista(sistema.listarCursosConEdicionInstituto(instituto));
    }
    
    @WebMethod
    public Lista listarCursos() {
        return new Lista(sistema.listarCursos());
    }

    @WebMethod
    public DataCurso darDatosCurso(String nombre) {
        DataCurso dc = sistema.darDatosCurso(nombre);
        if (dc == null) {
            dc = new DataCurso("", "", 0, 0, 0, null, "", null, null);
        }
        return dc;
    }

    @WebMethod
    public boolean validarNombreEdicion(String curso, String nombre) {
        return sistema.validarNombreEdicion(curso, nombre);
    }

    @WebMethod
    public void altaEdicionCurso(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List profesores, String curso) {
        DataEdicion de = new DataEdicion(nombre, fechaIni, fechaFin, cupos, fechaPublicacion, profesores);
        sistema.altaEdicionCurso(de, curso);
    }

    @WebMethod
    public DataEdicion darEdicionActual(String curso) {
        DataEdicion de = sistema.darEdicionActual(curso);
        if (de == null) {
            de = new DataEdicion("", null, null, 0, null, null);
        }
        return de;
    }

    @WebMethod
    public void inscripcionEdicion(String curso, String estudiante, Date fecha, String urlVideo) {
        sistema.inscripcionEdicion(curso, estudiante, fecha, urlVideo);
    }

    @WebMethod
    public Lista listarEdiciones(String curso) {
        return new Lista(sistema.listarEdiciones(curso));
    }

    @WebMethod
    public DataEdicion darDatosEdicion(String curso, String nombreEdicion) {
        DataEdicion de = sistema.darDatosEdicion(curso, nombreEdicion);
        if (de == null) {
            de = new DataEdicion("", null, null, 0, null, null);
        }
        return de;
    }

    @WebMethod
    public boolean validarNombrePrograma(String nombre) {
        return sistema.validarNombrePrograma(nombre);
    }

    @WebMethod
    public void altaProgramaFormacion(String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        DataProgramaFormacion dpf = new DataProgramaFormacion(nombre, descripcion, fechaIni, fechaFin);
        sistema.altaProgramaFormacion(dpf);
    }

    @WebMethod
    public Lista listarProgramas() {
        return new Lista(sistema.listarProgramas());
    }

    @WebMethod
    public boolean conteneCurso(String nombre, String curso) {
        return sistema.conteneCurso(nombre, curso);
    }

    @WebMethod
    public void agregarCursoAPrograma(String nombre, String nombreCurso) {
        sistema.agregarCursoAPrograma(nombre, nombreCurso);
    }

    @WebMethod
    public DataProgramaFormacion darProgramaFormacion(String nombre) {
        DataProgramaFormacion dpf = sistema.darProgramaFormacion(nombre);
        if (dpf == null) {
            dpf = new DataProgramaFormacion("", "", null, null);
        }
        return dpf;
    }

    @WebMethod
    public Boolean validarNombreCategoria(String nombre) {
        return sistema.validarNombreCategoria(nombre);
    }

    @WebMethod
    public void altaCategoria(String nombre) {
        sistema.altaCategoria(nombre);
    }

    @WebMethod
    public Lista listarCursosCategoria(String nombre) {
        return new Lista(sistema.listarCursosCategoria(nombre));
    }

    @WebMethod
    public Lista listarCategorias() {
        return new Lista(sistema.listarCategorias());
    }

    @WebMethod
    public Lista listarProfesoresInstituto(String instituto) {
        return new Lista(sistema.listarProfesoresInstituto(instituto));
    }

    @WebMethod
    public Lista listarInscriptosAEdicion(String curso, String edicion) {
        return new Lista(sistema.listarInscriptosAEdicion(curso, edicion));
    }

    @WebMethod
    public void aceptarInscripciones(String curso, String edicion, ArrayList est) {
        List<String> estudiantes = est;
        sistema.aceptarInscripciones(curso, edicion, estudiantes);
    }

    @WebMethod
    public Lista listarAceptadosAEdicion(String curso, String edicion) {
        return new Lista(sistema.listarAceptadosAEdicion(curso, edicion));
    }

    @WebMethod
    public void inscripcionAPrograma(String programa, String estudiante, Date fecha) {
        sistema.inscripcionAPrograma(programa, estudiante, fecha);
    }
    
    @WebMethod
    public void desistirDeInscripcion(String estudiante, String edicion){
        sistema.desistirDeInscripcion(estudiante, edicion);
    }
    
    @WebMethod
    public DataInscripcionEdicion darDatosInscripcionEdicion(String estudiante, String edicion){
        return sistema.darDatosInscripcionEdicion(estudiante, edicion);
    }
    
    @WebMethod
    public void agregarComentarioEdicionCurso(String curso, String edicion, String estudiante, String cuerpo, Date fechaPublicacion){
        sistema.agregarComentarioEdicionCurso(curso, edicion, estudiante, cuerpo, fechaPublicacion);
    }
    
    @WebMethod
    public List<DataEdicion> edicionesEstudiante(String estudiante){
        return sistema.edicionesEstudiante(estudiante);
    }
    
    @WebMethod
    public void valorarCurso(String curso, Double valoracion){
        sistema.valorarCurso(curso, valoracion);
    }
    
}
