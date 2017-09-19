 import java.io.IOException;
 import java.net.URL;
 import java.util.Scanner;

import org.w3c.dom.Text;

    /**
     * Retrieve contents from a URL and return them as a string.
     * @return the contents from the url as a string, or an empty string on error
     */
public class Lab3 {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
       //System.out.println(hamlet);
       hamlet.replace(',', ' ');
       hamlet.replace('\t', ' ');
       hamlet.replace('.', ' ');
       hamlet.replace('!', ' ');
       hamlet.replace('\n', ' ');
       hamlet.replace('?', ' ');
       System.out.println(hamlet);
       String word=null;
       int wordcount=0;
       int princeCounter=0;
       for(int i = 0; i<hamlet.length()-1; i++)
       {
           while(hamlet.charAt(i)!=(' '))
           {
               word+=hamlet.charAt(i);
           }
           wordcount++;
           if(word.compareTo("prince")==0)
           {
               princeCounter++;
               System.out.println(word);
           }
           word=null;
       }
       System.out.println("Word count "+ wordcount);
       System.out.println("Prince occurrences "+princeCounter);


    }

}
