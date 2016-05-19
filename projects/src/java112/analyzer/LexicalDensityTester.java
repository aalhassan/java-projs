package java112.analyzer ;
import java.io.*;
import java.util.* ;

/**
 *  This class tests the lexical density analyzer. <br>
 *@since March 9th, 2016
 *@author     M. Alhassan
 */
public class LexicalDensityTester {   
    private static LexicalDensityTester lexicalTestLauncher; 
    private String testFile; 
    private String testOutFile;  
    private Analyzer lexicalDensityAnalyzer ;
    private static final double expectedResult = 80.00;    
    
    /**
     * Constructor for class <br>
     *@param testFile file containing test text
     *@param testOutFile file containing result of test
     */
    public LexicalDensityTester(String testFile , String testOutFile) {       
        this.testFile = testFile;
        this.testOutFile = testOutFile;
        lexicalDensityAnalyzer = new LexicalDensityAnalyzer();
    }     
   
    /**
     *  Main method for launching test <br>
     *
     *@param args String array of passed in command line inputs.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            lexicalTestLauncher = new LexicalDensityTester(args[0], args[1]);
            lexicalTestLauncher.processAllTokens();
            lexicalTestLauncher.writeAllTestResults();
        } else System.out.println("Please enter 2 inputs.");
    }
    
    /**
     *Generates all tokens from a file, and passes them to analyzers for processing<br>     
     *
     */
    public void processAllTokens() {
        String[] lineTokens = null;
        try (BufferedReader in = new BufferedReader(new FileReader(testFile))) {      
            while (in.ready()) {
                lineTokens = in.readLine().split("\\W");    
                processTokensArray(lineTokens);           
            }        
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File could not be read");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File could not be read");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Error reading file");
            exception.printStackTrace();
        }
    }  
    
    /**
     *Processes a given array of tokens through analyzers <br>     
     *
     *@param tokenArray tokens to processed
     */
    public void processTokensArray(String[] tokenArray) {
        for (String token : tokenArray) {
            if (!token.equals("")) {             
                lexicalDensityAnalyzer.processToken(token);                
            }           
        }        
    }
    
    /**
     *Produces all output files showing result of test <br>     
     *
     */
    public void writeAllTestResults() {
        String testResultFile = null;
        //double lexicalDensity = ((LexicalDensityAnalyzer) lexicalDensityAnalyzer).getTotalTokensCount();
        double lexicalDensity = ((LexicalDensityAnalyzer) lexicalDensityAnalyzer).getLexicalDensity();
        String testResult = "TestCase: Lexical Density Output"+"\n\t\t"+"Result:Failed"
                +"\n\t\t"+"Expected: "+ expectedResult+"\n\t\t"+"But was: "+lexicalDensity;
        if (lexicalDensity == expectedResult)  testResult = "TestCase: LexicalDensity Output"+"\n\t\t"+"Result:Success";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(testOutFile)))) {          
            out.println(testResult);
                    
        } catch (IOException ioException) {
                System.out.println("There was a problem writing to the file:");
                ioException.printStackTrace();
        } catch (Exception exception) {
                System.out.println("There was a problem other than an IoException:");
                exception.printStackTrace();
        }
        
        try {
            testResultFile = new File(testOutFile).getAbsolutePath();
        } catch (Exception e) {
             System.out.println("Problem getting output file path");
             e.printStackTrace();
        }
       
     System.out.println("See test results: "+ testResultFile);  
    }    
       
}
