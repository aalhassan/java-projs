package java112.analyzer;

/**
 *  Specifies what a file analyzer must do
 *
 */
public interface Analyzer {
    /**
     *Process a given token<br>
     *
     *@param token token to be processed
     */
    public void processToken(String token);

    /**
     *Write results of analysis to an output file<br>
     *
     *@param inputFilePath path of file analyzed
     */
    public void writeOutputFile(String inputFilePath);
}