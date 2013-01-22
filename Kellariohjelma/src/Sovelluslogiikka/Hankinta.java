
package Sovelluslogiikka;


public class Hankinta {
    private Pullo pullo;
    private int maara;
    private Paivays paivays;
    
    public Hankinta(Pullo pullo, int maara, Paivays paivays) {
        this.pullo = pullo;
        this.maara = maara;
        this.paivays = paivays;
    }
    public void kulutaPullo(){
        if (maara > 0) {
            maara--;
        }
    }
    public int getMaara() {
        return maara;
    }
    public Pullo getPullo() {
        return pullo;
    }
    @Override
    public String toString() {
        return paivays.toString()+" "+pullo.getViini().lyhytToString()+"maara: "+maara+" kpl";
    }
}
