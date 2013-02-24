/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kellariohjelma;

import Kayttoliittyma.Aloitusnakyma;
import Sovelluslogiikka.Kellaritoiminnot;
import Tiedostonkasittely.Tiedostonkasittely;
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
        Tiedostonkasittely kasittely = new Tiedostonkasittely();
        Kellaritoiminnot toim = new Kellaritoiminnot();
        Aloitusnakyma aloitus = new Aloitusnakyma(toim, kasittely);
        aloitus.run();
        
    }
    
}
