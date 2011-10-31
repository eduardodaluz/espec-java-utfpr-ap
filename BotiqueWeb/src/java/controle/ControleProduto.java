package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ControleProduto extends Controle {
    
    public Produto getProduto(int id) {
	return em.find(Produto.class, id);
    }
    
    public String inserir(Produto produto) {
        try {
            tx.begin();
            em.persist(produto);
            tx.commit();
        } catch(Exception e ) {
            tx.rollback();
        }
	
	return null;
    }
    
    public String deletar(int id) {
        String status = "Não foi possível excluir o Produto!";
        try {
            tx.begin();
            Produto produto = em.find(Produto.class, id);
            em.remove(produto);
            tx.commit();
            status = "Produto : " + id + ", excluido com sucesso!";
        } catch(Exception e ) {
                tx.rollback();
        }
	return status;
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
    
    public List<Produto> listaDeProdutosPorDescricao(String descricao) {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            tx.begin();
            String query = "from Produto where descricao like '%" + descricao + "%'";
            produtos = em.createQuery(query).getResultList();
            tx.commit();
        } catch(Exception e ) {
            tx.rollback();
        }
	return produtos;
    }
    
    public String atualizar(Produto produto) {
        try {
            tx.begin();
            Produto prodUp = em.find(Produto.class, produto.getId());
            prodUp.setDescricao(produto.getDescricao());
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return null;
    }
    
}
