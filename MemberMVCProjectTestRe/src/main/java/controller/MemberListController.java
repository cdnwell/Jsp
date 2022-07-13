package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import view.ModelAndView;

public class MemberListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<MemberDTO> list = MemberService.getInstance().selectMemberList();
		
		if(!list.isEmpty()) {
			request.getSession().setAttribute("m_list", list);
		}
		
		return new ModelAndView("main_member.jsp",true);
	}

}
