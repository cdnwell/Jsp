package dto;

public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private String position;
	private int salary;
	public EmployeeDTO(String eno, String name, String department, String position, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.position = position;
		this.salary = salary;
	}
	/**
	 * @return the eno
	 */
	public String getEno() {
		return eno;
	}
	/**
	 * @param eno the eno to set
	 */
	public void setEno(String eno) {
		this.eno = eno;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", position=" + position
				+ ", salary=" + salary + "]";
	}
	
	
	
}
