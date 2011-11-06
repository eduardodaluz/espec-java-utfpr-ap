package webservices;

import controle.ControleProduto;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Produto;

@WebService(serviceName = "ProdutoWS")
public class ProdutoWS {
    
    ControleProduto controlProd;
    
    public ProdutoWS() {
        controlProd = new ControleProduto();
    }

    @WebMethod(operationName = "inserir")
    public String inserir(@WebParam(name = "produto") Produto produto) {
        return controlProd.inserir(produto);
    }
    
    @WebMethod(operationName = "atualizar")
    public String atualizar(@WebParam(name = "produto") Produto produto) {
        return controlProd.atualizar(produto);
    }
    
    @WebMethod(operationName = "deletar")
    public String deletar(@WebParam(name = "id") int id) {
        return controlProd.deletar(id);
    }
    
    @WebMethod(operationName = "getProduto")
    public Produto getProduto(@WebParam(name = "id") int id) {
        return controlProd.getProduto(id);
    }
    
    @WebMethod(operationName = "listaDeProdutos")
    public List<Produto> listaDeProdutos() {
        return controlProd.listaDeProdutos();
    }
    
    @WebMethod(operationName = "listaDeProdutosPorDescricao")
    public List<Produto> listaDeProdutosPorDescricao(
            @WebParam(name = "descricao") String descricao) {
        return controlProd.listaDeProdutosPorDescricao(descricao);
    }
    
}
