package mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	private SqlSession session;
	
	private MemberMapper() {
		session = DBManager.getInstance().getSession();
	}
	
	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		
		return instance;
	}

	public MemberDTO login(Map<String, String> map) {
		return session.selectOne("login",map);
	}

	public List<MemberDTO> selectTopAge3() {
		return session.selectList("selectTopAge3");
	}

	public int insertMemberDTO(MemberDTO dto) {
		return session.insert("insertMemberDTO",dto);
	}

	public MemberDTO selectMemberDTO(String id) {
		return session.selectOne("selectMemberDTO",id);
	}

	public int updateMemberDTO(MemberDTO dto) {
		return session.update("updateMemberDTO", dto);
	}

	public int deleteMemberDTO(String id) {
		return session.delete("deleteMemberDTO",id);
	}

	public List<MemberDTO> selectMemberList() {
		return session.selectList("selectMemberList");
	}

	public List<MemberDTO> selectMemberList(Map<String, String> map) {
		return session.selectList("selectMemberSearchList",map);
	}
	
}
