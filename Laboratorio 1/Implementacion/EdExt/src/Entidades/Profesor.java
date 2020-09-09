package Entidades;

import DataTypes.DataInstituto;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        return new DataProfesor(instituto.darDatos(), super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }
}
