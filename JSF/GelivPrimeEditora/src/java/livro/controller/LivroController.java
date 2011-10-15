/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package livro.controller;

import livro.dao.EditoraDaoImp;
import livro.dao.LivroDaoImp;
import livro.modelo.Editora;
import livro.modelo.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class LivroController {
    private Livro livro = new Livro();
    private DataModel listaLivros;
    private String estado = "inserir";
    private List<Editora> listaEditoras;

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

    public String prepararAdicionarLivro() {
        livro = new Livro();
        estado = "inserir";
        return "gerenciarLivro";
    }

    public String prepararAlterarLivro() {
        livro = (Livro) (listaLivros.getRowData());
        estado = "alterar";
        return "gerenciarLivro";
    }

    public String excluirLivro() {
        Livro livroTemp = (Livro) (listaLivros.getRowData());
        LivroDaoImp dao = new LivroDaoImp();
        dao.remove(livroTemp);
        return "index";
    }

    public void adicionarLivro(ActionEvent actionEvent) {
        LivroDaoImp dao = new LivroDaoImp();
        dao.save(livro);

    }

    public void alterarLivro(ActionEvent actionEvent) {

        LivroDaoImp dao = new LivroDaoImp();
        dao.update(livro);

    }

    public boolean isEstadoInsercao() {
        return estado.equals("inserir");
    }
    
    public List<Editora> getListaEditoras()
    {
        EditoraDaoImp dao = new EditoraDaoImp();
        listaEditoras = dao.list();
        return listaEditoras;
    }
}
