/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.sql.*;
import javax.swing.*;
/**
 *  This class holds all the queries that the applications
 * use in the data base.
 * @author Adi Malka and Felix Vainer
 */
public class mySqlConnect {
    Connection conn=null;
    public static Connection connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/yatzig_db","root","1234");
            return conn; 
        }catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
    }
    
}

}
