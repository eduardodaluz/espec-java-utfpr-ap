package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

    @SequenceGenerator(name = "gen_pedido", sequenceName = "GEN_PEDIDO", allocationSize = 1)
    
    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="gen_pedido")
    private int id;
    private int numero;
    @Temporal(TemporalType.DATE)
    private Date dtPedido;
    @OneToOne
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> pedidoItens;

    public Pedido() {
    }

    public Pedido(int numero, Date dtPedido, Fornecedor fornecedor) {
        this.numero = numero;
        this.dtPedido = dtPedido;
        this.fornecedor = fornecedor;
    }
    
    public void setPedidoItens(List<PedidoItem> pedidoItens) {
	this.pedidoItens = pedidoItens;
    }
    
    public List<PedidoItem> getPedidoItens() {
	return pedidoItens;
    }
    
    public void addItem(PedidoItem item) {
	if (pedidoItens == null) {
	    pedidoItens = new ArrayList<PedidoItem>();
	}
	pedidoItens.add(item);
    }
    
    public void rmItem(PedidoItem item) {
	if (pedidoItens != null) {
	    pedidoItens.remove(item);
	}
    }
    
    public Object[] row() {
	return new Object[] {getId(), getNumero(), getDtPedido(), getFornecedor().getNome()};
    }
    
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", dtPedido=" + dtPedido + ", fornecedor=" + fornecedor + '}';
    }
}
