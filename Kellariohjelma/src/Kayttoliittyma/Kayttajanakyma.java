/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Kellaritoiminnot;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mikko
 */
public class Kayttajanakyma {

    private Kellaritoiminnot toiminnot;
    private Kayttaja kayttaja;
    private boolean kirjautunut;
    private Scanner lukija;

    public Kayttajanakyma(Kellaritoiminnot toiminnot, Scanner lukija) {
        this.kayttaja = null;
        this.toiminnot = toiminnot;
        this.kirjautunut = false;
        this.lukija = lukija;
    }

    public void liitaKayttaja(Kayttaja k) {
        this.kayttaja = k;
        this.kirjautunut = true;
    }

    public boolean getKirjautunut() {
        return kirjautunut;
    }

    public void perusnakyma() {
        System.out.println("1 - listaa oman kellarin viinit");
        System.out.println("2 - lisää viini omaan kellariin");
        System.out.println("3 - lisää arvio");
        System.out.println("4 - lisää viini järjestelmään");
        System.out.println("5 - Kirjaudu ulos");
        lueKomento();
    }

    public void luoViini() {
        System.out.println("Vari (kirjoita 'puna', 'valko' tai 'rose'");
        String v = lukija.nextLine();
        System.out.print("Tyyli ('mieto', 'kuohuva', 'vakeva', 'makea': ");
        String t = lukija.nextLine();
        System.out.print("Tuottaja: ");
        String tuottaja = lukija.nextLine();
        System.out.print("Alkuperämerkintä (Paina Enter jos alkuperämerkintää ei ole): ");
        String alkupera = lukija.nextLine();
        if (alkupera.isEmpty()) {
            alkupera = "-";
        }
        System.out.print("Pullote: ");
        String pullote = lukija.nextLine();
        if (pullote.isEmpty()) {
            pullote = "-";
        }
        System.out.print("Maa: ");
        String maa = lukija.nextLine();
        System.out.print("Alue: ");
        String alue = lukija.nextLine();
        System.out.print("Vuosikerta ('nv' jos vuosikertaa ei ole): ");
        String vuosikerta = lukija.nextLine();
        System.out.print("Rypälelaji: ");
        String rypale = lukija.nextLine();
        Viini uusi = new Viini(v, t, rypale, vuosikerta, maa, alue, alkupera, tuottaja, pullote);
        toiminnot.lisaaViini(uusi);
        System.out.println("");

    }

    private void lisaaArvio() {
        System.out.print("Anna hakusana(t): ");
        Viini v = etsiViini();
        if (v == null) {
            System.out.println("Viiniä ei löytynyt");
        } else {
            System.out.print("Anna päiväys(pp.kk.vvvv): ");
            String pvm = lukija.nextLine();
            Paivays paivays = new Paivays(pvm);
            System.out.println("Kirjoita kuvaus:");
            String kuvaus = lukija.nextLine();
            System.out.print("Anna pisteet (50-100): ");
            int pist = Integer.parseInt(lukija.nextLine());
            Arvio arvio = new Arvio(v.getAvain(), kayttaja.getKayttajatunnus(), paivays, pist, kuvaus);
            toiminnot.lisaaArvio(v.getAvain(), arvio);
            perusnakyma();
        }
    }

    private void lueKomento() {
        String k = lukija.nextLine();
        if (k.equals("1")) {
            listaaKayttajanKellari();
        } else if (k.equals("2")) {
            lisaaHankinta();
        } else if (k.equals("3")) {
            lisaaArvio();
        } else if (k.equals("4")) {
            luoViini();
        } else if (k.equals("5")) {
            kirjautunut = false;
        }
    }

    private void lisaaHankinta() {
        System.out.print("Anna lisättäväan viiniin liittyvä(t) hakusana(t): ");
        Viini etsitty = etsiViini();
        System.out.print("Anna päivämäärä(pp.kk.vvvv): ");
        String pvm = lukija.nextLine();
        Paivays p = new Paivays(pvm);
        System.out.print("Pullojen määrä: ");
        int maara = Integer.parseInt(lukija.nextLine());
        System.out.print("Pullokoko(ml): ");
        int koko = Integer.parseInt(lukija.nextLine());
        Hankinta h = new Hankinta(etsitty, kayttaja.getKayttajatunnus(), maara, koko, p);
        toiminnot.lisaaHankinta(kayttaja.getKayttajatunnus(), h);

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

    private void listaaKayttajanKellari() {
        ArrayList<Hankinta> lista = toiminnot.etsiKayttajanKellari(kayttaja.getKayttajatunnus());
        if (lista == null) {
            System.out.println("Kellarisi on tyhjä");
        } else {
            for (Hankinta h : lista) {
                System.out.println(h.toString() + "\n");
            }
        }
    }
}
