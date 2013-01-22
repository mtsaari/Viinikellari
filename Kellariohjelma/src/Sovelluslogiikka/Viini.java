
package Sovelluslogiikka;

import java.util.ArrayList;


/**
 *
 * @author mikko
 */
public class Viini {

    private String vari;
    private String tyyli;
    private String vuosikerta;
    private String maa;
    private String alue;
    private String alkupera;
    private String tuottaja;
    private String pullote;
    private String rypalelaji;
    private ArrayList<String> hakusanat;
    private String hakumerkkijono;
    private ArrayList<Arvio> arviot;

    public Viini(String vari, String tyyli, String rypalelaji, String vuosikerta,
            String maa, String alue, String alkupera, String tuottaja, String pullote) {
        this.vari = vari;
        this.tyyli = tyyli;
        this.maa = maa;
        this.vuosikerta = vuosikerta;
        this.alue = alue;
        this.tuottaja = tuottaja;
        this.pullote = pullote;
        this.alkupera = alkupera;
        this.rypalelaji = rypalelaji;
        this.hakusanat = new ArrayList<String>();
        this.arviot  = new ArrayList<Arvio>();
        lisaaHakusanat();
        this.hakumerkkijono = vari+" "+tyyli+" "+maa+" "+vuosikerta+" "
                +alue+" "+tuottaja+" "+pullote+" "+alkupera+" "+rypalelaji;
    }

    private void lisaaHakusanat() {
        hakusanat.add(vari);
        hakusanat.add(tyyli);
        hakusanat.add(vuosikerta);
        hakusanat.add(maa);
        hakusanat.add(alue);
        hakusanat.add(tuottaja);
        if (!alkupera.isEmpty()) {
            hakusanat.add(alkupera);
        }
        if (!pullote.isEmpty()) {
            hakusanat.add(pullote);
        }
        if (!rypalelaji.isEmpty()) {
        hakusanat.add(rypalelaji);
        }
    }
    public ArrayList<String> getHakusanat() {
        return hakusanat;
    }
    public String getHakumerkkijono() {
        return hakumerkkijono;
    }
    public void lisaaArvio(Arvio a) {
        arviot.add(a);
    }

    public String naytaArviot() {
        String p = "";
        for (Arvio arvio : arviot) {
            p += arvio.toString() + "\n";
        }
        return p;
    }

    public double pisteKeskiArvo() {
        if (!arviot.isEmpty()) {
            int summa = 0;
            int eiPisteita = 0;
            for (Arvio arvio : arviot) {
                if (arvio.getPisteet() != 0) {
                    summa += arvio.getPisteet();
                }   else    {
                    eiPisteita++;
                }
            }
            return (double) summa / (arviot.size()-eiPisteita);
        }
        return 0;
    }
   
    @Override
    public String toString() {
        return "Vuosikerta:         " + vuosikerta + "\n"
                + "Vari:               " + vari + "\n" 
                + "Tyyli:              " + tyyli + "\n"
                + "Tuottaja:           " + tuottaja + "\n"
                + "Rypälelaji          " + rypalelaji + "\n"
                + "Pullote             " + pullote + "\n"
                + "Maa                 " + maa + "\n"
                + "Alue                " + alue + "\n"
                + "Alkuperämerkintä    " + alkupera + "\n" + "\n" + "\n"
                + naytaArviot();
    }

    public String lyhytToString() {
        return vuosikerta + " " + tuottaja + " " + alkupera + " " + pullote + " " + ". Pisteet (ka): " + pisteKeskiArvo();
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
