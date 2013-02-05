/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author mikko1
 * 
 */
public class Paivays implements Comparable<Paivays> {
    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.vuosi = vuosi;
        this.kuukausi = kuukausi;
        this.paiva = paiva;
    }
    public Paivays(String s) {
        String[]a = s.split("\\.");
        this.paiva = Integer.parseInt(a[0]);
        this.kuukausi = Integer.parseInt(a[1]);
        this.vuosi = Integer.parseInt(a[2]);
    }

    public boolean onkoPaivaysKorrekti() {
        if (kuukausi < 1 || kuukausi > 12) {
            return false;
        }
        if (kuukausi == 2) {
            return karkausvuosi();
        }
        if (kuukausi == 4 || kuukausi == 6 || kuukausi == 9 || kuukausi == 11){
            if (paiva < 1 || paiva > 30) {
                return false;
            }
        }
        if (paiva < 1 || paiva > 31) {
            return false;
        }
        return true;
    }

    private boolean karkausvuosi() {
        if (vuosi % 4 != 0 || vuosi % 100 == 0 && !(vuosi % 400 == 0)) {
            if (paiva < 1 || paiva > 28) {
                return false;
            }
        }
        if (paiva < 1 || paiva > 29) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return paiva + "." + kuukausi + "." + vuosi;
    }

    @Override
    public int compareTo(Paivays t) {
        if (this.vuosi > t.vuosi) {
            return -1;
        }
        if (this.vuosi < t.vuosi) {
            return 1;
        }
        if (this.vuosi == t.vuosi) {
            if (this.kuukausi > t.kuukausi) {
                return -1;
            }
            if (this.kuukausi < t.kuukausi) {
                return 1;
            }
            if (this.kuukausi == t.kuukausi) {
                if (this.paiva > t.paiva) {
                    return -1;
                }
                if (this.paiva < t.paiva) {
                    return 1;
                }
            }
        }
        return 0;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paivays other = (Paivays) obj;
        if (this.paiva != other.paiva) {
            return false;
        }
        if (this.kuukausi != other.kuukausi) {
            return false;
        }
        if (this.vuosi != other.vuosi) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.paiva;
        hash = 53 * hash + this.kuukausi;
        hash = 53 * hash + this.vuosi;
        return hash;
    }
}
