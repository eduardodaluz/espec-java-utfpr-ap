/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

/**
 *
 * @author ana
 */
//Classe que contém mídias de diferentes tipos
public class MediaItem {

    private String s;

    public MediaItem(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
