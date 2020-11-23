
package Server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataValoracion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataValoracion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantValoraciones" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valoracion" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cant5" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cant4" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cant3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cant2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cant1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataValoracion", propOrder = {
    "cantValoraciones",
    "valoracion",
    "cant5",
    "cant4",
    "cant3",
    "cant2",
    "cant1"
})
public class DataValoracion {

    protected int cantValoraciones;
    protected double valoracion;
    protected int cant5;
    protected int cant4;
    protected int cant3;
    protected int cant2;
    protected int cant1;

    /**
     * Obtiene el valor de la propiedad cantValoraciones.
     * 
     */
    public int getCantValoraciones() {
        return cantValoraciones;
    }

    /**
     * Define el valor de la propiedad cantValoraciones.
     * 
     */
    public void setCantValoraciones(int value) {
        this.cantValoraciones = value;
    }

    /**
     * Obtiene el valor de la propiedad valoracion.
     * 
     */
    public double getValoracion() {
        return valoracion;
    }

    /**
     * Define el valor de la propiedad valoracion.
     * 
     */
    public void setValoracion(double value) {
        this.valoracion = value;
    }

    /**
     * Obtiene el valor de la propiedad cant5.
     * 
     */
    public int getCant5() {
        return cant5;
    }

    /**
     * Define el valor de la propiedad cant5.
     * 
     */
    public void setCant5(int value) {
        this.cant5 = value;
    }

    /**
     * Obtiene el valor de la propiedad cant4.
     * 
     */
    public int getCant4() {
        return cant4;
    }

    /**
     * Define el valor de la propiedad cant4.
     * 
     */
    public void setCant4(int value) {
        this.cant4 = value;
    }

    /**
     * Obtiene el valor de la propiedad cant3.
     * 
     */
    public int getCant3() {
        return cant3;
    }

    /**
     * Define el valor de la propiedad cant3.
     * 
     */
    public void setCant3(int value) {
        this.cant3 = value;
    }

    /**
     * Obtiene el valor de la propiedad cant2.
     * 
     */
    public int getCant2() {
        return cant2;
    }

    /**
     * Define el valor de la propiedad cant2.
     * 
     */
    public void setCant2(int value) {
        this.cant2 = value;
    }

    /**
     * Obtiene el valor de la propiedad cant1.
     * 
     */
    public int getCant1() {
        return cant1;
    }

    /**
     * Define el valor de la propiedad cant1.
     * 
     */
    public void setCant1(int value) {
        this.cant1 = value;
    }

}
