/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kellariohjelma;

import Kellariohjelma.gui.Aloitusnakyma;
import Sovelluslogiikka.Kellaritoiminnot;
import Tiedostonkasittely.Tiedostonkasittely;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 *
 * @author mikko
 */
public class Kellariohjelma {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final Tiedostonkasittely kasittely = new Tiedostonkasittely();
        final Kellaritoiminnot toim = new Kellaritoiminnot();
        kopioiTiedostot(kasittely, toim);
        Aloitusnakyma aloitus = new Aloitusnakyma(toim);
        aloitus.addWindowListener(new java.awt.event.WindowAdapter() {           
            @Override
    public void windowClosing(WindowEvent winEvt) {
        kirjoitaTiedostot(kasittely, toim);
        System.exit(0); 
    }
});
        aloitus.run();
        
    }
    private static void kopioiTiedostot(Tiedostonkasittely kasittely, Kellaritoiminnot toim) {
        toim.lisaaViinilista(kasittely.kopioiViinit());
        toim.lisaaKayttajalista(kasittely.kopioiKayttajat());
        toim.lisaaArviolista(kasittely.kopioiArviot());
        toim.lisaaHankintalista(kasittely.kopioiHankinnat());
        
    }
    private static void kirjoitaTiedostot(Tiedostonkasittely kasittely, Kellaritoiminnot toim) {
        kasittely.tyhjennaKaikkiTiedostot();
        kasittely.kirjoitaViinit(toim.getViinit());
        kasittely.kirjoitaKayttajat(toim.getKayttajat());
        kasittely.kirjoitaArviot(toim.getArviot());
        kasittely.kirjoitaHankinnat(toim.getHankinnat());
    }
}
