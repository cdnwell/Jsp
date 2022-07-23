package service;

import java.util.List;

import dto.BoardDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	
	private BoardService() {
		
	}
	
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		
		return instance;
	}

	public List<BoardDTO> selectAllBoard(int pageNo) {
		return BoardMapper.getInstance().selectAllBoard(pageNo);
	}

	public int selectAllCount() {
		return BoardMapper.getInstance().selectAllCount();
	}

	
}
