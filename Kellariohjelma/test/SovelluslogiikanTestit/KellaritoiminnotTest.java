/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SovelluslogiikanTestit;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Kayttaja;
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
    private Kayttaja k1;
    private Kayttaja k2;
    public KellaritoiminnotTest() {
    }
    
    
    @Before
    public void setUp() {
        this.toiminnot = new Kellaritoiminnot();
        this.k1 = new Kayttaja("Mikko Talvensaari","mikko","mtsaari");
        this.k2 = new Kayttaja("Erkki Aro","eki","77HHgtfaf");
        this.v1 =  new Viini("Punainen","Mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon",13);
        this.v2 = new Viini("Punainen", "Mieto", "Pinot Noir", "2010", "Ranska",
                 "Burgundi", "Mercurey", "Faiveley", "Clos des Myglands",13);
        this.v3 = new Viini("Valkoinen", "Makea", "Riesling", "2011", "Saksa",
                 "Nahe", "-","Dönnhoff", "Oberhauser Leistenberg Riesling Kabinett",10.5);
        this.h1 = new Hankinta(v1, k1.getKayttajatunnus(),4,750, new Paivays(13,1,2013),"Vinexus",29.80);
        this.h2 = new Hankinta(v2, k1.getKayttajatunnus(),3,750, new Paivays(13,1,2013),"Vinexus",19.90);
        this.h3 = new Hankinta(v3, k2.getKayttajatunnus(), 3, 750, new Paivays(20,11,2012),"Noble Wine",12.80);
        this.arvio1 = new Arvio(v2.getAvain(),"mikko",new Paivays(5,2,2013), 91,
                "Todella seksikäs Pinot Noir ja hintakin kohtuullinen");
        this.arvio2 = new Arvio(v2.getAvain(), "eki",new Paivays(4,2,2013), 59, "Tämä oli ihan kuraa");
        toiminnot.lisaaKayttaja(k1);
        toiminnot.lisaaKayttaja(k2);
        toiminnot.lisaaViini(v1);
        toiminnot.lisaaViini(v2);
        toiminnot.lisaaViini(v3);
        toiminnot.lisaaArvio(v2.getAvain(), arvio1);
        toiminnot.lisaaArvio(v2.getAvain(), arvio2);
        toiminnot.lisaaHankinta(h1.getTunnus(), h1);
        toiminnot.lisaaHankinta(h2.getTunnus(), h2);
        
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
    @Test
    public void etsiArvioitaPalauttaaKaikkiKysytynViininArviotOikeassaJarjestyksessa() {
        ArrayList<Arvio> arviot = toiminnot.etsiArvioita(v2.getAvain());
        assertEquals(true, arviot.get(0).equals(arvio1));
        assertEquals(true, arviot.get(1).equals(arvio2));
        assertEquals(null, toiminnot.etsiArvioita(v1.getAvain()));
    }
    @Test
    public void kayttajatunnusVapaaPalauttaaFalseJosKayttajatunnusOnVarattu() {
        assertEquals(false, toiminnot.kayttajatunnusVapaa("mikko"));
        assertEquals(false, toiminnot.kayttajatunnusVapaa("eki"));
        assertEquals(false, toiminnot.kayttajatunnusVapaa("Mikko"));
        assertEquals(true, toiminnot.kayttajatunnusVapaa("miko"));
    }
    public void etsiKayttajaPalauttaaKayttajanParametrinaOlevanKayttajatunnuksenMukaan() {
        assertEquals(null, toiminnot.etsiKayttaja("matti"));
        assertEquals("mikko", toiminnot.etsiKayttaja("mikko"));
        assertEquals("eki", toiminnot.etsiKayttaja(k2.getKayttajatunnus()));
    }
    @Test
    public void etsiKayttajanKellariPalauttaaKaikkiKayttajanViinit() {
        assertEquals(null, toiminnot.etsiKayttajanKellari(k2.getKayttajatunnus()));
        assertEquals(2, toiminnot.etsiKayttajanKellari(k1.getKayttajatunnus()).size());
        toiminnot.lisaaHankinta(k2.getKayttajatunnus(), h3);
        assertEquals(1, toiminnot.etsiKayttajanKellari(k2.getKayttajatunnus()).size());
    }
}
