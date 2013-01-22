/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttaja;

import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;

/**
 *
 * @author mikko
 */
public class Kayttaja {
    private ArrayList<Hankinta> omaKellari;
    private String nimi;
    private String kayttajatunnus;
    private int pullojenMaara;
    
    public Kayttaja(String nimi, String kayttajatunnus) {
        this.nimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.omaKellari = new ArrayList<Hankinta>();
    }
    public void lisaaHankinta(Hankinta h) {
        omaKellari.add(h);
        pullojenMaara+=h.getMaara();
    }
    public String getKayttajatunnus() {
        return kayttajatunnus;
    }
    public void juoPullo(Viini viini) {
        for (Hankinta hankinta : omaKellari) {
            if (hankinta.getPullo().getViini().equals(viini)) {
                hankinta.kulutaPullo();
                if (hankinta.getMaara()==0) {
                    omaKellari.remove(hankinta);
                }
                return;
            }
        }
    }
    
}
