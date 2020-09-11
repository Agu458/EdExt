package DataTypes;

import java.util.Date;
import java.util.List;

public class DataEdicion {

    private String nombre;
    private Date fechaIni;
    private Date fechaFin;
    private int cupos;
    private Date fechaPublicacion;
    private List<String> profesores;

    public DataEdicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<String> profesores) {
        this.nombre = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = profesores;
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
}
