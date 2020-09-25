package Entidades;

import Entidades.Edicion;
import Entidades.Instituto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-25T17:09:53")
@StaticMetamodel(Profesor.class)
public class Profesor_ extends Usuario_ {

    public static volatile SingularAttribute<Profesor, Instituto> instituto;
    public static volatile MapAttribute<Profesor, String, Edicion> ediciones;
    public static volatile ListAttribute<Profesor, Instituto> institutos;

}