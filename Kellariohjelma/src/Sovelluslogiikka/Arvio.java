
package Sovelluslogiikka;


public class Arvio {
    private Paivays paivays;
    private int pisteet;
    private String kuvaus;
    public String maistaja;
    
    public Arvio(String maistaja, Paivays paivays, int pisteet, String kuvaus) {
        this.maistaja = maistaja;
        this.paivays = paivays;
        this.pisteet = pisteet;
        this.kuvaus = kuvaus;
    }
    public Arvio(String maistaja, Paivays paivays, String kuvaus) {
        this.kuvaus = kuvaus;
        this.maistaja = maistaja;
        this.paivays = paivays;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    @Override
    public String toString() {
        return "Maistaja    "+ maistaja +"\n"+
               "Pvm         "+ paivays.toString()+"\n"+
               "Pisteet     "+ pisteet+"\n"+kuvaus+"\n";
                
    }
}
