package Entidades;

import Entidades.Comentario;
import Entidades.Curso;
import Entidades.InscripcionEdicion;
import Entidades.Profesor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-24T10:04:04")
@StaticMetamodel(Edicion.class)
public class Edicion_ { 

    public static volatile MapAttribute<Edicion, String, Profesor> profesores;
    public static volatile SingularAttribute<Edicion, Date> fechaIni;
    public static volatile SingularAttribute<Edicion, Curso> curso;
    public static volatile SingularAttribute<Edicion, Integer> aceptados;
    public static volatile SingularAttribute<Edicion, Integer> cupos;
    public static volatile SingularAttribute<Edicion, Date> fechaPublicacion;
    public static volatile SingularAttribute<Edicion, Date> fechaFin;
    public static volatile ListAttribute<Edicion, Comentario> comentarios;
    public static volatile SingularAttribute<Edicion, String> nombreEdicion;
    public static volatile ListAttribute<Edicion, InscripcionEdicion> inscriptos;

}