package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Mej Alhassan
 * class HttpPropertiesServlet
 *
 */
@WebServlet(
    name = "propertiesServlet", 
    urlPatterns = { "/properties-servlet" }
)

public class PropertiesServlet extends HttpServlet {
    private Properties properties;
    private static String propertiesFile = "/project3.properties.txt";

    public void init() {
       loadProperties(propertiesFile);      
       log("init Executed");        
    }

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        Set<String> propertyNames =  properties.stringPropertyNames();
             
        request.setAttribute("myProperties", properties);
        request.setAttribute("propertyNames", propertyNames);
        String url = "/Proj3Properties.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


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

}
