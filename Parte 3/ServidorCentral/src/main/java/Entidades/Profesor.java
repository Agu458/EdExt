package Entidades;

import DataTypes.DataEdicion;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.*;
import javax.persistence.*;

@Entity
public class Profesor extends Usuario {


    @ManyToOne
    private Instituto instituto;
    @ManyToMany(mappedBy = "profesores")
    @MapKey(name = "nombreEdicion")
    private Map<String, Edicion> ediciones;

    public Profesor() {
    }

    public Profesor(Instituto instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia ,String imagen ) {
        super(nick, nombre, apellido, email, fechaNacimiento, contrasenia ,imagen);
        this.instituto = instituto;
        this.ediciones = new HashMap();
    }

    @Override
    public DataUsuario darDatos() {
        Map<String, DataEdicion> eds = new HashMap();
        for(Edicion e : ediciones.values()){
            eds.put(e.getNombreEdicion(), e.darDatos());
        }
        return new DataProfesor(instituto.darDatos().getNombre(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento(), eds, super.getContrasenia() ,super.getimagen());
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
