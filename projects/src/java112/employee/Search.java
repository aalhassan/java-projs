package java112.employee;

import java.util.ArrayList;

public class Search extends Object {
	private String searchType;
	private String searchTerm;
	private ArrayList<Employee> foundEmployees;
	private boolean isFound;
 
   /**Default empty constructor
	 * 
	 */
	public Search() {
		foundEmployees = new ArrayList<Employee>();
	}
	
	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}
	
	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}
	
	/**
	 * @param searchTerm the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	/**
	 * @return the foundEmployees
	 */
	public ArrayList<Employee> getFoundEmployees() {
		return foundEmployees;
	}
	
	
	/**
	 * @param foundEmployees the foundEmployees to set
	 */
	public void setFoundEmployees(ArrayList<Employee> foundEmployees) {
		this.foundEmployees = foundEmployees;
	}
	
	
	/**
	 * @return the isFound
	 */
	public boolean isFound() {
		return isFound;
	}
	
	/**
	 * @param isFound the isFound to set
	 */
	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}




	/** Adds a found employee to the object's list of found employees
	 * @param foundEmployee the found employee if any
	 */
	public void  addFoundEmployee (Employee foundEmployee){		
			this.getFoundEmployees().add(foundEmployee);	
	}
 	
}
