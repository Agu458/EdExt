
package DataTypes;

import java.util.Date;

public class DataInscripcionEdicion {
    private Long id;
    private Date fecha;
    private DataEdicion edicion;
    private EstadoInscripcion estado;
    private float calificacion;
    private String estudiante;
    private Integer inscripcionesPrevias;

    public DataInscripcionEdicion(Long id, Date fecha, DataEdicion edicion, EstadoInscripcion estado, float calificacion, String estudiante, Integer inscripcionesPrevias) {
        this.id = id;
        this.fecha = fecha;
        this.edicion = edicion;
        this.estado = estado;
        this.calificacion = calificacion;
        this.estudiante = estudiante;
        this.inscripcionesPrevias = inscripcionesPrevias;
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
    
}
