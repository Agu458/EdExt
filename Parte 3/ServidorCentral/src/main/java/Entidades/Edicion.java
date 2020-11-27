package Entidades;

import DataTypes.DataComentario;
import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.EstadoInscripcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Edicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreEdicion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIni;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    private int cupos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;
    @ManyToMany
    @MapKey(name = "email")
    private Map<String, Profesor> profesores;
    @OneToOne
    private Curso curso;
    @OneToMany
    private List<InscripcionEdicion> inscriptos;
    private int aceptados;
    @OneToMany
    private List<Comentario> comentarios;
    private boolean activa;

    public Edicion() {
    }
    
    public Edicion(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<Profesor> profesores, Curso curso) {
        this.nombreEdicion = nombre;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cupos = cupos;
        this.fechaPublicacion = fechaPublicacion;
        this.profesores = new HashMap();
        this.comentarios = new ArrayList();
        for (Profesor p : profesores) {
            this.profesores.put(p.getEmail(), p);
        }
        this.curso = curso;
        this.aceptados = 0;
        this.activa = true;
    }

    public Long getId() {
        return id;
    }

    public String getNombreEdicion() {
        return nombreEdicion;
    }

    public void setNombre(String nombre) {
        this.nombreEdicion = nombre;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Map<String, Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Map<String, Profesor> profesores) {
        this.profesores = profesores;
    }

    public DataEdicion darDatos() {
        List<String> dps = new ArrayList();
        for (Profesor p : profesores.values()) {
            dps.add(p.getEmail());
        }

        String c = null;
        if (this.curso != null) {
            c = this.curso.getNombre();
        }

        List<DataComentario> coms = new ArrayList();
        for(Comentario comentario : comentarios){
            coms.add(comentario.darDatos());
        }
        
        return new DataEdicion(nombreEdicion, fechaIni, fechaFin, cupos, aceptados, fechaPublicacion, dps, c, coms, activa);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean estaInscripto(String email) {
        for (InscripcionEdicion aux : inscriptos) {
            if (aux.getEstudiante().getEmail() == email) {
                return true;
            }
        }
        return false;
    }

    public void agregarInscripcion(InscripcionEdicion inscripcion) {
        if (!this.estaInscripto(inscripcion.getEstudiante().getEmail())) {
            inscriptos.add(inscripcion);
        }
    }

    public List<String> darInscriptos() {
        List<String> insc = new ArrayList();
        for (InscripcionEdicion inscripcion : this.inscriptos) {
            if (inscripcion.getEstado() == EstadoInscripcion.INSCRIPTO) {
                insc.add(inscripcion.getEstudiante().getEmail());
            }
        }
        return insc;
    }

    public List<InscripcionEdicion> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(List<InscripcionEdicion> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public int getAceptados() {
        return aceptados;
    }

    public void setAceptados(int aceptados) {
        this.aceptados = aceptados;
    }

    

    public List<DataEstudiante> darAceptados() {
        List<DataEstudiante> insc = new ArrayList();
        for (InscripcionEdicion inscripcion : this.inscriptos) {
            if(inscripcion.getEstado() == EstadoInscripcion.ACEPTADO){
                insc.add((DataEstudiante) inscripcion.getEstudiante().darDatos());
            }
        }
        return insc;
    }

    public InscripcionEdicion darInscripcion(String email) {
        InscripcionEdicion ie = null;
        boolean encontre = false;
        for (InscripcionEdicion aux : inscriptos) {
            if (!encontre) {
                if (aux.getEstudiante().getEmail() == email) {
                    ie = aux;
                    encontre = true;
                }
            } else {
                break;
            }
        }
        return ie;
    }

    public void aceptarInscripciones(List<String> estudiantes) {
        for (InscripcionEdicion ie : inscriptos) {
            for (String s : estudiantes) {
                if (ie.getEstudiante().getEmail().equals(s)) {
                    ie.setEstado(EstadoInscripcion.ACEPTADO);
                    this.aceptados = this.aceptados + 1;
                } else {
                    if (ie.getEstado() != EstadoInscripcion.ACEPTADO) {
                        ie.setEstado(EstadoInscripcion.RECHASADO);
                    }
                }
            }
        }
    }

    public void cancelarInscripcionEstudiante(InscripcionEdicion inscripcion) {
        if (inscripcion != null) {
            inscriptos.remove(inscripcion);
        }
    }

    public boolean quedanCupos(int cupos) {
        if (this.cupos != 0) {
            if (this.aceptados < this.cupos) {
                if ((this.aceptados + cupos) <= this.cupos) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    //Comentarios de la edicion

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void agregarComentario(String estudiante, String cuerpo, Date fechaPublicacion, EntityManager em){
        Comentario comentario = new Comentario(estudiante, cuerpo, fechaPublicacion);
        this.comentarios.add(comentario);
        em.persist(comentario);
    }
}
