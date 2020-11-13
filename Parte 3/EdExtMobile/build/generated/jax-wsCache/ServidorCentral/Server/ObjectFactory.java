
package Server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataEdicion_QNAME = new QName("http://Servidor/", "dataEdicion");
    private final static QName _DataProfesor_QNAME = new QName("http://Servidor/", "dataProfesor");
    private final static QName _DataProgramaFormacion_QNAME = new QName("http://Servidor/", "dataProgramaFormacion");
    private final static QName _DataCurso_QNAME = new QName("http://Servidor/", "dataCurso");
    private final static QName _DataEstudiante_QNAME = new QName("http://Servidor/", "dataEstudiante");
    private final static QName _DataUsuario_QNAME = new QName("http://Servidor/", "dataUsuario");
    private final static QName _DataInscripcionEdicion_QNAME = new QName("http://Servidor/", "dataInscripcionEdicion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataEstudiante }
     * 
     */
    public DataEstudiante createDataEstudiante() {
        return new DataEstudiante();
    }

    /**
     * Create an instance of {@link DataEstudiante.InscripcionProgramas }
     * 
     */
    public DataEstudiante.InscripcionProgramas createDataEstudianteInscripcionProgramas() {
        return new DataEstudiante.InscripcionProgramas();
    }

    /**
     * Create an instance of {@link DataEstudiante.InscripcionEdiciones }
     * 
     */
    public DataEstudiante.InscripcionEdiciones createDataEstudianteInscripcionEdiciones() {
        return new DataEstudiante.InscripcionEdiciones();
    }

    /**
     * Create an instance of {@link DataProfesor }
     * 
     */
    public DataProfesor createDataProfesor() {
        return new DataProfesor();
    }

    /**
     * Create an instance of {@link DataProfesor.Ediciones }
     * 
     */
    public DataProfesor.Ediciones createDataProfesorEdiciones() {
        return new DataProfesor.Ediciones();
    }

    /**
     * Create an instance of {@link DataEdicion }
     * 
     */
    public DataEdicion createDataEdicion() {
        return new DataEdicion();
    }

    /**
     * Create an instance of {@link DataProgramaFormacion }
     * 
     */
    public DataProgramaFormacion createDataProgramaFormacion() {
        return new DataProgramaFormacion();
    }

    /**
     * Create an instance of {@link DataInscripcionEdicion }
     * 
     */
    public DataInscripcionEdicion createDataInscripcionEdicion() {
        return new DataInscripcionEdicion();
    }

    /**
     * Create an instance of {@link DataCurso }
     * 
     */
    public DataCurso createDataCurso() {
        return new DataCurso();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link Lista }
     * 
     */
    public Lista createLista() {
        return new Lista();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link DataEstudiante.InscripcionProgramas.Entry }
     * 
     */
    public DataEstudiante.InscripcionProgramas.Entry createDataEstudianteInscripcionProgramasEntry() {
        return new DataEstudiante.InscripcionProgramas.Entry();
    }

    /**
     * Create an instance of {@link DataEstudiante.InscripcionEdiciones.Entry }
     * 
     */
    public DataEstudiante.InscripcionEdiciones.Entry createDataEstudianteInscripcionEdicionesEntry() {
        return new DataEstudiante.InscripcionEdiciones.Entry();
    }

    /**
     * Create an instance of {@link DataProfesor.Ediciones.Entry }
     * 
     */
    public DataProfesor.Ediciones.Entry createDataProfesorEdicionesEntry() {
        return new DataProfesor.Ediciones.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataEdicion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataEdicion")
    public JAXBElement<DataEdicion> createDataEdicion(DataEdicion value) {
        return new JAXBElement<DataEdicion>(_DataEdicion_QNAME, DataEdicion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataProfesor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataProfesor")
    public JAXBElement<DataProfesor> createDataProfesor(DataProfesor value) {
        return new JAXBElement<DataProfesor>(_DataProfesor_QNAME, DataProfesor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataProgramaFormacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataProgramaFormacion")
    public JAXBElement<DataProgramaFormacion> createDataProgramaFormacion(DataProgramaFormacion value) {
        return new JAXBElement<DataProgramaFormacion>(_DataProgramaFormacion_QNAME, DataProgramaFormacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataCurso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataCurso")
    public JAXBElement<DataCurso> createDataCurso(DataCurso value) {
        return new JAXBElement<DataCurso>(_DataCurso_QNAME, DataCurso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataEstudiante }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataEstudiante")
    public JAXBElement<DataEstudiante> createDataEstudiante(DataEstudiante value) {
        return new JAXBElement<DataEstudiante>(_DataEstudiante_QNAME, DataEstudiante.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataUsuario")
    public JAXBElement<DataUsuario> createDataUsuario(DataUsuario value) {
        return new JAXBElement<DataUsuario>(_DataUsuario_QNAME, DataUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataInscripcionEdicion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "dataInscripcionEdicion")
    public JAXBElement<DataInscripcionEdicion> createDataInscripcionEdicion(DataInscripcionEdicion value) {
        return new JAXBElement<DataInscripcionEdicion>(_DataInscripcionEdicion_QNAME, DataInscripcionEdicion.class, null, value);
    }

}
