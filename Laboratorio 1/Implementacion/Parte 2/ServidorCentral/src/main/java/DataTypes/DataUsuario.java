package DataTypes;

import java.util.Date;

public class DataUsuario {

    private final String nick;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final Date fechaNacimiento;
    private final String contrasenia;

    public DataUsuario(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "DataUsuario{" + ", nick=" + nick + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
