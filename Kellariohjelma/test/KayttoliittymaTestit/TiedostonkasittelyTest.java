/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaTestit;

import Tiedostonkasittely.Tiedostonkasittely;
import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Kellaritoiminnot;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class TiedostonkasittelyTest {
    private Tiedostonkasittely kasittely;
    private File viinit;
    private File kayttajat;
    private File hankinnat;
    private File arviot;
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

    public TiedostonkasittelyTest() {
    }

    @Before
    public void setUp() {
        String[] nimet = {"viinitesti.txt", "arviotesti.txt", "kayttajatesti.txt", "hankintatesti.txt"};
        luoTiedostot();
        this.kasittely = new Tiedostonkasittely(nimet);
        this.toiminnot = new Kellaritoiminnot();
        this.k1 = new Kayttaja("Mikko Talvensaari", "mikko", "mtsaari");
        this.k2 = new Kayttaja("Erkki Aro", "eki", "77HHgtfaf");
        this.v1 = new Viini("Punainen","Mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon",13);
        this.v2 = new Viini("Punainen", "Mieto", "Pinot Noir", "2010", "Ranska",
                "Burgundi", "Mercurey", "Faiveley", "Clos des Myglands",13);
        this.v3 = new Viini("Valkoinen", "Makea", "Riesling", "2011", "Saksa",
                "Nahe", "-", "Dönnhoff", "Oberhauser Leistenberg Riesling Kabinett",10.5);
        this.h1 = new Hankinta(v1, k1.getKayttajatunnus(),4,750, new Paivays(13,1,2013),"Vinexus",29.80);
        this.h2 = new Hankinta(v2, k1.getKayttajatunnus(),3,750, new Paivays(13,1,2013),"Vinexus",19.90);
        this.h3 = new Hankinta(v3, k2.getKayttajatunnus(), 3, 750, new Paivays(20,11,2012),"Noble Wine",12.80);
        this.arvio1 = new Arvio(v2.getAvain(), "mikko", new Paivays(5, 2, 2013), 91,
                "Todella seksikäs Pinot Noir ja hintakin kohtuullinen");
        this.arvio2 = new Arvio(v2.getAvain(), "eki", new Paivays(4, 2, 2013), 59, "Tämä oli ihan kuraa");
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

    @After
    public void tearDown() {
        arviot.delete();
        viinit.delete();
        kayttajat.delete();
        hankinnat.delete();
    }

    @Test
    public void kirjoitaViinitKirjoittaaViinitTiedostoonSitenEttaKopioiViinitKopioiNeSiitaOikein() {
        Viini viini = toiminnot.etsiViineja("Dönnhoff").get(0);
        HashMap<String, Viini> kopio = toiminnot.getViinit();
        kasittely.kirjoitaViinit(toiminnot.getViinit());
        HashMap<String, Viini> lista = new HashMap<String, Viini>();
        toiminnot.lisaaViinilista(lista);
        toiminnot.lisaaViinilista(kasittely.kopioiViinit());
        assertEquals(true, kopio.size() == toiminnot.getViinit().size());
        Viini riesling = toiminnot.etsiViineja("Dönnhoff").get(0);
        assertEquals(true, riesling.equals(viini));
    }

    @Test
    public void kirjoitaArviotKirjoittaaArviotTiedostoonSitenEttaKopioiArviotKopioiNeOikein() {
        HashMap<String, ArrayList<Arvio>> kopio = toiminnot.getArviot();
        Arvio arvio = toiminnot.etsiArvioita(v2.getAvain()).get(0);
        kasittely.kirjoitaArviot(toiminnot.getArviot());
        HashMap<String, ArrayList<Arvio>> tyhjaLista = new HashMap<String, ArrayList<Arvio>>();
        toiminnot.lisaaArviolista(tyhjaLista);
        toiminnot.lisaaArviolista(kasittely.kopioiArviot());
        assertEquals(true, kopio.size() == toiminnot.getArviot().size());
        Arvio uusi = toiminnot.etsiArvioita(v2.getAvain()).get(0);
        assertEquals(true, uusi.equals(arvio));
    }
    @Test
    public void kirjoitaKayttajatKirjoittaaKayttajatTiedostoonjaKopioKayttajatKopioNeOikein() {
        ArrayList<Kayttaja> kopio = toiminnot.getKayttajat();
        Kayttaja kayttaja = toiminnot.etsiKayttaja(k1.getKayttajatunnus());
        kasittely.kirjoitaKayttajat(toiminnot.getKayttajat());
        ArrayList<Kayttaja> tyhja = new ArrayList<Kayttaja>();
        toiminnot.lisaaKayttajalista(tyhja);
        toiminnot.lisaaKayttajalista(kasittely.kopioiKayttajat());
        assertEquals(true, kopio.size()==toiminnot.getKayttajat().size());
        Kayttaja uusi = toiminnot.etsiKayttaja(k1.getKayttajatunnus());
        assertEquals(true, uusi.tiedostomuoto().equals(kayttaja.tiedostomuoto()));
    }
    @Test
    public void kirjoitaHankinnatKirjoittaaHankinnatTiedostoonSitenEttaKopioiHankinnatKopioiNeOikein() {
        HashMap<String, ArrayList<Hankinta>> kopio = toiminnot.getHankinnat();
        ArrayList<Hankinta> lista = toiminnot.etsiKayttajanKellari(k1.getKayttajatunnus());
        Hankinta hankinta = lista.get(0);
        kasittely.kirjoitaHankinnat(toiminnot.getHankinnat());
        HashMap<String, ArrayList<Hankinta>> tyhjalista = new HashMap<String, ArrayList<Hankinta>>();
        toiminnot.lisaaHankintalista(tyhjalista);
        toiminnot.lisaaHankintalista(kasittely.kopioiHankinnat());
        assertEquals(true, kopio.get(k1.getKayttajatunnus()).size() ==toiminnot.getHankinnat().get(k1.getKayttajatunnus()).size());
        
    }
    private void luoTiedostot() {
        try {
            this.viinit = new File("viinitesti.txt");
            this.hankinnat = new File("hankintatesti.txt");
            this.kayttajat = new File("kayttajatesti.txt");
            this.arviot = new File("arviotesti.txt");
            viinit.createNewFile();
            hankinnat.createNewFile();
            kayttajat.createNewFile();
            arviot.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(TiedostonkasittelyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
