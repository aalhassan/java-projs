package java112.analyzer ;
import java.io.*;
import java.util.* ;

/**
 *  This class runs all processes for the application. <br>
 *@since Feb 9th, 2016
 *@author     M. Alhassan
 */
public class AnalyzeFile {    
    private String inputFilePath;
    private Properties properties;
    private ArrayList<Analyzer> analyzers;    
    private static final int INPUTS_ALLOWED = 2;    
    
    /**
     * Setter for input file path <br>
     *
     *@param filaPath path to file to be analyzed
     */
    public void setInputFilePath(String filePath) {       
        this.inputFilePath = filePath;
    }
    
    /**
     *Method performs validation, initiates and calls all processes <br>
     *required for file analysis <br>
     *
     *@param inputs inputs passed from command line through app driver
     */
    public void runAnalysis(String[] inputs) {
        if (validInputs(inputs)) {
            init(inputs[0], inputs[1]);
            //processAllTokens();            
            //writeAllOutputFiles();
            processAndWriteTokens();
        }            
    }
    
    /**
     *Performs input validation <br>
     *     
     *@param inputs inputs to check
     *@return False for failed validation and True otherwise
     */
    public boolean validInputs(String[] inputs) {
        boolean valid = (inputs.length == INPUTS_ALLOWED);
        if (!valid) System.out.println("Please enter one argument on the command line");
        return valid;                    
    }
    
    /**
     *Instantiates class variables, loads properties <br>     
     *
     *@param inputfile command line input representing the input file path
     *@param propertyFile command line input representing the property file path
     */
    public void init(String inputFile, String propertyFile) {
        setInputFilePath(inputFile);
        loadProperties(propertyFile);
        createAnalyzers();      
    }

    /**
     *Loads key value pairs from a file to a Properties' object <br>     
     *
     *@param propertiesFilePath Path of file containing properties
     */
    public void loadProperties(String propertiesFilePath)  {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        }
        catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        }
        catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    /**
     *Instantiates and fills in the list of analyzers
     */
     public void createAnalyzers() {
        analyzers = new ArrayList<Analyzer>();
        analyzers.add(new UniqueTokenAnalyzer(properties));
        analyzers.add(new SummaryReport(properties));
        analyzers.add(new BigWordAnalyzer(properties));
        analyzers.add(new TokenCountAnalyzer(properties));
        analyzers.add(new LexicalDensityAnalyzer(properties));
        analyzers.add(new TokenSizeAnalyzer(properties));
        analyzers.add(new KeywordAnalyzer(properties));
    }

       
    
    /**
     *Generates all tokens from a file, and passes them to analyzers for processing<br>     
     *
     */
    public void processAllTokens() {
        String[] lineTokens = null;
        try (BufferedReader in = new BufferedReader(new FileReader(inputFilePath))) {      
            while (in.ready()) {
                lineTokens = in.readLine().split("\\W");    
                processTokensArray(lineTokens);           
            }        
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File not found");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File not found");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something bad happened");
            exception.printStackTrace();
        }
    }  
    

    /**
     *Generates all tokens from a file, and passes them to analyzers for processing<br>     
     *@param analyzer type of analyzer to use
     */
    public void processAllTokens(Analyzer analyzer) {
        String[] lineTokens = null;
        try (BufferedReader in = new BufferedReader(new FileReader(inputFilePath))) {      
            while (in.ready()) {
                lineTokens = in.readLine().split("\\W");    
                processTokensArray(lineTokens, analyzer);           
            }        
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File not found");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File not found");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something bad happened");
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
                for (Analyzer analyzer : analyzers) {
                    analyzer.processToken(token);
                }
            }           
        }        
    }
    
    /**
     *Produces all output files showing result of analysis <br>     
     *
     */
    public void writeAllOutputFiles() {
        for (Analyzer analyzer : analyzers) {
            analyzer.writeOutputFile(inputFilePath);
        }          
    }
    
    /**
     *Processes a given array of tokens through an analyzer<br>     
     *@param analyzer to process token
     *@param tokenArray tokens to processed
     */
    public void processTokensArray(String[] tokenArray, Analyzer analyzer) {
        for (String token : tokenArray) {
             analyzer.processToken(token);
        }        
    }
    
    /**
     *Produces all output files showing result of analysis for one analyzer<br>     
     *@param analyzer Analyzer whose output is to be written
     */
    public void writeAllOutputFiles(Analyzer analyzer) {       
            analyzer.writeOutputFile(inputFilePath);        
    }
    
    /**Process all tokens and Produces all output files showing result of analysis for all analyzers<br>     
     *Each analyzer runs its process and writes its output in a separate thread.
     */
    public void processAndWriteTokens() {
    	Thread worker = null; 
    	for (Analyzer analyzer : analyzers) {
    		worker = new AnalyzerThread(this, analyzer);
    		worker.start();
        }  
    }
}