package Entidades;

import DataTypes.EstadoInscripcion;
import Entidades.Edicion;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-02T11:45:56")
@StaticMetamodel(InscripcionEdicion.class)
public class InscripcionEdicion_ { 

    public static volatile SingularAttribute<InscripcionEdicion, Usuario> estudiante;
    public static volatile SingularAttribute<InscripcionEdicion, Date> fecha;
    public static volatile SingularAttribute<InscripcionEdicion, EstadoInscripcion> estado;
    public static volatile SingularAttribute<InscripcionEdicion, Float> calificacion;
    public static volatile SingularAttribute<InscripcionEdicion, String> urlVideo;
    public static volatile SingularAttribute<InscripcionEdicion, Integer> inscripcionesPrevias;
    public static volatile SingularAttribute<InscripcionEdicion, Boolean> aprobado;
    public static volatile SingularAttribute<InscripcionEdicion, Long> id;
    public static volatile SingularAttribute<InscripcionEdicion, Date> fechaAprobado;
    public static volatile SingularAttribute<InscripcionEdicion, Edicion> edicion;

}