package java112.analyzer ;
import java.io.*;
import java.util.* ;

/**
 *  This class tests if a word is lexical or not. <br>
 *@since March 9th, 2016
 *@author     M. Alhassan
 */
public class LexicalTester {  
    private ArrayList<String> nonLexicalList; 
    private InputStream nonLexicalFile;    
    
    /**
     * Default contructor for class. Sets default file for <br>
     * non Lexicals
     */
    public LexicalTester() {       
        nonLexicalList = new ArrayList<String>();
        nonLexicalFile = this.getClass().getResourceAsStream("/nonLexicalWords.txt");    
    }

    /**
     * Constructor with file of non Lexical words specified <br>
     *@param fileName file containing list of functional words
     */
    public LexicalTester(InputStream fileName) {       
        this();
        nonLexicalFile = fileName;
        read(nonLexicalFile);        
    }
    
    /**
     *Method checks nonLexical file list to check if a word is lexical or not<br>
     *
     *@param word word to be tested
     *@return true or false indicating lexicality of word
     */
    public boolean isLexical (String word) {
        for (String nonLexical : nonLexicalList) {
            if (word.equals(nonLexical))
                return false;      
        }
        return true;
    }

    
    /**
     *Reads from a file line by line from a given file<br>
     *
     *@param fileName file to be read from     
     */
    public void read(InputStream fileName) {
        String line = null;
        BufferedReader in = null;
        try {            
            in = new BufferedReader(new InputStreamReader(fileName));
            while (in.ready()) { 
                line = in.readLine();
                nonLexicalList.add(line);
            }        
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File could not be read");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File could not be read");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("An Exception reading from file");
            exception.printStackTrace();
        }  finally {
            try {
                in.close();
            } catch (IOException ioEx2) {
                ioEx2.printStackTrace();
            }       
        } 

    }     
   
}