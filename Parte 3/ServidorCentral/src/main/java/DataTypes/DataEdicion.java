package DataTypes;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataEdicion {

    private String nombre;
    private Date fechaIni;
    private Date fechaFin;
    private int cupos;
    private Date fechaPublicacion;
    private List<String> profesores;
    private String curso;

    public DataEdicion() {
    }

    public DataEdicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<String> profesores) {
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = profesores;
    }
    
    public DataEdicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<String> profesores, String curso) {
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = profesores;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getCupos() {
        return cupos;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<String> getProfesores() {
        return profesores;
    }

    public String getCurso() {
        return curso;
    }

}
