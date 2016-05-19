package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Servlet Life Cycle
 *
 *@author    Mej
 */
@WebServlet(
    name = "ServletPractice", 
    urlPatterns = { "/servletPractice", "/ServletPractice", "/Servletpractice" }
)
public class ServletPractice extends HttpServlet {
    private int hitCounter ;
    String firstAccessTime;
    String servletName;

    public void init() {
       log("init Executed");
       firstAccessTime = ""+ new Date();
       
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
        hitCounter++;
        
         log("doGet Executed");
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>ServletPractice</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<p>Name: Majeed Alhassan</p>");
         out.print("<p>Course: Java 112 Spring 2016</p>"); 
        out.print("<a href= '/java112'>Link back to  Home Page:</a> <br/>");
        out.print("<br/>Current Time: "+ new Date());
        
        if ( firstAccessTime != null)    out.print("<br/>First time page accessed: "+ firstAccessTime); 
        out.print("<br/>Hit Times: "+ hitCounter);
        out.print(getServletInfo());      
        log("End of servlet");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
    
    public String getServletInfo() {
       return "<br/><br/>Author: Mej <br/> School: MATC";
       
    }
    public void destroy() {
       log("destroy Executed");
       
    }

}

