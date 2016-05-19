package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 *  This is a Servlet that starts up and loads required properties for project4 app.
 *
 *@author    Mej
 */
@WebServlet(
		name = "applicationStartup", 
	    urlPatterns = { "/project4-startup" },
	    loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet {
	private Properties properties;
    private static String propertiesFile = "/project4.properties.txt";
    private EmployeeDirectory employeeDir;

    @Override
    public void init() {
    	ServletContext application =getServletContext();     	
        loadProperties(propertiesFile);
        employeeDir = new EmployeeDirectory(this.properties);
        application.setAttribute("project4Properties", this.properties);  
        application.setAttribute("employeeDir", employeeDir);
        log("Application Init Executed");        
    }
    
      
    /**
     *Loads key value pairs from a file to a Properties' object <br>     
     *
     *@param propertiesFilePath Path of file containing properties
     */
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

    public void destroy() {
       log("Application destroy Executed");       
    }

}
