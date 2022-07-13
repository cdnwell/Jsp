package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import view.ModelAndView;

public class DeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		int result = EmployeeService.getInstance().deleteEmployee(eno);
		
		if(result == 0) {
			response.getWriter().write("<script>alert('삭제 실패');location.href='employee_list.do';</script>");
		}else {
			response.getWriter().write("<script>alert('삭제 성공');location.href='employee_list.do';</script>");
		}
		
		return null;
	}
	
}
