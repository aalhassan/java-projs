package java112.labs1;
import java.io.*;

public class LabSix {
    public static void main(String[] args) {
        LabSix labSix = new LabSix();
        if (args.length != 2) System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
        else labSix.run(args[0], args[1]);
    }
    
    public void  run(String inputOne, String inputTwo){
        readWrite(inputOne, inputTwo);
    }
    
    public void readWrite(String inputFileName, String outputFileName) {
        String line = null;
        //BufferedReader in = null;
        //PrintWriter out = null; 
        try (
            BufferedReader in = new BufferedReader(new FileReader(inputFileName));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {
            while (in.ready()) {
                line = in.readLine();
                out.println(line);                
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
}
  
