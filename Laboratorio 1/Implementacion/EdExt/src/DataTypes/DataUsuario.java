package DataTypes;

import java.util.Date;

public class DataUsuario {

    private Long id;
    private String nick;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;

    public DataUsuario(Long id, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        this.id = id;
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public String getNick() {
        return nick;
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
        return "DataUsuario{" + "id=" + id + ", nick=" + nick + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
