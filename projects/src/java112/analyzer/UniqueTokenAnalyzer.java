package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *  This class performs analysis of unique tokens in a file. <br>
 *
 *
 *@author     M. Alhassan
 */
public class UniqueTokenAnalyzer implements Analyzer {
    
    private Set<String> uniqueTokensList;
    private Properties properties ;

    /**
     *Instantiates the set of unique tokens<br>
     *
     */

    public UniqueTokenAnalyzer () {
        uniqueTokensList = new TreeSet<String>();
    }
 
    /**
     *Instantiates the set of unique tokens and sets properties variable<br>
     *@param properties Loaded properties for object
     */
    public UniqueTokenAnalyzer ( Properties properties) {
        this();
        this.properties = properties;
    }
  
    /**
     *Getter for list of unique tokens<br>
     *
     *@return list of unique tokens analyzed
     */
    public Set<String> getUniqueTokensList() {
        return uniqueTokensList;
    }

    /**
     *Processes a given token-adds token to unique token list<br>
     *
     *@param token token to be processed     
     */
    public void processToken(String token) {
        uniqueTokensList.add(token);      
    }

    /**
     *Writes all unique tokens in input file to an output file<br>
     *
     *@param inputFilePath File path for file analyzed
     *@param outputFilePath output file path to hold list of unique tokens     
     */
    public void writeOutputFile(String inputFilePath) {
        Set<String> tokensList =  getUniqueTokensList();
        String outputFilePath = properties.getProperty("output.dir") + ""
                + properties.getProperty("output.file.unique");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (String eachToken : tokensList) {
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