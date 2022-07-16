package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MajorDTO;
import dto.StudentDTO;
import service.StudentService;
import service.TeacherService;
import view.ModelAndView;

public class MainViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//list-session,major_list-session
		ArrayList<MajorDTO> major_list = TeacherService.getInstance().selectMajorList();
		ArrayList<StudentDTO> list = StudentService.getInstance().selectStudentList();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("major_list", major_list);
		session.setAttribute("list", list);
		
		return new ModelAndView("university_manager.jsp", true);
	}

}
