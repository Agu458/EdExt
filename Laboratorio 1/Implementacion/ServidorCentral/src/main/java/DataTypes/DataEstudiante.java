package DataTypes;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataEstudiante extends DataUsuario{
    
    Map<String, DataInscripcionEdicion> inscripcionEdiciones;
    Map<String, DataProgramaFormacion> inscripcionProgramas;

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
