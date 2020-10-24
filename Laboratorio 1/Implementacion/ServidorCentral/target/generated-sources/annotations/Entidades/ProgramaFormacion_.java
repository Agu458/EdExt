package Entidades;

import Entidades.Categoria;
import Entidades.Curso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-10-24T14:32:54")
@StaticMetamodel(ProgramaFormacion.class)
public class ProgramaFormacion_ { 

    public static volatile SingularAttribute<ProgramaFormacion, String> descripcion;
    public static volatile ListAttribute<ProgramaFormacion, Curso> cursos;
    public static volatile SingularAttribute<ProgramaFormacion, Date> fechaIni;
    public static volatile ListAttribute<ProgramaFormacion, Categoria> categorias;
    public static volatile SingularAttribute<ProgramaFormacion, String> nombre;
    public static volatile SingularAttribute<ProgramaFormacion, Date> fechaFin;

}