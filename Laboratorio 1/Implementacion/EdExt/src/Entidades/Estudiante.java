package Entidades;

import DataTypes.DataEstudiante;
import DataTypes.DataUsuario;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Estudiante extends Usuario {

    public Estudiante() {
    }

    public Estudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
    }
    
    @Override
    public DataUsuario darDatos(){
        return new DataEstudiante(super.getId(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }
}
