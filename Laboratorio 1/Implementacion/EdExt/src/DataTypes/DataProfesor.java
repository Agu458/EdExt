package DataTypes;

import java.util.Date;
import java.util.List;

public class DataProfesor extends DataUsuario{
    
    private List<DataInstituto> institutos;

    public DataProfesor(List<DataInstituto> institutos, Long id, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(id, nick, nombre, apellido, email, fechaNacimiento);
        this.institutos = institutos;
    }

}
