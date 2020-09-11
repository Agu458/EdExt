package Entidades;

import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.*;
import javax.persistence.*;

@Entity
public class Profesor extends Usuario {

    @OneToOne
    private Instituto instituto;
    @ManyToMany(mappedBy = "profesores")
    private Map<String, Edicion> ediciones;

    public Profesor() {
    }

    public Profesor(Instituto instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.instituto = instituto;
        this.ediciones = new HashMap();
    }

    @Override
    public DataUsuario darDatos() {
        List<String> eds = new ArrayList();
        for(Edicion e : ediciones.values()){
            eds.add(e.getNombre());
        }
        return new DataProfesor(instituto.darDatos().getNombre(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento(), eds);
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public Map<String, Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(Map<String, Edicion> ediciones) {
        this.ediciones = ediciones;
    }
    
}
