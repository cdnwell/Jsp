package mapper;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.MemberDTO;

public class MemberMapper {
	private static MemberMapper instance = new MemberMapper();
	
	private MemberMapper() {
		
	}
	
	public static MemberMapper getInstance() {
		if(instance == null)
			instance = new MemberMapper();
		
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		SqlSession session = DBManager.getInstance().getSession(); 
		HashMap<String,String> map = new HashMap<>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		MemberDTO dto = session.selectOne("login",map);
		session.close();
		
		return dto;
	}

	public int insertMember(MemberDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		result = session.insert("insertMember",dto);
		session.commit();
		session.close();
		
		return result;
	}
	
}
