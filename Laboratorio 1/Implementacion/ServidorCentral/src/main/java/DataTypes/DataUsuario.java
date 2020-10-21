package DataTypes;

import java.util.Date;

public class DataUsuario {

    private final String nick;
    private final String nombre;
    private final String apellido;
    private final String email;
    private final Date fechaNacimiento;
    private final String contrasenia;
    private final String imagen;
    
    public DataUsuario(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia ,String imagen) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
        this.imagen = imagen;
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

    public String getimagen() {
        return imagen;
    }

}
