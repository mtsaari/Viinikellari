/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttoliittymaTestit;

import Kayttoliittyma.Tiedostonkasittely;
import Sovelluslogiikka.Tyyli;
import Sovelluslogiikka.Vari;
import Sovelluslogiikka.Viini;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class TiedostonkasittelyTest {
    Tiedostonkasittely tk;
    Viini v1;
    Viini v2;
    
    public TiedostonkasittelyTest() {
        
    }
    
    
    
    @Before
    public void setUp()  {
        tk = new Tiedostonkasittely("testi.txt");
        v1 = new Viini(Vari.PUNAINEN,Tyyli.MIETO,"Sangiovese","2006","Italia"
                ,"Toscana","Chianti Classico Riserva","Felsina","Rancia");
        
    }
    @Test
    public void tiedostoonLisattyViiniLoytyyYhdellaHakusanalla() {
        tk.lisaaViini(v1);
        assertEquals(true, tk.etsiViini("2006").get(0).equals(v1));
        assertEquals(true, tk.etsiViini("Felsina").get(0).equals(v1));
        assertEquals(true, tk.etsiViini("Sangiovese").get(0).equals(v1));
        assertEquals(true, tk.etsiViini("Chianti").get(0).equals(v1));
    }
    @Test
    public void tiedostoonLisattyViiniLoytyyUseammallaHakusanalla() {
        tk.tyhjennaTiedosto();
        tk.lisaaViini(v1);
        assertEquals(true, tk.etsiViini("Felsina Rancia").get(0).equals(v1));
        assertEquals(true, tk.etsiViini("Chianti Classico Toscana").get(0).equals(v1));
    }
    
    
}
