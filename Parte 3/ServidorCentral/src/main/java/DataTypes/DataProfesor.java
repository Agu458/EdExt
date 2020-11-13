package DataTypes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProfesor extends DataUsuario {

    private String instituto;
    private Map<String, DataEdicion> ediciones;

    public DataProfesor(){
    }
    
    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento,  String contrasenia ,String imagen) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia ,imagen);
        this.instituto = instituto;
    }
    
    public DataProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, Map<String, DataEdicion> ediciones, String contrasenia ,String imagen) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia ,imagen);
        this.instituto = instituto;
        this.ediciones = ediciones;
    }

    public String getInstituto() {
        return instituto;
    }

    public Map<String, DataEdicion> getEdiciones() {
        return ediciones;
    }

}
