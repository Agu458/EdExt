/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustín
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataComentario {
    
    private String estudiante;
    private String cuerpo;
    private List<DataComentario> respuestas;

    public DataComentario() {
    }

    public DataComentario(String estudiante, String cuerpo, List<DataComentario> respuestas) {
        this.estudiante = estudiante;
        this.cuerpo = cuerpo;
        this.respuestas = respuestas;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public List<DataComentario> getRespuestas() {
        return respuestas;
    }
    
    
}
