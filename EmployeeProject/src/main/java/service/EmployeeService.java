package service;

import java.util.ArrayList;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeService {
	private static EmployeeService instance = new EmployeeService();
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getInstance() {
		if(instance == null)
			instance = new EmployeeService();
		
		return instance;
	}

	public EmployeeDTO login(String name, String eno) {
		return EmployeeDAO.getInstance().login(name,eno);
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		return EmployeeDAO.getInstance().selectAllEmployee();
	}

	public void insertEmployee(EmployeeDTO dto) {
		EmployeeDAO.getInstance().insertEmployee(dto);
		EmployeeDAO.getInstance().insertEmployeeSup(dto);
	}

	public int deleteEmployee(String eno) {
		return EmployeeDAO.getInstance().deleteEmployee(eno);
	}

}
