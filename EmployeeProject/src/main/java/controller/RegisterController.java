package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import service.EmployeeService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
//		if(eno.length() > 4 || name.length() == 0 || department.length() == 0 ) {
//			response.getWriter().write("<script>alert('사원정보가 올바르지 않게 입력되었습니다.');</script>");
//		}else {
			EmployeeDTO dto = new EmployeeDTO(eno, name, department, position, salary);
			EmployeeService.getInstance().insertEmployee(dto);
			response.getWriter().write("<script>alert('사원정보 등록 성공');</script>");
//		}
		
		return new ModelAndView("employee_list.do", true);
		
	}

}
