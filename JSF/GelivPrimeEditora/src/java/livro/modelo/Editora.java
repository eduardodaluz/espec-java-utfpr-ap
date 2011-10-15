/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livro.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="editora")
public class Editora implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;

    public Editora() {
    }

    public Editora(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }
    
    public boolean equals(Object outro)
    {
        return this.id == ((Editora)outro).getId();
    }

}
