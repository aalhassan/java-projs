package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *This class performs analysis of unique tokens in a file. <br>
 *Outputs the number of a particular in a file.
 *@since March 23rd, 2016
 *@author     M. Alhassan
 */
public class TokenCountAnalyzer implements Analyzer {
    
    private Map<String, Integer> tokenCounts;
    private Properties properties ;

    /**
     *Instantiates the map of  token  counts<br>
     *
     */

    public TokenCountAnalyzer () {
        tokenCounts = new TreeMap<String, Integer>();
    }

    /**
     *Instantiates the map of  token  counts and gets properties <br>
     *@param properties Loaded properties for object
     */
    public TokenCountAnalyzer (Properties properties) {
        this();
        this.properties = properties;
    }
  
    /**
     *Getter for map of tokens counts<br>
     *
     *@return map of  tokens counts
     */
    public Map getTokenCounts() {
        return tokenCounts;
    }

    /**
     *Processes a given token-adds a token and its count to list<br>
     *
     *@param token token to be processed     
     */
    public void processToken(String token) {        
        int currentCount;
        Map<String, Integer> tokenCounts = getTokenCounts();
        if (tokenCounts.containsKey(token)) {      
            currentCount = tokenCounts.get(token);            
            tokenCounts.put(token , ++currentCount); 
        } else {
            tokenCounts.put(token ,1);
        } 
     
             
    }

    /**
     *Writes all unique tokens in input file to an output file<br>
     *
     *@param inputFilePath File path for file analyzed  
     */
    public void writeOutputFile(String inputFilePath) {
        Map<String, Integer> tokenCounts =  getTokenCounts();
        String outputFilePath = properties.getProperty("output.dir") + ""
                + properties.getProperty("output.file.token.count");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (Map.Entry<String,Integer> entry : tokenCounts.entrySet()) {
                out.println(entry.getKey()+"\t"+entry.getValue());
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