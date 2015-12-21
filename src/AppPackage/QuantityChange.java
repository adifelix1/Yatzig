/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Adi
 */
public class QuantityChange extends javax.swing.JFrame {

   static Connection conn = loginGUI.conn;
    static Statement pst = null;
    static ResultSet rs = null;
    String itemId;
    String newQ;
    public QuantityChange() {
        initComponents();
        
        user_update_table();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        quantityChangeTable = new javax.swing.JTable();
        aproveButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        quantityChangeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        quantityChangeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityChangeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(quantityChangeTable);

        aproveButton.setText("Aprove");
        aproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aproveButtonActionPerformed(evt);
            }
        });

        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aproveButton)
                    .addComponent(rejectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(aproveButton)
                        .addGap(34, 34, 34)
                        .addComponent(rejectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantityChangeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityChangeTableMouseClicked
        int raw = quantityChangeTable.getSelectedRow();
            itemId = (quantityChangeTable.getModel().getValueAt(raw, 0).toString());
            newQ = (quantityChangeTable.getModel().getValueAt(raw, 3).toString());
           
    }//GEN-LAST:event_quantityChangeTableMouseClicked

    private void aproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aproveButtonActionPerformed
       boolean checkEmpty=true;
        try{
            String sql = "update items set quantity='"+newQ+"' where item_id='"+itemId+"' ";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        dalate_raw();
        JOptionPane.showMessageDialog(null, "Quantity Change Approved");
        user_update_table();
         try{
            String sql = "select * from quantity_change";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
             checkEmpty=rs.next();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         if(!checkEmpty)
           {
            String sql = "update users set flag=0 where user_type=3";
        try{
            pst = conn.prepareStatement(sql);
            pst.execute(sql);
            }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }
           }
        
    }//GEN-LAST:event_aproveButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        dalate_raw();
        JOptionPane.showMessageDialog(null, "Quantity Change Rejected");
    }//GEN-LAST:event_rejectButtonActionPerformed

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
            java.util.logging.Logger.getLogger(QuantityChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuantityChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuantityChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuantityChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuantityChange().setVisible(true);
            }
        });
    }
    
               private void user_update_table(){
        try{
                 String sql = "select item_id as 'Item ID',user_name as 'User Name',old_quantity as 'Old Quantity',new_quantity as 'New Quantity',comments as 'Comments' from quantity_change";
                 pst=conn.prepareStatement(sql);
                 rs=pst.executeQuery(sql);
                 quantityChangeTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
               
               private void dalate_raw()
               {
                   try{
            String sql = "delete from quantity_change where item_id='"+itemId+"' ";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
               }
               

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aproveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable quantityChangeTable;
    private javax.swing.JButton rejectButton;
    // End of variables declaration//GEN-END:variables
}

