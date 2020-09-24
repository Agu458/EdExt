package DataTypes;

import java.util.List;

public class DataInstituto {
    
    private String nombre;
    private List<String> cursos;

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
