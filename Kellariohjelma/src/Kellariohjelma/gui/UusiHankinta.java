/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kellariohjelma.gui;

import Sovelluslogiikka.Hankinta;
import Sovelluslogiikka.Paivays;
import Sovelluslogiikka.Viini;
import javax.swing.JOptionPane;

public class UusiHankinta extends javax.swing.JDialog {
    private Viini viini;
    private Hankinta hankinta;
    private boolean hankintaLuotu;
    private String tunnus;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextFieldPvm = new javax.swing.JTextField();
        jTextFieldKoko = new javax.swing.JTextField();
        jTextFieldKpl = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHinta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPaikka = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Valmis");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Päivämäärä(pp.kk.vvvv):");

        jLabel2.setText("Pullokoko(ml):");

        jLabel3.setText("Määrä:");

        jLabel4.setText("Hinta(€/plo):");

        jLabel5.setText("Ostopaikka:");

        jButton2.setText("Valmis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPvm, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldKpl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldHinta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                        .addComponent(jTextFieldKoko, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(20, 20, 20))
                            .addComponent(jTextFieldPaikka, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPvm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKoko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldHinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPaikka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        luoHankinta();
        if (hankintaLuotu) {
            setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldHinta;
    private javax.swing.JTextField jTextFieldKoko;
    private javax.swing.JTextField jTextFieldKpl;
    private javax.swing.JTextField jTextFieldPaikka;
    private javax.swing.JTextField jTextFieldPvm;
    // End of variables declaration//GEN-END:variables

    public UusiHankinta(java.awt.Frame parent, boolean modal, Viini viini, String tunnus) {
        super(parent, modal);
        initComponents();
        this.hankintaLuotu = false;
        this.viini = viini;
        this.tunnus = tunnus;
    }
    public boolean gethankintaLuotu() {
        return hankintaLuotu;
    }
    public Hankinta getHankinta() {
        return this.hankinta;
    }
    public void luoHankinta() {
        hankintaLuotu = true;
        String pvm = jTextFieldPvm.getText();
        Paivays paivays = luoPaivays(pvm);
        String pullokoko = jTextFieldKoko.getText();
        String maara = jTextFieldKpl.getText();
        String hinta = jTextFieldHinta.getText();
        String myyja = jTextFieldPaikka.getText();
        if (!onkoKokonaisluku(pullokoko)) {
            virheilmoitus("Anna pullon koko millilitroissa kokonaislukuna.");
            hankintaLuotu = false;
            return;
        }
        int koko = Integer.parseInt(pullokoko);
        if(!onkoKokonaisluku(maara)) {
            virheilmoitus("Anna pullojen määrä yhtenä kokonaislukuna");
            hankintaLuotu = false;
            return;
        }
        int kpl = Integer.parseInt(maara);
        if(!onkoDesimaaliluku(hinta)) {
            virheilmoitus("Anna hinta desimaalilukuna. Erota desimaalit pisteellä '.'");
            hankintaLuotu = false;
            return;
        }
        double eurot = Double.parseDouble(hinta);    
        this.hankinta = new Hankinta(viini, tunnus, kpl, koko, paivays, myyja, eurot);



    }

    private Paivays luoPaivays(String p) {
        Paivays paivays = null;
        if (!paivaysOikeaaMuotoa(p)) {
            virheilmoitus("Anna päiväys muodossa 'pp.kk.vvvv'.");
            hankintaLuotu = false;
        } else {
            paivays = new Paivays(p);
            if (!paivays.onkoPaivaysKorrekti()) {
                virheilmoitus("Antamasi päiväys on virheellinen.");
                hankintaLuotu = false;
                paivays = null;
            }
        }
        return paivays;
    }

    private boolean paivaysOikeaaMuotoa(String s) {
        String[] p = s.split("\\.");
        if (p.length != 3) {
            return false;
        }
        for (int i = 0; i < p.length; i++) {
            if (!onkoKokonaisluku(p[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean onkoKokonaisluku(String numero) {
        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void virheilmoitus(String ilmoitus) {
        JOptionPane.showMessageDialog(this, ilmoitus);
    }

    private boolean onkoDesimaaliluku(String numero) {
        try {
            Double.parseDouble(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
