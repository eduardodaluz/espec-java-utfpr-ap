/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import controle.ControlePedido;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import modelo.Fornecedor;
import modelo.Pedido;
import modelo.PedidoItem;
import modelo.Produto;

/**
 *
 * @author eduardo
 */
@WebService(serviceName = "PedidoWS")
public class PedidoWS {

    ControlePedido controlPed;
    
    public PedidoWS() {
        controlPed = new ControlePedido();
    }

    @WebMethod(operationName = "inserir")
    public String inserir(
            @WebParam(name = "pedido") Pedido pedido) {
	return controlPed.inserir(pedido);
    }
    
    @WebMethod(operationName = "deletar")
    public String deletar(
            @WebParam(name = "id") int id) {
	return controlPed.deletar(id);
    }
    
    @WebMethod(operationName = "atualizar")
    public String atualizar(
            @WebParam(name = "pedido") Pedido pedido) {
        return controlPed.atualizar(pedido);
    }
    
    @WebMethod(operationName = "getPedido")
    public Pedido getPedido(
            @WebParam(name = "id") int id) {
	return controlPed.getPedido(id);
    }
    
    @WebMethod(operationName = "getProduto")
    public Produto getProduto(
            @WebParam(name = "id") int id) {
        return controlPed.getProduto(id);
    }
    
    @WebMethod(operationName = "getItem")
    public PedidoItem getItem(
            @WebParam(name = "id") int id) {
	return controlPed.getItem(id);
    }
    
    @WebMethod(operationName = "getFornecedor")
    public Fornecedor getFornecedor(
            @WebParam(name = "id") int id) {
        return controlPed.getFornecedor(id);
    }
    
    @WebMethod(operationName = "listaDePedidos")
    public List<Pedido> listaDePedidos() {
	return controlPed.listaDePedidos();
    }
    
    @WebMethod(operationName = "listadeFornecedores")
    public List<Fornecedor> listaDeFornecedores() {
	return controlPed.listaDeFornecedores();
    }
    
    @WebMethod(operationName = "listaDeProdutos")
    public List<Produto> listaDeProdutos() {
	return controlPed.listaDeProdutos();
    }
    
}
