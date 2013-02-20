/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kellariohjelma.gui;

import Sovelluslogiikka.Arvio;
import Sovelluslogiikka.Kellaritoiminnot;
import Sovelluslogiikka.Paivays;
import javax.swing.JOptionPane;

/**
 *
 * @author mikko
 */
public class UusiArvio extends javax.swing.JDialog {

    private Kellaritoiminnot toiminnot;
    private Arvio arvio;
    private boolean arvioLuotu;
    private String avain;
    private String tunnus;

    /**
     * Creates new form UusiArvio
     */
    public UusiArvio(java.awt.Frame parent, boolean modal, Kellaritoiminnot toiminnot, String avain, String tunnus) {
        super(parent, modal);
        initComponents();
        this.toiminnot = toiminnot;
        this.arvioLuotu = false;
        this.avain = avain;
        this.tunnus = tunnus;
    }
    public boolean getArvioLuotu() {
        return arvioLuotu;
    }

    public Arvio getArvio() {
        return arvio;
    }

    private boolean paivaysOikeaaMuotoa(String s) {
        String[] p = s.split("\\.");
        if (p.length != 3) {
            return false;
        }
        for (int i = 0; i < p.length; i++) {
            if (!onkoNumero(p[i])) {
                return false;
            }
        }
        return true;
    }

    private void virheilmoitus(String ilmoitus) {
        JOptionPane.showMessageDialog(this, ilmoitus);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldPisteet = new javax.swing.JTextField();
        jTextFieldPaivays = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("pp.kk.vvvv");

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel2.setText("Kuvaus");

        jLabel3.setText("Pisteet (50-100)");

        jButton1.setText("Valmis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPisteet)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldPaivays))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPaivays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPisteet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        luoArvio();
        if(arvioLuotu) {
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPaivays;
    private javax.swing.JTextField jTextFieldPisteet;
    // End of variables declaration//GEN-END:variables

    private Paivays luoPaivays(String p) {
        Paivays paivays = null;
        if (!paivaysOikeaaMuotoa(p)) {
            virheilmoitus("Anna päiväys muodossa 'pp.kk.vvvv'.");
            arvioLuotu = false;
        } else {
            paivays = new Paivays(p);
            if (!paivays.onkoPaivaysKorrekti()) {
                virheilmoitus("Antamasi päiväys on virheellinen.");
                arvioLuotu = false;
                paivays = null;
            }
        }
        return paivays;
    }

    private void luoArvio() {
        arvioLuotu = true;
        String pvm = jTextFieldPaivays.getText();
        Paivays paivays = luoPaivays(pvm);
        if(paivays==null) {
            return;
        }
        String kuvaus = jEditorPane1.getText();
        String pisteet = jTextFieldPisteet.getText();
        if (!onkoNumero(pisteet)) {
            virheilmoitus("Anna pisteet numeroina.");
            arvioLuotu = false;
        } else {
            int p = Integer.parseInt(pisteet);
            if(p > 100 || p < 50) {
                virheilmoitus("Pisteiden tulee olla välillä 50-100");
                arvioLuotu = false;
            } else {
                this.arvio = new Arvio(avain,tunnus,paivays,p,kuvaus);
            }
        }
    }
    private boolean onkoNumero(String numero) {
        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
