package Entidades;

import Entidades.ProgramaFormacion;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-20T10:37:12")
@StaticMetamodel(InscripcionPrograma.class)
public class InscripcionPrograma_ { 

    public static volatile SingularAttribute<InscripcionPrograma, Usuario> estudiante;
    public static volatile SingularAttribute<InscripcionPrograma, Date> fecha;
    public static volatile SingularAttribute<InscripcionPrograma, ProgramaFormacion> programa;
    public static volatile SingularAttribute<InscripcionPrograma, Long> id;

}