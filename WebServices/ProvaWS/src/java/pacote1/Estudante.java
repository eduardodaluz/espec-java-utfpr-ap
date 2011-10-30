package pacote1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESTUDANTE")
public class Estudante implements Serializable {

    public Estudante() {
    }
        
    @Column(name="CLASSIFICACAO")
    Integer classificacao;
    @Id @Column(name="NOME")
    String nome;
    
    public Estudante(Integer classificacao, String nome) {
        this.classificacao = classificacao;
        this.nome = nome;
    }
    
    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
