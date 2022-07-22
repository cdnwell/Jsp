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

	public MemberDTO login(String id, String pass) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		return session.selectOne("login", map);
	}
	
	
	
}
