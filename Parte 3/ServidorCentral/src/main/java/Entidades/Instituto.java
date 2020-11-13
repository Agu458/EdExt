package Entidades;

import DataTypes.DataInstituto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    @OneToMany
    @MapKey(name = "nombre")
    private Map<String,Curso> cursos;
    @OneToMany(mappedBy = "instituto")
    private List<Profesor> profesores;

    public Instituto() {
    }

    public Instituto(String nombre) {
        this.nombre = nombre;
        cursos = new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, Curso> getCursos() {
        return cursos;
    }
    
    public List<String> darCursos(){
        List<String> c = new ArrayList();
        for (Curso curso : cursos.values()) {
            c.add(curso.getNombre());
        }
        return c;
    }

    public void setCursos(Map<String, Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void agregarCurso(Curso c){
        if(!cursos.containsKey(c.getNombre())){
            cursos.put(c.getNombre(), c);
        }
    }
    
    public void agregarProfesor(Profesor p){
        if(p != null){
            this.profesores.add(p);
        }
    }
    
    public List<String> darProfesores(){
        List<String> p = new ArrayList();
        for (Profesor profesor : profesores) {
            p.add(profesor.getEmail());
        }
        return p;
    }
    
    public DataInstituto darDatos(){
        List<String> c = new ArrayList();
        for(Curso curso : cursos.values()){
            c.add(curso.getNombre());
        }
        return new DataInstituto(nombre,c);
    }
}
