/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmafinal;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhanushka
 */
public class setstudentupdate extends javax.swing.JDialog {

    /**
     * Creates new form setstudentupdate
     */
    public setstudentupdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setstudent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tname = new javax.swing.JComboBox<>();
        t1 = new javax.swing.JComboBox<>();
        g1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tnameItemStateChanged(evt);
            }
        });
        jPanel1.add(tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 30));

        t1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select data" }));
        t1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                t1ItemStateChanged(evt);
            }
        });
        t1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t1MouseClicked(evt);
            }
        });
        jPanel1.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 30));

        g1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select" }));
        jPanel1.add(g1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 30));

        jButton1.setText("Add to Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Subject");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tnameItemStateChanged
        try {
            t1.removeAllItems();
            t1.addItem("Please Select");

            String stid = (String) tname.getSelectedItem();
            ResultSet rs = DB.search("select * from subject where subjectname='" + stid + "'");
            if (rs.next()) {
                System.out.println("erer");
                String id = rs.getString("subjectid");
                ResultSet e = DB.search("select * from subject_has_teacher where subject_subjectid='" + id + "'");
                while (e.next()) {
                    System.out.println("bbbbbbb");
                    String d = e.getString("teacher_teacherid");
                    ResultSet q = DB.search("select * from teacher where teacherid='" + d + "'");
                    if (q.next()) {
                        System.out.println("dsdf");
                        String name = q.getString("name");

                        t1.addItem(name);
                    } else {

                    }
                }
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tnameItemStateChanged

    private void t1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_t1ItemStateChanged
        try {
            g1.removeAllItems();
            g1.addItem("select here");
            String stid = (String) t1.getSelectedItem();
            ResultSet rs = DB.search("select * from teacher where name='" + stid + "'");
            if (rs.next()) {
                String id = rs.getString("teacherid");
                ResultSet e = DB.search("select * from subject_has_teacher where teacher_teacherid='" + id + "'");
                if (e.next()) {
                    String d = e.getString("subtea_id");
                    ResultSet q = DB.search("select * from classregistation  where subject_has_teacher_subtea_id='" + d + "'");
                    if (q.next()) {
                        String nn = q.getString("type");

                        g1.addItem(nn);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_t1ItemStateChanged

    private void t1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t1MouseClicked

    }//GEN-LAST:event_t1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) MainGUI.setaction.getModel();
        int i = MainGUI.setaction.getRowCount();
        boolean b = false;
        for (int j = 0; j < i; j++) {
            boolean s1 = (boolean) MainGUI.setaction.getValueAt(j, 0);
            String s2 = (String) MainGUI.setaction.getValueAt(j, 1);
            String s3 = (String) MainGUI.setaction.getValueAt(j, 2);
            String s4 = (String) MainGUI.setaction.getValueAt(j, 3);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
            if (s2.equals(tname.getSelectedItem()) && s3.equals(t1.getSelectedItem()) && s4.equals(g1.getSelectedItem())) {
                System.out.println(s2 == tname.getSelectedItem());
                System.out.println(s3 == t1.getSelectedItem());
                System.out.println(s4 == g1.getSelectedItem());
                b = true;

            } else {

            }

        }
        if (b == false) {
            Vector v = new Vector();
            v.add(false);
            v.add(tname.getSelectedItem());
            v.add(t1.getSelectedItem());
            v.add(g1.getSelectedItem());
            dtm.addRow(v);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Already Add");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(setstudentupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setstudentupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setstudentupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setstudentupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setstudentupdate dialog = new setstudentupdate(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox g1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> t1;
    public static javax.swing.JComboBox<String> tname;
    // End of variables declaration//GEN-END:variables

    private void setstudent() {
        try {
            setstudentupdate.tname.removeAllItems();
            setstudentupdate.tname.addItem("none");
            ResultSet rs = DB.search("select * from stream where stream='" + MainGUI.jComboBox7.getSelectedItem() + "'");
            if (rs.next()) {
                String w = rs.getString("streamid");
                ResultSet raa = DB.search("select * from stream_has_subject  where stream_streamid='" + w + "'");
                while (raa.next()) {
                    System.out.print("sdsd");
                    String sub = raa.getString("subject_subjectid");
                    ResultSet e = DB.search("select * from subject where subjectid='" + sub + "'");

                    if (e.next()) {
                        String xxx = e.getString("subjectname");

                        setstudentupdate.tname.addItem(xxx);
                        System.err.println(xxx);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}