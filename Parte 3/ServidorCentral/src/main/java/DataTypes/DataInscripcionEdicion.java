
package DataTypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInscripcionEdicion {
    private Long id;
    private Date fecha;
    private DataEdicion edicion;
    private EstadoInscripcion estado;
    private float calificacion;
    private String estudiante;
    private Integer inscripcionesPrevias;
    private String urlVideo;
    private Boolean aprobado;
    private Date fechaAprobado;

    public DataInscripcionEdicion() {
    }

    public DataInscripcionEdicion(Long id, Date fecha, DataEdicion edicion, EstadoInscripcion estado, float calificacion, String estudiante, Integer inscripcionesPrevias, String urlVideo, Boolean aprobado, Date fechaAprobado) {
        this.id = id;
        this.fecha = fecha;
        this.edicion = edicion;
        this.estado = estado;
        this.calificacion = calificacion;
        this.estudiante = estudiante;
        this.inscripcionesPrevias = inscripcionesPrevias;
        this.urlVideo = urlVideo;
        this.aprobado = aprobado;
        this.fechaAprobado = fechaAprobado;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public DataEdicion getEdicion() {
        return edicion;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public Integer getInscripcionesPrevias() {
        return inscripcionesPrevias;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public Date getFechaAprobado() {
        return fechaAprobado;
    }
    
}
