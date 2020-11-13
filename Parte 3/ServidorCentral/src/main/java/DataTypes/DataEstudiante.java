package DataTypes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataEstudiante extends DataUsuario{
    
    Map<String, DataInscripcionEdicion> inscripcionEdiciones;
    Map<String, DataProgramaFormacion> inscripcionProgramas;

    public DataEstudiante(){
    }
    
    public DataEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia ,String imagen) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia ,imagen);
    }

    public DataEstudiante(Map<String, DataInscripcionEdicion> inscripcionEdiciones, Map<String, DataProgramaFormacion> inscripcionProgramas, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia ,String imagen) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia ,imagen);
        this.inscripcionEdiciones = inscripcionEdiciones;
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public Map<String, DataInscripcionEdicion> getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public Map<String, DataProgramaFormacion> getInscripcionProgramas() {
        return inscripcionProgramas;
    }
    
}
