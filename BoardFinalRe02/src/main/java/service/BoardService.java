package service;

public class BoardService {
	private static BoardService instance = new BoardService();
	
	private BoardService() {
		
	}
	
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		
		return instance;
	}
}
