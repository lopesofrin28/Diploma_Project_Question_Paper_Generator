package automaticpaper;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import JavaApplication1.Secure_file.manipulatePdf
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import javax.swing.UIManager;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Omkar
 */
public class MAPPING1 extends javax.swing.JFrame {
     int totalque=0;
    private PDFont fontPlain;
      private void shuffleArray(String[] ar) {
         Random rnd = ThreadLocalRandom.current();
    for (int i =totalque-1; i >0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      String a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stmt = null;
    private Object subject;

    /**
     * Creates new form MAPPING1
     */
    public MAPPING1() {
        initComponents();
        Random gen = new Random();

        Color color = new Color(gen.nextInt(240), gen.nextInt(240),
                gen.nextInt(240));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(submit)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(125, 125, 125))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     void mapping34(String sub) throws IOException, COSVisitorException, DocumentException {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here: 
        // String hrs="select HOURS from ai12 where MODULE=1";
         int n;
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csv_db", "root", "");
            stmt = con.createStatement();
            String[] strArr = null;
            
            final String str = "Explain ,Describe ,Write short note on ,What is ,";
            String[] typeQuestion = null;
            String[] que =new String[20];
            
            //String[] args =new String[totalque];
            String array = "";
            int flag = 0;
            int[] no_que=new int[20] ;
            int count1 = 0;
            int any=0;
            int p=0;
            int q=0;
            int a=0;
            boolean signal=false;
            int anything=0;        
          // String outputFileName =null;
          // outputFileName = "Simple1.pdf";
        //if (args.length > 0)
          //  outputFileName = args[0];
           // Composer1 c=new Composer1();
            //Finding no of modules
      if (str.contains(",")) {
            typeQuestion = str.split(",");
        }
        if ( typeQuestion == null || typeQuestion.length == 0) {
            System.out.println("Null array found");
            return;
        }
            System.out.println(sub);
          //System.out.println(String.valueOf(sub));
            String module = "select MODULE from " +sub+"";
            
            PreparedStatement ps1=con.prepareStatement(module);

           ResultSet rs1 = ps1.executeQuery();
          
           while (rs1.next()) {
            
           String mod = rs1.getString("MODULE");
                
           if(!mod.isEmpty()){ 
           any=Integer.parseInt(mod);  
            
            }
          }
           System.out.println("Total modules before "+any);
           
            
            //Finding no of questions
            for(int j=0;j<any;j++)
            {
           // String nquestion = "select QUESTIONS from weightage where HOURS IN(select HOURS from ai1 where MODULE IN(SELECT MODULE FROM ai1 ))";
           String nquestion = "select QUESTIONS from weightage where HOURS =(select HOURS from "+ sub+" where MODULE='"+(j+1)+"')";
             PreparedStatement ps2=con.prepareStatement(nquestion);    
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                String noquestion = rs2.getString("QUESTIONS");
                System.out.println("Total questions:" + noquestion);
                no_que[j] = Integer.parseInt(noquestion);
                totalque = totalque + no_que[j];
                
              
           }
            
           } 
           
            String[] queprnt =new String[totalque];
             
            
            //Generating random questions 
           
             String subtopic = "SELECT SUBTOPIC FROM "+sub+"";
              PreparedStatement ps3=con.prepareStatement(subtopic);
              ResultSet rs3 = ps3.executeQuery();
             
          //  while(rs3.next()){
              //  flag=0;
               while(rs3.next())
               {
                   
                String subtopic1 = rs3.getString("SUBTOPIC");
                array = array + subtopic1;
                flag++;

                if (subtopic1.isEmpty() && flag != 1) {
                    //System.out.println("flag"+flag);
                   // break;
                    //continue;
                count1++;
                
             //   StringTokenizer st2 = new StringTokenizer(array,",");
//System.out.println("Total number of tokens : " + st2.countTokens());
           // while (st2.hasMoreElements()) {
           
                
               
                
                if (array.contains(",")) {
                    strArr = array.split(",");
                   // array1=strArr;
                    
                    /*      
                    String[] key = new String[strArr.length]; 
                    for(int j = 0; j <= strArr.length -1; j++)
                    {
                    if(!strArr[j].isEmpty())
                    {
                    key[j] = strArr[j]; 
                    }
                    System.out.println("Explain " + key[j]);//********
                    }*/




                }

                if (strArr == null || strArr.length == 0) {
                    System.out.println("Null array found");
                    return;
                }
             
                  
                for(int count=0;count < no_que[p];count++) {
                     
                    //if (count == no_que[j]) {
                    //System.exit(0);
                      //continue;
                   // break;
                    //}
                    if(p<any){
                        String match=strArr[new Random().nextInt(strArr.length)];
                         if(q>0){
                              for(int i=1;i<=anything;i++){
                                
                                if(match.contains(que[i-1])){
                                signal=true;
                                break;
                                }
                                signal=false;
                             }  
                              
                              if(signal==true){
                               count--;
                              }
                              
                              if(signal==false){
                              que[q]=match;
                              q++;
                              anything++;
                              }
                           
                       }
                          else{
                       que[q]=match;
                       q++;
                       anything++;
                       }
                   // System.out.println("Explain " + strArr[new Random().nextInt(strArr.length)]);
                   //que[q]=typeQuestion[new Random().nextInt(typeQuestion.length)] + strArr[new Random().nextInt(strArr.length)];
                      //que[q]="Explain" + strArr[new Random().nextInt(strArr.length)];
                   
                    }
                    //System.out.println(""+strArr[j]);
                   
                
                } 
                //System.out.println(""+array);
                ++p;
                
                array="";
                
                
               // }
            
           //st2.nextToken(",");
           //System.out.println(st2.nextToken(","));
            //System.out.println(st2.nextElement());
            

          // st2.nextElement();
          
                
            }
               
               if(subtopic1.contains("//")) 
               {
                count1++;
                if (array.contains(",")) {
                    strArr = array.split(",");
                }
                 if (strArr == null || strArr.length == 0) {
                    System.out.println("Null array found");
                    return;
                }
                  for(int count=0;count < no_que[p];count++) {
                    if(p<any){
                        String match=strArr[new Random().nextInt(strArr.length)];
                       
                       
                         if(q>0){
                              for(int i=1;i<=anything;i++){
                                
                                if(match.contains(que[i-1])){
                                signal=true;
                                break;
                                }
                                signal=false;
                             }  
                              
                              if(signal==true){
                               count--;
                              }
                              
                              if(signal==false){
                                   System.out.println("********");
                                  System.out.println(match);
                              que[q]=match;
                              q++;
                              anything++;
                              }
                           
                       }
                       else{
                       que[q]=match;
                       q++;
                       anything++;
                       
                       }
                   // System.out.println("Explain " + strArr[new Random().nextInt(strArr.length)]);
                                        //que[q]=typeQuestion[new Random().nextInt(typeQuestion.length)] + strArr[new Random().nextInt(strArr.length)];
                                           //que[q]="Explain" + strArr[new Random().nextInt(strArr.length)];
                         
                    } 
               // System.out.println(""+array);
               
                 
                    }
                  ++p;
                
                array="";
               }
                
               }
               
              // StringTokenizer st1 = new StringTokenizer(array,",");

            //while (st1.hasMoreElements()) {
            
                System.out.println(anything);
              
           // }
               System.out.println("******");
             System.out.println("Total modules after"+count1);
             System.out.println("Total questions "+totalque);
              System.out.println("******");
              
        
           // }
/* PDDocument document = new PDDocument();
        PDPage page1 = new PDPage(PDPage.PAGE_SIZE_A4);
         document.addPage(page1);
   PDPageContentStream cos = new PDPageContentStream(document, page1);*/
//shuffleArray(que);
              
          for(int i=0;i<totalque;i++){
                      queprnt[i]=que[i];
                 }
              // for(int i=0;i<totalque;i++){
               /* if(i==totalque-1)
                {
                    break;
                }*/
                 //System.out.println(que[q]); 
                 /*if(que[i].equals(null))
                 {
                     continue;
                 }*/
              
                //System.out.println(queprnt[i]);
               
                //System.out.println(queprnt[i]);
                 
             
             /*for(int i=0;i<totalque;i++){
           System.out.println(queprnt[i]);
             }*/
             
            // System.out.println(strArr.length);
          
             
              Document document = new Document();
              PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E://"+sub+".pdf"));
             
          
              // String USER_PASS = "Hello123";
              //String OWNER_PASS = "Owner123";
              
              //writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
               //    PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
               //Security.addProvider(new BouncyCastleProvider());
              // writer.setEncryption("krishna".getBytes(), "testpass".getBytes(),

                   //     PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);

               String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString(); 
              document.open();
                 Image image1 = Image.getInstance("G:\\mu.png");
               
                 image1.setAbsolutePosition(10f,650f);
                  image1.scaleAbsolute(550,180);
                  document.add(image1);
                       document.add(image1);
                       Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
                         Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
                 document.add(new Paragraph("                                                                             "));
                 document.add(new Paragraph("                                                                             "));
                 document.add(new Paragraph("                                                                             "));
                 document.add(new Paragraph("                                                                             "));
                 document.add(new Paragraph("                                                                             "));
                 document.add(new Paragraph("                                                                             "));
             shuffleArray(queprnt);//shuffling of array queprnt
              
   int c=97;//used to show subquestions a and b
    composer4 c4 = new composer4();
   String Branch=String.valueOf(c4.branch.getSelectedItem());  
    document.add( Chunk.NEWLINE );
     document.add(new Paragraph("Branch: "+Branch+"",boldFont));
    document.add(new Paragraph("Subject: "+sub+"",boldFont));
    document.add(new Paragraph("CODE: "+saltStr+"",boldFont));
    document.add(new Paragraph("                                                                             "));
    document.add(new Paragraph("Rules:",boldFont));
    document.add(new Paragraph("1) Question no.1 is compulsory."));
    document.add(new Paragraph("2) Solve any 3 out of remaining 5 questions."));
    document.add(new Paragraph("3) Marks assigned to each question is given at right side."));
    
   // document.add(new Paragraph("                                                                             "));
    document.add(new Paragraph("____________________________________________________________________________ "));
   
    
   
   //PdfContentByte cb = writer.getDirectContent();
   //cb.beginText();
   //cb.setTextMatrix(100,300);
    document.add( Chunk.NEWLINE );
             for (int i = 0; i <totalque && i<6 ; i++)
    {
        //document.add( Chunk.NEWLINE );
       // if(i==totalque-1)
        //{
             //System.out.println(i);        
          //  break;
                   
       // }     
        document.add(new Paragraph("Q."+(i+1)+"."+" Solve the Following",boldFont));
        System.out.println("Q"+(i+1)+" Solve the Following");
        for(int j=1;j<=2;j++)
        {
            
         //cos.beginText();
        //cos.setFont(fontPlain,12);
        String aChar = new Character((char) c).toString();  
      document.add(new Paragraph("   "+aChar+")."+ typeQuestion[+new Random().nextInt(typeQuestion.length)]+queprnt[a]+" [10]",boldFont1));
      //document.add( Chunk.NEWLINE );
            System.out.print(typeQuestion[new Random().nextInt(typeQuestion.length)]+queprnt[a]+"  [10]");
      c++;
      a++;
      System.out.println();
        }
        c=97;
       document.add( Chunk.NEWLINE );
        System.out.println();
      //cos.endText();
    
    }
             document.add(new Paragraph("                                                                        "));
             document.add(new Paragraph("---------------------------------------------------//ALL THE BEST//-------------------------------------------------------"));
             
             //cb.endText();
       
    document.close();
   writer.close();
     /*cos.close();
          document.save(outputFileName);
        document.close();*/
   
   //Secure_file s=new Secure_file();
           
          //s.main(null);
        Secure_file s = new Secure_file();//call for encyption and watermark
        s.anu(sub);

            
         }catch (SQLException ex) {
            Logger.getLogger(MAPPING1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    //GEN-LAST:event_submitActionPerformed

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
           /* for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MAPPING1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAPPING1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAPPING1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAPPING1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MAPPING1().setVisible(true);
            }
        });
   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

