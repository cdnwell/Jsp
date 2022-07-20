package mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	
	private BoardMapper() {
		
	}
	
	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		
		return instance;
	}

	public List<BoardDTO> selectBoardList(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectBoardList",pageNo);
		session.close();
		return list;
	}

	public void addCountBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		session.update("addCountBoard", bno);
		session.close();
	}

	public BoardDTO selectBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		BoardDTO dto = session.selectOne("selectBoard",bno);
		session.close();
		return dto;
	}

	public List<BoardCommentDTO> selectBoardCommentList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardCommentDTO> list = session.selectList("selectBoardCommentList",bno);
		session.close();
		return list;
	}
	
}
