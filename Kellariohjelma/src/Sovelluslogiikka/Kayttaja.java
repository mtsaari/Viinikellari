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
