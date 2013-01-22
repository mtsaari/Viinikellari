/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Kayttaja.Kayttaja;
import java.util.ArrayList;

/**
 *
 * @author mikko
 */
public class Kellaritoiminnot {
    private ArrayList<Viini> viinit;
    private ArrayList<Kayttaja> kayttajat;
    
    public Kellaritoiminnot() {
        this.kayttajat = new ArrayList<Kayttaja>();
        this.viinit = new ArrayList<Viini>();
    }
    public void lisaaKayttaja(Kayttaja k) {
        kayttajat.add(k);
    }
    public Kayttaja etsiKayttaja(String s) {
        for (Kayttaja kayttaja: kayttajat) {
            if (kayttaja.getKayttajatunnus().equals(s)) {
                return kayttaja;
            }
        }
        return null;
    }
    public ArrayList<Viini> etsiViini(String s) {
        ArrayList<Viini> osumat = new ArrayList<Viini>();
        for(Viini viini: viinit) {
            for (String sana: viini.getHakusanat()) {
                if (sana.equals(s)) {
                    osumat.add(viini);
                }
            }
        }
        return osumat;
    }
}
