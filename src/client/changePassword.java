/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
  * @author Adi Malka
 * @author Felix Vainer
 * 
 */
/**
 * 
 * This class lets the user change its password
 */
public class changePassword extends javax.swing.JFrame {

    /**
     * Creates new form changePassword
     */
    static Connection conn = loginGUI.conn;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    public changePassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        oldPassTxt = new javax.swing.JPasswordField();
        newPassTxt = new javax.swing.JPasswordField();
        conPasstxt = new javax.swing.JPasswordField();
        background_green = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Old Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 72, 110, 25));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("New Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 123, 120, 20));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 20));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 70, -1));

        jButton2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButton2.setText("Cancel");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));
        getContentPane().add(oldPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 120, -1));
        getContentPane().add(newPassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 120, -1));
        getContentPane().add(conPasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 120, -1));

        background_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        background_green.setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().add(background_green, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String un = loginGUI.username;
        String op = oldPassTxt.getText();
        String dbp = null,np=null,cp=null;
        int f = 0;
        try{
            String sql = "select password from users where user_name='"+un+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) 
                dbp=rs.getString("password");
            if(dbp.equals(op))
               f=1; 
            else f=0;
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(f==0)
        JOptionPane.showMessageDialog(null, "Incorrect Password");
        
        np=newPassTxt.getText();
        cp=conPasstxt.getText();
        
        if(!np.equals(cp))
        {
            f=0;
             JOptionPane.showMessageDialog(null, "New Password does not mach");
        }
        
        if(f==1)
        {
            try{
              String sql = "update users set password='"+np+"' where user_name='"+un+"'";

            pst = conn.prepareStatement(sql);
            pst.execute();
            
            
            }
        

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            JOptionPane.showMessageDialog(null, "Password Updated");
        }
        
        oldPassTxt.setText("");
        newPassTxt.setText("");
        conPasstxt.setText("");
        
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
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_green;
    private javax.swing.JPasswordField conPasstxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPassTxt;
    private javax.swing.JPasswordField oldPassTxt;
    // End of variables declaration//GEN-END:variables
}
