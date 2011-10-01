/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

/**
 *
 * @author ana
 */
public class BookBuilder extends MediaBuilder {

    private Book b;

    @Override
    public void buildBase() {
        System.out.println("Construindo um livro.");
        b = new Book();

    }

    @Override
    public void addMediaItem(MediaItem chapter) {
        System.out.println("Adicionando capítulo " + chapter);
        b.add(chapter);
    }

    @Override
    public Media getFinishedMedia() {
        return b;
    }
}
