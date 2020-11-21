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
    private int aceptados;
    private Date fechaPublicacion;
    private List<String> profesores;
    private String curso;
    private List<DataComentario> comentarios;

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
    
    public DataEdicion(String nombre, Date fechaIni, Date fechaFin, int cupos, int aceptados, Date fechaPublicacion, List<String> profesores, String curso, List<DataComentario> comentarios) {
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = profesores;
        this.curso = curso;
        this.aceptados = aceptados;
        this.comentarios = comentarios;
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

    public int getAceptados() {
        return aceptados;
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

    public List<DataComentario> getComentarios() {
        return comentarios;
    }
    
    
}
