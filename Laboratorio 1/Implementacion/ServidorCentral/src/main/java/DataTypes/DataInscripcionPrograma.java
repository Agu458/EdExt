
package DataTypes;

import java.util.Date;

public class DataInscripcionPrograma {
    private Long id;
    private Date fecha;
    private String programa;

    public DataInscripcionPrograma(Long id, Date fecha, String programa) {
        this.id = id;
        this.fecha = fecha;
        this.programa = programa;
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getPrograma() {
        return programa;
    }
    
}
