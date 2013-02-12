/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

import java.util.ArrayList;



/**
 *
 * @author mikko
 */
public class Kayttaja {
    
    private String nimi;
    private String salasana;
    private String kayttajatunnus;
    private ArrayList<Hankinta> omaKellari;
    
    public Kayttaja(String nimi, String kayttajatunnus, String salasana) {
        this.nimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
             
    }
    public Kayttaja(String s) {
        String[] a = s.split("¤");
        this.kayttajatunnus = a[0];
        this.salasana = a[1];
        this.nimi = a[2];
    }
    public void liitaKellari(ArrayList<Hankinta> lista) {
        this.omaKellari = lista;
    }
    public String getKayttajatunnus() {
        return kayttajatunnus;
    }
    public String tiedostomuoto() {
        return kayttajatunnus+"¤"+salasana+"¤"+nimi;
    }
    
}
