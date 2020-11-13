
package DataTypes;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProgramaFormacion {
    private String nombre;
    private List<String> cursos;
    private String descripcion;
    private Date fechaIni;
    private Date fechaFin;
    private List<String> categorias;
    private List<String> inscriptos;

    public DataProgramaFormacion() {
    }

    public DataProgramaFormacion(String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    public DataProgramaFormacion(String nombre, List<String> cursos, String descripcion, Date fechaIni, Date fechaFin, List<String> categorias, List<String> inscriptos) {
        this.nombre = nombre;
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.categorias = categorias;
        this.inscriptos = inscriptos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public List<String> getInscriptos() {
        return inscriptos;
    }
    
}
