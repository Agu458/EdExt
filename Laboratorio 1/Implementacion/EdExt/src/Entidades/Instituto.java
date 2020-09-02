package Entidades;

import DataTypes.DataInstituto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nombre;

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
        return new DataInstituto(nombre);
    }
}
