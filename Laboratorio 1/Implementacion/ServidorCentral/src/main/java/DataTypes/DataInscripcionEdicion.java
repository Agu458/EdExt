
package DataTypes;

import java.util.Date;

public class DataInscripcionEdicion {
    private Long id;
    private Date fecha;
    private String edicion;

    public DataInscripcionEdicion(Long id, Date fecha, String edicion) {
        this.id = id;
        this.fecha = fecha;
        this.edicion = edicion;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEdicion() {
        return edicion;
    }
    
}
