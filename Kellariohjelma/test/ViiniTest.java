/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class ViiniTest {
    private Viini viini1;
    public ViiniTest() {
    }
    
    
    
    @Before
    public void setUp() {
        viini1 = new Viini("punainen","mieto viini","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
    }
    @Test
    public void equalsMetodiToimii() {
        Viini viini2 =  new Viini("punainen","mieto viini","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
        assertEquals(true, viini1.equals(viini2));
    }
    @Test
    public void keskiarvoMetodiToimiiEikaPisteettomatArviotLaskeKeskiarvoa() {
        Arvio a1 = new Arvio("Mikko", new Paivays(21,1,2013), 90, "Tämä oli hyvää");
        Arvio a2 = new Arvio("Mikko", new Paivays(21,1,2013), 89, "Tämä oli hyvää");
        Arvio a3 = new Arvio("Mikko", new Paivays(21,1,2013), "Tämä oli hyvää");
        viini1.lisaaArvio(a2);
        viini1.lisaaArvio(a1);
        viini1.lisaaArvio(a3);
        assertEquals(89.5, viini1.pisteKeskiArvo(), 1e-15);
    }
    
}