/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka;

/**
 *
 * @author mikko
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
}
