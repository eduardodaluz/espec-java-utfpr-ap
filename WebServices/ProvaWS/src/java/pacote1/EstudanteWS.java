/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote1;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.commons.logging.Log;

/**
 *
 * @author eduardo
 */
@WebService(serviceName = "EstudanteWS")
public class EstudanteWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "prova")
    public String prova(@WebParam(name = "classificacao") int classificacao, @WebParam(name = "nome") String nome) {
        String status = "Registro não inserido.";
        /*
         * Toda lógica de inserção vai aqui...
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaWSPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Estudante estudante = new Estudante( classificacao, nome);
            em.persist(estudante);
            em.getTransaction().commit();
            status = "Registro inserido!";
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getStackTrace());
        }
        return status;
    }
    
}
