/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livro.controller;

import livro.dao.LivroDao;
import livro.dao.LivroDaoImp;
import livro.model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author José Alexandre
 */
@ManagedBean
@SessionScoped
public class LivroController {

    private Livro livro;
    private DataModel listaLivros;
    private String estado = "inserir";

    public DataModel getListarLivros() {
        List<Livro> lista = new LivroDaoImp().list();
        listaLivros = new ListDataModel(lista);
        return listaLivros;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String prepararAdicionarLivro(){
        livro = new Livro();
        estado = "inserir";
        return "gerenciarLivro";
    }

    public String prepararAlterarLivro(){
        livro = (Livro)(listaLivros.getRowData());
        estado = "alterar";
        return "gerenciarLivro";
    }

    public String excluirLivro(){
        Livro livroTemp = (Livro)(listaLivros.getRowData());
        LivroDao dao = new LivroDaoImp();
        dao.remove(livroTemp);
        return "index";
    }

    public void adicionarLivro(ActionEvent actionEvent){

        LivroDao dao = new LivroDaoImp();
        dao.save(livro);

    }

    public void alterarLivro(ActionEvent actionEvent){

        LivroDao dao = new LivroDaoImp();
        dao.update(livro);

    }
    
    public boolean isEstadoInsercao()
    {
        return estado.equals("inserir");
    }
}
