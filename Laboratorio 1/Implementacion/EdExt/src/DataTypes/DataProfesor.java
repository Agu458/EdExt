package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProfesor extends DataUsuario {

    private String instituto;
    private List<String> ediciones;

    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.instituto = instituto;
    }
    
    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, List<String> ediciones) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.instituto = instituto;
        this.ediciones = ediciones;
    }

    public String getInstituto() {
        return instituto;
    }

    public List<String> getEdiciones() {
        return ediciones;
    }

}
