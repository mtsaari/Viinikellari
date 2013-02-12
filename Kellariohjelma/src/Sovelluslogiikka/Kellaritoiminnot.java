/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * luokka on ohjelman keskeisimpiä. Kellaritoiminnot hallitsee tietorakenteita,
 * joihinka sisältyvät kaikki ohjelmaan tallennetut oliot
 * @author mikko
 */
public class Kellaritoiminnot {

    private HashMap<String, ArrayList<Arvio>> arviot;
    private HashMap<String, Viini> viinit;
    private HashMap<String, ArrayList<Hankinta>> hankinnat;
    private ArrayList<Kayttaja> kayttajat;

    public Kellaritoiminnot() {
        this.arviot = new HashMap<String, ArrayList<Arvio>>();
        this.viinit = new HashMap<String, Viini>();
        this.hankinnat = new HashMap<String, ArrayList<Hankinta>>();
        this.kayttajat = new ArrayList<Kayttaja>();
    }

    public HashMap<String, Viini> getViinit() {
        return viinit;
    }

    public HashMap<String, ArrayList<Arvio>> getArviot() {
        return arviot;
    }
    public ArrayList<Kayttaja> getKayttajat() {
        return kayttajat;
    }
    public HashMap<String, ArrayList<Hankinta>> getHankinnat(){
        return hankinnat;
    }
    /**
     * lisää uuden Viinin järjestelmään
     * @param v Käyttäjän syötteen perusteella luotu Viini-olio
     */
    public void lisaaViini(Viini v) {
        viinit.put(v.getAvain(), v);
    }
    /**
     * Etsii viinejä kaikkien ohjelman tuntemien viinien joukosta
     * @param hakusana Käyttäjän syöttämä merkkijono, joka voi sisältää useita sanoja.
     * @return Palauttaa ArrayListin, joka sisältää kaikki hakusanoja vastaavat viinit.
     */
    public ArrayList<Viini> etsiViineja(String hakusana) {
        String[] h = hakusana.split(" ");
        ArrayList<Viini> osumat = new ArrayList<Viini>();
        for (Viini viini : viinit.values()) {
            boolean tark = true;
            String haettu = viini.tiedostomuoto();
            for (int i = 0; i < h.length; i++) {
                if (!haettu.contains(h[i])) {
                    tark = false;
                }
            }
            if (tark) {
                osumat.add(viini);
            }
        }
        Collections.sort(osumat);
        return osumat;
    }
    /**
     * Etsii Arvioita kaikkien ohjelman tuntemien Arvioiden joukosta.
     * @param avain merkkijono, jonka Arvio-olio saa Viiniltä, josta se on Arvio.
     * Arvion avain-kenttä toimii myös Arviot sisältävän HashMapin avaimena.
     * @return ArrayList<Arvio> lista, joka sisältää kaikki yhdestä Viinistä kirjoitetut Arviot. 
     */
    public ArrayList<Arvio> etsiArvioita(String avain) {
        if (arviot.containsKey(avain)) {
            ArrayList<Arvio> arv = arviot.get(avain);
            Collections.sort(arv);
            return arv;
        }
        return null;
    }
    /**
     * lisää ohjelmaan uuden arvion. Uusi Arvio luodaan käyttäjän antaman syötteen perusteella.
     * @param avain talletettavan Arvio-olion avain, joka kertoo mihin viiniin arvio liittyy.
     * @param a talletettava Arvio-olio.
     */
    public void lisaaArvio(String avain, Arvio a) {
        if (arviot.containsKey(avain)) {
            arviot.get(avain).add(a);
        } else {
            ArrayList<Arvio> uusi = new ArrayList<Arvio>();
            uusi.add(a);
            arviot.put(avain, uusi);
        }
    }
    /**
     * lisää uuden Käyttäjän ohjelmaan, ArrayList tietorakenteeseen, joka sisältää ohjelman kaikki käyttäjät.
     * @param k lisättävä Käyttäjä-olio.
     */
    public void lisaaKayttaja(Kayttaja k) {
        kayttajat.add(k);
    }
    /**
     * lisää ohjelmaan uuden Hankinta-olion
     * @param tunnus merkkijono joka on Hankinnan omistavan Kayttajan kayttajatunnus ja toimii HashMapin avaimena.
     * @param h lisättävä Hankinta-olio.
     */
    public void lisaaHankinta(String tunnus, Hankinta h) {
        if (hankinnat.containsKey(tunnus)) {
            hankinnat.get(tunnus).add(h);
        } else {
            ArrayList<Hankinta> lista = new ArrayList<Hankinta>();
            lista.add(h);
            hankinnat.put(tunnus, lista);
        }
    }
    /**
     * liittää Kellaritoiminnot luokkaan uuden Viini-olioita sisältävän HashMapin.
     * @param lista HashMap, joka sisältää ohjelman tuntemat viinit.
     */
    public void lisaaViinilista(HashMap<String, Viini> lista) {
        this.viinit = lista;
    }
    /**
     * liittää tähän luokkaan uuden Arvioita sisältävän HashMapin.
     * @param lista HashMap joka sisältää ohjemlman tuntemat arviot.
     */
    public void lisaaArviolista(HashMap<String, ArrayList<Arvio>> lista) {
        this.arviot = lista;
    }
    /**
     * liittää luokkaan Hankintoja sisältävän HashMapin.
     * @param lista HashMap joka sisältää ohjelman tuntemat Hankinnat
     */
    public void lisaaHankintalista(HashMap<String, ArrayList<Hankinta>> lista) {
        this.hankinnat = lista;
    }
    /**
     * liittää luokkaan Kayttajia sisältävän ArrayListin.
     * @param lista ArraList joka sisältää ohjelman tuntemat Kayttajat.
     */
    public void lisaaKayttajalista(ArrayList<Kayttaja> lista) {
        this.kayttajat = lista;
    }
    /**
     * Tarkistaa onko uuden Kayttaja-olion kayttajatunnus varattu.
     * @param tunnus merkkijono, uuden käyttäjän käyttäjätunnus.
     * @return false, jos tunnus on varattu, true, jos tunnus on vapaa.
     */
    public boolean kayttajatunnusVapaa(String tunnus) {
        for (Kayttaja k : kayttajat) {
            if (k.getKayttajatunnus().equalsIgnoreCase(tunnus)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Etsii ohjelman tuntemien Kayttajien joukosta Kayttajan kayttajatunnuksen perusteella.
     * @param tunnus merkkijono, etsityn Kayttajan kayttajatunnus.
     * @return Kayttaja, jonka käyttäjätunnus on sama kuin parametri. Jos Kayttajaa ei löydy, palauttaa null.
     */
    public Kayttaja etsiKayttaja(String tunnus) {
        for (Kayttaja k : kayttajat) {
            if (k.getKayttajatunnus().equals(tunnus)) {
                return k;
            }
        }
        return null;
    }
    /**
     * Etsii Kayttajan henkilökohtaisen kellarin sisältämät Hankinnat.
     * @param tunnus Kayttajan kayttajatunnus.
     * @return palauttaa ArrayListin, joka sisältää Kayttajan Hankinnat.
     */
    public ArrayList<Hankinta> etsiKayttajanKellari(String tunnus) {
        ArrayList<Hankinta> lista = hankinnat.get(tunnus);
        return lista;
    }
}
