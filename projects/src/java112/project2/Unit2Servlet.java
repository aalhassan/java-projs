package java112.project2;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *  Main servlet class for Unit2 project.
 *@since March 15th, 2016
 *@author    mAlhassan
 */
@WebServlet(
    name = "Unit2Servlet", 
    urlPatterns = { "/Unit2Project", "/unit2Project", "/unit2project" }
)
public class Unit2Servlet extends HttpServlet {
    private Properties properties;
    private static String propertiesFile = "/project2.properties.txt";

    public void init() {
        loadProperties(propertiesFile);
    }
  
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<String> propertyNames =  properties.stringPropertyNames();      
        
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Unit2Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<p  align='center'>This is a servlet that outputs info about the author in a table below:</p>");
        out.print("<table border='1' align='center'>");
        for (String property : propertyNames) {
           out.println("<tr><td>"+property +" </td><td>" + properties.getProperty(property)+"</td></tr>");
        }
        out.print("</table>");        
        out.print("<br/><a href= '/java112' >Back to  Home Page:</a> <br/>");
        log("End of servlet");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
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

