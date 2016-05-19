package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

/**
 *This is a servlet for project 3 Analyzer . <br/> 
 *It handles the request from  the upload form page, generates a run button on success<br/>
 *It also runs analyzer request after file is uploaded.
 *@author    Mej
 */
@WebServlet(
    name = "AnalyzerServlet", 
    urlPatterns = { "/AnalyzerServlet"}
)
public class AnalyzerServlet extends HttpServlet {
    private String uploadFolder;
    private String projectFolder;
    private int globalId;
    private static final int MAX_FILE_SIZE = 50 * 1000 * 1024;
    private static final int MAX_MEM_SIZE = 4 * 1000 * 1024;
    
	public void init() {
		ServletContext application = getServletContext();
		uploadFolder = (String) application.getInitParameter("file-upload");
		projectFolder = (String) application.getInitParameter("project-folder");
		log("AnalyzerServlet init Executed"); 
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
    	String respMsg = null;              
        String sessionId = (session.getAttribute("session_id")!=null)?
        			(String) session.getAttribute("session_id"):null;       
        boolean uploadSuccess = (session.getAttribute("uploadSuccess")!=null)?
        			(boolean) session.getAttribute("uploadSuccess"):false; 
                			
        String requestPage = (String) session.getAttribute("requestPage"); 
    	
        //Request to run analyzer? run analyzer
        if (requestPage.equals("run_analyzer.jsp") && sessionId != null && (uploadSuccess)) {        	
        	respMsg = runAnalyzer(request)? "File analyzed succesfully <br/>" 
        			+ "<a class=\"button\" href=\"../data/" + sessionId + "/"
        			+ (String) session.getAttribute("fileName") + "_analysis.jar" 
        			+ "\"/>Download results</a>":
        			"There was an error in the analysis. Please try again later";
            //Zip Files
            //Redirect user to download page 
        	session.setAttribute("analyzerResp", respMsg);
        	
        	String url = "/analyzer_results.jsp";                 
            RequestDispatcher  dispatcher = 
                    getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        
        else {
        	//Page accessed in error
        }
        
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
        String sessionId = null;
        HttpSession session = request.getSession();        
        String requestPage = (String) session.getAttribute("requestPage"); 
        
        String url = "/run_analyzer.jsp";                 
        RequestDispatcher  dispatcher = 
                getServletContext().getRequestDispatcher(url);
        
        if (requestPage.equals("file_analyzer.jsp") && session.getAttribute("session_id") == null) {
        	globalId += 1;
            sessionId = "session_id"+globalId;
            //sessionId += new Date();
            session.setAttribute("session_id", sessionId);
        } else if (!requestPage.equals("file_analyzer.jsp")) {
        	response.getWriter().println("Page Accessed in Error");
        	dispatcher.forward(request, response);
        	return;
        }
    
        respMsg = (processUpload(request))? "File Uploaded Succesfully <br/>" 
    			+ "<input type=\"submit\" value=\"Analyze " + session.getAttribute("fileName")+"\">":
    			"Please upload a valid file";
               
        session.setAttribute("analyzerResp", respMsg);
       
        dispatcher.forward(request, response);     
    }

    /** Handles the upload from the form field.
    *@param request user's current request object    
    *@return success or failure of upload
    */

    public boolean processUpload (HttpServletRequest request) {        
        String sessionId = null;
        File file = null;       
        
        HttpSession session = request.getSession();
        sessionId = (String) session.getAttribute("session_id");

        boolean uploadSuccess = (sessionId != null && ServletFileUpload.isMultipartContent(request));
        
        if (uploadSuccess) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(MAX_MEM_SIZE);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));
            
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax( MAX_FILE_SIZE );
    
            try{ 
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
            
            // Process the uploaded file items
            Iterator i = fileItems.iterator();
                while ( i.hasNext () ) {
                    FileItem fi = (FileItem)i.next();
                    if ( !fi.isFormField () )	
                    {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        //Set fileNames
                        if( fileName.lastIndexOf("\\") >= 0 ){
                           file = new File(uploadFolder +  sessionId + "_" +
                        		   	fileName.substring( fileName.lastIndexOf("\\"))  ) ;
                        } else {
                           file = new File( uploadFolder +  sessionId + "_" +
                        		   	fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                        }                        
                        //Original file name
                        session.setAttribute("fileName", fileName);
                         //Uploaded file name
                        session.setAttribute("upFileName", file.getAbsolutePath());
                        //Track success of upload
                        session.setAttribute("uploadSuccess", uploadSuccess);
                        // Write the file
                        fi.write(file);
                    }
                    
                }         
            } catch(Exception ex) {
                System.out.println(ex);
                uploadSuccess = false;
            }
        }
        return uploadSuccess;
    }
   
    /** Handles the request to run a file analysis.
     *@param request user's current request object    
     *@return success or failure of run process
     */
    public boolean runAnalyzer (HttpServletRequest request) {
    	HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("session_id");
    	String upFileName = (String) session.getAttribute("upFileName");
    	String resultFilePath = null;     	
    	boolean runSuccess = true;
    	
    	//Create download source directory for session
    	File downloadDir = new File(uploadFolder + "\\" + sessionId);
    	downloadDir.mkdirs();
    	
    	//Create result output folder for session
    	File outputDir = new File(projectFolder + "data\\" + sessionId + "\\output");
    	outputDir.mkdirs();
    	
    	//Get File Ref for run directory from output folder
    	File processDir = outputDir.getParentFile();    	
    	  	
    	String runCmd = "java -classpath ..\\..\\lib/analyzer.jar;..\\..\\config java112.analyzer.AnalyzerDriver "    					
    					+ upFileName + " /analyzer.properties.txt";
        
    	resultFilePath = downloadDir.getAbsolutePath() + "\\" 
    				+ ((String) session.getAttribute("fileName")) + "_analysis.jar";
    	
    	String archiveCmd = "jar cf " + resultFilePath
    				+ " -C " + outputDir.getAbsolutePath() + " *.txt";
    	
    	//For troubleshooting
    	log("Run Cmd: " + runCmd);	
    	log("Archive Cmd: " + archiveCmd);	
    	
    	try {    		
	        //runSuccess true if only both analyze and archive runs successfully 	        
	        runSuccess = processRunner(runCmd, processDir, "Run Analyzer") 
	        			&& processRunner(archiveCmd, outputDir, "Archive Results");	           	  
        } catch (IOException ioEx) {
        	log("An IO error occured running Analyzer");
        	runSuccess = false;
        	ioEx.printStackTrace();
        } catch (InterruptedException e) {
        	runSuccess = false;
        	log("An error occured running Analyzer");
			e.printStackTrace();
		}
    	session.setAttribute("runSuccess", runSuccess);
        return runSuccess;
    }
    
    /** Runs a different process(subprocess) given the run parameters.
     *@param cmdStr user's current request object
     *@param runDir working directory for the run process
     *@param runName name of subprocess     
     *@return success or failure of run process
     * @throws IOException 
     * @throws InterruptedException 
     */
    private boolean processRunner (String cmdStr, File runDir, String runName) 
    		throws IOException, InterruptedException {
    	boolean runSuccess = true;
    	Process runner = Runtime.getRuntime().exec(cmdStr, null, runDir);	
	    BufferedReader in = new BufferedReader(new InputStreamReader(runner.getInputStream()));
	    runSuccess = runner.waitFor() == 0;
	    log(runName + " SUCCESS: " + runSuccess);
	    return runSuccess;
    }

}
