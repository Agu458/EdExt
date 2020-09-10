package DataTypes;

import java.util.Date;
import java.util.List;

public class DataCurso {

    private String nombre;
    private String descripcion;
    private int duracion;
    private int horas;
    private int creditos;
    private Date fechaRegistro;
    private String URL;
    private List<DataEdicion> ediciones;
    private DataEdicion edicionAgtual;
    private List<String> previas;
    private List<String> progs;

    public DataCurso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<String> previas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horas = horas;
        this.creditos = creditos;
        this.fechaRegistro = fechaRegistro;
        this.URL = URL;
        this.previas = previas;
    }
    
    public DataCurso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<DataEdicion> ediciones, DataEdicion edicionAgtual, List<String> previas, List<String> progs) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horas = horas;
        this.creditos = creditos;
        this.fechaRegistro = fechaRegistro;
        this.URL = URL;
        this.ediciones = ediciones;
        this.edicionAgtual = edicionAgtual;
        this.previas = previas;
        this.progs = progs;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getHoras() {
        return horas;
    }

    public int getCreditos() {
        return creditos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getURL() {
        return URL;
    }

    public List<DataEdicion> getEdiciones() {
        return ediciones;
    }

    public DataEdicion getEdicionAgtual() {
        return edicionAgtual;
    }

    public List<String> getPrevias() {
        return previas;
    }

    public List<String> getProgs() {
        return progs;
    }
}
