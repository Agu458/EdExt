package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProfesor extends DataUsuario {

    private String instituto;
    private List<DataEdicion> ediciones;

    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento,  String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
        this.instituto = instituto;
    }
    
    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, List<DataEdicion> ediciones, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
        this.instituto = instituto;
        this.ediciones = ediciones;
    }

    public String getInstituto() {
        return instituto;
    }

    public List<DataEdicion> getEdiciones() {
        return ediciones;
    }

}
