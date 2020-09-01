package Entidades;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Estudiante extends Usuario {

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nombre, apellido, email, fechaNacimiento);
    }
    
}
