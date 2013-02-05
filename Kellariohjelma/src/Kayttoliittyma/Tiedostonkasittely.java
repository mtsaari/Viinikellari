/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Arvio;
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

    String tiedostonNimi;

    public Tiedostonkasittely() {
        this.tiedostonNimi = "viinit.txt";
    }

    public Tiedostonkasittely(String tiedostonNimi) {
        this.tiedostonNimi = tiedostonNimi;

    }

    public void kirjoitaViinit(ArrayList<Viini> lista) {
        FileWriter kirjoittaja = luoKirjoittaja("viinit.txt");
        for (Viini viini : lista) {
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

    public ArrayList<Viini> kopioiViinit() {
        File file = new File("viinit.txt");
        Scanner lukija = luoLukija(file);
        ArrayList<Viini> viinit = new ArrayList<Viini>();
        while (lukija.hasNextLine()) {
            Viini uusi = new Viini(lukija.nextLine());
            viinit.add(uusi);
        }
        return viinit;
    }

    public void kirjoitaArviot(HashMap<String, ArrayList<Arvio>> arviot) {
        FileWriter kirjoittaja = luoKirjoittaja("arviot.txt");
        for (ArrayList<Arvio> a : arviot.values()) {
            for (Arvio arvio : a) {
                try {
                    kirjoittaja.append(arvio.tiedostomuoto());
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
    public HashMap<String, ArrayList<Arvio>> kopioiArviot() {   
        Scanner lukija = luoLukija(new File("arviot.txt"));
        HashMap<String, ArrayList<Arvio>> arviot = new HashMap<String, ArrayList<Arvio>>();
        while(lukija.hasNextLine()) {
            Arvio uusi = new Arvio(lukija.nextLine());
            if(arviot.containsKey(uusi.getAvain())) {
                arviot.get(uusi.getAvain()).add(uusi);
            }   else {
                ArrayList<Arvio> lista = new ArrayList<Arvio>();
                arviot.put(uusi.getAvain(), lista);
            }
        }
        return arviot;
    }

    private Scanner luoLukija(File file) {
        Scanner lukija = null;
        try {
            lukija = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lukija;
    }

    private FileWriter luoKirjoittaja(String s) {
        try {
            return new FileWriter(s, true);
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
