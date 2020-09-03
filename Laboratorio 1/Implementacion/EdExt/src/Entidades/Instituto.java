package Entidades;

import DataTypes.DataInstituto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;
    private List<Curso> cursos;

    public Instituto() {
    }

    public Instituto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public DataInstituto darDatos(){
        List<String> c = new ArrayList();
        for(Curso curso : cursos){
            c.add(curso.getNombre());
        }
        return new DataInstituto(nombre,c);
    }
}
