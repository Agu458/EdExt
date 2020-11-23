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
public class DataValoracion {

    private int cantValoraciones;
    private double valoracion;
    private int cant5;
    private int cant4;
    private int cant3;
    private int cant2;
    private int cant1;

    public DataValoracion() {
    }

    public DataValoracion(List<Double> valoraciones) {
        this.cantValoraciones = valoraciones.size();
        this.cant1 = 0;
        this.cant2 = 0;
        this.cant3 = 0;
        this.cant4 = 0;
        this.cant5 = 0;
        Double suma = 0.0;
        for (Double d : valoraciones) {
            suma = suma + d;
            if (d >= 4.5) {
                this.cant5 = this.cant5 + 1;
            } else {
                if (d >= 3.5) {
                    this.cant4 = this.cant4 + 1;
                } else {
                    if (d >= 2.5) {
                        this.cant3 = this.cant3 + 1;
                    } else {
                        if (d >= 1.5) {
                            this.cant2 = this.cant2 + 1;
                        } else {
                            this.cant1 = this.cant1 + 1;
                        }
                    }
                }
            }
        }
        this.valoracion = (suma / this.cantValoraciones);
    }

    public int getCantValoraciones() {
        return cantValoraciones;
    }

    public double getValoracion() {
        return valoracion;
    }

    public int getCant5() {
        return cant5;
    }

    public int getCant4() {
        return cant4;
    }

    public int getCant3() {
        return cant3;
    }

    public int getCant2() {
        return cant2;
    }

    public int getCant1() {
        return cant1;
    }

}
