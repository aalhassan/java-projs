package java112.labs2 ;
import java.util.* ;
import java.io.*;

public class LabFour {
    private Map<Integer,Student> map ;

    public static void main(String[] args) {
        LabFour labFour = new LabFour();
        labFour.run();                
    }

    public void run()  {
        Student Mej = new Student(22,"Majeed", "Al", 12) ;  
        Student Alice = new Student(24,"Alice", "Land", 9) ;   
        Student Jones = new Student(26,"Jones", "Mike", 6) ;
        Student Hamid = new Student(18,"Hamid", "Soso", 11) ;   
        this.map = new HashMap<Integer , Student>() ;
        map.put(18,Hamid);
        map.put(22,Mej);
        map.put(24,Alice);
        map.put(26,Jones);
                   
        for (Map.Entry<Integer,Student> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = > " + entry.getValue().getFName());
        }
        System.out.println("\nPrinting Map:");
        System.out.println(map);
        Mej.setFName("Mej");
        System.out.println("\nPrinting Map after name update:");
        for (Map.Entry<Integer,Student> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = > " + entry.getValue().getFName());
        }
    }

}
