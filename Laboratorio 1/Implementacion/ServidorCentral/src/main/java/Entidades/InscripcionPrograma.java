
package Entidades;

import DataTypes.DataInscripcionPrograma;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class InscripcionPrograma implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private ProgramaFormacion programa;

    public InscripcionPrograma() {
    }

    public InscripcionPrograma(Date fecha, ProgramaFormacion programa) {
        this.fecha = fecha;
        this.programa = programa;
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

    public ProgramaFormacion getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaFormacion programa) {
        this.programa = programa;
    }
    
    public DataInscripcionPrograma darDatos(){
        return new DataInscripcionPrograma(id, fecha, programa.getNombre());
    }
}
