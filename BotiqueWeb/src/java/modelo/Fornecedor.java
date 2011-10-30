package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Fornecedor implements Serializable {
    
    @SequenceGenerator(name = "gen_fornecedor", sequenceName = "GEN_FORNECEDOR", allocationSize = 1)

    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="gen_fornecedor")
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Object[] row() {
	return new Object[] {getId(), getNome(), getTelefone(), getEmail()};
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}
