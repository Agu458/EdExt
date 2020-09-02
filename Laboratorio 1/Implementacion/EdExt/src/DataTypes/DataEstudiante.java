package DataTypes;

import java.util.Date;

public class DataEstudiante extends DataUsuario{

    public DataEstudiante(Long id, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(id, nick, nombre, apellido, email, fechaNacimiento);
    }
    
}
