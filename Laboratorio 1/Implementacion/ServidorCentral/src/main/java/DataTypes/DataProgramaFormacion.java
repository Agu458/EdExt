
package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProgramaFormacion {
    private String nombre;
    private List<String> cursos;
    private String descripcion;
    private Date fechaIni;
    private Date fechaFin;
    private List<String> categorias;

    public DataProgramaFormacion(String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }
    
    public DataProgramaFormacion(String nombre, List<String> cursos, String descripcion, Date fechaIni, Date fechaFin, List<String> categorias) {
        this.nombre = nombre;
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.categorias = categorias;
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
    
}
