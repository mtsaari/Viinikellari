/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

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
        kopioiTiedostot();
        while(aloitus.getKaynnissa()) {
            if(aloitus.getKirjautunut()) {
                kayttajanakyma.liitaKayttaja(aloitus.getKayttaja());
                while(kayttajanakyma.getKirjautunut()) {
                    kayttajanakyma.perusnakyma();
                }
                aloitus.kirjauduUlos();
            }
            aloitus.alkuvalikko();
        }
        lopeta();
    }
    private void kopioiTiedostot() {
        toiminnot.lisaaViinilista(tiedostonkasittely.kopioiViinit());
        toiminnot.lisaaArviolista(tiedostonkasittely.kopioiArviot());
        toiminnot.lisaaHankintalista(tiedostonkasittely.kopioiHankinnat());
        toiminnot.lisaaKayttajalista(tiedostonkasittely.kopioiKayttajat());
        tiedostonkasittely.tyhjennaKaikkiTiedostot();
    }
    private void lopeta() {
        tiedostonkasittely.kirjoitaViinit(toiminnot.getViinit());
        tiedostonkasittely.kirjoitaArviot(toiminnot.getArviot());
        tiedostonkasittely.kirjoitaKayttajat(toiminnot.getKayttajat());
        tiedostonkasittely.kirjoitaHankinnat(toiminnot.getHankinnat());
    }
}
