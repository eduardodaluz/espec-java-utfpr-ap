/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ana
 */
public class MediaBuilderTest {

    private List input = Arrays.asList(new MediaItem[]{
                new MediaItem("item1"), new MediaItem("item2"),
                new MediaItem("item3"), new MediaItem("item4"),});

    public void testBook() {
        MediaDirector buildBook =
                new MediaDirector(new BookBuilder());
        Media book = buildBook.produceMedia(input);
        String result = "Livro: " + book;
        System.out.println(result);
    }

    public void testMagazine() {
        MediaDirector buildMagazine =
                new MediaDirector(new MagazineBuilder());
        Media magazine = buildMagazine.produceMedia(input);
        String result = "Revista: " + magazine;
        System.out.println(result);
    }

    public void testWebSite() {
        MediaDirector buildWebSite =
                new MediaDirector(new WebSiteBuilder());
        Media webSite = buildWebSite.produceMedia(input);
        String result = "Website: " + webSite;
        System.out.println(result);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MediaBuilderTest mb = new MediaBuilderTest();
        mb.testBook();
        mb.testMagazine();
        mb.testWebSite();
    }
}
