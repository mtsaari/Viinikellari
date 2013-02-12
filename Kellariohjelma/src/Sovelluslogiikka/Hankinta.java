
package Sovelluslogiikka;


public class Hankinta implements Comparable<Hankinta>{
    private Viini viini;
    private int pullokoko;
    private int maara;
    private Paivays paivays;
    private String tunnus;
    
    public Hankinta(Viini viini, String tunnus, int maara, int pullokoko, Paivays paivays) {
        this.pullokoko = pullokoko;
        this.maara = maara;
        this.paivays = paivays;
        this.viini = viini;
        this.tunnus = tunnus;
    }
    public Hankinta(Viini v, String s) {
        this.viini = v;
        String[] a = s.split("¤");
        this.tunnus = a[1];
        this.paivays = new Paivays(a[2]);
        this.pullokoko = Integer.parseInt(a[3]);
        this.maara = Integer.parseInt(a[4]);
    }
    public void kulutaPullo(){
        if (maara > 0) {
            maara--;
        }
    }
    public String getTunnus() {
        return tunnus;
    }
    public int getMaara() {
        return maara;
    }
    public Paivays getPaivays() {
        return paivays;
    }
    public Viini getViini() {
        return viini;
    }
    public String tiedostomuoto() {
        return viini.getAvain()+"¤"+tunnus+"¤"+paivays.toString()+"¤"+pullokoko+"¤"+maara;
    }
    @Override
    public String toString() {
        return paivays.toString()+" "+pullokoko+" "+viini.lyhytToString()+" "+maara;
    }
    @Override
    public int compareTo(Hankinta t) {
        return paivays.compareTo(t.getPaivays());
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hankinta other = (Hankinta) obj;
        if (this.viini != other.viini && (this.viini == null || !this.viini.equals(other.viini))) {
            return false;
        }
        if (this.pullokoko != other.pullokoko) {
            return false;
        }
        if (this.maara != other.maara) {
            return false;
        }
        if (this.paivays != other.paivays && (this.paivays == null || !this.paivays.equals(other.paivays))) {
            return false;
        }
        if ((this.tunnus == null) ? (other.tunnus != null) : !this.tunnus.equals(other.tunnus)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.viini != null ? this.viini.hashCode() : 0);
        hash = 41 * hash + this.pullokoko;
        hash = 41 * hash + this.maara;
        hash = 41 * hash + (this.paivays != null ? this.paivays.hashCode() : 0);
        hash = 41 * hash + (this.tunnus != null ? this.tunnus.hashCode() : 0);
        return hash;
    }
}
