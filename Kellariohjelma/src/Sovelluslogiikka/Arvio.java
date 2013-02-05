
package Sovelluslogiikka;


public class Arvio implements Comparable<Arvio>{
    private Paivays paivays;
    private int pisteet;
    private String kuvaus;
    private String maistaja;
    private String avain;
    
    public Arvio(String avain, String maistaja, Paivays paivays, int pisteet, String kuvaus) {
        this.avain = avain;
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
    public Arvio(String s) {
        String[] sanat = s.split("¤");
        this.avain = sanat[0];
        this.maistaja = sanat[1];
        this.paivays = new Paivays(sanat[2]);
        this.pisteet = Integer.parseInt(sanat[3]);
        this.kuvaus = sanat[4];
    }
    public String getAvain() {
        return avain;
    }
    public int getPisteet() {
        return this.pisteet;
    }
    public Paivays getPaivays() {
        return paivays;
    }
    @Override
    public String toString() {
        return "Maistaja    "+ maistaja +"\n"+
               "Pvm         "+ paivays.toString()+"\n"+
               "Pisteet     "+ pisteet+"\n"+kuvaus+"\n";
                
    }
    public String tiedostomuoto() {
        return avain+"¤"+maistaja+"¤"+paivays.toString()+"¤"+pisteet+"¤"+kuvaus;
    }
   
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arvio other = (Arvio) obj;
        if (this.paivays != other.paivays && (this.paivays == null || !this.paivays.equals(other.paivays))) {
            return false;
        }
        if (this.pisteet != other.pisteet) {
            return false;
        }
        if ((this.kuvaus == null) ? (other.kuvaus != null) : !this.kuvaus.equals(other.kuvaus)) {
            return false;
        }
        if ((this.maistaja == null) ? (other.maistaja != null) : !this.maistaja.equals(other.maistaja)) {
            return false;
        }
        if ((this.avain == null) ? (other.avain != null) : !this.avain.equals(other.avain)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.paivays != null ? this.paivays.hashCode() : 0);
        hash = 13 * hash + this.pisteet;
        hash = 13 * hash + (this.kuvaus != null ? this.kuvaus.hashCode() : 0);
        hash = 13 * hash + (this.maistaja != null ? this.maistaja.hashCode() : 0);
        hash = 13 * hash + (this.avain != null ? this.avain.hashCode() : 0);
        return hash;
    }

    @Override
    public int compareTo(Arvio t) {
        return this.paivays.compareTo(t.getPaivays());
    }
    
}
