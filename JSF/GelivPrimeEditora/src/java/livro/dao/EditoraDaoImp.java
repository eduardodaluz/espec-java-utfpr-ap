package livro.dao;

import livro.modelo.Editora;
import livro.modelo.Livro;
import livro.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EditoraDaoImp  {

    public void save(Editora editora) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Editora getEditora(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Editora) session.load(Editora.class, id);
    }

    public List<Editora> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from editora").list();
        t.commit();
        return lista;
    }

    public void remove(Editora editora) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Editora editora) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}