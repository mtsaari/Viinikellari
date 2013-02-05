/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class HankintaTest {
    private Viini v1;
    private Hankinta h1;
    private Hankinta h2;
    
    public HankintaTest() {
        
    }
    
    @Before
    public void setUp() {
        this.v1 =  new Viini("puna", "mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
        this.h1 = new Hankinta(v1, "mikko",4,750, new Paivays(13,1,2013));
        this.h2 = new Hankinta(v1, "mikko",4,750, new Paivays(13,1,2013));
    }
    @Test
    public void equalsMetodiPalauttaaTrueVainJosOliotOvatIdenttiset () {
        assertEquals(true, h1.equals(h2));
        h1.kulutaPullo();
        assertEquals(false, h1.equals(h2));
    }
    @Test
    public void toinenKonstruktoriLuoKopionOliostaTiedostomuodonAvulla() {
        Hankinta h3 = new Hankinta(v1, h1.tiedostomuoto());
        assertEquals(true, h1.equals(h3));
    }
    @Test
    public void kulutaPulloVahentaaMaaraaYhdellaEikaMaaraMuutuNegatiiviseksi() {
        assertEquals(4, h2.getMaara());
        h2.kulutaPullo();
        assertEquals(3, h2.getMaara());
        for(int i = 0; i < 5; i++) {
            h2.kulutaPullo();
        }
        assertEquals(0, h2.getMaara());
    }
    @Test
    public void compareToMetodiJarjestaaHankinnatPaivamaaranMukaanViimeinenEnsin() {
        ArrayList<Hankinta> lista = new ArrayList<Hankinta>();
        Hankinta uusi = new Hankinta(v1, "mikko",4,750, new Paivays(15,1,2013));
        lista.add(h1);
        lista.add(uusi);
        Collections.sort(lista);
        assertEquals(true, uusi.equals(lista.get(0)));
    }
    
    
             
}
