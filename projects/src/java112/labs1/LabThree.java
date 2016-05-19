package java112.labs1 ;
    
public class LabThree {
    public static void main(String[] args){
        LabThree labThree = new LabThree();
        if (args.length != 1) System.out.println("Please enter one argument on the command line");
        else  labThree.run(args[0]);
    }
    
    public void  run(String arg){
        if (arg !=null) System.out.println("input: "+arg);
    } 
}
