package persistencia;

import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Firebird {
    
    private EntityManager em;
    public static Firebird connControl = new Firebird();
    ResultSet resultSet;
    
    public Firebird() {
	em = Persistence.createEntityManagerFactory("BotiquePU").createEntityManager();

    }
    
    public EntityManager getEntityManager() {
	return em;
    }
    
}
