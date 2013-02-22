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
    
    /**
     * luo uuden Kayttaja olion
     * @param nimi String
     * @param kayttajatunnus String 
     * @param salasana String
     */
    public Kayttaja(String nimi, String kayttajatunnus, String salasana) {
        this.nimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;

    }
    /**
     * luo uuden Käyttäjä-olion tiedostomuoto-merkkijonon avulla kun Kayttajan tiedot kopioidaan tiedostosta
     * @param s String jossa attribuutit on erotettu merkillä "¤"
     */
    public Kayttaja(String s) {
        String[] a = s.split("¤");
        this.kayttajatunnus = a[0];
        this.salasana = a[1];
        this.nimi = a[2];
    }
    
    /**
     * kertoo Kayttajan kellarissa jäljellä olevien pullojen määrän
     * @return int jäljellä olevien pullojen määrä
     */
    public int pullojenMaara() {
        if (omaKellari.isEmpty()) {
            return 0;
        }
        int summa = 0;
        for (Hankinta h : omaKellari) {
            summa += h.getJaljella();
        }
        return summa;
    }
    /**
     * palauttaa kellarissa olevien pullojen yhteenlasketun arvon
     * @return double 
     */
    public double kellarinArvo() {
        if (omaKellari.isEmpty()) {
            return 0;
        }
        double summa = 0;
        for (Hankinta h : omaKellari) {
            summa += h.getHinta() * h.getJaljella();
        }
        return summa;
    }
    /**
     * liittää Kayttaja-olioon ArrayList tietorakenteen, joka sisältää Käyttäjän Hankinnat. 
     * @param lista ArrayList<Hankinta>.  
     */
    public void liitaKellari(ArrayList<Hankinta> lista) {
        if (lista == null) {
            this.omaKellari = new ArrayList<Hankinta>();
        } else {
            this.omaKellari = lista;
        }
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public ArrayList<Hankinta> getKellari() {
        return omaKellari;
    }
    /**
     * luo ja palauttaa merkkijonon, joka tallennetaan tiedostoon ja jonka avulla konstruktori luo kopion Kayttaja-oliosta
     * @return String merkkijono, jossa Kayttajan attribuutit on erotettu merkillä "¤"
     */
    public String tiedostomuoto() {
        return kayttajatunnus + "¤" + salasana + "¤" + nimi;
    }

    @Override
    public String toString() {
        return "Nimi: " + this.nimi + "\n" + "Käyttäjätunnus: " + this.kayttajatunnus + "\n"
                + "Pulloja kellarissa: " + pullojenMaara() + "\n"
                + "Kellarin arvo: " + kellarinArvo() + "\n\n";
    }
}
