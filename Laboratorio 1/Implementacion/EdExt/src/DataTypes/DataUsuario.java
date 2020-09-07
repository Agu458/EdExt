package DataTypes;

import java.util.Date;

public class DataUsuario {

    private String nick;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;

    public DataUsuario(String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
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
        return "DataUsuario{" + ", nick=" + nick + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
