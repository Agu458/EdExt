package DataTypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({DataEstudiante.class,DataProfesor.class})
public class DataUsuario {

    private String nick;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;
    private String contrasenia;
    private byte[] imagen;

    public DataUsuario() {
    }
    
    public DataUsuario(String nick, String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia ,byte[] imagen) {
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

    public byte[] getimagen() {
        return imagen;
    }

}
