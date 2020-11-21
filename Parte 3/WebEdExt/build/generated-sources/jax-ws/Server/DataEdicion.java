
package Server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataEdicion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataEdicion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaIni" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cupos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="aceptados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="profesores" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="curso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataEdicion", propOrder = {
    "nombre",
    "fechaIni",
    "fechaFin",
    "cupos",
    "aceptados",
    "fechaPublicacion",
    "profesores",
    "curso"
})
public class DataEdicion {

    protected String nombre;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaIni;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFin;
    protected int cupos;
    protected int aceptados;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPublicacion;
    @XmlElement(nillable = true)
    protected List<String> profesores;
    protected String curso;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIni.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaIni() {
        return fechaIni;
    }

    /**
     * Define el valor de la propiedad fechaIni.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaIni(XMLGregorianCalendar value) {
        this.fechaIni = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Define el valor de la propiedad fechaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFin(XMLGregorianCalendar value) {
        this.fechaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad cupos.
     * 
     */
    public int getCupos() {
        return cupos;
    }

    /**
     * Define el valor de la propiedad cupos.
     * 
     */
    public void setCupos(int value) {
        this.cupos = value;
    }

    /**
     * Obtiene el valor de la propiedad aceptados.
     * 
     */
    public int getAceptados() {
        return aceptados;
    }

    /**
     * Define el valor de la propiedad aceptados.
     * 
     */
    public void setAceptados(int value) {
        this.aceptados = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPublicacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Define el valor de la propiedad fechaPublicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPublicacion(XMLGregorianCalendar value) {
        this.fechaPublicacion = value;
    }

    /**
     * Gets the value of the profesores property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profesores property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfesores().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProfesores() {
        if (profesores == null) {
            profesores = new ArrayList<String>();
        }
        return this.profesores;
    }

    /**
     * Obtiene el valor de la propiedad curso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Define el valor de la propiedad curso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurso(String value) {
        this.curso = value;
    }

}
