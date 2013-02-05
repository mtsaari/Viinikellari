/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Paivays;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class ArvioTest {
    private Arvio arvio1;
    private Arvio arvio2;
    public ArvioTest() {
    }
    
    
    @Before
    public void setUp() {
        this.arvio1 = new Arvio("avain","mikko",new Paivays(5,2,2013), 60, "Tämä oli ihan kuraa");
        this.arvio2 = new Arvio("avain","mikko",new Paivays(4,2,2013), 59, "Tämä oli ihan kuraa");
    }

    @Test
    public void konstruktoriLuoOliostaKopionTiedostomuotoMetodinAvulla() {
        Arvio uusi = new Arvio(arvio1.tiedostomuoto());
        assertEquals("avain", uusi.getAvain());
        assertEquals(60, uusi.getPisteet());
        assertEquals(true, uusi.equals(arvio1));
    }
    @Test
    public void equalsMetodiToimii() {
        assertEquals(false, arvio2.equals(arvio1));
    }
    @Test
    public void compareToMetodiJarjestaaArviotPaivayksenMukaanViimeisinEnsin() {
        ArrayList<Arvio> lista = new ArrayList<Arvio>();
        lista.add(arvio2);
        lista.add(arvio1);
        Collections.sort(lista);
        assertEquals(true, lista.get(0).equals(arvio1));
    }
    
    
    
}
