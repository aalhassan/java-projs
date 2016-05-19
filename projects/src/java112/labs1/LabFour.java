package java112.labs1 ;
import java.io.*;
   
public class LabFour {
    public static void main(String[] args) {
        LabFour labFour = new LabFour();
        if (args.length != 1) System.out.println("Please enter one argument on the command line");
        else labFour.run(args[0]);
    }
    
    public void  run(String arg){
        read(arg);
    }
    
    public void read(String fileName) {
        String line = null;
        BufferedReader in = null;
        try {            
            in = new BufferedReader(new FileReader(fileName));
            while (in.ready()) { 
                line = in.readLine();
                System.out.println(line);
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
        } finally {
            try {
                in.close();
            } catch (IOException ioEx2) {
                ioEx2.printStackTrace();
            }       
        } 

    } 
        
}