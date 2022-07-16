package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StudentDTO;
import service.StudentService;
import view.ModelAndView;

public class SearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//kind search
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
	
		ArrayList<StudentDTO> list = StudentService.getInstance().selectStudentSearch(kind,search);
		
		request.getSession().setAttribute("list", list);
		
		System.out.println(list);
		
		return new ModelAndView("university_manager.jsp", false);
	}

}
