/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kellariohjelma.gui;

import Sovelluslogiikka.Viini;
import javax.swing.JOptionPane;

/**
 *
 * @author mikko
 */
public class UusiViini extends javax.swing.JDialog {

    private Viini viini;
    private boolean viiniLuotu;

    /**
     * Creates new form UusiViini
     */
    public UusiViini(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.viiniLuotu = false;
    }

    public boolean getViiniLuotu() {
        return viiniLuotu;
    }

    public Viini getViini() {
        return viini;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jTextFieldMaa = new javax.swing.JTextField();
        jTextFieldAlue = new javax.swing.JTextField();
        jTextFieldTuot = new javax.swing.JTextField();
        jTextFieldAlkup = new javax.swing.JTextField();
        jTextFieldPull = new javax.swing.JTextField();
        jTextFieldVk = new javax.swing.JTextField();
        jTextFieldRyp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldAlk = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Punainen", "Valkoinen", "Rosé" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mieto", "Väkevä", "Kuohuva", "Makea" }));

        jLabel1.setText("Väri:");

        jLabel2.setText("Tyyli:");

        jLabel3.setText("Maa:");

        jLabel4.setText("Alue:");

        jLabel5.setText("Tuottaja:");

        jLabel6.setText("Alkuperämerkintä:");

        jLabel7.setText("Pullotteen nimi:");

        jLabel8.setText("Vuosikerta:");

        jLabel9.setText("Rypälelaji:");

        jButton1.setText("Valmis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Alkoholi(%):");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Anna viinin tiedot (\"-\", jos tietoa ei ole)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldRyp)
                                    .addComponent(jTextFieldVk)
                                    .addComponent(jTextFieldPull)
                                    .addComponent(jTextFieldAlkup)
                                    .addComponent(jTextFieldAlk)))
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTuot)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldMaa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jTextFieldAlue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTuot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAlkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAlk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        luoViini();
        if (viiniLuotu) {
            setVisible(false);

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldAlk;
    private javax.swing.JTextField jTextFieldAlkup;
    private javax.swing.JTextField jTextFieldAlue;
    private javax.swing.JTextField jTextFieldMaa;
    private javax.swing.JTextField jTextFieldPull;
    private javax.swing.JTextField jTextFieldRyp;
    private javax.swing.JTextField jTextFieldTuot;
    private javax.swing.JTextField jTextFieldVk;
    // End of variables declaration//GEN-END:variables

    private void luoViini() {
        viiniLuotu = true;
        String vari = (String) jComboBox1.getSelectedItem();
        String tyyli = (String) jComboBox2.getSelectedItem();
        String maa = jTextFieldMaa.getText();
        String alue = jTextFieldAlue.getText();
        String tuottaja = jTextFieldTuot.getText();
        String alkupera = jTextFieldAlkup.getText();
        String pullote = jTextFieldPull.getText();
        String vuosikerta = jTextFieldVk.getText();
        String rypale = jTextFieldRyp.getText();
        String alkoholi = jTextFieldAlk.getText();
        if (!onkoNumero(alkoholi)) {
            virheilmoitus("Anna alkoholipitoisuus desimaalilukuna. Erota desimaalit pisteellä");
            this.viiniLuotu = false;
            return;
        }
        double alk = alkoholi(alkoholi);
        String ilm = "Valitse YES jos tiedot ovat oikein"+"\n"+"Vari: "+vari+"\n"
                +"Tyyli: "+tyyli+"\n"+"Maa: "+maa+"\n"+"Alue: "+alue+"\n"+
                "Tuottaja: "+tuottaja+"\n"+"Alkuperä: "+alkupera+"\n"+"Pullote: "+pullote+"\n"+
                "Vuosikerta: "+vuosikerta+"\n"+"Rypälelaji: "+rypale+"\n"+"Alkoholi: "+alkoholi;
        int vast = JOptionPane.showConfirmDialog(this, ilm, "Varmistus", JOptionPane.YES_NO_OPTION);
        if (vast==JOptionPane.NO_OPTION) {
            this.viiniLuotu=false;
            return;
        }
        this.viini = new Viini(vari, tyyli, rypale, vuosikerta, maa,
                alue, alkupera, tuottaja, pullote, alk);

    }

    private boolean onkoNumero(String numero) {
        if (numero.equals("-")) {
            return true;
        }
        try {
            Double.parseDouble(numero);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void virheilmoitus(String ilmoitus) {
        JOptionPane.showMessageDialog(this, ilmoitus);
    }

    private double alkoholi(String alkoholi) {
        if (alkoholi.equals("-")) {
            return 0;
        }
        return Double.parseDouble(alkoholi);
    }
}
