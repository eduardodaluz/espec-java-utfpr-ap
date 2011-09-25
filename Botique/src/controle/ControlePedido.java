package controle;

import java.util.List;
import modelo.Fornecedor;
import modelo.Pedido;

public class ControlePedido extends Controle {
    
    public String inserir(Pedido pedido) {
	tx.begin();
	em.persist(pedido);
	tx.commit();
	return null;
    }
    
    public String deletar(int id) {
	tx.begin();
	Pedido pedido = em.find(Pedido.class, id);
	em.remove(pedido);
	tx.commit();
	return null;
    }
    
    public String atualizar(Pedido pedido) {
	tx.begin();
	Pedido pedUpdate = em.find(Pedido.class, pedido.getId());
	pedUpdate.setNumero(pedido.getNumero());
	pedUpdate.setDtPedido(pedido.getDtPedido());
	pedUpdate.setFornecedor(pedido.getFornecedor());
	tx.commit();
	return null;
    }
    
    public Pedido getPedido(int id) {
	tx.begin();
	Pedido pedido = em.find(Pedido.class, id);
	tx.commit();
	return pedido;
    }
    
    public List<Pedido> listaDePedidos() {
	tx.begin();
	List<Pedido> pedidos = em.createQuery("from Pedido").getResultList();
	tx.commit();
	return pedidos;
    }
    
    public List<Fornecedor> listaDeFornecedores() {
	tx.begin();
	List<Fornecedor> fornecedores = em.createQuery("from Fornecedor").getResultList();
	tx.commit();
	return fornecedores;
    }
}
