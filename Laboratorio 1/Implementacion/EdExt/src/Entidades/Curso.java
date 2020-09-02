package Entidades;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    private String descripcion;
    private int duracion;
    private int horas;
    private int creditos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;
    private String URL;
    @OneToMany
    private List<Edicion> ediciones;
    @OneToOne
    private Edicion edicionActual;

    public Curso() {
    }

    public Curso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<Edicion> ediciones, Edicion edicionAgtual) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horas = horas;
        this.creditos = creditos;
        this.fechaRegistro = fechaRegistro;
        this.URL = URL;
        this.ediciones = ediciones;
        this.edicionActual = edicionActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(List<Edicion> ediciones) {
        this.ediciones = ediciones;
    }

    public Edicion getEdicionAgtual() {
        return edicionActual;
    }

    public void setEdicionActual(Edicion edicionActual) {
        this.edicionActual = edicionActual;
    }

    private DataCurso darDatos(){
        List<DataEdicion> e = new ArrayList();
        for(Edicion ed : ediciones){
            DataEdicion de = ed.darDatos();
            e.add(de);
        }
        return new DataCurso(nombre, descripcion, duracion, horas, creditos, fechaRegistro, URL, e, edicionActual.darDatos());
    }
}
