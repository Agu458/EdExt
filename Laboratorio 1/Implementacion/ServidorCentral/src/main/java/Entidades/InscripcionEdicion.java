
package Entidades;

import DataTypes.DataInscripcionEdicion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class InscripcionEdicion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private Edicion edicion;

    public InscripcionEdicion() {
    }

    public InscripcionEdicion(Date fecha, Edicion edicion) {
        this.fecha = fecha;
        this.edicion = edicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }
    
    public DataInscripcionEdicion darDatos(){
        return new DataInscripcionEdicion(id, fecha, edicion.getNombreEdicion());
    }
}
