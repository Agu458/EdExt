package Entidades;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataProgramaFormacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @OneToMany
    private List<Curso> previas;
    @ManyToMany(mappedBy = "cursos")
    private List<ProgramaFormacion> programas;

    public Curso() {
    }

    public Curso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<Curso> previas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horas = horas;
        this.creditos = creditos;
        this.fechaRegistro = fechaRegistro;
        this.URL = URL;
        this.previas = previas;
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

    public void altaEdicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<Profesor> p, EntityManager em) {
        Edicion e = new Edicion(nombre, fechaIni, fechaFin, cupos, fechaPublicacion, p);
        em.persist(e);
        ediciones.add(e);
    }

    public Edicion getEdicionActual() {
        return edicionActual;
    }

    public void setEdicionActual(Edicion edicionActual) {
        this.edicionActual = edicionActual;
    }

    public List<Curso> getPrevias() {
        return previas;
    }

    public void setPrevias(List<Curso> previas) {
        this.previas = previas;
    }

    public DataEdicion darActual() {
        return edicionActual.darDatos();
    }

    public List<ProgramaFormacion> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaFormacion> programas) {
        this.programas = programas;
    }

    public DataCurso darDatos() {

        List<DataEdicion> edis = new ArrayList();
        for (Edicion ed : ediciones) {
            DataEdicion de = ed.darDatos();
            edis.add(de);
        }

        List<String> progs = new ArrayList();
        for (ProgramaFormacion pf : programas) {
            progs.add(pf.getNombre());
        }

        List<String> prevs = new ArrayList();
        for (Curso c : previas) {
            prevs.add(c.getNombre());
        }
        
        DataEdicion actual = null;
        if(edicionActual != null){
            actual = edicionActual.darDatos();
        }

        return new DataCurso(nombre, descripcion, duracion, horas, creditos, fechaRegistro, URL, prevs, edis, actual, progs);
    }
}
