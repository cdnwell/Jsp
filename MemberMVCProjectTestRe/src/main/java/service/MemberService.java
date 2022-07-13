package service;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	private static MemberService instance = new MemberService();
	
	private MemberService() { }
	
	public static MemberService getInstance() {
		if(instance == null)
			instance = new MemberService();
		
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		return MemberDAO.getInstance().login(id,passwd);
	}

	public ArrayList<MemberDTO> selectTop3Member() {
		return MemberDAO.getInstance().selectTop3Member();
	}

	public ArrayList<MemberDTO> selectMemberList() {
		return MemberDAO.getInstance().selectMemberList();
	}

	public void insertMember(MemberDTO dto) {
		MemberDAO.getInstance().insertMember(dto);
	}

	public void deleteMember(String id) {
		MemberDAO.getInstance().deleteMember(id);
	}

	public MemberDTO selectMember(String id) {
		return MemberDAO.getInstance().selectMember(id);
	}

	
}
