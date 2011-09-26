package controle;

import java.util.List;
import modelo.Fornecedor;
import modelo.Pedido;
import modelo.PedidoItem;
import modelo.Produto;

public class ControlePedido extends Controle {
    
    public String inserir(Pedido pedido) {
	tx.begin();
	em.persist(pedido);
	for(PedidoItem item : pedido.getPedidoItens()) {
	    item.setPedido(pedido);
	    em.persist(item);
	}
	tx.commit();
	return null;
    }
    
    public String deletar(int id) {
	tx.begin();
	Pedido pedido = em.find(Pedido.class, id);
	for(PedidoItem item : pedido.getPedidoItens()) {
	    item.setPedido(pedido);
	    em.remove(item);
	}
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
	for(PedidoItem item : pedido.getPedidoItens()) {
//	    item.setPedido(pedUpdate);
	    em.persist(item);
	}
	tx.commit();
	return null;
    }
    
    public Pedido getPedido(int id) {
	tx.begin();
	Pedido pedido = em.find(Pedido.class, id);
	tx.commit();
	return pedido;
    }
    
    public PedidoItem getItem(int id) {
	tx.begin();
	PedidoItem item = em.find(PedidoItem.class, id);
	tx.commit();
	return item;
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
    
    public List<Produto> listaDeProdutos() {
	tx.begin();
	List<Produto> produtos = em.createQuery("from Produto").getResultList();
	tx.commit();
	return produtos;
    }
    
}
