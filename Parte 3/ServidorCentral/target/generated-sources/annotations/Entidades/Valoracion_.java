package Entidades;

import Entidades.Curso;
import Entidades.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:18:03")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Estudiante> estudiante;
    public static volatile SingularAttribute<Valoracion, Curso> curso;
    public static volatile SingularAttribute<Valoracion, Double> valoracion;
    public static volatile SingularAttribute<Valoracion, Long> id;

}