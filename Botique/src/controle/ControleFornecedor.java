package controle;

import java.util.List;
import modelo.Fornecedor;

public class ControleFornecedor extends Controle {
    
    public String inserir(Fornecedor fornecedor) {
	tx.begin();
	em.persist(fornecedor);
	tx.commit();
	return null;
    }
    
    public String deletar(int id) {
	tx.begin();
	Fornecedor fornecedor = em.find(Fornecedor.class, id);
	em.remove(fornecedor);
	tx.commit();
	return null;
    }
    
    public List<Fornecedor> listaDeFornecedores() {
	tx.begin();
	List<Fornecedor> fornecedor = em.createQuery("from Fornecedor").getResultList();
	tx.commit();
	return fornecedor;
    }
    
    public List<Fornecedor> listaDeFonecedoresPorNome(String nome) {
	tx.begin();
	String query = "from Fornecedor where nome like '%" + nome + "%'";
	List<Fornecedor> fornecedores = em.createQuery(query).getResultList();
	tx.commit();
	return fornecedores;
    }
    
    public Fornecedor getFornecedor(int id) {
	return em.find(Fornecedor.class, id);
    }
    
    public String atualizar(Fornecedor fornecedor) {
	tx.begin();
	Fornecedor fornUpdate = em.find(Fornecedor.class, fornecedor.getId());
	fornUpdate.setEmail(fornecedor.getEmail());
	fornUpdate.setNome(fornecedor.getNome());
	fornUpdate.setTelefone(fornecedor.getTelefone());
	tx.commit();
	return null;
    }    
    
}
