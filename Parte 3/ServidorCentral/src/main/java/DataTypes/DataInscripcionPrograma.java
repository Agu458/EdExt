
package DataTypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInscripcionPrograma {
    private Long id;
    private Date fecha;
    private String programa;
    private String estudiante;
    private Boolean aprobado;
    
    public DataInscripcionPrograma() {
    }

    public DataInscripcionPrograma(Long id, Date fecha, String programa, String estudiante, Boolean aprobado) {
        this.id = id;
        this.fecha = fecha;
        this.programa = programa;
        this.estudiante = estudiante;
        this.aprobado = aprobado;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getPrograma() {
        return programa;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public Boolean getAprobado() {
        return aprobado;
    }
    
}
