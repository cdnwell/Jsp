package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TeacherDTO;
import service.TeacherService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		TeacherDTO dto = TeacherService.getInstance().login(id,pass);
		
		if(dto == null) {
			response.getWriter().write("<script>alert('아이디 비밀번호를 확인하세요.');history.back();</script>");
		}else {
			request.getSession().setAttribute("dto", dto);
			response.getWriter().write("<script>location.href='main.do'</script>");
		}
		
		return null;
	}

}
