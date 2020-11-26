/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustín
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataValoracion {

    private Long id;
    private String estudiante;
    private Double valoracion;
    private String curso;

    public DataValoracion() {
    }

    public DataValoracion(Long id, String estudiante, Double valoracion, String curso) {
        this.id = id;
        this.estudiante = estudiante;
        this.valoracion = valoracion;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public String getCurso() {
        return curso;
    }
    
}
