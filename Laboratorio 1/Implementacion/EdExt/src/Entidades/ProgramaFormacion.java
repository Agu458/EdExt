package Entidades;

import DataTypes.DataProgramaFormacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class ProgramaFormacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    @OneToMany
    private List<Curso> cursos;
    private String descripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIni;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    public ProgramaFormacion() {
    }

    public ProgramaFormacion(String nombre, List<Curso> cursos, String descripcion, Date fechaIni, Date fechaFin) {
        this.nombre = nombre;
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    public DataProgramaFormacion darDatos(){
        List<String> c = new ArrayList();
        for(Curso cur : cursos){
            String dp = cur.getNombre();
            c.add(dp);
        }
        return new DataProgramaFormacion(nombre, c, descripcion, fechaIni, fechaFin);
    }
}
