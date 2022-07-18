package dto;

public class EmployeeDTO {
	private String eno;
	private String name;
	private String department;
	private int positionNo;
	
	public EmployeeDTO(String eno, String name, String department, int positionNo) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.positionNo = positionNo;
	}
	
	public EmployeeDTO() {
		super();
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
	 * @return the positionNo
	 */
	public int getPositionNo() {
		return positionNo;
	}
	/**
	 * @param positionNo the positionNo to set
	 */
	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", positionNo="
				+ positionNo + "]";
	}
	
}
