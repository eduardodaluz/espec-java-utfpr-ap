/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

/**
 *
 * @author ana
 */
public class WebSiteBuilder extends MediaBuilder {

    private WebSite w;

    @Override
    public void buildBase() {
        System.out.println("Construindo um website.");
        w = new WebSite();
    }

    @Override
    public void addMediaItem(MediaItem webItem) {
        System.out.println("Adicionando item web " + webItem);
        w.add(webItem);
    }

    @Override
    public Media getFinishedMedia() {
        return w;
    }
}
