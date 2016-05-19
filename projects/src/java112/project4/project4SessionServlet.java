package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is a servlet for Sessions.
 *
 *@author    Mej
 */
@WebServlet(
    name = "project4SessionServlet", 
    urlPatterns = { "/project4SessionServlet"}
)
public class project4SessionServlet extends HttpServlet {
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
        Integer sessionCounter = null;        
    	HttpSession session = request.getSession();
        if (session.getAttribute("project4SessionCounter") == null) {
            session.setAttribute("project4SessionCounter",new Integer(1));
        }
        else {
            sessionCounter = (Integer) session.getAttribute("project4SessionCounter");
            sessionCounter++;
            session.setAttribute("project4SessionCounter", sessionCounter);
        }  
        String url = "/project4Session.jsp";                 
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
