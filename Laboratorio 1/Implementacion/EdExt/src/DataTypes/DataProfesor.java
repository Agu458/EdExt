package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProfesor extends DataUsuario{
    
    private List<DataInstituto> institutos;

    public DataProfesor(List<DataInstituto> institutos, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super( nick, nombre, apellido, email, fechaNacimiento);
        this.institutos = institutos;
    }

    public List<DataInstituto> getInstitutos() {
        return institutos;
    }

}
