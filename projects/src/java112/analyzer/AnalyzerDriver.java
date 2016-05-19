package java112.analyzer;
import java.io.*;

/**
 *  This class is the launcher for the file analyzer app. <br>
 *
 *@since Feb 9th, 2016
 *@author     M. Alhassan
 */

public class AnalyzerDriver {
    /**
     *  Main method for launching application <br>
     *
     *@param args String array of passed in command line inputs.
     */
    public static void main(String[] args) {
        AnalyzeFile fileAnalysis = new AnalyzeFile();
        fileAnalysis.runAnalysis(args);
    }
}
        
        
        