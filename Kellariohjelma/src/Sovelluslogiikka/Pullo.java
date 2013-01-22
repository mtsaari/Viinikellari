
package Sovelluslogiikka;



public class Pullo {
    private Viini viini;
    private int koko;
     
    public Pullo(Viini viini, int koko) {
        this.viini = viini;
        this.koko = koko;
    }
    public Viini getViini() {
        return viini;
    }
}