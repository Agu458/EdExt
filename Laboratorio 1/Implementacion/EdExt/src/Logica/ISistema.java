package Logica;

import DataTypes.DataUsuario;
import DataTypes.RET;
import java.util.Date;
import java.util.List;

public interface ISistema {

    public RET altaInstituto(String nombre);

    public void bajaInstituto(String nombre);
    
    public List<String> listarInstitutos();

    public RET altaEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento);
    
    public RET altaProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento);
    
    public List<String> listarUsuarios();
    
    public DataUsuario darDatosUsuario(String email);
}
