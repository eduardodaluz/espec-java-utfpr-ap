package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pacote1.Estudante;

public class TestConn {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaWSPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudante estudante = new Estudante(10, "Eduardo");
        em.persist(estudante);
        em.getTransaction().commit();
    }
    
}
