package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProfesor extends DataUsuario {

    private String instituto;

    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.instituto = instituto;
    }

    public String getInstituto() {
        return instituto;
    }

}
