/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiedostonkasittely;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Viini;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tiedostonkasittely {

    String kayttajatiedosto;
    String viinitiedosto;
    String hankintatiedosto;
    String arviotiedosto;

    /**
     * luo uuden Tiedostonkasittelyolion. Kutsuu metodia luoTiedostot, joka luo
     * neljä tiedostoa, jos niitä ei ole
     */
    public Tiedostonkasittely() {
        this.viinitiedosto = "viinit.txt";
        this.arviotiedosto = "arviot.txt";
        this.hankintatiedosto = "hankinnat.txt";
        this.kayttajatiedosto = "kayttajat.txt";
        luoTiedostot();

    }

    /**
     * konstruktori luokan testausta varten
     *
     * @param nimet
     */
    public Tiedostonkasittely(String[] nimet) {
        this.viinitiedosto = nimet[0];
        this.arviotiedosto = nimet[1];
        this.kayttajatiedosto = nimet[2];
        this.hankintatiedosto = nimet[3];
    }

    /**
     * luo tiedoston viineille, käyttäjille, arvioille ja hankinnoille. Jos
     * tiedostot ovat jo olemassa metodi ei tee mitään
     */
    private void luoTiedostot() {
        try {
            File viinit = new File(viinitiedosto);
            File arviot = new File(arviotiedosto);
            File kayttajat = new File(kayttajatiedosto);
            File hankinnat = new File(hankintatiedosto);
            viinit.createNewFile();
            arviot.createNewFile();
            kayttajat.createNewFile();
            hankinnat.createNewFile();
        } catch (IOException e) {
        }
    }
    /**
     * kirjoittaa kaikki järjestelmän tuntemat Viini-oliot tiedostoon
     * @param lista Kellaritoiminto-olion tuntema HashMap
     */
    public void kirjoitaViinit(HashMap<String, Viini> lista) {
        FileWriter kirjoittaja = luoKirjoittaja(viinitiedosto);
        for (Viini viini : lista.values()) {
            try {
                kirjoittaja.append(viini.tiedostomuoto() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * lukee tiedoston "viinit.txt", luo Viini-oliot
     * @return HashMap&ltString, Viini>, joka liitetään Kellaritoiminnot-olioon
     */
    public HashMap<String, Viini> kopioiViinit() {
        File file = new File(viinitiedosto);
        Scanner lukija = luoLukija(file);
        HashMap<String, Viini> v = new HashMap<String, Viini>();
        while (lukija.hasNextLine()) {
            Viini uusi = new Viini(lukija.nextLine());
            v.put(uusi.getAvain(), uusi);
        }
        return v;
    }
    /**
     * kirjoittaa ohjelman tuntemat Arviot tiedostoon
     * @param arviot HashMap&ltString, ArrayList&ltArvio>
     */
    public void kirjoitaArviot(HashMap<String, ArrayList<Arvio>> arviot) {
        FileWriter kirjoittaja = luoKirjoittaja(arviotiedosto);
        for (ArrayList<Arvio> a : arviot.values()) {
            for (Arvio arvio : a) {
                try {
                    kirjoittaja.append(arvio.tiedostomuoto() + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * lukee tiedoston "arviot.txt" ja luo Arvio-oliot
     * @return HashMap&ltString, ArrayList&ltArvio>> joka liitetään Kellaritoiminnot-olioon
     */
    public HashMap<String, ArrayList<Arvio>> kopioiArviot() {
        File file = new File(arviotiedosto);
        Scanner lukija = luoLukija(file);
        HashMap<String, ArrayList<Arvio>> arviot = new HashMap<String, ArrayList<Arvio>>();
        while (lukija.hasNextLine()) {
            Arvio uusi = new Arvio(lukija.nextLine());
            if (arviot.containsKey(uusi.getAvain())) {
                arviot.get(uusi.getAvain()).add(uusi);
            } else {
                ArrayList<Arvio> lista = new ArrayList<Arvio>();
                lista.add(uusi);
                arviot.put(uusi.getAvain(), lista);
            }
        }
        return arviot;
    }
    /**
     * kirjoittaa kaikkien Kayttajien tiedot "kayttajat.txt" tiedostoon
     * @param kayttajat ArrayList&ltKayttajat>
     */
    public void kirjoitaKayttajat(ArrayList<Kayttaja> kayttajat) {
        FileWriter kirjoittaja = luoKirjoittaja(kayttajatiedosto);
        for (Kayttaja k : kayttajat) {
            try {
                kirjoittaja.append(k.tiedostomuoto() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * lukee tiedoston "kayttajat.txt" ja luo Kayttaja-oliot
     * @return ArrayList&ltKayttaja> joka liitetään Kellaritoiminnot-olioon
     */
    public ArrayList<Kayttaja> kopioiKayttajat() {
        File file = new File(kayttajatiedosto);
        Scanner lukija = luoLukija(file);
        ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
        while (lukija.hasNextLine()) {
            String k = lukija.nextLine();
            Kayttaja kayttaja = new Kayttaja(k);
            kayttajat.add(kayttaja);
        }
        return kayttajat;
    }
    /**
     * kirjoittaa Arvioiden tiedot "arviot.txt" tiedostoon
     * @param h HashMap&ltString, ArrayList&ltHankinta>>
     */
    public void kirjoitaHankinnat(HashMap<String, ArrayList<Hankinta>> h) {
        FileWriter kirjoittaja = luoKirjoittaja(hankintatiedosto);
        for (String tunnus : h.keySet()) {
            for (Hankinta hankinta : h.get(tunnus)) {
                try {
                    kirjoittaja.append(hankinta.tiedostomuoto() + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * lukee tiedoston "hankinnat.txt" ja luo Hankinnat
     * @return HashMap&ltString, ArrayList&ltHankinta>> joka liitetään Kellaritoiminnot-olioon
     */
    public HashMap<String, ArrayList<Hankinta>> kopioiHankinnat() {
        File file = new File(hankintatiedosto);
        Scanner lukija = luoLukija(file);
        HashMap<String, ArrayList<Hankinta>> h = new HashMap<String, ArrayList<Hankinta>>();
        HashMap<String, Viini> viinit = kopioiViinit();
        while (lukija.hasNextLine()) {
            String s = lukija.nextLine();
            String avain = s.split("¤")[0];
            Hankinta hankinta = new Hankinta(viinit.get(avain), s);
            if (h.containsKey(hankinta.getTunnus())) {
                h.get(hankinta.getTunnus()).add(hankinta);
            } else {
                ArrayList<Hankinta> lista = new ArrayList<Hankinta>();
                lista.add(hankinta);
                h.put(hankinta.getTunnus(), lista);
            }
        }
        return h;
    }
    /**
     * luo uuden tiedostoa lukevan Scanner-olion
     * @param file tiedosto
     * @return Scanner
     */
    private Scanner luoLukija(File file) {
        Scanner lukija = null;
        try {
            lukija = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lukija;
    }
    
    /**
     * luo uuden tiedostoon kirjoittavan FileWriter-olion
     * @param s String tiedoston nimi
     * @return FileWriter
     */
    private FileWriter luoKirjoittaja(String s) {
        try {
            return new FileWriter(s, true);
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * tyhjentää kaikki tiedostot
     */
    public void tyhjennaKaikkiTiedostot() {
        String[] nimet = {viinitiedosto, kayttajatiedosto, hankintatiedosto, arviotiedosto};
        for (int i = 0; i < nimet.length; i++) {
            tyhjennaTiedosto(nimet[i]);
        }
    }
    /**
     * tyhjentaa tiedoston
     * @param tiedostonimi String tyhjennettävän tiedoston nimi 
     */
    private void tyhjennaTiedosto(String tiedostonimi) {
        FileWriter kirjoittaja = null;
        try {
            kirjoittaja = new FileWriter(tiedostonimi, false);
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kirjoittaja.write("");
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
