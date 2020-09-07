package Presentacion;

import DataTypes.RET;
import Logica.Fabrica;
import Logica.ISistema;
import javax.swing.JOptionPane;

public class Main {

    public static void mostrarMensaje(RET r){
        if(r != RET.OK){
            JOptionPane.showMessageDialog(null, r, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        ISistema is = Fabrica.getInstance().getISistema();
    }

}
