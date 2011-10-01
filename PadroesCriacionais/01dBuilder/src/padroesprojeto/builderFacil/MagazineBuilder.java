/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

/**
 *
 * @author ana
 */
public class MagazineBuilder extends MediaBuilder {

    private Magazine m;

    @Override
    public void buildBase() {
        System.out.println("Construindo uma revista.");
        m = new Magazine();
    }

    @Override
    public void addMediaItem(MediaItem article) {
        System.out.println("Adicionando artigo " + article);
        m.add(article);
    }

    @Override
    public Media getFinishedMedia() {
        return m;
    }
}
