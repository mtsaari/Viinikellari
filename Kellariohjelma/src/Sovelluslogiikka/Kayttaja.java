/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import Sovelluslogiikka.Hankinta;
import java.util.ArrayList;



/**
 *
 * @author mikko
 */
public class Kayttaja {
    
    private String nimi;
    private String kayttajatunnus;
    private ArrayList<Hankinta> omaKellari;
    
    public Kayttaja(String nimi, String kayttajatunnus) {
        this.nimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.omaKellari = new ArrayList<Hankinta>();
        
    }    
    public String getKayttajatunnus() {
        return kayttajatunnus;
    }
    
    public String listaaViinit() {
        String hankinnat = "";
        for (Hankinta h: omaKellari) {
            hankinnat += h.toString()+"\n";
        }
        return hankinnat;
    }
    public String tiedostomuoto() {
        return "Kayttajatunnus: "+kayttajatunnus;
    }
    
}
