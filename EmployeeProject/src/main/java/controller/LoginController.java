package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import service.EmployeeService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String eno = request.getParameter("eno");
		
		EmployeeDTO dto = EmployeeService.getInstance().login(name,eno);
		
		ModelAndView view = null;
		if(dto != null) {
			request.getSession().setAttribute("dto", dto);
			view = new ModelAndView("employee_list.do", true);
		}else {
			response.getWriter().write("<script>alert('입력하신 정보를 확인하세요');history.back();</script>");
		}
		
		return view;
	}

}
