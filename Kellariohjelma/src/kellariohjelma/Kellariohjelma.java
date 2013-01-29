/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kellariohjelma;

import Kayttoliittyma.Aloitus;
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
       Aloitus liittyma = new Aloitus();
       liittyma.alkuvalikko();
    }
}
