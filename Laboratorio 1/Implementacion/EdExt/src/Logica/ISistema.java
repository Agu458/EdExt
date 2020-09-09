package Logica;

import DataTypes.DataUsuario;
import DataTypes.RET;
import java.util.Date;
import java.util.List;

public interface ISistema {

    public RET altaInstituto(String nombre);

    public void bajaInstituto(String nombre);
    
    public List<String> listarInstitutos();
    
    public boolean validarEmail(String email);
    
    public boolean validarNick(String nick);

    public void altaEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento);
    
    public void altaProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento);
    
    public List<String> listarUsuarios();
    
    public DataUsuario darDatosUsuario(String email);
}
