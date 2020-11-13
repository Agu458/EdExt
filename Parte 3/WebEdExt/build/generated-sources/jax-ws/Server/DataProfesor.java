
package Server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataProfesor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataProfesor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Servidor/}dataUsuario">
 *       &lt;sequence>
 *         &lt;element name="instituto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ediciones" type="{http://Servidor/}dataEdicion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataProfesor", propOrder = {
    "instituto",
    "ediciones"
})
public class DataProfesor
    extends DataUsuario
{

    protected String instituto;
    @XmlElement(nillable = true)
    protected List<DataEdicion> ediciones;

    /**
     * Obtiene el valor de la propiedad instituto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstituto() {
        return instituto;
    }

    /**
     * Define el valor de la propiedad instituto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstituto(String value) {
        this.instituto = value;
    }

    /**
     * Gets the value of the ediciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ediciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdiciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataEdicion }
     * 
     * 
     */
    public List<DataEdicion> getEdiciones() {
        if (ediciones == null) {
            ediciones = new ArrayList<DataEdicion>();
        }
        return this.ediciones;
    }

}
