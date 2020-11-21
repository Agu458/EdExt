package Logica;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public interface ISistema {
    
    public boolean validarNombreInstituto(String nombre);

    public void altaInstituto(String nombre);

    public void bajaInstituto(String nombre);
    
    public List<String> listarInstitutos();
    
    public boolean validarEmail(String email);
    
    public boolean validarNick(String nick);

    public void altaUsuario(DataUsuario du);
    
    public List<String> listarUsuarios();
    
    public DataUsuario darDatosUsuario(String email);
    
    public List<String> listarEstudiantes();
    
    public List<String> listarProfesores();
    
    public void modificarUsuario(DataUsuario du);
    
    public boolean validarNombreCurso(String nombre);
    
    public void altaCurso(DataCurso dc, String instituto);
    
    public List<String> listarCursosInstituto(String instituto);
    
    public List<String> listarCursos();
    
    public DataCurso darDatosCurso(String nombre);
    
    public boolean validarNombreEdicion(String curso, String nombre);
    
    public void altaEdicionCurso(DataEdicion de, String curso);
    
    public DataEdicion darEdicionActual(String curso);
    
    public void inscripcionEdicion(String curso, String estudiante, Date fecha, String urlVideo);
    
    public List<String> listarEdiciones(String curso);
    
    public DataEdicion darDatosEdicion(String curso, String nombreEdicion);
    
    public boolean validarNombrePrograma(String nombre);
    
    public void altaProgramaFormacion(DataProgramaFormacion dpf);
    
    public List<String> listarProgramas();
    
    public boolean conteneCurso(String nombre, String curso);
    
    public void agregarCursoAPrograma(String nombre, String nombreCurso);
    
    public DataProgramaFormacion darProgramaFormacion(String nombre);
    
    public Boolean validarNombreCategoria(String nombre);
    
    public void altaCategoria(String nombre);
    
    public List<String> listarCursosCategoria(String nombre);
    
    public List<String> listarCategorias();
    
    public List<String> listarProfesoresInstituto(String instituto);
    
    public List<String> listarInscriptosAEdicion(String curso, String edicion);
    
    public void aceptarInscripciones(String curso, String edicion, List<String> estudiantes);
    
    public List<String> listarAceptadosAEdicion(String curso, String edicion);
    
    public void inscripcionAPrograma(String programa, String estudiante, Date fecha);
    
    public List<String> listarCursosConEdicionInstituto(String instituto);
    
    public void desistirDeInscripcion(String estudiante, String edicion);
    
    public DataInscripcionEdicion darDatosInscripcionEdicion(String estudiante, String edicion);
    
    public void agregarComentarioEdicionCurso(String curso, String edicion, String estudiante, String cuerpo, Date fechaPublicacion);
    
    public List<DataEdicion> edicionesEstudiante(String estudiante);
}
