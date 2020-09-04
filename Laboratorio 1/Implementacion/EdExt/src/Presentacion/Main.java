package Presentacion;

import Logica.Fabrica;
import Logica.ISistema;

public class Main {

    public static void main(String[] args) {
        ISistema is = Fabrica.getInstance().getISistema();
    }

}
