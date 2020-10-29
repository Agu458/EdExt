package Entidades;

import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import DataTypes.EstadoInscripcion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Estudiante extends Usuario {

    @OneToMany
    private List<InscripcionEdicion> inscripcionEdiciones;
    @OneToMany
    private List<InscripcionPrograma> inscripcionProgramas;

    public Estudiante() {
    }

    public Estudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia, String imagen) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia, imagen);
        inscripcionEdiciones = new ArrayList();
        inscripcionProgramas = new ArrayList();
    }

    public List getInscripcionEdiciones() {
        return inscripcionEdiciones;
    }

    public void setInscripcionEdiciones(List inscripcionEdiciones) {
        this.inscripcionEdiciones = inscripcionEdiciones;
    }

    public List getInscripcionProgramas() {
        return inscripcionProgramas;
    }

    public void setInscripcionProgramas(List inscripcionProgramas) {
        this.inscripcionProgramas = inscripcionProgramas;
    }

    public boolean estaInscripto(String edicion) {
        for (InscripcionEdicion aux : inscripcionEdiciones) {
            if (aux.getEdicion().getNombreEdicion() == edicion) {
                return true;
            }
        }
        return false;
    }

    public InscripcionEdicion darInscripcionEdicion(String edicion) {
        for (InscripcionEdicion aux : inscripcionEdiciones) {
            if (aux.getEdicion().getNombreEdicion() == edicion) {
                return aux;
            }
        }
        return null;
    }

    public InscripcionEdicion inscribirseAUnaEdicion(Edicion edicion, Date fecha) {
        InscripcionEdicion inscripcion = this.darInscripcionEdicion(edicion.getNombreEdicion());
        if (inscripcion != null) {
            if (inscripcion.getEstado() == EstadoInscripcion.RECHASADO) {
                inscripcion.setEstado(EstadoInscripcion.INSCRIPTO);
                inscripcion.setInscripcionesPrevias(inscripcion.getInscripcionesPrevias() + 1);
            }

        } else {
            inscripcion = new InscripcionEdicion(fecha, edicion, this);
            inscripcionEdiciones.add(inscripcion);
        }
        return inscripcion;
    }

    @Override
    public DataUsuario darDatos() {
        Map<String, DataInscripcionEdicion> eds = new HashMap();
        for (InscripcionEdicion ie : inscripcionEdiciones) {
            if (ie != null) {
                DataInscripcionEdicion die = ie.darDatos();
                eds.put(die.getEdicion().getNombre(), die);
            }
        }
        Map<String, DataProgramaFormacion> progs = new HashMap();
        for (InscripcionPrograma ip : inscripcionProgramas) {
            if (ip.getPrograma() != null) {
                DataProgramaFormacion dpf = ip.getPrograma().darDatos();
                progs.put(dpf.getNombre(), dpf);
            }
        }
        return new DataEstudiante(eds, progs, super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento(),
                super.getContrasenia(), super.getimagen());
    }
}
