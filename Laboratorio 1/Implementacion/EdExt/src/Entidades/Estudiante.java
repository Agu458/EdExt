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
import javax.persistence.EntityManager;
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
    
    public void inscribirEdicion(Edicion e, Date fecha, EntityManager em){
        InscripcionEdicion ie = new InscripcionEdicion(fecha, e);
        inscripcionEdiciones.put(e.getNombre(), ie);
        em.persist(ie);
    }
    
    @Override
    public DataUsuario darDatos() {
        List<String> eds = new ArrayList();
        for (String s : inscripcionEdiciones.keySet()) {
            eds.add(s);
        }
        List<String> progs = new ArrayList();
        for (String s : inscripcionProgramas.keySet()) {
            progs.add(s);
        }
        return new DataEstudiante(eds, progs, super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }
}
