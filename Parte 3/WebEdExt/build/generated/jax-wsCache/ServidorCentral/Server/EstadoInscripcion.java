
package Server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoInscripcion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoInscripcion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INSCRIPTO"/>
 *     &lt;enumeration value="RECHASADO"/>
 *     &lt;enumeration value="ACEPTADO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoInscripcion")
@XmlEnum
public enum EstadoInscripcion {

    INSCRIPTO,
    RECHASADO,
    ACEPTADO;

    public String value() {
        return name();
    }

    public static EstadoInscripcion fromValue(String v) {
        return valueOf(v);
    }

}
