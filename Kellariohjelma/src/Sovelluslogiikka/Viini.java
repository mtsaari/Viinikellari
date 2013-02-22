package Sovelluslogiikka;

import java.util.Random;

/**
 * 
 * @author mikko
 */
public class Viini implements Comparable<Viini> {

    private String vari;
    private String tyyli;
    private String vuosikerta;
    private String maa;
    private String alue;
    private String alkupera;
    private String tuottaja;
    private String pullote;
    private String rypalelaji;
    private String avain;
    private double alkoholi;

    /**
     * luo uuden Viini-olion parametrina 9 merkkijonoa. Tätä konstruktoria
     * käytettäessä viinille luodaan avain, joka on satunnainen 10 merkin
     * pituinen merkkijono. Avain toimii avaimena sekä Viinit että Arviot
     * sisältävässä HashMapissa.
     *
     * @param vari
     * @param tyyli
     * @param rypalelaji
     * @param vuosikerta
     * @param maa
     * @param alue
     * @param alkupera
     * @param tuottaja
     * @param pullote
     */
    public Viini(String vari, String tyyli, String rypalelaji, String vuosikerta,
            String maa, String alue, String alkupera, String tuottaja, String pullote, double alkoholi) {
        luoAvain();
        this.vari = vari;
        this.tyyli = tyyli;
        this.maa = maa;
        this.vuosikerta = vuosikerta;
        this.alue = alue;
        this.tuottaja = tuottaja;
        this.pullote = pullote;
        this.alkupera = alkupera;
        this.rypalelaji = rypalelaji;
        this.alkoholi = alkoholi;
    }

    /**
     * Luo uuden Viini-olion parametrina tiedostomuoto-merkkijono
     *
     * @param b String tiedostomuoto, jossa kenttien arvot on erotettu
     * "¤"-merkillä.
     */
    public Viini(String b) {
        String[] a = b.split("¤");
        this.avain = a[0];
        this.vari = a[1];
        this.tyyli = a[2];
        this.rypalelaji = a[3];
        this.vuosikerta = a[4];
        this.maa = a[5];
        this.alue = a[6];
        this.alkupera = a[7];
        this.tuottaja = a[8];
        this.pullote = a[9];
        this.alkoholi = Double.parseDouble(a[10]);

    }

    /**
     * luo Viini-oliosta merkkijonon, joka talletetaan tiedostoon ja jonka
     * avulla ohjelma kopioi olion tiedostosta
     *
     * @return merkkijono
     */
    public String tiedostomuoto() {
        return avain + "¤" + vari + "¤" + tyyli + "¤" + rypalelaji + "¤" + vuosikerta
                + "¤" + maa + "¤" + alue + "¤" + alkupera + "¤" + tuottaja + "¤" + pullote + "¤" + alkoholi;
    }

    /**
     * metodi luo Viini-oliolle 10-merkkisen satunnaisen merkkijonon, joka
     * toimii Viinit ja Arviot sisältävien HashMap-olioiden avaimena
     */
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

    /**
     * asettaa Viinille uuden avaimen
     *
     * @param avain merkkijono
     */
    public void asetaAvain(String avain) {
        this.avain = avain;
    }

    /**
     * tarkastaa vastaako mahdollisesti useita sanoja sisältävä
     * hakusana-merkkijono viinin attribuutteja
     *
     * @param sana String käyttäjän antama hakusana
     * @return palauttaa true vain jos hakusana merkkijonon kaikki sanat
     * vastaavat jotakin viinin attribuuttia
     */
    public boolean hakuOsuma(String sana) {
        String[] hakusanat = sana.split(" ");
        String[] attribuutit = this.tiedostomuoto().split("¤");
        int samat = 0;
        for (int i = 0; i < hakusanat.length; i++) {
            for (int j = 0; j < attribuutit.length; j++) {
                String[] osat = attribuutit[j].split(" ");
                if (osat.length == 1) {
                    osat = attribuutit[j].split("-");
                }
                for (int k = 0; k < osat.length; k++) {
                    if (hakusanat[i].equalsIgnoreCase(osat[k])) {
                        samat++;
                    }
                }
            }
        }
        if (samat < hakusanat.length) {
            return false;
        }
        return true;
    }

    /**
     * merkkijono, joka esittää viinin attribuutit kattavasti
     *
     * @return String
     */
    public String pitkaToString() {
        return "Vuosikerta:         " + vuosikerta + "\n"
                + "Vari:               " + vari.toString() + "\n"
                + "Tyyli:              " + tyyli.toString() + "\n"
                + "Tuottaja:           " + tuottaja + "\n"
                + "Rypälelaji          " + rypalelaji + "\n"
                + "Pullote             " + pullote + "\n"
                + "Maa                 " + maa + "\n"
                + "Alue                " + alue + "\n"
                + "Alkuperämerkintä    " + alkupera + "\n\n";

    }

    @Override
    public String toString() {
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

    @Override
    public int compareTo(Viini t) {
        if (!this.vuosikerta.equals("nv")) {
            int tamaVk = Integer.parseInt(this.vuosikerta);
            int tuoVk = Integer.parseInt(t.vuosikerta);
            if (tamaVk > tuoVk) {
                return -1;
            }
            if (tamaVk < tuoVk) {
                return 1;
            }
        }
        if (this.tuottaja.compareTo(t.tuottaja) != 0) {
            return this.tuottaja.compareTo(t.tuottaja);
        }
        return this.pullote.compareTo(t.pullote);
    }
}
