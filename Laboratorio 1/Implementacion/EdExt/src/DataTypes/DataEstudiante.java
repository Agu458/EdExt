package DataTypes;

import java.util.Date;
import java.util.List;

public class DataEstudiante extends DataUsuario{
    
    List<DataInscripcionEdicion> inscripcionEdiciones;
    List<DataInscripcionPrograma> inscripcionProgramas;

    public DataEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
    }

    public DataEstudiante(List<DataInscripcionEdicion> inscripcionEdiciones, List<DataInscripcionPrograma> inscripcionProgramas, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.inscripcionEdiciones = inscripcionEdiciones;
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public List<DataInscripcionEdicion> getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public List<DataInscripcionPrograma> getInscripcionProgramas() {
        return inscripcionProgramas;
    }
    
}
