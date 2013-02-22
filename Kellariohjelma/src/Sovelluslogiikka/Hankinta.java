
package Sovelluslogiikka;


public class Hankinta implements Comparable<Hankinta>{
    private Viini viini;
    private int pullokoko;
    private int maara;
    private Paivays paivays;
    private String tunnus;
    private String ostopaikka;
    private double hinta;
    private int juotu;
    private int jaljella;
    
    public Hankinta(Viini viini, String tunnus, int maara, int pullokoko,
            Paivays paivays, String ostopaikka, double hinta) {
        this.pullokoko = pullokoko;
        this.maara = maara;
        this.paivays = paivays;
        this.viini = viini;
        this.tunnus = tunnus;
        this.ostopaikka = ostopaikka;
        this.hinta = hinta;
        this.jaljella = maara;
        this.juotu = 0;
        
    }
    public Hankinta(Viini v, String s) {
        this.viini = v;
        String[] a = s.split("¤");
        this.tunnus = a[1];
        this.paivays = new Paivays(a[2]);
        this.pullokoko = Integer.parseInt(a[3]);
        this.maara = Integer.parseInt(a[4]);        
        this.juotu = Integer.parseInt(a[5]);
        this.jaljella = maara - juotu;
        this.ostopaikka = a[6];
        this.hinta = Double.parseDouble(a[7]);
       
    }
    public void kulutaPullo(){
        if (jaljella > 0) {
            jaljella--;
            juotu++;
        }
    }
    public String getTunnus() {
        return tunnus;
    }
    public int getMaara() {
        return maara;
    }
    public double getHinta() {
        return hinta;
    }
    public int getJaljella() {
        return jaljella;
    }
    public Paivays getPaivays() {
        return paivays;
    }
    public Viini getViini() {
        return viini;
    }
    public String tiedostomuoto() {
        return viini.getAvain()+"¤"+tunnus+"¤"+paivays.toString()+"¤"+pullokoko+"¤"
                +maara+"¤"+juotu+"¤"+ostopaikka+"¤"+hinta;
    }
    @Override
    public String toString() {
        return paivays.toString()+" "+pullokoko+" "+viini.toString();
    }
    public String naytaHankinta() {
        String format = "%1$-10s %2$-70s %3$-9s %4$-8s %5$-8s";
        String nayta = String.format(format, paivays.toString(), viini.toString(), pullokoko, maara, jaljella);
        return nayta;
    }
    @Override
    public int compareTo(Hankinta t) {
        return paivays.compareTo(t.getPaivays());
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hankinta other = (Hankinta) obj;
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
        if ((this.ostopaikka == null) ? (other.ostopaikka != null) : !this.ostopaikka.equals(other.ostopaikka)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hinta) != Double.doubleToLongBits(other.hinta)) {
            return false;
        }
        if (this.juotu != other.juotu) {
            return false;
        }
        if (this.jaljella != other.jaljella) {
            return false;
        }
        return true;
    }

    
     
       

    
}
