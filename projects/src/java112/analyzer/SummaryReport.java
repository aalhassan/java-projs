package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *  This class produces summary analysis of a given file. <br>
 *
 *
 *@author     M. Alhassan
 */
public class SummaryReport implements Analyzer {
    private int totalTokensCount;
    private Properties properties ;

    /**
     *Default contructor for SummaryReport.<br>
     *
     */
    public SummaryReport () {
    }

    /**
     *Custom contructor for SummaryReport.<br>
     *@param properties Loaded properties for object
     */
    public SummaryReport (Properties properties) {
         this();
         this.properties = properties;
    }

    /**
     *Getter for total number of tokens<br>
     *
     *@return number of tokens in file
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }
    
    /**
     *Processes a given token-counts number of tokens processed<br>
     *
     *@param token token to be processed     
     */
    public void processToken(String token) {         
        totalTokensCount++;
    }

    /**
     *Writes result of summary analysis of input file to an output file <br>
     *
     *@param inputFilePath File path for file processed   
     */
    public void writeOutputFile(String inputFilePath) {        
        String inputFile = null;
        String outputFilePath = properties.getProperty("output.dir") + ""
                + properties.getProperty("output.file.summary");
        try {
            inputFile = new File(inputFilePath).getAbsolutePath();
        } catch (Exception e) {
             System.out.println("Problem getting output file path");
             e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            out.println("Application: "+ properties.getProperty("application.name"));
            out.println("Author: "+properties.getProperty("author") 
                    + ", " +properties.getProperty("author.session"));
            out.println("email: "+properties.getProperty("author.email.address"));
            out.println("Input file: "+ inputFile);
            out.println("Analyzed on: "+ new Date());
            out.println("Total token count: "+ getTotalTokensCount());           
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