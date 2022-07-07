package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		ModelAndView view = null;
		
		MemberDTO dto = MemberService.getInstance().login(id,pass);
		
		if(dto == null) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("<script>alert('로그인에 실패하였습니다.');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			ArrayList<MemberDTO> list = MemberService.getInstance().selectTopAge3();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("list",list);
			session.setAttribute("dto", dto);
			
			view = new ModelAndView("main.jsp",true);
		}
		
		return view;
	}

}
