package Entidades;

import DataTypes.DataEstudiante;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataInscripcionPrograma;
import DataTypes.DataUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estudiante extends Usuario {

    @OneToMany
    Map<String, InscripcionEdicion> inscripcionEdiciones;
    @OneToMany
    Map<String, InscripcionPrograma> inscripcionProgramas;

    public Estudiante() {
    }

    public Estudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        inscripcionEdiciones = new HashMap();
        inscripcionProgramas = new HashMap();
    }

    public Map getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public void setInscripcionEdiciones(Map inscripcionEdiciones) {
        this.inscripcionEdiciones = inscripcionEdiciones;
    }

    public Map getInscripcionProgramas() {
        return inscripcionProgramas;
    }

    public void setInscripcionProgramas(Map inscripcionProgramas) {
        this.inscripcionProgramas = inscripcionProgramas;
    }

    @Override
    public DataUsuario darDatos() {
        List<DataInscripcionEdicion> die = new ArrayList();
        for (Object o : inscripcionEdiciones.values()) {
            InscripcionEdicion ie = (InscripcionEdicion) o;
            DataInscripcionEdicion de = ie.darDatos();
            die.add(de);
        }
        List<DataInscripcionPrograma> dip = new ArrayList();
        for (Object o : inscripcionProgramas.values()) {
            InscripcionPrograma ip = (InscripcionPrograma) o;
            DataInscripcionPrograma dp = ip.darDatos();
            dip.add(dp);
        }
        return new DataEstudiante(die, dip, super.getId(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }
}
