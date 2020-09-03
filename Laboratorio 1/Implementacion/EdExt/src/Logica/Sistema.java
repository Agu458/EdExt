package Logica;

import DataTypes.DataEstudiante;
import DataTypes.DataInstituto;
import DataTypes.DataProfesor;
import DataTypes.DataUsuario;
import Entidades.Curso;
import Entidades.Estudiante;
import Entidades.Instituto;
import Entidades.Profesor;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Sistema implements ISistema {

    private static Sistema instance = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("EdExtPU");

    private Sistema() {
    }

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    // Instituto
    public void altaInstituto(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instituto i = new Instituto(nombre);
            em.persist(i);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }

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

    // Ususario
    public void altaUsuario(DataUsuario du, int tipo) {
        EntityManager em = emf.createEntityManager();
        if (tipo == 1) {
            DataEstudiante de = (DataEstudiante) du;
            try {
                em.getTransaction().begin();
                Estudiante es = new Estudiante(de.getNick(), de.getNombre(), de.getApellido(), de.getEmail(), de.getFechaNacimiento());
                em.persist(es);
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
                List<Instituto> institutos = new ArrayList();
                for (DataInstituto i : dp.getInstitutos()) {
                    Instituto insti = em.find(Instituto.class, i.getNombre());
                    if (insti != null) {
                        institutos.add(insti);
                    } else {
                        insti = new Instituto(i.getNombre());
                        em.persist(insti);
                        institutos.add(insti);
                    }
                }
                Profesor p = new Profesor(institutos, dp.getNick(), dp.getNombre(), dp.getApellido(), dp.getEmail(), dp.getFechaNacimiento());
                em.persist(p);
                em.getTransaction().commit();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    public List<DataUsuario> listarUsuarios() {
        EntityManager em = emf.createEntityManager();
        List<DataUsuario> u = new ArrayList();
        try {
            em.getTransaction().begin();
            List usuarios = em.createQuery("SELECT u FROM Usuarios u").getResultList();
            for (Object o : usuarios) {
                if (o instanceof Estudiante) {
                    Estudiante e = (Estudiante) o;
                    u.add(e.darDatos());
                } else {
                    if (o instanceof Profesor) {
                        Profesor p = (Profesor) o;
                        u.add(p.darDatos());
                    } else {
                        Usuario usu = (Usuario) o;
                        u.add(usu.darDatos());
                    }
                }
            }
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
                Estudiante e = (Estudiante) em.find(Usuario.class, de.getId());
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
                Profesor p = (Profesor) em.find(Usuario.class, dp.getId());
                p.setNick(dp.getNick());
                p.setNombre(dp.getNombre());
                p.setApellido(dp.getApellido());
                p.setEmail(dp.getEmail());
                p.setFechaNacimiento(dp.getFechaNacimiento());
                for(DataInstituto di : dp.getInstitutos()){
                    Instituto i = em.find(Instituto.class, di.getNombre());
                    if(!p.tieneInstituto(i)){
                        p.agregarInstituto(i);
                    }
                }
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
    public void altaCurso(String nombre, String descripcion, int duracion, int horas, int creditos, Date fechaRegistro, String URL, List<String> previas){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Curso> p = new ArrayList();
            for(String s : previas){
                p.add(em.find(Curso.class, s));
            }
            Curso c = new Curso(nombre, descripcion, duracion, horas, creditos, fechaRegistro, URL, p);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
}
