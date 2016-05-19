package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * class HttpPropertiesServlet
 *
 */
@WebServlet(
    name = "MvcChallengeServlet", 
    urlPatterns = { "/mvc-challenge-servlet" }
)

public class MvcChallengeServlet extends HttpServlet {
    private Properties answers;
    private static String answersFile = "/project3.answersFile.txt";
    private static final String correctImgPath = "/java112/images/correct.png";
    private static final String wrongImgPath = "/java112/images/wrong.jpg";
    private static final String appDiagram = "/java112/images/MvcDiagram.jpg";

    public void init() {
       loadProperties(answersFile);
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
        Set<String> questions =  answers.stringPropertyNames();

        int score = 0;
        int scorePercent = 0;
        String markImg = null;
        Map<String, ArrayList<String>> gradeMap = new TreeMap<String, ArrayList<String>>();

        for (String question : questions) {
           if(request.getParameter(question)!=null && request.getParameter(question).equals(answers.getProperty(question))){
                score++;
                markImg = correctImgPath;
           }
           
           else {
                markImg = wrongImgPath;             
           }
           

           gradeMap.put(question, new ArrayList<String>());
           gradeMap.get(question).add(answers.getProperty(question));
           gradeMap.get(question).add(request.getParameter(question));
           gradeMap.get(question).add(markImg);
        }  

        scorePercent = score * 100/questions.size();

        GradeBean gradeBean = new GradeBean(score, scorePercent, gradeMap);

        request.setAttribute("results", gradeBean);
        request.setAttribute("appDiagram", appDiagram);
        String url = "/Mvc-Challenge.jsp";

        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     *Loads key value pairs from a file to a Properties' object <br>     
     *
     *@param propertiesFilePath Path of file containing properties
     */
    public void loadProperties(String answersFile)  {
        answers = new Properties();
        try {
            answers.load(this.getClass().getResourceAsStream(answersFile));
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
