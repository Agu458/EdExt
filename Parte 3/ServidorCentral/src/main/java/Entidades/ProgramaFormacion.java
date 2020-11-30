package Entidades;

import DataTypes.DataProgramaFormacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class ProgramaFormacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    @ManyToMany
    private List<Curso> cursos;
    private String descripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIni;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    @OneToMany
    private List<Categoria> categorias;
    private List<InscripcionPrograma> inscriptos;

    public ProgramaFormacion() {
    }

    public ProgramaFormacion(String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.inscriptos = new ArrayList();
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
    
    public void agregarCurso(Curso c){
        cursos.add(c);
        for(Categoria cat : c.getCategorias()){
            String nombre = cat.getNombre();
            if(!caonteieneCategoria(nombre)){
                categorias.add(cat);
            }
        }
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
    
    public boolean estaInscripto(String email) {
        for (InscripcionPrograma aux : inscriptos) {
            if (aux.getEstudiante().getEmail() == email) {
                return true;
            }
        }
        return false;
    }
    
    public List<String> darInscriptos(){
        List<String> result = new ArrayList();
        for(InscripcionPrograma ip : inscriptos){
            result.add(ip.getEstudiante().getEmail());
        }
        return result;
    }

    public void agregarInscripcion(InscripcionPrograma inscripcion) {
        if (!this.estaInscripto(inscripcion.getEstudiante().getEmail())) {
            inscriptos.add(inscripcion);
        }
    }
    
    public DataProgramaFormacion darDatos(){
        List<String> c = new ArrayList();
        for(Curso cur : cursos){
            String dp = cur.getNombre();
            c.add(dp);
        }
        
        List<String> cats = new ArrayList();
        for(Categoria cat : categorias){
            cats.add(cat.getNombre());
        }
        
        List<String> insc = new ArrayList();
        for(InscripcionPrograma ip : inscriptos){
            insc.add(ip.getEstudiante().getEmail());
        }
        
        return new DataProgramaFormacion(nombre, c, descripcion, fechaIni, fechaFin, cats, insc);
    }
    
    public boolean conteneCurso(String curso){
        boolean encontre = false;
        Iterator it = cursos.iterator();
        while(it.hasNext() && !encontre){
            Curso c = (Curso) it.next();
            if(c.getNombre() == curso){
                encontre = true;
            }
        }
        return encontre;
    }
    
    public boolean caonteieneCategoria(String cat){
        boolean encontre = false;
        Iterator it = categorias.iterator();
        while(it.hasNext() && !encontre){
            Categoria c = (Categoria) it.next();
            if(c.getNombre() == cat){
                encontre = true;
            }
        }
        return encontre;
    }
}
