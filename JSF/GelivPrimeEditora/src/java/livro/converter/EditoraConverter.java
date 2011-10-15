/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package livro.converter;

import livro.dao.EditoraDaoImp;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import livro.modelo.Editora;
import javax.faces.convert.Converter;

@FacesConverter(forClass=Editora.class, value="editoraConverter")
public class EditoraConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String id) {
        EditoraDaoImp dao = new EditoraDaoImp();
        return dao.getEditora(Long.parseLong(id));
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ""+((Editora) o).getId();
    }
    
}
