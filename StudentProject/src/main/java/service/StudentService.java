package service;

import java.util.ArrayList;

import dao.StudentDAO;
import dto.StudentDTO;

public class StudentService {
	private static StudentService instance = new StudentService();
	
	private StudentService() {
		
	}
	
	public static StudentService getInstance() {
		if(instance == null)
			instance = new StudentService();
		
		return instance;
	}

	public ArrayList<StudentDTO> selectStudentList() {
		return StudentDAO.getInstance().selectStudentList();
	}

	public int updateMajor(int mno, String mname) {
		return StudentDAO.getInstance().updateMajor(mno, mname);
	}

	public int deleteMajor(int mno) {
		return StudentDAO.getInstance().deleteMajor(mno);
	}

	public int insertMajor(int mno, String mname) {
		return StudentDAO.getInstance().insertMajor(mno,mname);
	}

	public ArrayList<StudentDTO> selectStudentSearch(String kind, String search) {
		return StudentDAO.getInstance().selectStudentSearch(kind,search);
	}
	
	
}
