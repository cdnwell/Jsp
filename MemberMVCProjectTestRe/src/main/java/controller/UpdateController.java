package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		MemberDTO dto = MemberService.getInstance().selectMember(id); 
		
		dto.setPasswd(null);
		
		request.setAttribute("update_dto", dto);
		
		return new ModelAndView("register_update.jsp",false);
	}

}
