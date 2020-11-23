package Entidades;

import Entidades.InscripcionEdicion;
import Entidades.InscripcionPrograma;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-23T11:43:47")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ extends Usuario_ {

    public static volatile ListAttribute<Estudiante, InscripcionEdicion> inscripcionEdiciones;
    public static volatile ListAttribute<Estudiante, InscripcionPrograma> inscripcionProgramas;

}