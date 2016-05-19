package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is a servlet for project 4. It's a proxy for the add employee form.
 *
 *@author    Mej
 */
@WebServlet(
    name = "AddPageServlet", 
    urlPatterns = { "/AddPageServlet"}
)
public class AddPageServlet extends HttpServlet {
   
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
      	HttpSession session = request.getSession();
        String url = "/add_employee.jsp";                 
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);      
        
    }
    

}
