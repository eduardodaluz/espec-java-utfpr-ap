package botique;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Produto;
    
public class Botique {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BotiquePU");
	EntityManager em = emf.createEntityManager();
	try {
	    em.getTransaction().begin();
	    Produto prod1 = new Produto("Arroz");
	    em.persist(prod1);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    em.getTransaction().rollback();
	}
    }
}
