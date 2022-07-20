package mapper;

import java.util.ArrayList;
import java.util.HashMap;
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

	public MemberDTO login(HashMap<String, String> map) {
		return session.selectOne("login",map);
	}

	public List<MemberDTO> selectTopAge3() {
		return session.selectList("selectTopAge3");
	}

	public List<MemberDTO> selectMemberList(String kind, String search) {
		Map<String, String> map = new HashMap<>();
		map.put("kind", kind);
		map.put("search", search);
		return session.selectList("selectMemberList",map);
	}

	public MemberDTO selectMemberDTO(String id) {
		return session.selectOne("selectMemberDTO",id);
	}

	public void insertMemberDTO(MemberDTO dto) {
		session.insert("insertMemberDTO",dto);
	}

	public void deleteMemberDTO(String id) {
		session.delete("deleteMemberDTO",id);
	}

	public int updateMemberDTO(MemberDTO dto) {
		return session.update("updateMemberDTO",dto);
	}
	
	
}
