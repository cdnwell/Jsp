package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView view = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO dto = MemberService.getInstance().login(id,passwd);
		
		if(dto != null) {
			HttpSession session = request.getSession();
			ArrayList<MemberDTO> list = MemberService.getInstance().selectTop3Member();
			
			session.setAttribute("dto", dto);
			session.setAttribute("list", list);
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>alert('아이디와 비밀번호가 일치하지 않습니다.');history.back();</script>");
		}
		
		return new ModelAndView("main.jsp",true);
	}

}
