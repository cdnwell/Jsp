package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import view.ModelAndView;

public class DeleteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		int result = StudentService.getInstance().deleteMajor(mno);
		
		response.getWriter().write(String.valueOf(result));
		
		return null;
	}

}
