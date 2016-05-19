package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.employee.*;

/**
 *  This is a Servlet for project 4. It handles the request from  the search employee form
 *
 *@author    Mej
 */
@WebServlet(
    name = "SearchPageHandler", 
    urlPatterns = { "/SearchPageHandler"}
)
public class SearchPageHandler extends HttpServlet {
	private EmployeeDirectory employeeDir;
	public void init() {
		ServletContext application = getServletContext();
		employeeDir = (EmployeeDirectory) application.getAttribute("employeeDir");
		log("AddPageHandler init Executed"); 
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
    	HttpSession session = request.getSession();
    	Search search = new Search();
    	search.setSearchType(request.getParameter("searchType"));
    	search.setSearchTerm(request.getParameter("searchTerm"));
    	search = employeeDir.searchEmployee(search);
    	
    	session.setAttribute("searchResult", search);
    	
        String url = "/search_result.jsp";                 
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
