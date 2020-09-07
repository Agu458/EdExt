package Logica;

import DataTypes.RET;
import java.util.Date;
import java.util.List;

public interface ISistema {

    public RET altaInstituto(String nombre);

    public void bajaInstituto(String nombre);

    public RET altaEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento);
    
    public RET altaProfesor(List<String> institutos, String nick, String nombre, String apellido, String email, Date fechaNacimiento);
}
