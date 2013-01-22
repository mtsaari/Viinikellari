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
    private Kellaritoiminnot toiminnot;
    private Scanner lukija;
    
    public Kayttoliittyma() {
        toiminnot = new Kellaritoiminnot();
        lukija = new Scanner(System.in);
    }
    public void alkuvalikko() {
        System.out.println("VIINIKELLARI");
        System.out.println("");
        System.out.println("Valitse toiminto (näppäile numero ja paina Enter):");
        System.out.println("1 - Etsi viiniarvioita");
        System.out.println("2 - Kirjaudu sisään");
        System.out.println("3 - Luo Käyttäjätunnus");
        
    }
}
