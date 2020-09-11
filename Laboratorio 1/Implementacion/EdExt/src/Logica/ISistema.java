package Logica;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import java.util.Date;
import java.util.List;

public interface ISistema {

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
    
    public void altaCurso(DataCurso dc, String instituto);
    
    public List<String> listarCursosInstituto(String instituto);
    
    public List<String> listarCursos();
    
    public DataCurso darDatosCurso(String nombre);
    
    public void altaEdicionCurso(DataEdicion de, String curso);
    
    public DataEdicion darEdicionActual(String curso);
    
    public void inscripcionEdicion(String curso, String estudiante, Date fecha);
    
    public List<String> listarEdiciones(String curso);
    
    public DataEdicion darDatosEdicion(String curso, String nombreEdicion);
    
    public void altaProgramaFormacion(DataProgramaFormacion dpf);
    
    public List<String> listarProgramas();
    
    public void agregarCursoAPrograma(String nombre, String nombreCurso);
    
    public DataProgramaFormacion darProgramaFormacion(String nombre);
}
