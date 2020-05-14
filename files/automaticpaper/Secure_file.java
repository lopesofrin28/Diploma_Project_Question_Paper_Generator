package automaticpaper;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author prathamesh
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Secure_file
{

  

 /** User password. */
    public static byte[] USER = Login1.pwd.getBytes();
    /** Owner password. */
    public static byte[] OWNER = Login1.pwd.getBytes();
    
    public static void anu(String sub) throws IOException{
   
   
   
  System.out.println("Hi1");
      try
      { 
          File file = new File("E:/"+sub+".pdf");
        file.getParentFile().mkdirs();
        new Secure_file().manipulatePdf("E:/"+sub+".pdf", "E:/"+sub+"Secured"+".pdf");
          
          //Secure_file.encryptPdf(SRC,DEST);
} catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
   
   
   }
     
public static void main(String[] args) throws IOException {

}
/*
    public static void main() throws IOException {
        
        System.out.println("Hi1");
      try
      { 
           File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Secure_file().manipulatePdf(SRC, DEST);
          
          //Secure_file.encryptPdf(SRC,DEST);
    } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      
    }*/

//public static void encryptPdf(String src, String dest) throws IOException, DocumentException {
   
//}

 public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
     
     System.out.println("Hi2");
        
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        
        System.out.println("Hi3");
        
         //Encrypting PDF
         //PdfReader reader = new PdfReader(src);
   // PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.setEncryption(USER, OWNER,
        PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
    //stamper.close();
    //reader.close();
    
        
            //Watermark
        PdfContentByte under = stamper.getUnderContent(1);
        Font f = new Font(FontFamily.HELVETICA, 70);
       // Phrase p = new Phrase("This watermark is added UNDER the existing content", f);
       // ColumnText.showTextAligned(under, Element.ALIGN_CENTER, p, 297, 550, 0);
        PdfContentByte over = stamper.getOverContent(1);
       // p = new Phrase("This watermark is added ON TOP OF the existing content", f);
       // ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, 297, 500, 0);
       Phrase p = new Phrase("AQPGS", f);
        over.saveState();
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.3f);
        over.setGState(gs1);
        ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, 297, 450, 30);
        over.restoreState();
        stamper.close();
        reader.close();
        
       
        
    

    }

  

}