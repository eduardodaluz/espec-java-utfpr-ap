package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto implements Serializable {
    
    @SequenceGenerator(name = "gen_produto", sequenceName = "GEN_PRODUTO", allocationSize = 1)

    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_produto")
    private int id;
    private String descricao;

    public Produto() {
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Object[] row() {
	Object[] row = {getId(), getDescricao()};
	return row;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
}
