package Entidades;

import Entidades.Comentario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-29T14:02:01")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> estudiante;
    public static volatile ListAttribute<Comentario, Comentario> respuestas;
    public static volatile SingularAttribute<Comentario, Long> id;
    public static volatile SingularAttribute<Comentario, Date> fechaPublicacion;
    public static volatile SingularAttribute<Comentario, String> cuerpo;

}