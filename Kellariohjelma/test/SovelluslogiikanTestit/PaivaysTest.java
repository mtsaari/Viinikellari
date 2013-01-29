package SovelluslogiikanTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Paivays;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class PaivaysTest {
    Paivays eka;
    Paivays toka;
    Paivays kolmas;
    ArrayList<Paivays> lista;
    public PaivaysTest() {
    }
    
    
    @Before
    public void setUp() {
        eka = new Paivays(31,12,2012);
        toka = new Paivays(1,1,2013);
        kolmas = new Paivays(2,1,2013);
        lista = new ArrayList<Paivays>();
        lista.add(eka);
        lista.add(toka);
        lista.add(kolmas);
    }
    @Test
    public void vikaPvmTuleeEnsin() {
        Collections.sort(lista);
        assertEquals("2.1.2013", lista.get(0).toString());
        assertEquals("1.1.2013", lista.get(1).toString());
        assertEquals("31.12.2012", lista.get(2).toString());
    }
    @Test
    public void vaariaPaivamaariaEiHyvaksyta() {
        assertEquals(false, new Paivays(1,13,2011).onkoPaivaysKorrekti());
        assertEquals(false, new Paivays(31,9,2012).onkoPaivaysKorrekti());
        assertEquals(false, new Paivays(32,12,2012).onkoPaivaysKorrekti());
    }
    @Test 
    public void karkauspaivatOikein() {
        assertEquals(true, new Paivays(29,2,2000).onkoPaivaysKorrekti());
        assertEquals(true, new Paivays(29,2,2012).onkoPaivaysKorrekti());
        assertEquals(false, new Paivays(29,2,1900).onkoPaivaysKorrekti());
    }
}
