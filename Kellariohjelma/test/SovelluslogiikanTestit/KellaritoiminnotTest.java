/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Kellaritoiminnot;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;
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
public class KellaritoiminnotTest {
    private Kellaritoiminnot toiminnot;
    private Viini v1;
    private Viini v2;
    private Viini v3;
    private Hankinta h1;
    private Hankinta h2;
    private Hankinta h3;
    private Arvio arvio1;
    private Arvio arvio2;
    
    public KellaritoiminnotTest() {
    }
    
    
    @Before
    public void setUp() {
        this.toiminnot = new Kellaritoiminnot();
        this.v1 =  new Viini("puna", "mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
        this.v2 = new Viini("puna", "mieto", "Pinot Noir", "2010", "Ranska",
                 "Burgundi", "Mercurey", "Faiveley", "Clos des Myglands");
        this.v3 = new Viini("valko", "makea", "Riesling", "2011", "Saksa",
                 "Nahe", "-","Dönnhoff", "Oberhauser Leistenberg Riesling Kabinett");
        this.h1 = new Hankinta(v1, "mikko",4,750, new Paivays(13,1,2013));
        this.h2 = new Hankinta(v2, "mikko",3,750, new Paivays(13,1,2013));
        this.h3 = new Hankinta(v3, "eki", 3, 750, new Paivays(20,11,2012));
        this.arvio1 = new Arvio(v2.getAvain(),"mikko",new Paivays(5,2,2013), 91,
                "Todella seksikäs Pinot Noir ja hintakin kohtuullinen");
        this.arvio2 = new Arvio(v2.getAvain(), "eki",new Paivays(4,2,2013), 59, "Tämä oli ihan kuraa");
        toiminnot.lisaaViini(v1);
        toiminnot.lisaaViini(v2);
        toiminnot.lisaaViini(v3);
    }
    @Test
    public void etsiViiniPalauttaaOikeatViinitYhdellaHakusanalla() {
        ArrayList<Viini> viinit = toiminnot.etsiViineja("Ranska");
        assertEquals(true, viinit.get(0).equals(v1));
        assertEquals(true, viinit.get(1).equals(v2));
        assertEquals(2, viinit.size());
        viinit = toiminnot.etsiViineja("Delas");
        assertEquals(1, viinit.size());
        assertEquals(true, viinit.get(0).equals(v1));
    }
    @Test 
    public void etsiViiniPalauttaaOikeatViinitUseammallaHakusanalla() {
        ArrayList<Viini> viinit = toiminnot.etsiViineja("Ranska 2010");
        assertEquals(2, viinit.size());
        viinit = toiminnot.etsiViineja("2010 Faiveley");
        assertEquals(1, viinit.size());
        assertEquals(true, viinit.get(0).equals(v2));
        viinit = toiminnot.etsiViineja("Ranska 2010 Delas Syrah");
        assertEquals(true, viinit.get(0).equals(v1));
    }
}
