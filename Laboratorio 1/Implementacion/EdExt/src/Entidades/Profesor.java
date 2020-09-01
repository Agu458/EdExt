package Entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends Usuario {

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Instituto> institutos;

    public Profesor() {
    }

    public Profesor(List<Instituto> institutos, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nombre, apellido, email, fechaNacimiento);
        this.institutos = institutos;
    }

}
