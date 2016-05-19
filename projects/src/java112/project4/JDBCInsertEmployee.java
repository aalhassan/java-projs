package java112.project4;
  
import java.io.*;
import java.sql.*;
  
/**
 *
 *@author     MAlhassan
 *
 */
public class JDBCInsertEmployee {
  
    public void runSample(String firstName,String lastName, String ssn, 
            String dept, String room, String phone) {
  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Statement insertStatement = null;
        int rows_affected = 0;
  
        try {
            //Load Driver. Make sure it's available
            Class.forName("com.mysql.jdbc.Driver");
  
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");
  
            insertStatement = connection.createStatement();          

            String name = lastName;
            String queryString = "INSERT INTO employees VALUES (151, '"+firstName+"', '"+lastName+"', '"+ssn+"', '"+dept+"', '"+room+"', '"+phone+"')";

            //Nice for troubleshooting
            System.out.println("InsertQuery: " + queryString);
   
            rows_affected = insertStatement.executeUpdate(queryString);

            statement = connection.createStatement();   

            resultSet = null;          

            queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees ";
            System.out.println("SelectQuery: " + queryString);
  
            resultSet = statement.executeQuery(queryString);

            System.out.println();
            
             String employeeId = null;
             String fName = null;
             String lName = null;
                
            while (resultSet.next()) {
                employeeId = resultSet.getString("emp_id");
                fName = resultSet.getString("first_name");
                lName = resultSet.getString("last_name");
                
            }
            System.out.println(" Row: " + employeeId + " "
                            + fName + " " + lName);
  
            System.out.println();
  
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            String nameOne = resultSetMetaData.getColumnName(1);
            String typeOne = resultSetMetaData.getColumnTypeName(1);
            String labelOne = resultSetMetaData.getColumnLabel(1);
            System.out.println(" Column count : " + columns);
            System.out.println(" Column 1 name : " + nameOne);
            System.out.println(" Column 1 type : " + typeOne);
            System.out.println(" Column 1 label name : " + labelOne);
  
            System.out.println();
  
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
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
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
  
    }
  
    /**
     *  The main program for the JDBCInsertExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {
        if (args.length < 6) {
             System.out.println("Argument(s) missing");       
        } else {
            JDBCInsertEmployee insertEmployee = new JDBCInsertEmployee();  
            insertEmployee.runSample(args[0], args[1], args[2], args[3],args[4], args[5]) ;
        }
    }
  
}
