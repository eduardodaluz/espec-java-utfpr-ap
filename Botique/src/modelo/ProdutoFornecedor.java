package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProdutoFornecedor implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    @OneToOne
    private Produto produto;
    @OneToOne
    private Fornecedor fornecedor;
    private double quantidade;

    public ProdutoFornecedor() {
    }

    public ProdutoFornecedor(Produto produto, Fornecedor fornecedor, double quantidade) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ProdutoFornecedor{" + "produto=" + produto + ", fornecedor=" + fornecedor + ", quantidade=" + quantidade + '}';
    }
}
