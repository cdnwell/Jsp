package mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	
	private BoardMapper() {
		
	}
	
	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		
		return instance;
	}

	public List<BoardDTO> selectAllBoard(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectAllBoard",pageNo);
		session.close();
		
		return list;
	}

	public int selectAllCount() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.selectOne("selectAllCount");
		session.close();
		
		return result;
	}
	
	
}
