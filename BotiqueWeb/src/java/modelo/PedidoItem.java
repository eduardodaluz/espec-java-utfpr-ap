package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PedidoItem implements Serializable {

    @SequenceGenerator(name = "gen_prodForn", sequenceName = "GEN_PRODFORN", allocationSize = 1)
    
    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="gen_prodForn")
    private int id;
    @OneToOne
    private Produto produto;
    private double quantidade;
    @ManyToOne
    private Pedido pedido;

    public Pedido getPedido() {
	return pedido;
    }

    public void setPedido(Pedido pedido) {
	this.pedido = pedido;
    }

    public PedidoItem() {
    }

    public PedidoItem(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Object[] row() {
	return new Object[] {getId(), getProduto().getDescricao(), getQuantidade()};
    }
    
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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
        return id + " - " + produto + ", " + quantidade;
    }
}
