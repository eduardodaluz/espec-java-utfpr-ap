package tests;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import modelo.Produto;

public class TestConnection {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("BotiqueWebPU").createEntityManager();
        em.getTransaction().begin();
        Produto prod = new Produto("iPad");
        em.persist(prod);
        em.getTransaction().commit();
    }
    
}
