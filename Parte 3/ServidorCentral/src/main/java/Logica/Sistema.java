package Logica;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.DataInscripcionEdicion;
import DataTypes.DataProfesor;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import DataTypes.DataValoracion;
import Entidades.Categoria;
import Entidades.Comentario;
import Entidades.Curso;
import Entidades.Edicion;
import Entidades.Estudiante;
import Entidades.InscripcionEdicion;
import Entidades.InscripcionPrograma;
import Entidades.Instituto;
import Entidades.Profesor;
import Entidades.ProgramaFormacion;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class Sistema implements ISistema {

    private static Sistema instance = null;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EdExtPU");

    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    // Instituto
    @Override
    public boolean validarNombreInstituto(String nombre) {
        EntityManager em = emf.createEntityManager();
        Instituto i = em.find(Instituto.class, nombre);
        return (i == null);
    }

    @Override
    public void altaInstituto(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto i = new Instituto(nombre);
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();

    }

    @Override
    public void bajaInstituto(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, nombre);
            em.remove(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<String> listarInstitutos() {
        EntityManager em = emf.createEntityManager();
        List<String> instis = new ArrayList();
        try {
            em.getTransaction().begin();
            List institutos = em.createQuery("SELECT i FROM Instituto i").getResultList();
            for (Object o : institutos) {
                Instituto i = (Instituto) o;
                instis.add(i.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return instis;
    }

    // Ususario
    @Override
    public boolean validarEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, email);
        return (u == null);
    }

    @Override
    public boolean validarNick(String nick) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nick = :nick");
        query.setParameter("nick", nick);
        List l = query.getResultList();
        return (l.isEmpty());
    }

    @Override
    public void altaUsuario(DataUsuario du) {
        EntityManager em = emf.createEntityManager();
        if (du instanceof DataEstudiante) {
            DataEstudiante de = (DataEstudiante) du;
            try {
                em.getTransaction().begin();
                Estudiante es = new Estudiante(de.getNick(), de.getNombre(), de.getApellido(), de.getEmail(), de.getFechaNacimiento(), de.getContrasenia(), de.getimagen());
                em.persist(es);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
            em.close();
        } else {
            DataProfesor dp = (DataProfesor) du;
            try {
                em.getTransaction().begin();
                Instituto insti = em.find(Instituto.class, dp.getInstituto());
                if (insti == null) {
                    this.altaInstituto(dp.getInstituto());
                    insti = em.find(Instituto.class, dp.getInstituto());
                }
                Profesor p = new Profesor(insti, dp.getNick(), dp.getNombre(), dp.getApellido(), dp.getEmail(), dp.getFechaNacimiento(), dp.getContrasenia(), dp.getimagen());
                insti.agregarProfesor(p);
                em.persist(p);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override
    public List<String> listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        List<String> u = new ArrayList();
        try {
            em.getTransaction().begin();
            List usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
            for (Object o : usuarios) {
                Usuario usu = (Usuario) o;
                u.add(usu.getEmail());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return u;
    }

    @Override
    public DataUsuario darDatosUsuario(String email) {
        EntityManager em = emf.createEntityManager();
        DataUsuario u = null;
        try {
            em.getTransaction().begin();
            Usuario usu = em.find(Usuario.class, email);
            u = usu.darDatos();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return u;
    }

    @Override
    public List<String> listarEstudiantes() {
        EntityManager em = emf.createEntityManager();
        List<String> ests = new ArrayList();
        try {
            em.getTransaction().begin();
            List aux = em.createQuery("SELECT e FROM Estudiante e").getResultList();
            for (Object o : aux) {
                Usuario u = (Usuario) o;
                ests.add(u.getEmail());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ests;
    }

    @Override
    public List<String> listarProfesores() {
        EntityManager em = emf.createEntityManager();
        List<String> ests = new ArrayList();
        try {
            em.getTransaction().begin();
            List aux = em.createQuery("SELECT p FROM Profesor p").getResultList();
            for (Object o : aux) {
                Usuario u = (Usuario) o;
                ests.add(u.getEmail());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ests;
    }

    @Override
    public List<String> listarProfesoresInstituto(String instituto) {
        EntityManager em = emf.createEntityManager();
        List<String> p = new ArrayList();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            if (i != null) {
                p = i.darProfesores();
            }
            em.getTransaction().rollback();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
        return p;
    }

    @Override
    public void modificarUsuario(DataUsuario du) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, du.getEmail());
            u.setNombre(du.getNombre());
            u.setApellido(du.getApellido());
            u.setFechaNacimiento(du.getFechaNacimiento());
            u.setimagen(du.getimagen());
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    // Curso
    @Override
    public boolean validarNombreCurso(String nombre) {
        EntityManager em = emf.createEntityManager();
        Curso c = em.find(Curso.class, nombre);
        return (c == null);
    }

    @Override
    public void altaCurso(DataCurso dc, String instituto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            if (i != null) {
                List<Curso> prevs = new ArrayList();
                for (String p : dc.getPrevias()) {
                    Curso c = em.find(Curso.class, p);
                    if (c != null) {
                        prevs.add(c);
                    }
                }
                List<Categoria> cats = new ArrayList();
                for (String s : dc.getCategorias()) {
                    Categoria cat = em.find(Categoria.class, s);
                    if (cat != null) {
                        cats.add(cat);
                    }
                }
                Curso curso = new Curso(dc.getNombre(), dc.getDescripcion(), dc.getDuracion(), dc.getHoras(), dc.getCreditos(), dc.getFechaRegistro(), dc.getURL(), prevs, i, cats);
                em.persist(curso);
                i.agregarCurso(curso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<String> listarCursosInstituto(String instituto) {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = null;
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            cursos = i.darCursos();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

    @Override
    public List<String> listarCursosConEdicionInstituto(String instituto) {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = null;
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            cursos = i.darCursosConEdicion();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

    @Override
    public List<String> listarCursos() {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = new ArrayList();
        try {
            em.getTransaction().begin();
            String q = "SELECT c FROM Curso c";
            List cur = em.createQuery(q).getResultList();
            for (Object o : cur) {
                Curso c = (Curso) o;
                cursos.add(c.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

    @Override
    public DataCurso darDatosCurso(String nombre) {
        EntityManager em = emf.createEntityManager();
        DataCurso dc = null;
        if (nombre != null) {
            try {
                em.getTransaction().begin();
                Curso c = em.find(Curso.class, nombre);
                if (c != null) {
                    dc = c.darDatos();
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
        em.close();
        return dc;
    }

    @Override
    public boolean validarNombreEdicion(String curso, String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            if (c != null) {
                if (c.validarNombreEdicion(nombre)) {
                    em.getTransaction().commit();
                    em.close();
                    return true;
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return false;
    }

    @Override
    public void altaEdicionCurso(DataEdicion de, String curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            if (c != null) {
                List<Profesor> p = new ArrayList();
                for (String s : de.getProfesores()) {
                    Profesor pro = em.find(Profesor.class, s);
                    p.add(pro);
                }
                Edicion e = c.altaEdicion(de.getNombre(), de.getFechaIni(), de.getFechaFin(), de.getCupos(), de.getFechaPublicacion(), p, em);
                if (e != null) {
                    for (Profesor pro : p) {
                        pro.agregarEdicion(e);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public DataEdicion darEdicionActual(String curso) {
        EntityManager em = emf.createEntityManager();
        DataEdicion de = null;
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            if (c != null) {
                de = c.darActual();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return de;
    }

    @Override
    public void inscripcionEdicion(String curso, String estudiante, Date fecha, String urlVideo) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (estudiante != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (curso != null) {
                    Curso cur = em.find(Curso.class, curso);
                    if (est != null && cur != null) {
                        Edicion ed = cur.getEdicionActual();
                        if (ed != null && ed.isActiva()) {
                            InscripcionEdicion inscripcion = est.inscribirseAUnaEdicion(ed, fecha, urlVideo);
                            cur.getEdicionActual().agregarInscripcion(inscripcion);
                            em.persist(inscripcion);
                        }
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void inscripcionAPrograma(String programa, String estudiante, Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (programa != null) {
                ProgramaFormacion prog = em.find(ProgramaFormacion.class, programa);
                if (estudiante != null) {
                    Estudiante est = em.find(Estudiante.class, estudiante);
                    if (prog != null && est != null) {
                        InscripcionPrograma inscripcion = est.inscribirseAUnPrograma(prog, fecha);
                        prog.agregarInscripcion(inscripcion);
                        for (Curso c : prog.getCursos()) {
                            this.inscripcionEdicion(c.getNombre(), estudiante, fecha, "");
                        }
                        em.persist(inscripcion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<String> listarEdiciones(String curso) {
        EntityManager em = emf.createEntityManager();
        List<String> ediciones = new ArrayList();
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            ediciones = c.darEdiciones();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return ediciones;
    }

    @Override
    public DataEdicion darDatosEdicion(String curso, String nombreEdicion) {
        EntityManager em = emf.createEntityManager();
        DataEdicion edicion = null;
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            edicion = c.darDatosEdicion(nombreEdicion);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return edicion;
    }

    @Override
    public boolean validarNombrePrograma(String nombre) {
        EntityManager em = emf.createEntityManager();
        ProgramaFormacion pf = em.find(ProgramaFormacion.class, nombre);
        return (pf == null);
    }

    @Override
    public void altaProgramaFormacion(DataProgramaFormacion dpf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = new ProgramaFormacion(dpf.getNombre(), dpf.getDescripcion(), dpf.getFechaIni(), dpf.getFechaFin());
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<String> listarProgramas() {
        EntityManager em = emf.createEntityManager();
        List<String> dpf = new ArrayList();
        try {
            em.getTransaction().begin();
            List programas = em.createQuery("SELECT p FROM ProgramaFormacion p").getResultList();
            for (Object o : programas) {
                ProgramaFormacion pf = (ProgramaFormacion) o;
                dpf.add(pf.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return dpf;
    }

    @Override
    public boolean conteneCurso(String nombre, String curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = em.find(ProgramaFormacion.class, nombre);
            if (pf != null && pf.conteneCurso(curso)) {
                em.getTransaction().commit();
                em.close();
                return true;
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return false;
    }

    @Override
    public void agregarCursoAPrograma(String nombre, String nombreCurso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = em.find(ProgramaFormacion.class, nombre);
            Curso c = em.find(Curso.class, nombreCurso);
            if (pf != null && c != null) {
                if (c.getEdicionActual() != null) {
                    pf.agregarCurso(c);
                    for (String s : pf.darInscriptos()) {
                        this.inscripcionEdicion(c.getNombre(), s, new Date(), "");
                    }
                    c.agregarPrograma(pf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public DataProgramaFormacion darProgramaFormacion(String nombre) {
        EntityManager em = emf.createEntityManager();
        DataProgramaFormacion dpf = null;
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = em.find(ProgramaFormacion.class, nombre);
            if (pf != null) {
                dpf = pf.darDatos();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return dpf;
    }

    // Categorias
    @Override
    public Boolean validarNombreCategoria(String nombre) {
        EntityManager em = emf.createEntityManager();
        Categoria cat = em.find(Categoria.class, nombre);
        em.close();
        return (cat == null);
    }

    @Override
    public void altaCategoria(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Categoria cat = new Categoria(nombre);
            em.persist(cat);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<String> listarCursosCategoria(String nombre) {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = new ArrayList();
        try {
            em.getTransaction().begin();
            String q = "SELECT c FROM Curso c";
            List cur = em.createQuery(q).getResultList();
            for (Object o : cur) {
                Curso c = (Curso) o;
                if (c.conteieneCategoria(nombre)) {
                    cursos.add(c.getNombre());
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

    @Override
    public List<String> listarCategorias() {
        EntityManager em = emf.createEntityManager();
        List<String> categorias = new ArrayList();
        try {
            em.getTransaction().begin();
            List cats = em.createQuery("SELECT c FROM Categoria c").getResultList();
            for (Object o : cats) {
                Categoria cat = (Categoria) o;
                categorias.add(cat.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return categorias;
    }

    @Override
    public List<DataInscripcionEdicion> listarInscriptosAEdicion(String curso, String edicion) {
        EntityManager em = emf.createEntityManager();
        List<DataInscripcionEdicion> inscriptos = null;
        try {
            em.getTransaction().begin();
            Curso cur = em.find(Curso.class, curso);
            if (cur != null) {
                inscriptos = cur.darInscriptosEdicion(edicion);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return inscriptos;
    }

    @Override
    public void aceptarInscripciones(String curso, String edicion, List<String> estudiantes) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso cur = em.find(Curso.class, curso);
            if (cur != null) {
                cur.aceptarInscripciones(edicion, estudiantes);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<DataInscripcionEdicion> listarAceptadosAEdicion(String curso, String edicion) {
        EntityManager em = emf.createEntityManager();
        List<DataInscripcionEdicion> aceptados = null;
        try {
            em.getTransaction().begin();
            Curso cur = em.find(Curso.class, curso);
            if (cur != null) {
                aceptados = cur.darAceptadosAEdicion(edicion);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return aceptados;
    }

    //Permite a un estudiante desistir de una inscripcion
    @Override
    public void desistirDeInscripcion(String estudiante, String edicion, String curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (estudiante != null && edicion != null && curso != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (est != null) {
                    est.cancelarInscripcionEdicion(edicion, curso, em);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public DataInscripcionEdicion darDatosInscripcionEdicion(String estudiante, String edicion, String curso) {
        EntityManager em = emf.createEntityManager();
        DataInscripcionEdicion die = null;
        try {
            em.getTransaction().begin();
            if (estudiante != null && edicion != null && curso != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (est != null) {
                    die = est.darDatosInscripcionEdicion(curso, edicion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
        return die;
    }

    @Override
    public void agregarComentarioEdicionCurso(String curso, String edicion, String estudiante, String cuerpo, Date fechaPublicacion, Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (id != null) {
                Comentario com = em.find(Comentario.class, id);
                if(com != null){
                    Comentario coment = new Comentario(estudiante, cuerpo, fechaPublicacion);
                    com.agregarRespuesta(coment);
                    em.persist(coment);
                }
            } else {
                if (curso != null && edicion != null && estudiante != null && cuerpo != null && fechaPublicacion != null) {
                    Curso c = em.find(Curso.class, curso);
                    if (c != null) {
                        c.agregarComentarioEdicion(edicion, estudiante, cuerpo, fechaPublicacion, em);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    public List<DataEdicion> edicionesEstudiante(String estudiante) {
        EntityManager em = emf.createEntityManager();
        List<DataEdicion> result = new ArrayList();
        try {
            em.getTransaction().begin();
            if (estudiante != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (est != null) {
                    result = est.darInscripcionesActivasEdicion();
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<String> cursosEstudiante(String estudiante) {
        EntityManager em = emf.createEntityManager();
        List<String> result = new ArrayList();
        try {
            em.getTransaction().begin();
            if (estudiante != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (est != null) {
                    result = est.darInscripcionesActivasCurso();
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public void valorarCurso(String curso, Double valoracion, String estudiante) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (estudiante != null && curso != null && valoracion != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                Curso cur = em.find(Curso.class, curso);
                if (est != null) {
                    est.valorarCurso(cur, valoracion, em);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public DataValoracion darValoracionEst(String curso, String estudiante) {
        EntityManager em = emf.createEntityManager();
        DataValoracion result = null;
        try {
            em.getTransaction().begin();
            if (estudiante != null && curso != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                result = est.darDatosValoracion(curso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
        return result;
    }

    @Override
    public Boolean sePuedeFinalizar(String curso, String edicion) {
        EntityManager em = emf.createEntityManager();
        Boolean ok = false;
        try {
            em.getTransaction().begin();
            if (curso != null && edicion != null) {
                Curso cur = em.find(Curso.class, curso);
                if (cur != null) {
                    Edicion ed = cur.darEdicion(edicion);
                    if (ed != null) {
                        ok = ed.sePuedeFinalizar();
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
        return ok;
    }

    @Override
    public void finalizarEdicion(String curso, String edicion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (curso != null && edicion != null) {
                Curso cur = em.find(Curso.class, curso);
                if (cur != null) {
                    Edicion ed = cur.darEdicion(edicion);
                    if (ed != null) {
                        ed.finalizar();
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public void calificarEstudiante(String estudiante, String curso, String edicion, Float calificacion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (estudiante != null && curso != null && edicion != null && calificacion != null) {
                Estudiante est = em.find(Estudiante.class, estudiante);
                if (est != null) {
                    est.calificar(curso, edicion, calificacion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public List<DataInscripcionEdicion> darDatosCertificado(String estudiante, String programa) {
        EntityManager em = emf.createEntityManager();
        List<DataInscripcionEdicion> result = null;
        try {
            em.getTransaction().begin();
            ProgramaFormacion prog = em.find(ProgramaFormacion.class, programa);
            if (prog != null) {
                result = prog.darDatosCertificado(estudiante);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        em.close();
        return result;
    }

    public void agregarVisita(String curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            if (curso != null) {
                Curso cur = em.find(Curso.class, curso);
                if (cur != null) {
                    cur.setVisitas(cur.getVisitas() + 1);
                }
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<String> listarCursosTendencia() {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = new ArrayList();
        try {
            em.getTransaction().begin();

            //Traer cursos de la db
            String q = "SELECT c FROM Curso c";
            List cur = em.createQuery(q).getResultList();

            //Ordenar cursos por visitas
            cur.sort(Comparator.comparing(Curso::getVisitas).reversed());

            //Dar datos de los cursos
            for (Object o : cur) {
                Curso c = (Curso) o;
                cursos.add(c.getNombre());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }
}
