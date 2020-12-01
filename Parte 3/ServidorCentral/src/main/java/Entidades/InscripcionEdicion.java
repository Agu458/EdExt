
package Entidades;

import DataTypes.DataInscripcionEdicion;
import DataTypes.EstadoInscripcion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @OneToOne
    private Usuario estudiante;
    @Enumerated(EnumType.STRING)
    private EstadoInscripcion estado;
    private float calificacion;
    private Integer inscripcionesPrevias;
    private String urlVideo;
    private Boolean aprobado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAprobado;

    public InscripcionEdicion() {
    }

    public InscripcionEdicion(Date fecha, Edicion edicion, Usuario estudiante, String urlVideo) {
        this.fecha = fecha;
        this.edicion = edicion;
        this.estado = EstadoInscripcion.INSCRIPTO;
        this.calificacion = 0;
        this.estudiante = estudiante;
        this.inscripcionesPrevias = 0;
        this.urlVideo = urlVideo;
        this.aprobado = false;
        this.fechaAprobado = null;
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

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public Integer getInscripcionesPrevias() {
        return inscripcionesPrevias;
    }

    public void setInscripcionesPrevias(Integer inscripcionesPrevias) {
        this.inscripcionesPrevias = inscripcionesPrevias;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaAprobado() {
        return fechaAprobado;
    }

    public void setFechaAprobado(Date fechaAprobado) {
        this.fechaAprobado = fechaAprobado;
    }
    
    public DataInscripcionEdicion darDatos(){
        return new DataInscripcionEdicion(id, fecha, edicion.darDatos(), estado, calificacion, estudiante.getEmail(), inscripcionesPrevias, urlVideo, aprobado, fechaAprobado);
    }
}
