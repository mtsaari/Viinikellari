/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Tyyli;
import Sovelluslogiikka.Vari;
import Sovelluslogiikka.Viini;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tiedostonkasittely {
    String tiedostonNimi;
    public Tiedostonkasittely(String tiedostonNimi) {
        this.tiedostonNimi = tiedostonNimi;
        
    }

    public void lisaaViini(Viini viini)  {
        FileWriter viinikirjoittaja = null;
        try {
            viinikirjoittaja = new FileWriter(tiedostonNimi, true);
            viinikirjoittaja.append(viini.getHakumerkkijono() + "\n");
            viinikirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                viinikirjoittaja.close();
            } catch (IOException ex) {
                Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Viini> etsiViini(String sana)   {
        File viinit = new File(tiedostonNimi);
        Scanner lukija = null;
        try {
            lukija = new Scanner(viinit);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] hakusanat = sana.split(" ");
        ArrayList<Viini> osumat = new ArrayList<Viini>();
        while (lukija.hasNextLine()) {
            boolean tark = true;
            String s = lukija.nextLine();
            for (int i = 0; i < hakusanat.length; i++) {
                if (!s.contains(hakusanat[i])) {
                    tark = false;
                }
            }
            if (tark) {
                String[] k = s.split("¤");
                Viini uusi = new Viini(Vari.valueOf(k[0]), Tyyli.valueOf(k[1]), k[2], k[3], k[4], k[5], k[6], k[7], k[8]);
                osumat.add(uusi);
            }
        }
        return osumat;
    }
    public void tyhjennaTiedosto() {
        try {
            FileWriter kirjoittaja = new FileWriter(tiedostonNimi);
            kirjoittaja.write("");
        } catch (IOException ex) {
            Logger.getLogger(Tiedostonkasittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
