package controle;

import java.util.List;
import modelo.Produto;

public class ControleProduto extends Controle {
    
    public Produto getProduto(int id) {
	return em.find(Produto.class, id);
    }
    
    public String inserir(Produto produto) {
	tx.begin();
	em.persist(produto);
	tx.commit();
	return null;
    }
    
    public String deletar(int id) {
	tx.begin();
	Produto produto = em.find(Produto.class, id);
	em.remove(produto);
	tx.commit();
	return null;
    }
    
    public List<Produto> listaDeProdutos() {
	tx.begin();
	List<Produto> produtos = em.createQuery("from Produto").getResultList();
	tx.commit();
	return produtos;
    }
    
    public List<Produto> listaDeProdutosPorDescricao(String descricao) {
	tx.begin();
	String query = "from Produto where descricao like '%" + descricao + "%'";
	List<Produto> produtos = em.createQuery(query).getResultList();
	tx.commit();
	return produtos;
    }
    
    public String atualizar(Produto produto) {
	tx.begin();
	Produto prodUp = em.find(Produto.class, produto.getId());
	prodUp.setDescricao(produto.getDescricao());
	tx.commit();
	return null;
    }
    
}
