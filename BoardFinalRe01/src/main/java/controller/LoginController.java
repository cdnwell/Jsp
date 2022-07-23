package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO dto = MemberService.getInstance().login(id,passwd);
		
		if(dto!=null) {
			request.getSession().setAttribute("dto", dto);
			response.getWriter().write("<script>location.href='main.do'</script>");
		}else {
			response.getWriter().write("<script>alert('로그인 정보가 올바르지 않습니다.');history.back();</script>");
		}
		
		return null;
	}

}
