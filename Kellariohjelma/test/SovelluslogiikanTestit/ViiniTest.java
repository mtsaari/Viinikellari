package SovelluslogiikanTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Sovelluslogiikka.Viini;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mikko
 */
public class ViiniTest {
    private Viini viini1;
    private Viini v2;
    private Viini v3;
    
    public ViiniTest() {
    }
    
    
    
    @Before
    public void setUp() {
        viini1 = new Viini("Punainen", "Mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon",13);
        this.v2 = new Viini("Punainen", "Mieto", "Pinot Noir", "2010", "Ranska",
                 "Burgundi", "Mercurey", "Faiveley", "Clos des Myglands",13);
        this.v3 = new Viini("Valkoinen", "Makea", "Riesling", "2011", "Saksa",
                 "Nahe", "-","Dönnhoff", "Oberhauser Leistenberg Riesling Kabinett",11);
    }
    @Test
    public void compareToMetodiJarjestaaViinitVuosikerranTuottajanPullotteenMukaan() {
        ArrayList<Viini> viinit = new ArrayList<Viini>();
        viinit.add(v2);
        viinit.add(viini1);
        viinit.add(v3);
        Collections.sort(viinit);
        assertEquals(true, viinit.get(0).equals(v3));
        assertEquals(true, viinit.get(1).equals(viini1));
        assertEquals(true, viinit.get(2).equals(v2));
    }
    @Test
    public void equalsMetodiToimii() {
        Viini viini2 =  new Viini("Punainen","Mieto","Syrah","2010","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon",13);
        assertEquals(true, viini1.equals(viini2));
        Viini viini3 = new Viini("Punainen","Mieto","Syrah","2009","Ranska",
                "Pohjois-Rhone","St Joseph","Delas","Francois de Tournon",13);
        assertEquals(false, viini3.equals(viini1));
    }
    @Test 
    public void konstruktoriLuoKopionViinistaTiedostomuodonAvulla() {
        Viini uusi = new Viini(viini1.tiedostomuoto());
        assertEquals(true, uusi.equals(viini1));
    }
    @Test
    public void hakuOsumaPalauttaaTrueKunYhdenSananMerkkijonoVastaaJotakinViininAttribuuttia() {
        assertEquals(true, viini1.hakuOsuma("Syrah"));
        assertEquals(true, viini1.hakuOsuma("ranska"));
        assertEquals(true, viini1.hakuOsuma("Tournon"));
                
    }
    @Test
    public void hakuOsumaPalauttaaTrueKunUseanSananHakumerkkijonoVastaaUseaaaViininAttribuuttiaTaiAttribuutinOsaa() {
        assertEquals(true, viini1.hakuOsuma("ranska syrah"));
        assertEquals(false, viini1.hakuOsuma("merlot ranska"));
        assertEquals(true, viini1.hakuOsuma("Rhone Delas"));
        assertEquals(true, viini1.hakuOsuma("syrah ranska rhone"));
        assertEquals(false, viini1.hakuOsuma("st joseph syrah perrin"));
    }
    
    
}