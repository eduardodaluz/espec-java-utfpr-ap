package webservices;

import controle.ControleFornecedor;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Fornecedor;

@WebService(serviceName = "FornecedorWS")
public class FornecedorWS {
    
    ControleFornecedor controlForn;
    
    public FornecedorWS() {
        controlForn = new ControleFornecedor();
    }
    
    @WebMethod(operationName = "inserir")
    public String inserir(
            @WebParam(name = "fornecedor") Fornecedor fornecedor) {
	return controlForn.inserir(fornecedor);
    }
    
    @WebMethod(operationName = "deletar")
    public String deletar(@WebParam(name = "id") int id) {
	return controlForn.deletar(id);
    }
    
    @WebMethod(operationName = "listaDeFornecedores")
    public List<Fornecedor> listaDeFornecedores() {
	return controlForn.listaDeFornecedores();
    }
    
    @WebMethod(operationName = "listaDeFornecedoresPorNome")
    public List<Fornecedor> listaDeFornecedoresPorNome(
            @WebParam(name = "nome") String nome) {
	return controlForn.listaDeFornecedoresPorNome(nome);
    }
    
    @WebMethod(operationName = "getFornecedor")
    public Fornecedor getFornecedor(
            @WebParam(name = "id") int id) {
	return controlForn.getFornecedor(id);
    }
    
    @WebMethod(operationName = "atualizar")
    public String atualizar(
            @WebParam(name = "fornecedor") Fornecedor fornecedor) {
	return controlForn.atualizar(fornecedor);
    }
}
