package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 *  This is a servlet for project 4. It handles the request from  the add employee form.
 *
 *@author    Mej
 */
@WebServlet(
    name = "AddPage", 
    urlPatterns = { "/AddPageHandler"}
)
public class AddPageHandler extends HttpServlet {
    private EmployeeDirectory employeeDir;
	public void init() {
		ServletContext application = getServletContext();
		employeeDir = (EmployeeDirectory) application.getAttribute("employeeDir");
		log("AddPageHandler init Executed"); 
	}
	
    /**
     *  Handles HTTP POST requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String respMsg = null;
        boolean valid = false;
    	HttpSession session = request.getSession();

    	String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
    	String ssn = request.getParameter("ssn");
        String dept = request.getParameter("dept");    	
        String room = request.getParameter("room");
        String phone = request.getParameter("phone");
        
        valid = (firstName.length()>0 && lastName.length()>0 && ssn.length()>0 && 
                dept.length()>0 && room.length()>0 && phone.length()>0);
            
        respMsg = (valid)? employeeDir.addEmployee(firstName, lastName, ssn, dept, room, phone):"Invalid Data Supplied.";

        session.setAttribute("project4AddMessage", respMsg);
        String url = "/java112/AddPageServlet";                 
        response.sendRedirect(url);        
    }

}
