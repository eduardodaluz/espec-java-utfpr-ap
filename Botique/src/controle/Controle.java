package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import persistencia.Firebird;

public class Controle {
    
    EntityManager em;
    EntityTransaction tx;
    
    public Controle() {
	em = Firebird.connControl.getEntityManager();
	tx = em.getTransaction();
    }
    
}
