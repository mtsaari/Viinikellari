/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Tyyli;
import Sovelluslogiikka.Vari;
import Sovelluslogiikka.Viini;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mikko
 */
public class Aloitus {
    private Scanner lukija;
    private Tiedostonkasittely tiedostonkasittely;
    private boolean kirjautunut;
    
    public Aloitus()  {
        lukija = new Scanner(System.in);
        this.tiedostonkasittely = new Tiedostonkasittely("viinit.txt");
        this.kirjautunut = false;
    }
    public void alkuvalikko()  {
        System.out.println("VIINIKELLARI");
        System.out.println("");
        System.out.println("Valitse toiminto (näppäile numero ja paina Enter):");
        System.out.println("1 - Etsi viinejä");
        System.out.println("2 - Kirjaudu sisään");
        System.out.println("3 - Luo Käyttäjätunnus");
        System.out.println("4 - Lisää viini");
        System.out.println("5 - Sulje ohjelma");
        lueKomento();
    }
    public void kayttajavalikko() {
        System.out.println("");
    }
    public void etsiViiniarvioita()  {
        System.out.println("Anna hakusana(t):");
        String hakusanat = lukija.nextLine();
        ArrayList<Viini> loydetyt = tiedostonkasittely.etsiViini(hakusanat);
        if (loydetyt.isEmpty()) {
            System.out.println("Viiniä ei löytynyt");
        }   else {
            for(Viini viini:loydetyt) {
                System.out.println(viini.lyhytToString());
            }
        }
        alkuvalikko();
    }
    public void lueKomento()  {
        String komento = lukija.nextLine();
        if (komento.equals("1")) {
            etsiViiniarvioita();
        }   else if (komento.equals("4")) {
            luoViini();
        }         
    }

    public void luoViini()  {
        System.out.print("Väri (kirjoita 'puna', 'valko' tai 'rose'): ");      
        Vari v = vari();
        System.out.print("Tyyli ('mieto', 'kuohuva', 'vakeva', 'makea': ");
        Tyyli t = tyyli();
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
        Viini uusi = new Viini(v,t,rypale,vuosikerta,maa,alue,alkupera,tuottaja,pullote);
        tiedostonkasittely.lisaaViini(uusi);
        System.out.println("");
        alkuvalikko();
    }
    private Vari vari() {
        String vari = lukija.nextLine();
        if (vari.equals("puna")) {
            return Vari.PUNAINEN;
        }   else if (vari.equals("valko")) {
            return Vari.VALKOINEN;
        }   else if (vari.equals("rose")) {
            return Vari.ROSE;
        }   else    {
            System.out.println("Tuntematon väri");
            vari();
        }
        return null; 
    }
    private Tyyli tyyli() {
        String tyyli = lukija.nextLine();
        Tyyli t = null;
        if (tyyli.equals("mieto")) {
            t = Tyyli.MIETO;
        }   else if (tyyli.equals("kuohuva")) {
            t = Tyyli.KUOHUVA;
        }   else if (tyyli.equals("vakeva")) {
            t = Tyyli.VAKEVA;
        }   else if (tyyli.equals("makea")) {
            t = Tyyli.MAKEA;
        }   else {
            System.out.println("Valitse jokin neljästä annetusta tyylistä");
            tyyli();
        }
        return t;
    }
    
}
