package DataTypes;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class DataEstudiante extends DataUsuario{
    
    Map<String, DataEdicion> inscripcionEdiciones;
    Map<String, DataProgramaFormacion> inscripcionProgramas;

    public DataEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
    }

    public DataEstudiante(Map<String, DataEdicion> inscripcionEdiciones, Map<String, DataProgramaFormacion> inscripcionProgramas, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
        this.inscripcionEdiciones = inscripcionEdiciones;
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public Map<String, DataEdicion> getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public Map<String, DataProgramaFormacion> getInscripcionProgramas() {
        return inscripcionProgramas;
    }
    
}
