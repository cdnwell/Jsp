package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		int grade_no = Integer.parseInt(request.getParameter("position"));
		
		MemberDTO dto = new MemberDTO(id, passwd, name, nick, grade_no);
		
		int result = MemberService.getInstance().insertMember(dto);
		
		ModelAndView view = null;
		if(result == 0) {
			response.getWriter().write("<script>alert('회원가입에 실패하셨습니다.');history.back();</script>");
		}else {
			MemberDTO dto2 = MemberService.getInstance().login(dto.getId(),dto.getPasswd());
			request.getSession().setAttribute("dto", dto2);
			view = new ModelAndView("main.do", true);
		}
		
		return view;
	}

}
