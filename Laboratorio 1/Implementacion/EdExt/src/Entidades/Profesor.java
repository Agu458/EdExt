package Entidades;

import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Profesor extends Usuario {

    @OneToOne
    private Instituto instituto;

    public Profesor() {
    }

    public Profesor(Instituto instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.instituto = instituto;
    }

    @Override
    public DataUsuario darDatos() {
        return new DataProfesor(instituto.darDatos().getNombre(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }
}
