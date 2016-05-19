package java112.employee;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String ssn; 
	private String dept;
	private String room;
	private String phone;
	
	
	/**Default Constructor
	 * 
	 */
	public Employee() {
	}
    
	

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}



	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", dept=" + dept
				+ ", room=" + room + ", phone=" + phone + "]";
	}
	
	
}
