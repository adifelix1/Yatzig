/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Adi
 */
public class mySqlConnect {
    Connection conn=null;
    public static Connection connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/yatzig_db","root","1234");
            JOptionPane.showMessageDialog(null, "You are conncted to the Database", "Server Status", JOptionPane.INFORMATION_MESSAGE);
            return conn; 
        }catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
    }
    
}

}
