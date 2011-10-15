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
        return "gerenciarLivro";
    }

    public String prepararAlterarLivro(){
        livro = (Livro)(listaLivros.getRowData());
        return "gerenciarLivro";
    }

    public String excluirLivro(){

        Livro livroTemp = (Livro)(listaLivros.getRowData());
        LivroDao dao = new LivroDaoImp();
        dao.remove(livroTemp);
        return "index";

    }

    public String adicionarLivro(){

        LivroDao dao = new LivroDaoImp();
        dao.save(livro);
        return "index";
        
    }

    public String alterarLivro(){

        LivroDao dao = new LivroDaoImp();
        dao.update(livro);
        return "index";

    }

}
