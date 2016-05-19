package java112.labs2 ;
import java.util.* ;
import java.io.*;

public class LabThree {
    private Properties properties ; 
    private String propertiesFilePath;

    public static void main(String[] args) {
        LabThree labThree = new LabThree();
        labThree.run(args[0]);
                
    }

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

    public void run(String input)  {
        
        this.propertiesFilePath = input ;
        loadProperties(propertiesFilePath);
        Set<String> propertyNames =  properties.stringPropertyNames();
           
        for (String property : propertyNames) {
            System.out.println(property + " = > " + properties.getProperty(property));
        }
    }

}
