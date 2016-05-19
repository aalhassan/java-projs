package java112.labs1 ;
import java.io.*;
   
public class LabFive {
    public static void main(String[] args){
        LabFive labFive = new LabFive();
        if (args.length != 2) System.out.println("Please enter two arguments on the command line, a file name and a message");
        else labFive.run(args[0],args[1]);
    }
    
    public void  run(String fileName, String message){
        write(fileName, message);
    }
    
    public void write(String fileName,String message) {        
        PrintWriter out = null;
        try {         
            
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            out.println(message);
            out.close();
    
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