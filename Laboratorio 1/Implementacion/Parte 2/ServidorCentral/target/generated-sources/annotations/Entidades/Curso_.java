package Entidades;

import Entidades.Curso;
import Entidades.Edicion;
import Entidades.Instituto;
import Entidades.ProgramaFormacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T13:28:21")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> descripcion;
    public static volatile ListAttribute<Curso, Curso> previas;
    public static volatile SingularAttribute<Curso, Integer> horas;
    public static volatile SingularAttribute<Curso, Instituto> instituto;
    public static volatile MapAttribute<Curso, String, Edicion> ediciones;
    public static volatile SingularAttribute<Curso, Date> fechaRegistro;
    public static volatile ListAttribute<Curso, ProgramaFormacion> programas;
    public static volatile SingularAttribute<Curso, Integer> duracion;
    public static volatile SingularAttribute<Curso, Integer> creditos;
    public static volatile SingularAttribute<Curso, String> nombre;
    public static volatile SingularAttribute<Curso, Edicion> edicionActual;
    public static volatile SingularAttribute<Curso, String> URL;

}