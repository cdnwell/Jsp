package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberService() {  }
	
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		
		return instance;
	}

	public MemberDTO login(String id, String pass) {
		return MemberDAO.getInstance().login(id, pass);
	}

	public ArrayList<MemberDTO> selectTopAge3() {
		return MemberDAO.getInstance().selectTopAge3();
	}
	
	

}
