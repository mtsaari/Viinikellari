package SovelluslogiikanTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Viini;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
        viini1 = new Viini("puna", "mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
    }
    @Test
    public void equalsMetodiToimii() {
        Viini viini2 =  new Viini("puna","mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
        assertEquals(true, viini1.equals(viini2));
        Viini viini3 = new Viini("puna","mieto","Syrah","2009","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon");
        assertEquals(false, viini3.equals(viini1));
    }
    @Test 
    public void konstruktoriLuoKopionViinistaTiedostomuodonAvulla() {
        Viini uusi = new Viini(viini1.tiedostomuoto());
        assertEquals(true, uusi.equals(viini1));
    }
    
    
}