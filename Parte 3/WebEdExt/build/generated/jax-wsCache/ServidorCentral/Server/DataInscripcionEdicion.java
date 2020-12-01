
package Server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dataInscripcionEdicion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataInscripcionEdicion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="edicion" type="{http://Servidor/}dataEdicion" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://Servidor/}estadoInscripcion" minOccurs="0"/>
 *         &lt;element name="calificacion" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="estudiante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inscripcionesPrevias" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aprobado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fechaAprobado" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataInscripcionEdicion", propOrder = {
    "id",
    "fecha",
    "edicion",
    "estado",
    "calificacion",
    "estudiante",
    "inscripcionesPrevias",
    "urlVideo",
    "aprobado",
    "fechaAprobado"
})
public class DataInscripcionEdicion {

    protected Long id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    protected DataEdicion edicion;
    protected EstadoInscripcion estado;
    protected float calificacion;
    protected String estudiante;
    protected Integer inscripcionesPrevias;
    protected String urlVideo;
    protected Boolean aprobado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAprobado;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad edicion.
     * 
     * @return
     *     possible object is
     *     {@link DataEdicion }
     *     
     */
    public DataEdicion getEdicion() {
        return edicion;
    }

    /**
     * Define el valor de la propiedad edicion.
     * 
     * @param value
     *     allowed object is
     *     {@link DataEdicion }
     *     
     */
    public void setEdicion(DataEdicion value) {
        this.edicion = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoInscripcion }
     *     
     */
    public EstadoInscripcion getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoInscripcion }
     *     
     */
    public void setEstado(EstadoInscripcion value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad calificacion.
     * 
     */
    public float getCalificacion() {
        return calificacion;
    }

    /**
     * Define el valor de la propiedad calificacion.
     * 
     */
    public void setCalificacion(float value) {
        this.calificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estudiante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstudiante() {
        return estudiante;
    }

    /**
     * Define el valor de la propiedad estudiante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstudiante(String value) {
        this.estudiante = value;
    }

    /**
     * Obtiene el valor de la propiedad inscripcionesPrevias.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInscripcionesPrevias() {
        return inscripcionesPrevias;
    }

    /**
     * Define el valor de la propiedad inscripcionesPrevias.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInscripcionesPrevias(Integer value) {
        this.inscripcionesPrevias = value;
    }

    /**
     * Obtiene el valor de la propiedad urlVideo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Define el valor de la propiedad urlVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

    /**
     * Obtiene el valor de la propiedad aprobado.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAprobado() {
        return aprobado;
    }

    /**
     * Define el valor de la propiedad aprobado.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAprobado(Boolean value) {
        this.aprobado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAprobado.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAprobado() {
        return fechaAprobado;
    }

    /**
     * Define el valor de la propiedad fechaAprobado.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAprobado(XMLGregorianCalendar value) {
        this.fechaAprobado = value;
    }

}
