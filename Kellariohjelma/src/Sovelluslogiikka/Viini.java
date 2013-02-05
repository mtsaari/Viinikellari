
package Sovelluslogiikka;


import java.util.Random;


/**
 *
 * @author mikko
 */
public class Viini {
    private Vari vari;
    private Tyyli tyyli;
    private String vuosikerta;
    private String maa;
    private String alue;
    private String alkupera;
    private String tuottaja;
    private String pullote;
    private String rypalelaji;
    private String avain;
    

    public Viini(String vari, String tyyli, String rypalelaji, String vuosikerta,
            String maa, String alue, String alkupera, String tuottaja, String pullote) {
        luoAvain();
        vari(vari);
        tyyli(tyyli);
        this.maa = maa;
        this.vuosikerta = vuosikerta;
        this.alue = alue;
        this.tuottaja = tuottaja;
        this.pullote = pullote;
        this.alkupera = alkupera;
        this.rypalelaji = rypalelaji;
     
        
    }
    public Viini(String b) {
        String[] a = b.split("¤");
        this.avain = a[0];
        this.vari = Vari.valueOf(a[1]); this.tyyli = Tyyli.valueOf(a[2]);
        this.rypalelaji = a[3];
        this.vuosikerta = a[4];
        this.maa = a[5];
        this.alue = a[6];
        this.alkupera = a[7];
        this.tuottaja = a[8];
        this.pullote = a[9];   
        
    }
    private boolean tyyli(String t) {                
        if (t.equals("mieto")) {
            this.tyyli = Tyyli.MIETO;
        }   else if (t.equals("kuohuva")) {
            this.tyyli = Tyyli.KUOHUVA;
        }   else if (t.equals("vakeva")) {
            this.tyyli = Tyyli.VAKEVA;
        }   else if (t.equals("makea")) {
            this.tyyli = Tyyli.MAKEA;
        }   else {
            return false;            
        }
        return true;
    }
    private boolean vari(String vari) {    
        if (vari.equals("puna")) {
            this.vari = Vari.PUNAINEN;
        }   else if (vari.equals("valko")) {
            this.vari = Vari.VALKOINEN;
        }   else if (vari.equals("rose")) {
            this.vari = Vari.ROSE;
        }   else    {
            return false;
            
        }
        return true; 
    }
    public String tiedostomuoto() { 
        return avain+"¤"+vari+"¤"+tyyli+"¤"+rypalelaji+"¤"+vuosikerta
                +"¤"+maa+"¤"+alue+"¤"+alkupera+"¤"+tuottaja+"¤"+pullote;
    }
    private void luoAvain() {
        String a = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += a.charAt(r.nextInt(a.length()));
        }
        this.avain = s;
    }
    public String getAvain() {
        return avain;
    }
    @Override
    public String toString() {
        return "Vuosikerta:         " + vuosikerta + "\n"
                + "Vari:               " + vari.toString() + "\n" 
                + "Tyyli:              " + tyyli.toString() + "\n"
                + "Tuottaja:           " + tuottaja + "\n"
                + "Rypälelaji          " + rypalelaji + "\n"
                + "Pullote             " + pullote + "\n"
                + "Maa                 " + maa + "\n"
                + "Alue                " + alue + "\n"
                + "Alkuperämerkintä    " + alkupera + "\n" + "\n";
                
    }

    public String lyhytToString() {
        return vuosikerta + " " + tuottaja + " " + alkupera + " " + pullote;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viini other = (Viini) obj;
        if ((this.vari == null) ? (other.vari != null) : !this.vari.equals(other.vari)) {
            return false;
        }
        if ((this.tyyli == null) ? (other.tyyli != null) : !this.tyyli.equals(other.tyyli)) {
            return false;
        }
        if ((this.vuosikerta == null) ? (other.vuosikerta != null) : !this.vuosikerta.equals(other.vuosikerta)) {
            return false;
        }
        if ((this.maa == null) ? (other.maa != null) : !this.maa.equals(other.maa)) {
            return false;
        }
        if ((this.alue == null) ? (other.alue != null) : !this.alue.equals(other.alue)) {
            return false;
        }
        if ((this.alkupera == null) ? (other.alkupera != null) : !this.alkupera.equals(other.alkupera)) {
            return false;
        }
        if ((this.tuottaja == null) ? (other.tuottaja != null) : !this.tuottaja.equals(other.tuottaja)) {
            return false;
        }
        if ((this.pullote == null) ? (other.pullote != null) : !this.pullote.equals(other.pullote)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.vari != null ? this.vari.hashCode() : 0);
        hash = 11 * hash + (this.tyyli != null ? this.tyyli.hashCode() : 0);
        hash = 11 * hash + (this.vuosikerta != null ? this.vuosikerta.hashCode() : 0);
        hash = 11 * hash + (this.maa != null ? this.maa.hashCode() : 0);
        hash = 11 * hash + (this.alue != null ? this.alue.hashCode() : 0);
        hash = 11 * hash + (this.alkupera != null ? this.alkupera.hashCode() : 0);
        hash = 11 * hash + (this.tuottaja != null ? this.tuottaja.hashCode() : 0);
        hash = 11 * hash + (this.pullote != null ? this.pullote.hashCode() : 0);
        return hash;
    }
    
}
