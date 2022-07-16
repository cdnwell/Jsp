package service;

import java.util.ArrayList;

import dao.TeacherDAO;
import dto.MajorDTO;
import dto.TeacherDTO;

public class TeacherService {
	private static TeacherService instance = new TeacherService();
	
	private TeacherService() {
		
	}
	
	public static TeacherService getInstance() {
		if(instance == null)
			instance = new TeacherService();
		
		return instance;
	}

	public TeacherDTO login(String id, String pass) {
		return TeacherDAO.getInstance().login(id,pass);
	}

	public ArrayList<MajorDTO> selectMajorList() {
		return TeacherDAO.getInstance().selectMajorList();
	}
	
	
}
