package java112.demo ;
import java.io.*;
    
public class ReadDemoEve {
    public static void main(String[] args){
        ReadDemoEve demo = new ReadDemoEve();
        demo.read();
    
    }
    public void read() {
        String line = null;
        BufferedReader in = null;
        try {
            //FileReader reader = new FileReader("foo.in");
            //BufferedReader in = new BufferedReader(reader); OR
            in = new BufferedReader(new FileReader("foo.in"));
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