package java112.labs2 ;

public class Student {
    private int id ; 
    private String fName;
    private String lName;
    private int grade;
    
    public Student () {
        //Put "always want to do stuff here"
        //Always call this() from other contructors.
    }

    public Student (int id, String fName, String lName, int grade) {
        this();
        this.id = id ;
        this.fName = fName ;
        this.lName = lName ;
        this.grade = grade ;
    }
    
    public int getId(){ 
        return this.id;
    }
    public String getFName(){ 
        return this.fName ;
    }
    public String getLName(){ 
        return this.lName;
    }
    public int getGrade(){ 
        return this.grade ;
    }
    
    public void setId(int id){ 
        this.id = id;
    }
    public void setFName(String fName){ 
        this.fName = fName; 
    }
    public void setLName(String lName){ 
        this.lName = lName;
    }
    public void setGrade( int grade){ 
        this.grade = grade ; 
    }    

}
