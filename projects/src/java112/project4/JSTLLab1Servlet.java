package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is a servlet for lab42.
 *
 *@author    Mej
 */
@WebServlet(
    name = "JSTLLab1Servlet", 
    urlPatterns = { "/JSTLLab1Servlet"}
)
public class JSTLLab1Servlet extends HttpServlet {
    private Map map;
    

    public void init() {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        log("doGet Executed");
        map = new HashMap();         
        map.put("number", "10");
        map.put("text", "Lab_4_2 Servlet Page.");
        map.put("html", "<p>This is a new paragraph.</p>");
        map.put("aDate", new Date());        
        
        request.setAttribute("myMap", map);
	
        String url = "/jstl-lab2.jsp";                 
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        
    }
    
    public String getServletInfo() {
       return "<br/><br/>Author: Mej <br/> School: MATC";
       
    }
    public void destroy() {
       log("destroy Executed");       
    }

}
