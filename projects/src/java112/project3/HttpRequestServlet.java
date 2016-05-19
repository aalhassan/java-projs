package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author Mej Alhassan
 * class HttpRequestServlet
 *
 */
@WebServlet(
    name = "requestServlet", 
    urlPatterns = { "/request-servlet" }
)

public class HttpRequestServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryParameter = request.getParameter("queryParameter");       

        HttpRequestData myRequestData = new HttpRequestData(request.getRemoteHost(), request.getRemoteAddr(),
                request.getMethod(),request.getRequestURI(), request.getRequestURL(), request.getProtocol());
       
        myRequestData.setServerName(request.getServerName());
        myRequestData.setServerPort(request.getServerPort());
        myRequestData.setCurrentLocale(request.getLocale());
        myRequestData.setQueryString(request.getQueryString());
        myRequestData.setQueryParameter(queryParameter);
        myRequestData.setUserAgent(request.getHeader("User-Agent"));          
	
        request.setAttribute("myRequestData", myRequestData);

        String url = "/HttpRequestData.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }

}
