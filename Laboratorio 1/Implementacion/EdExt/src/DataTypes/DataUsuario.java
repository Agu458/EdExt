package DataTypes;

import java.util.Date;

public class DataUsuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;

    public DataUsuario(Long id, String nombre, String apellido, String email, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "DataUsuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
