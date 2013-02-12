/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Kayttaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class KayttajaTest {
    Kayttaja matti;
    Kayttaja esko;
    
    public KayttajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        matti = new Kayttaja("Matti Aho", "matti", "dsfjöla");
        esko = new Kayttaja("Esko Nurmi", "esko", "nurmenEsko");
    }
    @Test
    public void toinenKonstruktoriLuoKayttajastaKopionTiedostomuotoMetodinAvulla() {
        Kayttaja kopio = new Kayttaja(matti.tiedostomuoto());
        assertEquals("matti", kopio.getKayttajatunnus());
        String[] parametrit = kopio.tiedostomuoto().split("¤");
        assertEquals("Matti Aho", parametrit[2]);
        assertEquals("matti", parametrit[0]);
        assertEquals("dsfjöla", parametrit[1]);
    }
}
