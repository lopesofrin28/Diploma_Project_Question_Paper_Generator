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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class numrical1 {
    public static void main(String args[])
    {
        int count=0;
        Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csv_db", "root", "");
            stmt = con.createStatement();
            String[] sums =new String[20];
               String problem = "select PROBLEMS from DSP_SUMS";   
                   pst=con.prepareStatement(problem);
                   rs = pst.executeQuery();
                   while (rs.next()){
                String problems=rs.getString("PROBLEMS");
             
               
                if (problems.contains(",")) {
                    sums = problems.split(",");
                   }

                if (sums == null || sums.length == 0) {
                    System.out.println("Null array found");
                    return;
                }
                 System.out.println("Value: " + sums[new Random().nextInt(sums.length)]);
                   }
                   
        } catch (SQLException ex) {
            Logger.getLogger(numrical1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
