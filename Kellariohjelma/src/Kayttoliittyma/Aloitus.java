/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Kellaritoiminnot;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mikko
 */
public class Aloitus {
    private Scanner lukija; 
    private Kellaritoiminnot toiminnot;
    private boolean kaynnissa;
    private boolean kirjautunut;
    private Kayttaja kayttaja;
    
    public Aloitus(Kellaritoiminnot toiminnot, Scanner lukija) {
        this.lukija = lukija;
        this.kaynnissa = true;
        this.toiminnot = toiminnot;
        this.kirjautunut = false;
        this.kayttaja = null;
    }
    public void kirjauduUlos() {
        this.kirjautunut = false;
        this.kayttaja = null;
    }
    public Kayttaja getKayttaja() {
        return kayttaja;
    }
    public void alkuvalikko() {
        System.out.println("VIINIKELLARI");
        System.out.println("");
        System.out.println("Valitse toiminto (näppäile numero ja paina Enter):");
        System.out.println("1 - Etsi viiniarvioita");
        System.out.println("2 - Kirjaudu sisään");
        System.out.println("3 - Luo Käyttäjätunnus");
        System.out.println("4 - Sulje ohjelma");
        lueKomento();
    }
    public boolean getKaynnissa() {
        return kaynnissa;
    }
    public boolean getKirjautunut() {
        return kirjautunut;
    }
    public void etsiViiniarvioita() {
        System.out.print("Anna hakusana(t): ");
        Viini etsitty = etsiViini();
        if (etsitty==null) {
            System.out.println("Viiniä ei löytynyt");
        } else {
            naytaArviot(etsitty);   
        }
    }

    public void lueKomento() {
        String komento = lukija.nextLine();
        if (komento.equals("1")) {
            etsiViiniarvioita();
        } else if (komento.equals("2")) {
            kirjaudu();
        } else if (komento.equals("3")) {
            luoKayttaja();
        } else if (komento.equals("4")) {
            kaynnissa = false;
        }
    }

    private void naytaArviot(Viini viini) {
        ArrayList<Arvio> loydetyt = toiminnot.etsiArvioita(viini.getAvain());
        if (loydetyt == null) {
            System.out.println("Viinistä ei ole arvioita");
        } else {
            for (Arvio arvio : loydetyt) {
                System.out.println(arvio.toString());
            }
        }
    }

    private void luoKayttaja() {
        System.out.print("Kirjoita nimesi: ");
        String nimi = lukija.nextLine();
        System.out.print("Anna kayttajatunnus(5-10 merkkiä): ");
        String tunnus = lukija.nextLine();
        while (tunnus.length() > 10 || tunnus.length() < 5) {
            System.out.print("Liian pitkä tai lyhyt tunnus. Kirjoita uusi: ");
            tunnus = lukija.nextLine();
        }
        while (!toiminnot.kayttajatunnusVapaa(tunnus)) {
            System.out.print("Käyttyjätunnus varattu. Anna uusi tunnus: ");
            tunnus = lukija.nextLine();
        }
        System.out.print("Anna salasana(5-15 merkkiä): ");
        String salasana = lukija.nextLine();
        while (salasana.length() > 15 || salasana.length() < 5) {
            System.out.print("Salasanan tulee olla 5-15 merkkiä pitkä. Anna uusi salasana: ");
            salasana = lukija.nextLine();
        }
        Kayttaja uusi = new Kayttaja(nimi, tunnus, salasana);
        toiminnot.lisaaKayttaja(uusi);
    }

    public void kirjaudu() {
        System.out.print("Anna käyttäjätunnus: ");
        String tunnus = lukija.nextLine();
        Kayttaja k = toiminnot.etsiKayttaja(tunnus);
        if (k == null) {
            System.out.println("Tuntematon käyttäjätunnus.");
        } else {
            this.kayttaja = k;
            kirjautunut = true;
        }
    }
    private Viini etsiViini() {
        Viini etsitty = null;
        String hakusana = lukija.nextLine();
        ArrayList<Viini> loydetyt = toiminnot.etsiViineja(hakusana);
        if (loydetyt.isEmpty()) {
            return etsitty;
        } else {
            int nro = 1;
            System.out.println("Löytyi seuraavat viinit");
            for (Viini viini : loydetyt) {
                System.out.println(nro + " - " + viini.lyhytToString());
                nro++;
            }
            System.out.print("Anna etsimäsi viinin numero: ");
            int indeksi = Integer.parseInt(lukija.nextLine()) - 1;
            etsitty = loydetyt.get(indeksi);
        }
        return etsitty;
    }
}
