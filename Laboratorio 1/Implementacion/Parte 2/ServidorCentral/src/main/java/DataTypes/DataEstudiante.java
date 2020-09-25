package DataTypes;

import java.util.Date;
import java.util.List;

public class DataEstudiante extends DataUsuario{
    
    List<DataEdicion> inscripcionEdiciones;
    List<String> inscripcionProgramas;

    public DataEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
    }

    public DataEstudiante(List<DataEdicion> inscripcionEdiciones, List<String> inscripcionProgramas, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
        this.inscripcionEdiciones = inscripcionEdiciones;
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public List<DataEdicion> getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public List<String> getInscripcionProgramas() {
        return inscripcionProgramas;
    }
    
}
