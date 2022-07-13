package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import service.EmployeeService;
import view.ModelAndView;

public class EmployeeListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<EmployeeDTO> list = EmployeeService.getInstance().selectAllEmployee();
		
		request.getSession().setAttribute("list", list);
		
		return new ModelAndView("employee_manager.jsp", true);
	}

}
