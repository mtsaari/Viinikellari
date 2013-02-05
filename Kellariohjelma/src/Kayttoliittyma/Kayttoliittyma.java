/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Kellaritoiminnot;
import java.util.Scanner;

/**
 *
 * @author mikko
 */
public class Kayttoliittyma {
    private Aloitus aloitus;
    private Kayttajanakyma kayttajanakyma;
    private Scanner lukija;
    private Tiedostonkasittely tiedostonkasittely;
    private Kellaritoiminnot toiminnot;
    
    public Kayttoliittyma() {
        this.toiminnot = new Kellaritoiminnot();
        this.lukija = new Scanner(System.in);
        this.tiedostonkasittely = new Tiedostonkasittely();
        this.aloitus = new Aloitus(toiminnot, lukija);
        this.kayttajanakyma = new Kayttajanakyma(toiminnot, lukija);
        
    }
    public void Kaynnista() {
        toiminnot.lisaaViinilista(tiedostonkasittely.kopioiViinit());
        toiminnot.lisaaArviolista(tiedostonkasittely.kopioiArviot());
        while(aloitus.getKaynnissa()) {
            if(aloitus.getKirjautunut()) {
                kayttajanakyma.liitaKayttaja(aloitus.getKayttaja());
                while(kayttajanakyma.getKirjautunut()) {
                    kayttajanakyma.perusnakyma();
                }
            }
            aloitus.alkuvalikko();
        }
        lopeta();
    }
    private void lopeta() {
        tiedostonkasittely.kirjoitaViinit(toiminnot.getViinit());
        tiedostonkasittely.kirjoitaArviot(toiminnot.getArviot());
    }
}
