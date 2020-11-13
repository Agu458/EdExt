
package Server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataEstudiante complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataEstudiante">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Servidor/}dataUsuario">
 *       &lt;sequence>
 *         &lt;element name="inscripcionEdiciones" type="{http://Servidor/}dataInscripcionEdicion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inscripcionProgramas" type="{http://Servidor/}dataProgramaFormacion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataEstudiante", propOrder = {
    "inscripcionEdiciones",
    "inscripcionProgramas"
})
public class DataEstudiante
    extends DataUsuario
{

    @XmlElement(nillable = true)
    protected List<DataInscripcionEdicion> inscripcionEdiciones;
    @XmlElement(nillable = true)
    protected List<DataProgramaFormacion> inscripcionProgramas;

    /**
     * Gets the value of the inscripcionEdiciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inscripcionEdiciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripcionEdiciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataInscripcionEdicion }
     * 
     * 
     */
    public List<DataInscripcionEdicion> getInscripcionEdiciones() {
        if (inscripcionEdiciones == null) {
            inscripcionEdiciones = new ArrayList<DataInscripcionEdicion>();
        }
        return this.inscripcionEdiciones;
    }

    /**
     * Gets the value of the inscripcionProgramas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inscripcionProgramas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripcionProgramas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataProgramaFormacion }
     * 
     * 
     */
    public List<DataProgramaFormacion> getInscripcionProgramas() {
        if (inscripcionProgramas == null) {
            inscripcionProgramas = new ArrayList<DataProgramaFormacion>();
        }
        return this.inscripcionProgramas;
    }

}
