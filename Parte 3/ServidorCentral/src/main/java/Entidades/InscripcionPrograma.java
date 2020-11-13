
package Entidades;

import DataTypes.DataInscripcionPrograma;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class InscripcionPrograma implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private ProgramaFormacion programa;
    private Usuario estudiante;

    public InscripcionPrograma() {
    }

    public InscripcionPrograma(Date fecha, ProgramaFormacion programa, Usuario estudiante) {
        this.fecha = fecha;
        this.programa = programa;
        this.estudiante = estudiante;
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

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }
    
    public DataInscripcionPrograma darDatos(){
        return new DataInscripcionPrograma(id, fecha, programa.getNombre(), estudiante.darDatos());
    }
}
