package Logica;

import Entidades.Estudiante;
import Entidades.Instituto;
import Entidades.Profesor;
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
    public void alataEstudiante(String nombre, String apellido, String email, Date fechaNacimiento){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Estudiante es = new Estudiante(nombre,apellido,email,fechaNacimiento);
            em.persist(es);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
    
    public void altaProfesor(List<String> inst, String nombre, String apellido, String email, Date fechaNacimiento){
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
            Profesor p = new Profesor(institutos, nombre, apellido, email, fechaNacimiento);
            em.persist(p);
            em.getTransaction().commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            em.getTransaction().rollback();
        }
        em.close();
    }
}
