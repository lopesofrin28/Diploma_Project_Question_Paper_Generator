/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticpaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Pass {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Connection con = null;
  PreparedStatement pst = null;
    ResultSet rs = null;
     try {
           
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csv_db", "root", "");
       Statement s=con.createStatement();
       Class.forName("com.mysql.jdbc.Driver").newInstance();
      String sql1="select username,Research,Phone,Qualification from login where username='Aniruddha Narendra Joshi'";
       pst = con.prepareStatement(sql1);
       rs = pst.executeQuery();
       String research=null;
       String phone=null;
       String qual=null;
       String name=null;
       
       while (rs.next()) {
       research = rs.getString("Research");
       phone = rs.getString("Phone");
       qual = rs.getString("Qualification");
       name = rs.getString("username");
       
       }
       System.out.println(name);
       System.out.println(research);
       System.out.println(phone);
       System.out.println(qual);
       
       GlobalVars.addValuesToGlobalMap("a", name);
       GlobalVars.addValuesToGlobalMap("c", phone);
       GlobalVars.addValuesToGlobalMap("d", qual);
       GlobalVars.addValuesToGlobalMap("b", research);

       
        
     }  catch (SQLException ex) {
            Logger.getLogger(Pass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
