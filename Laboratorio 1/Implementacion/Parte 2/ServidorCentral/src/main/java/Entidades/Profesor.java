package Entidades;

import DataTypes.DataEdicion;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.*;
import javax.persistence.*;

@Entity
public class Profesor extends Usuario {

    @OneToOne
    private Instituto instituto;
    @ManyToMany(mappedBy = "profesores")
    @MapKey(name = "nombreEdicion")
    private Map<String, Edicion> ediciones;
    @ManyToMany
    private List<Instituto> institutos;

    public Profesor() {
    }

    public Profesor(Instituto instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia);
        this.instituto = instituto;
        this.ediciones = new HashMap();
    }

    @Override
    public DataUsuario darDatos() {
        List<DataEdicion> eds = new ArrayList();
        for(Edicion e : ediciones.values()){
            eds.add(e.darDatos());
        }
        return new DataProfesor(instituto.darDatos().getNombre(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento(), eds, super.getContrasenia());
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
    
    public void agregarEdicion(Edicion e){
        this.ediciones.put(e.getNombreEdicion(), e);
    }
}