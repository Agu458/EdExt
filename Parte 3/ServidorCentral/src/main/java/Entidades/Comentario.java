/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DataTypes.DataComentario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Agustín
 */
@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estudiante;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPublicacion;
    private String cuerpo;
    private List<Comentario> respuestas;

    public Comentario() {
    }

    // Constructor del comentario
    public Comentario(String estudiante, String cuerpo, Date fechaPublicacion) {
        this.estudiante = estudiante;
        this.cuerpo = cuerpo;
        this.fechaPublicacion = fechaPublicacion;
        this.respuestas = new ArrayList();
    }
    
    public Long getId() {
        return id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Comentario> respuestas) {
        this.respuestas = respuestas;
    }
    
    public DataComentario darDatos(){
        List<DataComentario> coms = new ArrayList();
        for(Comentario resp : respuestas){
            coms.add(resp.darDatos());
        }
        return new DataComentario(id, estudiante, fechaPublicacion, cuerpo, coms);
    }
}
