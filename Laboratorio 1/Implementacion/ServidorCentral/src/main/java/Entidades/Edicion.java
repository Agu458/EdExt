
package Entidades;

import DataTypes.DataEdicion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Edicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombreEdicion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIni;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    private int cupos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;
    @ManyToMany
    @MapKey(name = "email")
    private Map<String, Profesor> profesores;
    @OneToOne
    private Curso curso;

    public Edicion() {
    }

    public Edicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<Profesor> profesores, Curso curso) {
        this.nombreEdicion = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = new HashMap();
        for(Profesor p : profesores){
            this.profesores.put(p.getEmail(), p);
        }
        this.curso = curso;
    }

    public String getNombreEdicion() {
        return nombreEdicion;
    }

    public void setNombre(String nombre) {
        this.nombreEdicion = nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Map<String, Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Map<String, Profesor> profesores) {
        this.profesores = profesores;
    }

    public DataEdicion darDatos(){
        List<String> dps = new ArrayList();
        for(Profesor p : profesores.values()){
            dps.add(p.getEmail());
        }
        
        String c = null;
        if(this.curso != null){
            c = this.curso.getNombre();
        }
        
        return new DataEdicion(nombreEdicion, fechaIni, fechaFin, cupos, fechaPublicacion, dps, c);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}