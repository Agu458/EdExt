package Entidades;

import DataTypes.DataInstituto;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import java.util.ArrayList;
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

    public Profesor(List<Instituto> institutos, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nick, nombre, apellido, email, fechaNacimiento);
        this.institutos = institutos;
    }

    @Override
    public DataUsuario darDatos() {
        List<DataInstituto> i = new ArrayList();
        for (Instituto inst : institutos) {
            i.add(inst.darDatos());
        }
        return new DataProfesor(i, super.getNick(), super.getNombre(), super.getApellido(), super.getEmail(), super.getFechaNacimiento());
    }

    public void agregarInstituto(Instituto i) {
        institutos.add(i);
    }

    public boolean tieneInstituto(Instituto i) {
        return institutos.contains(i);
    }
}
