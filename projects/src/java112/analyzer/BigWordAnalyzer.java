package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *  This class performs analysis of big tokens in a file. <br>
 *
 *
 *@author     M. Alhassan
 */
public class BigWordAnalyzer implements Analyzer {
    
    private Properties properties;
    private Set<String> bigWords;
    private int minimumWordLength;

    /**
     *Default contructor. Instantiates the set of big word tokens<br>
     *
     */

    public BigWordAnalyzer () {
        bigWords = new TreeSet<String>();
    }

    /**
     *Instantiates the set of big word tokens, gets properties and gets<br>
     *minimum word length for big words
     *@param properties Loaded properties for object
     */
    public BigWordAnalyzer (Properties properties) {
        this();
        this.properties = properties;
        this.minimumWordLength = Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
    }
  
    /**
     *Getter for list of big tokens<br>
     *
     *@return list of big tokens analyzed
     */
    public Set<String> getBigWords() {
        return bigWords;
    }

    /**
     *Processes a given token-adds token to big tokens list<br>
     *
     *@param token token to be processed     
     */
    public void processToken(String token) {
        if (token.length() >= minimumWordLength)
        bigWords.add(token);      
    }

    /**
     *Writes all big tokens in input file to an output file<br>
     *
     *@param inputFilePath File path for file analyzed   
     */
    public void writeOutputFile(String inputFilePath) {
        Set<String> bigWordsList =  getBigWords();
        String outputFilePath = properties.getProperty("output.dir") + ""
                + properties.getProperty("output.file.bigwords");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (String eachToken : bigWordsList) {
                out.println(eachToken);
            }            
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File could not be written to");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File could not be written to");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("An Exception writing to file");
            exception.printStackTrace();
        } 
    }
}