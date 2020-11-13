/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Agustín
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Lista {
    
    private List lista;

    public Lista() {
    }

    public Lista(List lista) {
        this.lista = lista;
    }

    public List getLista() {
        return lista;
    }
    
}
