/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Kayttaja;
import Sovelluslogiikka.Kellaritoiminnot;
import javax.swing.JOptionPane;

/**
 *  Käyttöliittymäluokka, jota käytetään sisäänkirjautumiseen
 * @author mikko
 */
public class Sisaankirjautuminen extends javax.swing.JDialog {

    private Kellaritoiminnot toiminnot;
    private boolean kirjautunut;
    private Kayttaja kayttaja;

    /**
     * luo uuden JDialog olion kun käyttäjä haluaa kirjautua sisään
     * @param toiminnot 
     */
    public Sisaankirjautuminen(java.awt.Frame parent, boolean modal, Kellaritoiminnot toiminnot) {
        super(parent, modal);
        initComponents();
        this.toiminnot = toiminnot;
        this.kirjautunut = false;
    }

    public boolean getKirjautunut() {
        return kirjautunut;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }
    /**
     * lukeen käyttäjän antaman syötteen ja muuttaa statuksen kirjautuneeksi
     */
    public void kirjaudu() {
        String tunnus = jTextField1.getText();
        String salasana = new String(jPasswordField1.getPassword());
        Kayttaja uusi = toiminnot.etsiKayttaja(tunnus);
        if (uusi == null) {
            virheilmoitus("Tuntematon käyttäjätunnus.");
            return;
        }
        if (!uusi.getSalasana().equals(salasana)) {
            virheilmoitus("Virheellinen salasana.");
            return;
        }
        this.kayttaja = uusi;
        this.kirjautunut=true;
    }

    private void virheilmoitus(String ilmoitus) {
        JOptionPane.showMessageDialog(this, ilmoitus);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPasswordField1.setText("jPasswordField1");

        jButton1.setText("Kirjaudu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Palaa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Käyttäjätunnus:");

        jLabel2.setText("Salasana:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(66, 66, 66)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jTextField1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * tapahtumakuuntelija Kirjaudu-nappulalle
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        kirjaudu();
        if (kirjautunut) {
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * tapahtumakuuntelija Palaa-vaihtoehdolle
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        kirjautunut = true;
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
