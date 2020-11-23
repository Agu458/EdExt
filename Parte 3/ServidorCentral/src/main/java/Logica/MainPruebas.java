/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataEdicion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Agustín
 */
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fabrica fab = Fabrica.getInstance();
        ISistema is = fab.getISistema();
        List profesores = new ArrayList();
        profesores.add("aguperaza458@gmail.com");
        DataEdicion de = new DataEdicion("BASE DE DATOS 2020", new Date(), new Date(), 2, new Date(), profesores);
        is.altaEdicionCurso(de, "BASE DE DATOS");
    }
    
}
