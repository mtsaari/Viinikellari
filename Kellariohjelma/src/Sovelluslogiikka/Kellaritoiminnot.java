/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mikko
 */
public class Kellaritoiminnot {

    private HashMap<String, ArrayList<Arvio>> arviot;
    private ArrayList<Viini> viinit;
    private HashMap<String, ArrayList<Hankinta>> pullot;
    private ArrayList<Kayttaja> kayttajat;

    public Kellaritoiminnot() {
        this.arviot = new HashMap<String, ArrayList<Arvio>>();
        this.viinit = new ArrayList<Viini>();
        this.pullot = new HashMap<String, ArrayList<Hankinta>>();
        this.kayttajat = new ArrayList<Kayttaja>();
    }

    public ArrayList<Viini> getViinit() {
        return viinit;
    }

    public HashMap<String, ArrayList<Arvio>> getArviot() {
        return arviot;
    }

    public void lisaaViini(Viini v) {
        viinit.add(v);
    }

    public ArrayList<Viini> etsiViineja(String hakusana) {
        String[] h = hakusana.split(" ");
        ArrayList<Viini> osumat = new ArrayList<Viini>();
        for (Viini viini : viinit) {
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
        return osumat;
    }

    public ArrayList<Arvio> etsiArvioita(String avain) {
        if (arviot.containsKey(avain)) {
            return arviot.get(avain);
        }
        return null;
    }

    public void lisaaArvio(String avain, Arvio a) {
        if (arviot.containsKey(avain)) {
            arviot.get(avain).add(a);
        } else {
            ArrayList<Arvio> uusi = new ArrayList<Arvio>();
            uusi.add(a);
            arviot.put(avain, uusi);
        }
    }

    public void lisaaKayttaja(Kayttaja k) {
        kayttajat.add(k);
    }

    public void lisaaPullo(String tunnus, Hankinta h) {
        pullot.get(tunnus).add(h);
    }

    public void lisaaViinilista(ArrayList<Viini> lista) {
        this.viinit = lista;
    }

    public void lisaaArviolista(HashMap<String, ArrayList<Arvio>> lista) {
        this.arviot = lista;
    }

    public boolean kayttajatunnusVapaa(String tunnus) {
        for (Kayttaja k : kayttajat) {
            if (k.getKayttajatunnus().equals(tunnus)) {
                return false;
            }
        }
        return true;
    }

    public Kayttaja etsiKayttaja(String tunnus) {
        for (Kayttaja k : kayttajat) {
            if (k.getKayttajatunnus().equals(tunnus)) {
                return k;
            }
        }
        return null;
    }

    public String listaaKayttajanKellari(String tunnus) {
        ArrayList<Hankinta> lista = pullot.get(tunnus);
        if (lista.isEmpty()) {
            return "Kellarissa ei ole viinejä";
        }
        String s = "";
        for (Hankinta h : lista) {
            s += h.toString() + "\n";
        }
        return s;
    }
}
