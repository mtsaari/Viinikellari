/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kellariohjelma;


import Kayttoliittyma.Kayttoliittyma;
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
       Kayttoliittyma liittyma = new Kayttoliittyma();
       liittyma.Kaynnista();
    }
}
