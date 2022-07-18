package dto;

public class EmployeeExDTO {
	private String eno;
	private String name;
	private String department;
	private int position;
	private EmployeeSalaryDTO employeeSalaryDTO;
	
	public EmployeeExDTO() {
		super();
	}

	public EmployeeExDTO(String eno, String name, String department, int position,
			EmployeeSalaryDTO employeeSalaryDTO) {
		super();
		this.eno = eno;
		this.name = name;
		this.department = department;
		this.position = position;
		this.employeeSalaryDTO = employeeSalaryDTO;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public EmployeeSalaryDTO getEmployeeSalaryDTO() {
		return employeeSalaryDTO;
	}

	public void setEmployeeSalaryDTO(EmployeeSalaryDTO employeeSalaryDTO) {
		this.employeeSalaryDTO = employeeSalaryDTO;
	}

	@Override
	public String toString() {
		return "EmployeeExDTO [eno=" + eno + ", name=" + name + ", department=" + department + ", position=" + position
				+ ", employeeSalaryDTO=" + employeeSalaryDTO + "]";
	}
	
	
}
