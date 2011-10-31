 package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;
import modelo.Pedido;
import modelo.PedidoItem;
import modelo.Produto;

public class ControlePedido extends Controle {
    
    public String inserir(Pedido pedido) {
        try {
            tx.begin();
            em.persist(pedido);
            for(PedidoItem item : pedido.getPedidoItens()) {
                item.setPedido(pedido);
                em.persist(item);
            }
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        }
	return null;
    }
    
    public String deletar(int id) {
        try {
            tx.begin();
            Pedido pedido = em.find(Pedido.class, id);
            for(PedidoItem item : pedido.getPedidoItens()) {
                item.setPedido(pedido);
                em.remove(item);
            }
            em.remove(pedido);
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return null;
    }
    
    public String atualizar(Pedido pedido) {
        try {
            tx.begin();
            Pedido pedUpdate = em.find(Pedido.class, pedido.getId());
            pedUpdate.setNumero(pedido.getNumero());
            pedUpdate.setDtPedido(pedido.getDtPedido());
            pedUpdate.setFornecedor(pedido.getFornecedor());
            if(pedido.getPedidoItens() != null) {
                for(PedidoItem item : pedido.getPedidoItens()) {
                    item.setPedido(pedUpdate);
                    em.persist(item);
                }
            }
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        }
	return null;
    }
    
    public Pedido getPedido(int id) {
        Pedido pedido = new Pedido();
        try {
            tx.begin();
            pedido = em.find(Pedido.class, id);
            tx.commit();
        } catch(Exception e ) {
            tx.rollback();
        }
	return pedido;
    }
    
    public Produto getProduto(int id) {
        Produto prod = new Produto();
        try {
            tx.begin();
            prod = em.find(Produto.class, id);
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
        return prod;
    }
    
    public PedidoItem getItem(int id) {
        PedidoItem item = new PedidoItem();
        try {
            tx.begin();
            item = em.find(PedidoItem.class, id);
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return item;
    }
    
    public Fornecedor getFornecedor(int id) {
        Fornecedor forn = new Fornecedor();
        try {
            tx.begin();
            forn = em.find(Fornecedor.class, id);
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
        return forn;
    }
    
    public List<Pedido> listaDePedidos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            tx.begin();
            pedidos = em.createQuery("from Pedido").getResultList();
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return pedidos;
    }
    
    public List<Fornecedor> listaDeFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        try {
            tx.begin();
            fornecedores = em.createQuery("from Fornecedor").getResultList();
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return fornecedores;
    }
    
    public List<Produto> listaDeProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            tx.begin();
            produtos = em.createQuery("from Produto").getResultList();
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return produtos;
    }
    
}
