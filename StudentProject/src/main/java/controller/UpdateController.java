package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mname = request.getParameter("mname");
		 
		int result = StudentService.getInstance().updateMajor(mno,mname);
		
		response.getWriter().write(String.valueOf(result));
		
		return null;
	}

}
