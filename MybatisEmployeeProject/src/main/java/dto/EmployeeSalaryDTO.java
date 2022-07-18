package dto;

public class EmployeeSalaryDTO {
	private String eno;
	private int salary;
	
	public EmployeeSalaryDTO() {
		super();
	}
	
	public EmployeeSalaryDTO(String eno, int salary) {
		super();
		this.eno = eno;
		this.salary = salary;
	}
	
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeSalaryDTO [eno=" + eno + ", salary=" + salary + "]";
	}
	
}
