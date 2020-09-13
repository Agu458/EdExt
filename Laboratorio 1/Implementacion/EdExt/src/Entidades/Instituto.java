package Entidades;

import DataTypes.DataInstituto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    @OneToMany
    private Map<String,Curso> cursos;

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
    
    public DataInstituto darDatos(){
        List<String> c = new ArrayList();
        for(Curso curso : cursos.values()){
            c.add(curso.getNombre());
        }
        return new DataInstituto(nombre,c);
    }
}
