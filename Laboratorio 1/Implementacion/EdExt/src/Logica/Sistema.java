package Logica;

import DataTypes.DataCurso;
import DataTypes.DataEdicion;
import DataTypes.DataEstudiante;
import DataTypes.DataProfesor;
import DataTypes.DataProgramaFormacion;
import DataTypes.DataUsuario;
import DataTypes.RET;
import Entidades.Curso;
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
    public RET altaInstituto(String nombre) {
        EntityManager em = emf.createEntityManager();
        Instituto i = em.find(Instituto.class, nombre);
        if (i != null) {
            em.close();
            return RET.NOMBRE_INVALIDO;
        } else {
            try {
                em.getTransaction().begin();
                i = new Instituto(nombre);
                em.persist(i);
                em.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                em.getTransaction().rollback();
            }
            em.close();
            return RET.OK;
        }
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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    public void altaEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante es = new Estudiante(nick, nombre, apellido, email, fechaNacimiento);
            em.persist(es);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

    @Override
    public void altaProfesor(String instituto, String nick, String nombre, String apellido, String email, Date fechaNacimiento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto insti = em.find(Instituto.class, instituto);
            if (insti == null) {
                insti = new Instituto(instituto);
                em.persist(insti);
            }
            Profesor p = new Profesor(insti, nick, nombre, apellido, email, fechaNacimiento);
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return u;
    }

    public DataUsuario darDatosUsuario(String email) {
        EntityManager em = emf.createEntityManager();
        DataUsuario u = null;
        try {
            em.getTransaction().begin();
            Usuario usu = em.find(Usuario.class, email);
            u = usu.darDatos();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return u;
    }

    public void modificarUsuario(DataUsuario du, int tipo) {
        EntityManager em = emf.createEntityManager();
        if (tipo == 1) {
            DataEstudiante de = (DataEstudiante) du;
            try {
                em.getTransaction().begin();
                Estudiante e = (Estudiante) em.find(Usuario.class, de.getEmail());
                e.setNick(de.getNick());
                e.setNombre(de.getNombre());
                e.setApellido(de.getApellido());
                e.setEmail(de.getEmail());
                e.setFechaNacimiento(de.getFechaNacimiento());
                em.persist(e);
                em.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                em.getTransaction().rollback();
            }
            em.close();
        } else {
            DataProfesor dp = (DataProfesor) du;
            try {
                em.getTransaction().begin();
                Profesor p = (Profesor) em.find(Usuario.class, dp.getEmail());
                p.setNick(dp.getNick());
                p.setNombre(dp.getNombre());
                p.setApellido(dp.getApellido());
                p.setEmail(dp.getEmail());
                p.setFechaNacimiento(dp.getFechaNacimiento());
                p.setInstituto(em.find(Instituto.class, dp.getInstituto().getNombre()));
                em.persist(p);
                em.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    // Curso
    public void altaCurso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<String> previas, String instituto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            if (i != null) {
                List<Curso> prevs = new ArrayList();
                for (String p : previas) {
                    Curso c = em.find(Curso.class, p);
                    if (c != null) {
                        prevs.add(c);
                    }
                }
                Curso curso = new Curso(nombre, descripcion, duracion, horas, creditos, fechaRegistro, URL, prevs);
                em.persist(curso);
                i.agregarCurso(curso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

    public List<String> listarCursosInstituto(String instituto) {
        EntityManager em = emf.createEntityManager();
        List<String> cursos = new ArrayList();
        try {
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, instituto);
            for (Curso c : i.getCursos().values()) {
                cursos.add(c.getNombre());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return cursos;
    }

    public DataCurso darDatosCurso(String nombre) {
        EntityManager em = emf.createEntityManager();
        DataCurso dc = null;
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, nombre);
            if (c != null) {
                dc = c.darDatos();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return dc;
    }

    public void altaEdicionCurso(String nombre, Date fechaIni, Date fechaFin, int cupos, Date fechaPublicacion, List<String> profesores, String curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso c = em.find(Curso.class, curso);
            if (c != null) {
                List<Profesor> p = new ArrayList();
                for (String s : profesores) {
                    Profesor pro = em.find(Profesor.class, s);
                    p.add(pro);
                }
                c.altaEdicion(nombre, fechaIni, fechaFin, cupos, fechaPublicacion, p, em);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return de;
    }

    public void inscripcionEdicion(String curso, String estudiante, Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante e = em.find(Estudiante.class, estudiante);
            if (e != null) {
                Curso c = em.find(Curso.class, curso);
                if (c != null) {
                    e.inscribirEdicion(c.getEdicionActual(), fecha);
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

    public void altaProgramaFormacion(String nombre, String descripcion, Date fechaIni, Date fechaFin) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = new ProgramaFormacion(nombre, descripcion, fechaIni, fechaFin);
            em.persist(pf);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return dpf;
    }

    public void agregarCursoAPrograma(String nombre, String nombreCurso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProgramaFormacion pf = em.find(ProgramaFormacion.class, nombre);
            Curso c = em.find(Curso.class, nombreCurso);
            if (pf != null && c != null) {
                pf.agregarCurso(c);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return dpf;
    }
}
