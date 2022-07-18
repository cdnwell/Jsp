package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EmployeeDTO;
import mapper.EmployeeMapper;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		
		List<EmployeeDTO> list = EmployeeMapper.getInstance().login(eno, name);
		
		ModelAndView view = null;
		if(list.isEmpty()) {
			response.getWriter().write("<script>alert('이름과 사번을 확인해주세요');history.back();</script>");
		} else {
			view = new ModelAndView("main.do", true);
			EmployeeDTO dto = list.get(0);
			List<String> list_pos = EmployeeMapper.getInstance().selectPosList(dto.getPosition());
			String pos = list_pos.get(0);
			request.getSession().setAttribute("dto", dto);
			request.getSession().setAttribute("pos", pos);
			
		}
		
		return view;
	}

}
