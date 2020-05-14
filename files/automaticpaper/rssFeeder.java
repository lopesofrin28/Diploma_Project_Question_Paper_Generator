/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automaticpaper;
import java.io.*;
import java.net.*;
/**
 *
 * @author Admin
 */
public class rssFeeder {
    public static void main(String args[]) throws IOException
    {
        System.out.println(readRss("http://www.careerbuilder.com/RTQ/rss20.aspx?rssid=RSS_PD&num=25&geoip=false&ddcompany=false&ddtitle=false&cat=JN004"));
    }

    public static String readRss(String urlAddress) throws IOException {
        try{
        URL rssUrl=new URL(urlAddress);
        BufferedReader in=new BufferedReader(new InputStreamReader(rssUrl.openStream()));
        String sourceCode="";
        String line;
        while ((line = in.readLine()) != null) {
    int titleEndIndex = 0;
    int titleStartIndex = 0;
    while (titleStartIndex >= 0) {
        titleStartIndex = line.indexOf("<title>", titleEndIndex);
        if (titleStartIndex >= 0) {
            titleEndIndex = line.indexOf("</title>", titleStartIndex);
            sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
        }
    }
}
       /* while((line = in.readLine())!= null)
        {
            
            if(line.contains("<title>"))
            {
            int firstPos = line.indexOf("<title>");
            String temp = line.substring(firstPos);
            temp = temp.replace("<title>", "");
            int lastPos = temp.indexOf("</title>");
            temp = temp.substring(0, lastPos);
            sourceCode += temp+"\n";
            }
        }*/
        
       /* while((line = in.readLine())!= null)
        {
            if(line.contains("<title>"))
            {
                
                int firstPos = line.indexOf("<title>");
                String temp = line.substring(firstPos);
                int fp = temp.indexOf("</title>");
                int lastPos = line.indexOf("</title>");
                
            System.out.println(firstPos);
            System.out.println(lastPos);
            System.out.println(fp);
            }    
        
        }*/  
        in.close();
        return sourceCode;
        
    }catch(MalformedURLException e){
        System.out.println("Something went wrong reading URL");
    }
        catch(IOException e){
            System.out.println("hello");
        }
      
    //catch(MalFormedURLException e){
        //System.out.println("MalFormed URL");
    //}

    return null;
    }
    
}
