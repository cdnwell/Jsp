package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeExDTO;
import mapper.EmployeeMapper;
import view.ModelAndView;

public class MainViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmployeeExDTO> list = EmployeeMapper.getInstance().selectEmployeeList();
		
		request.getSession().setAttribute("list", list);
		System.out.println(list);
		
		return null;
//		return new ModelAndView("employee_manager.jsp", true);
	}

}
