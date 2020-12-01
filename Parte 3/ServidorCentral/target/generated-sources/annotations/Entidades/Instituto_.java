package Entidades;

import Entidades.Curso;
import Entidades.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:18:03")
@StaticMetamodel(Instituto.class)
public class Instituto_ { 

    public static volatile MapAttribute<Instituto, String, Curso> cursos;
    public static volatile ListAttribute<Instituto, Profesor> profesores;
    public static volatile SingularAttribute<Instituto, String> nombre;

}