package botique;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Fornecedor;
import modelo.Pedido;
import modelo.PedidoItem;
import modelo.Produto;
    
public class Botique {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BotiquePU");
	EntityManager em = emf.createEntityManager();
	try {
	    em.getTransaction().begin();
	    Pedido pedido = new Pedido(7771312, new Date(), em.find(Fornecedor.class, 4));
	    pedido.addItem(new PedidoItem(em.find(Produto.class, 4), 20));
	    pedido.addItem(new PedidoItem(em.find(Produto.class, 7), 200));
	    em.persist(pedido);
	    for(PedidoItem item : pedido.getPedidoItens()) {
		item.setPedido(pedido);
		em.persist(item);
	    }
	    em.getTransaction().commit();
	} catch (Exception e) {
	    em.getTransaction().rollback();
	}
    }
}
