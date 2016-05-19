package java112.labs2 ;
import java.util.* ;
import java.io.*;

public class LabTwoFour {
    private Map<String,Integer> map ;
    private Map<String,Integer> map2 ;

    public static void main(String[] args) {
        LabTwoFour labFour = new LabTwoFour();
        labFour.run();                
    }

    public void run()  {        
        this.map = new HashMap<String,Integer>() ;
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Six",6);
        map.put("Five",5);
        map.put("Four",4);
           
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = > " + entry.getValue());
        }
        System.out.println("\nPrinting Map:");
        System.out.println(map);
        if (map.containsKey("Three")) {
            System.out.println("Value in Key Three:" + map.get("Three"));
        } else System.out.println("Error: Key Three doesn't exist.");

        map2 = new TreeMap<String, Integer>(map);
        System.out.println("\nPrinting Map2:");
        System.out.println(map2);
    }

}
