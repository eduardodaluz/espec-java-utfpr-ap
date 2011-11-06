package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;

public class ControleFornecedor extends Controle {
    
    public String inserir(Fornecedor fornecedor) {
        try {
            tx.begin();
            em.persist(fornecedor);
            tx.commit();
        } catch(Exception e ) {
            tx.rollback();
        }
	return null;
    }
    
    public String deletar(int id) {
        try {
            tx.begin();
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            em.remove(fornecedor);
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return null;
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
    
    public List<Fornecedor> listaDeFornecedoresPorNome(String nome) {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        try {
            tx.begin();
            String query = "from Fornecedor where nome like '%" + nome + "%'";
            fornecedores = em.createQuery(query).getResultList();
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return fornecedores;
    }
    
    public Fornecedor getFornecedor(int id) {
	return em.find(Fornecedor.class, id);
    }
    
    public String atualizar(Fornecedor fornecedor) {
        try {
            tx.begin();
            Fornecedor fornUpdate = em.find(Fornecedor.class, fornecedor.getId());
            fornUpdate.setEmail(fornecedor.getEmail());
            fornUpdate.setNome(fornecedor.getNome());
            fornUpdate.setTelefone(fornecedor.getTelefone());
            tx.commit();
        } catch(Exception e ) {
                tx.rollback();
        }
	return null;
    }    
    
}
