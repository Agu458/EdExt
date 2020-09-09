package Logica;

import DataTypes.DataUsuario;
import java.util.List;

public interface ISistema {

    public void altaInstituto(String nombre);

    public void bajaInstituto(String nombre);
    
    public List<String> listarInstitutos();
    
    public boolean validarEmail(String email);
    
    public boolean validarNick(String nick);

    public void altaUsuario(DataUsuario du);
    
    public List<String> listarUsuarios();
    
    public DataUsuario darDatosUsuario(String email);
}
