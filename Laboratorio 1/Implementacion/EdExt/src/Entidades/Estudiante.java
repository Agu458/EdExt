package Entidades;

import DataTypes.DataEstudiante;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataInscripcionPrograma;
import DataTypes.DataUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estudiante extends Usuario {

    @OneToMany
    List<InscripcionEdicion> inscripcionEdiciones;
    @OneToMany
    List<InscripcionPrograma> inscripcionProgramas;

    public Estudiante() {
    }

    public Estudiante(List<InscripcionEdicion> inscripcionEdiciones, List<InscripcionPrograma> inscripcionProgramas, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.inscripcionEdiciones = inscripcionEdiciones;
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public List<InscripcionEdicion> getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public void setInscripcionEdiciones(List<InscripcionEdicion> inscripcionEdiciones) {
        this.inscripcionEdiciones = inscripcionEdiciones;
    }

    public List<InscripcionPrograma> getInscripcionProgramas() {
        return inscripcionProgramas;
    }

    public void setInscripcionProgramas(List<InscripcionPrograma> inscripcionProgramas) {
        this.inscripcionProgramas = inscripcionProgramas;
    }

    @Override
    public DataUsuario darDatos() {
        List<DataInscripcionEdicion> die = new ArrayList();
        for (InscripcionEdicion ie : inscripcionEdiciones) {
            DataInscripcionEdicion de = ie.darDatos();
            die.add(de);
        }
        List<DataInscripcionPrograma> dip = new ArrayList();
        for (InscripcionPrograma ip : inscripcionProgramas) {
            DataInscripcionPrograma dp = ip.darDatos();
            dip.add(dp);
        }
        return new DataEstudiante(die, dip, super.getId(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }
}
