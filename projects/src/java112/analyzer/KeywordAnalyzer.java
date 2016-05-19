package java112.analyzer;
import java.io.*;
import java.util.*;

/**
 *  This class performs analysis of key tokens in a file. <br>
 *  Writes out all cases of occurrences for the key token
 *
 *@author     M. Alhassan
 */
public class KeywordAnalyzer implements Analyzer {
    
    private Map<String, List<Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;   

    /**
     *Instantiates the map of key word occurrences<br>
     *
     */

    public KeywordAnalyzer () {
        keywordMap = new TreeMap<String, List<Integer>>();             
    }

    /**
     *Instantiates the map of key word occurrences, gets properties<br>
     *@param properties Loaded properties for object
     */
    public KeywordAnalyzer (Properties properties) {
        this();
        this.properties = properties;
        String keyWordFile = properties.getProperty("file.path.keywords");
        loadKeywords(this.getClass().getResourceAsStream(keyWordFile));
    }
  
    /**
     *Getter for map of key word occurrences<br>
     *
     *@return map of key word occurrences
     */
    public Map<String, List<Integer>> getKeywordMap() {
        return keywordMap;
    }

    /**
     *Processes a given token-maps keywords to occurrences<br>
     *
     *@param token token to be processed     
     */
    public void processToken(String token) {
        Map<String, List<Integer>> keywordMap = getKeywordMap();
        tokenOccurence++;
        if (keywordMap.containsKey(token)) {      
            keywordMap.get(token).add(tokenOccurence);       
        }       
    }

    /**
     *Loads keywords from given file, initializes keyword occurrence map<br>
     *
     *@param fileName file to be read from     
     */
    public void loadKeywords(InputStream fileName) {
        String line = null;
        BufferedReader in = null;
        try {            
            in = new BufferedReader(new InputStreamReader(fileName));
            while (in.ready()) { 
                line = in.readLine();
                keywordMap.put(line, new ArrayList<Integer>());
            }        
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("File could not be read");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx) {
            System.out.println("File could not be read");
            ioEx.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Exception reading file");
            exception.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ioEx2) {
                ioEx2.printStackTrace();
            }       
        } 

    }

    /**
     *Prints keyword map for keyword map entry to a file
     *@param entry entry to print keyword map from
     *@param printer printer info
     *@param maxLineOccurences max number of occurrences per line    
     */
 
    public void keymapPrinter(Map.Entry<String,List<Integer>> entry, PrintWriter printer, 
            int maxLineOccurences) {
        int occurencePos = 1 ;                
        String commaSeperator = ", ";
       
        printer.println(entry.getKey() +" =");
        for (Integer occurence  : entry.getValue()) {
            //occurenceLinePositon = occurencePos % maxLineOccurences;

            //First occurrence overall
            if (occurencePos == 1 ) printer.print("["+occurence);

            //First occurrence for line 
            else if (occurencePos % maxLineOccurences == 1) printer.print(occurence);

            //Last occurrence for line            
            else if (occurencePos % maxLineOccurences == 0)  printer.println(commaSeperator+occurence+",");            

            //Other occurrences
            else printer.print(commaSeperator+occurence);
            
            occurencePos++ ;
        }

        printer.println("]\n");
       
    }
     

    /**
     *Writes token occurrence map in an input file to an output file<br>
     *
     *@param inputFilePath File path for file analyzed   
     */
    public void writeOutputFile(String inputFilePath) {
        Map<String, List<Integer>> keywordMap = getKeywordMap();

        String outputFilePath = properties.getProperty("output.dir") + ""
                + properties.getProperty("output.file.keyword");
        
        int maxLineOccurences = 8;

        //int occurencePerLine = Integer.parseInt(properties.getProperty("max.line.occurences"));

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {
            for (Map.Entry<String, List<Integer>> entry : keywordMap.entrySet()) {
                keymapPrinter(entry, out, maxLineOccurences);
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