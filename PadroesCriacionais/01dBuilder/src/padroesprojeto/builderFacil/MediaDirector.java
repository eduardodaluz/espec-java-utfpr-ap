/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.builderFacil;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ana
 */
public class MediaDirector {

    private MediaBuilder mb;

    public MediaDirector(MediaBuilder mb) {
        this.mb = mb;
    }

    public Media produceMedia(List input) {
        mb.buildBase();
        for (Iterator it = input.iterator(); it.hasNext();) {
            mb.addMediaItem((MediaItem) it.next());
        }
        return mb.getFinishedMedia();
    }
}
