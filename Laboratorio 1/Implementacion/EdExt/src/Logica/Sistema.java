package Logica;

import DataTypes.DataUsuario;
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

public class Sistema extends ISistema {

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
    public void altaInstituto(String nombre){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Instituto i = new Instituto(nombre);
            em.persist(i);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
    
    public void bajaInstituto(String nombre){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Instituto i = em.find(Instituto.class, nombre);
            em.remove(i);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
    
    // Ususario
    public void alataEstudiante(String nick, String nombre, String apellido, String email, Date fechaNacimiento){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Estudiante es = new Estudiante(nick, nombre,apellido,email,fechaNacimiento);
            em.persist(es);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
    
    public void altaProfesor(List<String> inst, String nick, String nombre, String apellido, String email, Date fechaNacimiento){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            List<Instituto> institutos = new ArrayList();
            for(String i : inst){
                Instituto insti = em.find(Instituto.class, i);
                if(insti != null){
                    institutos.add(insti);
                }
                else{
                    insti = new Instituto(i);
                    em.persist(insti);
                    institutos.add(insti);
                }
            }
            Profesor p = new Profesor(institutos, nick, nombre, apellido, email, fechaNacimiento);
            em.persist(p);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
    
    public List<DataUsuario> listarUsuarios(){
        EntityManager em = emf.createEntityManager();
        List<DataUsuario> u = new ArrayList();
        try{
            em.getTransaction().begin();
            List usuarios = em.createQuery("SELECT u FROM Usuarios u").getResultList();
            for(Object o : usuarios){
                if(o instanceof Estudiante){
                    Estudiante e = (Estudiante) o;
                    u.add(e.darDatos());
                }
                else{
                    if(o instanceof Profesor){
                        Profesor p = (Profesor) o;
                        u.add(p.darDatos());
                    }
                    else{
                        Usuario usu = (Usuario) o;
                        u.add(usu.darDatos());
                    }
                }
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
        return u;
    }
    
    public void modificarUsuario(DataUsuario du){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, du.getId());
            u.setNick(du.getNick());
            u.setNombre(du.getNombre());
            u.setApellido(du.getApellido());
            u.setEmail(du.getEmail());
            u.setFechaNacimiento(du.getFechaNacimiento());
            em.persist(u);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
}
