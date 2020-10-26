package Logica;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.DataProfesor;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import Entidades.Categoria;
import Entidades.Curso;
import Entidades.Edicion;
import Entidades.Estudiante;
import Entidades.Instituto;
import Entidades.Profesor;
import Entidades.ProgramaFormacion;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;

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
                Estudiante es = new Estudiante(de.getNick(), de.getNombre(), de.getApellido(), de.getEmail(), de.getFechaNacimiento(), de.getContrasenia() ,de.getimagen());
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
                    insti = new Instituto(dp.getInstituto());
                    em.persist(insti);
                }
                Profesor p = new Profesor(insti, dp.getNick(), dp.getNombre(), dp.getApellido(), dp.getEmail(), dp.getFechaNacimiento(), dp.getContrasenia() ,dp.getimagen());
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
    public List<String> listarProfesoresInstituto(String instituto){
        EntityManager em = emf.createEntityManager();
        List<String> p = new ArrayList();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            if(i != null){
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
                for(String s : dc.getCategorias()){
                    Categoria cat = em.find(Categoria.class, s);
                    if(cat != null){
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
    public void inscripcionEdicion(String curso, String estudiante, Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante e = em.find(Estudiante.class, estudiante);
            if (e != null) {
                Curso c = em.find(Curso.class, curso);
                if (c != null) {
                    e.inscribirEdicion(c.getEdicionActual(), fecha, em);
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
    public boolean conteneCurso(String nombre, String curso){
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
                pf.agregarCurso(c);
                c.agregarPrograma(pf);
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
    public Boolean validarNombreCategoria(String nombre){
        EntityManager em = emf.createEntityManager();
        Categoria cat = em.find(Categoria.class, nombre);
        return (cat == null);
    }
    
    @Override
    public void altaCategoria(String nombre){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Categoria cat = new Categoria(nombre);
            em.persist(cat);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public List<String> listarCursosCategoria(String nombre){
        EntityManager em = emf.createEntityManager();
        List<String> cursos = new ArrayList();
        try {
            em.getTransaction().begin();
            String q = "SELECT c FROM Curso c";
            List cur = em.createQuery(q).getResultList();
            for (Object o : cur) {
                Curso c = (Curso) o;
                if(c.conteieneCategoria(nombre)){
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
    public List<String> listarCategorias(){
        EntityManager em = emf.createEntityManager();
        List<String> categorias = new ArrayList();
        try {
            em.getTransaction().begin();
            List cats = em.createQuery("SELECT c FROM Categoria c").getResultList();
            for(Object o : cats){
                Categoria cat = (Categoria) o;
                categorias.add(cat.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return categorias;
    }
}
