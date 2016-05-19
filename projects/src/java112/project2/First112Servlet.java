package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first lab for servlet chapter.
 *
 *@author    Mej
 */
@WebServlet(
    name = "First112Servlet", 
    urlPatterns = { "/first112servlet", "/First112Servlet", "/first112Servlet" }
)
public class First112Servlet extends HttpServlet {

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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>First112Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<p>Name: Majeed Alhassan</p>");
         out.print("<p>Course: Java 112 Spring 2016</p>"); 
        out.print("<a href= '/java112'>Link back to  Home Page:</a> <br/>");
        out.print("<img src= '/java112/images/vintageMoose.jpg'/> <br/>");        
        log("End of servlet");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}

