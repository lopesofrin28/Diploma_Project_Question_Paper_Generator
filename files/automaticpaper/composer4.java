/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticpaper;
import java.util.*;
import javax.mail.*;
//import static automaticpaper.Composer1.name;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class composer4 extends javax.swing.JFrame {
    static String username1;

    /**
     * Creates new form composer4
     */
    
     
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public composer4() {
         setContentPane(new JLabel(new ImageIcon("C://Users//Joyan//Desktop//11.jpg")));
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        semester = new javax.swing.JComboBox();
        branch = new javax.swing.JComboBox();
        subject = new javax.swing.JComboBox();
        submit = new javax.swing.JButton();
        mail = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 0, 400, 100));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("ADVANCE QUESTION PAPER GENERATION SYSTEM");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 10, 928, 65);

        jPanel1.setOpaque(false);

        jLabel2.setText("BRANCH");

        jLabel4.setText("SEMESTER");

        jLabel5.setText("SUBJECT");

        semester.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sem 1", "Sem 2", "Sem 3", "Sem 4", "Sem 5", "Sem 6", "Sem 7", "Sem 8" }));
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        branch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Computer", "Mechanical", "Extc", "Electrical", "Civil" }));
        branch.setOpaque(false);
        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });

        subject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6" }));
        subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectActionPerformed(evt);
            }
        });

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        mail.setText("JUST MAIL IT");
        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        jButton1.setText("OPEN FOLDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(submit)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mail))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(branch, 0, 350, Short.MAX_VALUE)
                        .addComponent(semester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(190, 220, 615, 268);

        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(980, 100, 77, 34);

        profile.setText("Profile");
        profile.setOpaque(false);
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        getContentPane().add(profile);
        profile.setBounds(430, 170, 90, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Downloads\\images.jpg")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 280, 220);

        jButton2.setText("TERM TEST MODE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(540, 170, 130, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void close() {
        WindowEvent WinClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WinClosingEvent);
    }
    
    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
    semester.setSelectedItem("Sem 1");
    subject.setSelectedItem("a1");
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        Profile p =new Profile();
        p.setVisible(true);
        try {
            p.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(composer4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(composer4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(composer4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(composer4.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
//        System.out.println("Omkar ->>"+ GlobalVars.getGlobalMap().size());
//        System.out.println("Name: -->" + GlobalVars.getGlobalMap().get("fullName"));
//         name.setText(GlobalVars.getGlobalMap().get("fullName"));
        // TODO add your handling code here:
    }//GEN-LAST:event_profileActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csv_db", "root", "");
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            
            String sub=String.valueOf(subject.getSelectedItem());
            String sql = "SELECT * FROM weightage INNER JOIN " + String.valueOf(subject.getSelectedItem())
                    + " on weightage.HOURS=" + String.valueOf(subject.getSelectedItem()) + ".HOURS";
            
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            String abc = "<html>";
            while (rs.next()) {
                //Retrieve by column name
                // int id  = rs.getInt("id");
                // int age = rs.getInt("age");
                String first = rs.getString("MODULE");
                String last = rs.getString("QUESTIONS");

                //Display values
                //System.out.print("ID: " + id);
                //System.out.print(", Age: " + age);
                abc = abc + "MODULE" + first +" -> NUMBER OF QUESTIONS " + last + "<br/>";
//                System.out.print("MODULE " + first);
//                System.out.println("->NUMBER OF QUESTIONS " + last);
            }
            abc = abc + "</html>";
            composer4 c = new composer4();
           // c.lblText.setSize(450, 450);
           // c.lblText.setText(abc);
            c.setVisible(true);
            // new class of keyward 
            MAPPING1 k=new MAPPING1();
            //calling keyward function
                  k.mapping34(sub);
            rs.close();
            JOptionPane.showMessageDialog(null, "Question paper is generated");
            this.dispose();
            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        Login1 login=new Login1();
        login.setVisible(true);  
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
         
        JComboBox cb = (JComboBox)evt.getSource();
        String petName = (String)cb.getSelectedItem();
         String Branch=String.valueOf(branch.getSelectedItem());  
    
   
         if (Branch.equals("Computer"))
    {
         
         
         if(petName.equals("Sem 1"))
    {
        
        String[] petStrings = { "a1", "b1", "c1", "d1", "e1","f1" };
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        subject.addItem(petStrings[4]);
        subject.addItem(petStrings[5]);
        
        petStrings=null;
        
    }
      if(petName.equals("Sem 2"))
    {
        
        String[] petStrings = { "a2", "b2", "c2", "d2", "e2","f2" };
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        subject.addItem(petStrings[4]);
        subject.addItem(petStrings[5]);
        
        petStrings=null;
        
    }
    if(petName.equals("Sem 3"))
    {
        
        String[] petStrings = { "Discrete_Structure_Graph_Theory", "Electronic_Circuit_Communication_Fundamentals", "Digital_Logic_Design_Analysis", "Data_Structure", "Object_Oriented_Programming_Methodology",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        subject.addItem(petStrings[4]);
       
        
        petStrings=null;
    }
     if(petName.equals("Sem 4"))
    {
        
        String[] petStrings = { "Computer_Graphics", "Analysis_Of_Algorithm", "Computer_Organization_Architecture", "Database_Management_System", "Theory_Computer_Science",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        subject.addItem(petStrings[4]);
        
        
        petStrings=null;
    }
     if(petName.equals("Sem 5"))
    {
        
        String[] petStrings = { "Operating_System", "Microprocessor", "Computer_Networks", "Structured_Object_Oriented_Analysis_Design",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        
        petStrings=null;
    }
    if(petName.equals("Sem 6"))
    {
        
        String[] petStrings = { "Distrubuted_database", "Mobile_Computing_Communication", "System_Programming_Compiler_Comstruction", "Software_Engineering",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
       
        
        petStrings=null;
    }
     if(petName.equals("Sem 7"))
    {
        
        String[] petStrings = { "Artificial_Intelligence", "Advance_Algorithm", "Digital_Signal_Processing", "Cryptography_And_Security_System",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
     
        
        petStrings=null;
    }
     if(petName.equals("Sem 8"))
    {
        
        String[] petStrings = { "Digital_Forensics", "Parallel_Distrubted_System", "Data_Warehouse_Minning", "Human_Machine_Interaction",};
        subject.removeAllItems();
        subject.addItem(petStrings[0]);
        subject.addItem(petStrings[1]);
        subject.addItem(petStrings[2]);
        subject.addItem(petStrings[3]);
        
        
        petStrings=null;
    }
    }
    
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterActionPerformed

    private void subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
       
       Mail m=new Mail();
       m.setVisible(true);
       m.fromtext.setText("aqpgs16@gmail.com");
       this.dispose();
       
       
    }//GEN-LAST:event_mailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        OpenMain();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
       composerut c= new composerut();
       c.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
/* private void OpenMain()
    { try
 {
  //Path for folder or file that you want to open
  //In my case i will open C:\ drive
  //So create a String like below
  //Don't forget to change \ to \\
  String a="E:/";
  //Execute command
  //Command that you must know : rundll32 SHELL32.DLL,ShellExec_RunDLL File_Or_Folder_To_Open
  Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL \""+a+"\"");
 }
 catch(Exception exception)
 {
  exception.printStackTrace();
 }  }*/
  

    private void OpenMain() 
    {            
            Desktop desktop = Desktop.getDesktop();        
            File dirToOpen = null;
            try {        
                String path = "e:\\";        
                Runtime runtime = Runtime.getRuntime();        
                runtime.exec("explorer.exe "+path);        
                System.out.println("open");        
            } catch (Exception E) {        
                System.out.println("File Not Found");        
            }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(composer4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(composer4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(composer4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(composer4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new composer4().setVisible(true);
            }
        });
    }
      public javax.swing.JTextField fromtext;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox branch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JButton logout;
    private javax.swing.JButton mail;
    private javax.swing.JButton profile;
    private javax.swing.JComboBox semester;
    private javax.swing.JComboBox subject;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
