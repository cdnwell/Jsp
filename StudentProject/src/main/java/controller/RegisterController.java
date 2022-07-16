package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mname = request.getParameter("mname");
			
		int result = StudentService.getInstance().insertMajor(mno,mname);
		
		if(result != 0) {
			response.getWriter().write("<script>alert('학과정보 등록 성공');location.href='main.do';</script>");
		} else {
			response.getWriter().write("<script>alert('학과정보 등록 실패 입력한 데이터를 확인하세요');location.href='main.do';</script>");
		}
		
		return null;
		
	}

}
