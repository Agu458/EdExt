package DataTypes;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DataInstituto {
    
    private String nombre;
    private List<String> cursos;

    public DataInstituto() {
    }

    public DataInstituto(String nombre, List<String> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCursos() {
        return cursos;
    }
    
}
