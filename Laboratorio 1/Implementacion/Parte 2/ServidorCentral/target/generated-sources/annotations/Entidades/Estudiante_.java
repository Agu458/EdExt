package Entidades;

import Entidades.InscripcionEdicion;
import Entidades.InscripcionPrograma;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-25T17:09:53")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ extends Usuario_ {

    public static volatile MapAttribute<Estudiante, String, InscripcionEdicion> inscripcionEdiciones;
    public static volatile MapAttribute<Estudiante, String, InscripcionPrograma> inscripcionProgramas;

}