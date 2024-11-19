/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmafinal;

import static enigmafinal.MainGUI.table1;
import static enigmafinal.MainGUI.table2;
import static enigmafinal.MainGUI.table3;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhanushka
 */
public class setstudents extends javax.swing.JDialog {

    /**
     * Creates new form setstudents
     */
    public setstudents(java.awt.Frame parent, boolean modal) {
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
        g1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        g1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                g1ItemStateChanged(evt);
            }
        });
        jPanel1.add(g1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, 30));

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Class Type");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        jLabel2.setText("Please Select Class Type");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void g1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_g1ItemStateChanged
            DefaultTableModel dtma = (DefaultTableModel) MainGUI.table3.getModel();
        dtma.setRowCount(0);
        int i = table1.getSelectedRow();
        String stid = (String) table1.getValueAt(i, 0);
        int i1 = table2.getSelectedRow();
        String s2 = (String) table2.getValueAt(i1, 0);
        String fd=null;
        try {
            // g1.removeAllItems();
//            g1.addItem("select here");

            ResultSet rs = DB.search("select * from teacher where name='" + stid + "'");
            if (rs.next()) {

                String id = rs.getString("teacherid");
                ResultSet e = DB.search("select * from subject_has_teacher where teacher_teacherid='" + id + "'");
                if (e.next()) {
                    ResultSet ex = DB.search("select * from subject where subjectname='" + s2 + "'");
                    if (ex.next()) {
                        String sn = ex.getString("subjectid");
                       
                        ResultSet xx=DB.search("select * from subject_has_teacher where subject_subjectid='"+sn+"' and teacher_teacherid='"+id+"'");
                        if(xx.next()){
                         String d = xx.getString("subtea_id");
                        
                        ResultSet q = DB.search("select * from classregistation  where subject_has_teacher_subtea_id='" + d + "'  and type='" + g1.getSelectedItem() + "'");
                        if (q.next()) {
                            String classid = q.getString("classid");
                            ResultSet a1 = DB.search("select * from student_has_classregistation where classregistation_classid='" + classid + "'");
                            while (a1.next()) {
                                String sid = a1.getString("student_studentid");
                                ResultSet st = DB.search("select * from student where studentid='" + sid + "'");
                                if (st.next()) {
                                    DefaultTableModel dtm = (DefaultTableModel) MainGUI.table3.getModel();
                                    int j = MainGUI.table3.getRowCount();
                                    Vector v = new Vector();
                                    System.out.println(j);
                                    Boolean b = false;
                                    for (int k = 0; k < j; k++) {
fd=classid;
                                        String ck = (String) MainGUI.table3.getValueAt(k, 0);
                                        String l1 = st.getString("indexid");
                                        String l2 = st.getString("studentid");
                                        String s11 = st.getString("firstname");
                                        String s22 = st.getString("middlename");
                                        String s33 = st.getString("lastname");

                                        if (ck.equals(l1)) {
                                            b = true;
                                        } else {

                                        }

                                    }
                                    if (b == false) {
                                        System.out.println("notequal");
                                        String l1 = st.getString("indexid");
                                        String l2 = st.getString("studentid");
                                        String s11 = st.getString("firstname");
                                        String s22 = st.getString("middlename");
                                        String s33 = st.getString("lastname");
                                        //   System.out.println(ck);
                                        //   System.out.println(l1);
                                        //Vector v = new Vector();
                                        v.add(l1);
                                        v.add(l2);
                                        v.add(s11 + " " + s22 + " " + s33);
                                        dtm.addRow(v);
                                    }

                                }

                            }

                        }}
                    }
                }
            }
            MainGUI.jComboBox33.removeAllItems();
            MainGUI.jComboBox33.addItem(fd);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_g1ItemStateChanged

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
            java.util.logging.Logger.getLogger(setstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setstudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setstudents dialog = new setstudents(new javax.swing.JFrame(), true);
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

    private void setstudent() {
        int i = table1.getSelectedRow();
        String stid = (String) table1.getValueAt(i, 0);
        int i1 = table2.getSelectedRow();
        String s2 = (String) table2.getValueAt(i1, 0);
        try {
            g1.removeAllItems();
            g1.addItem("select here");

            ResultSet rs = DB.search("select * from teacher where name='" + stid + "'");
            if (rs.next()) {

                String id = rs.getString("teacherid");
                ResultSet e = DB.search("select * from subject_has_teacher where teacher_teacherid='" + id + "'");
                if (e.next()) {
                    ResultSet ex = DB.search("select * from subject where subjectname='" + s2 + "'");
                    if (ex.next()) {
                        String sn = ex.getString("subjectid");
                      //  String d = e.getString("subtea_id");
                        ResultSet xx=DB.search("select * from subject_has_teacher where subject_subjectid='"+sn+"' and teacher_teacherid='"+id+"'");
                        if(xx.next()){
                         String d = xx.getString("subtea_id");
                        ResultSet q = DB.search("select * from classregistation  where subject_has_teacher_subtea_id='" + d + "'");
                        if (q.next()) {
                            String nn = q.getString("type");

                            g1.addItem(nn);
                        }}
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> g1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}