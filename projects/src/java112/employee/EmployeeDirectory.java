/**
 * 
 */
package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author student
 *
 */
public class EmployeeDirectory {
	private Properties properties;
	private Search search;	
	private static String insertQueryTmpl;
	private static String searchQueryTmpl;
	
	/**Default constructor loads prepared statements	 
	 */
	public EmployeeDirectory() {
		insertQueryTmpl = "INSERT INTO employees (first_name,last_name,ssn,dept,room,phone) VALUES (?,?,?,?,?,?)";
		searchQueryTmpl = "SELECT * FROM employees";
		//searchQueryTmpl = readSql("/employeeSearch.sql");
	}
	
	/**Constructor gets loaded properties and instantiates DB connection
	 * @param properties loaded properties for object
	 */
	public EmployeeDirectory(Properties properties) {
		this();
		this.properties = properties;		
	}
	
	/**Checks if DB driver exists. Gets connection to DB
	 * @return connection to DB
	 * @throws SQLException if there is a SQL failure
	 * @throws ClassNotFoundException if driver not found
	 */
	private Connection getConnection () throws  ClassNotFoundException, SQLException {
		//Do this on each request		
		String user = this.properties.getProperty("username");
		String pass = this.properties.getProperty("password");
		String url = this.properties.getProperty("url");
		String driver = this.properties.getProperty("driver");
		
		Class.forName(driver);
		return DriverManager.getConnection(
               url, user, pass);
	}
	
	/**Inserts  an employee into DB
	 * @param employee Employee to insert
	 * @return result message
	 */
	public String addEmployee(String firstName,String lastName, String ssn, 
            String dept, String room, String phone)  {
		Connection connection = null;		
		PreparedStatement insertStmnt = null;		
		int rows_affected = 0;
		String resMsg = "";
		try {
			connection = this.getConnection();
			insertStmnt = connection.prepareStatement(insertQueryTmpl);
			insertStmnt.setString(1, firstName);
			insertStmnt.setString(2,lastName);
			insertStmnt.setString(3,ssn);
			insertStmnt.setString(4, dept);
			insertStmnt.setString(5, room);
			insertStmnt.setString(6, phone);
			
			//For troubleshooting
			System.out.println(insertStmnt.toString());
			
			rows_affected = insertStmnt.executeUpdate();
			
		} catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
            //resMsg += "Cannot find database driver <br/>";
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);           
            sqlException.printStackTrace();
            //resMsg += sqlException+" <br/>";
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
            //resMsg += "General Error <br/>";
        } finally {  
        	if (rows_affected == 0) {
        		resMsg += "<font color=\"red\">There was a problem adding the employee. Please try again later</font>";
        	}
            else {
                resMsg = "<font color=\"green\">Employee successfully added!</font>";
            }
            try {
                if (insertStmnt != null) {
                	insertStmnt.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();               
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
               
            }
        }
		return resMsg;
	}
	
 	/**Inserts  an employee into DB
	 * @param search search info
	 * @return the processed search object	 
	 */
	public Search searchEmployee(Search search)  {
		Connection connection = null;		
		Statement searchStmnt = null;		
		ResultSet resultSet = null;
        String searchQuery = null;
        Employee foundEmployee = null;
		
		if  (search.getSearchType().equals("id")){
			searchQuery = searchQueryTmpl + " WHERE emp_id = "+search.getSearchTerm();
		}
		else if (search.getSearchType().equals("lName")) {
			searchQuery = searchQueryTmpl + " WHERE last_name like '"+ search.getSearchTerm()+ "%'";
		}
			
		try {
			connection = this.getConnection();
			searchStmnt = connection.createStatement();		
			
			//For troubleshooting
			System.out.println(searchQuery);			
		    resultSet = searchStmnt.executeQuery(searchQuery);
            
            while (resultSet.next()) {
                foundEmployee = new Employee();
                foundEmployee.setEmployeeId(resultSet.getInt("emp_id"));
                foundEmployee.setFirstName(resultSet.getString("first_name"));
                foundEmployee.setLastName(resultSet.getString("last_name"));
                foundEmployee.setSsn(resultSet.getString("ssn"));
                foundEmployee.setDept(resultSet.getString("dept"));
                foundEmployee.setRoom(resultSet.getString("room"));
                foundEmployee.setPhone(resultSet.getString("phone"));
                //System.out.println(foundEmployee);
                search.addFoundEmployee(foundEmployee);
            }
			//At least one employ was created, thus found
			if (foundEmployee != null){
				search.setFound(true);
			}
			
			
		} catch (ClassNotFoundException classNotFound) {
            System.err.println("Cannot find database driver ");
            classNotFound.printStackTrace();
           
        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);           
            sqlException.printStackTrace();
            
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
           
        } finally {  
            try {
                if (searchStmnt != null) {
                	searchStmnt.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                System.err.println("Error in connection.ecting to database "
                        + sqlException);
                sqlException.printStackTrace();               
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
               
            }
        }
		return search;
	}
}
