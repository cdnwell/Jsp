package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.BoardDTO;
import dto.MemberDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private Connection conn;
	private DBManager manager;
	
	private BoardDAO() {
		conn = DBManager.getInstance().getConn();
		manager = DBManager.getInstance();
	}
	
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
		
		return instance;
	}
	
	public int selectCount() {
		int count = 0;
		
		String sql = "select count(*) from board";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		return count;
		
	}
	
	public ArrayList<BoardDTO> selectBoardList(int pageNo) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from (SELECT CEIL(ROWNUM / 15) AS pageNo, b.* FROM BOARD_VIEW b) "
				+ "where pageNo = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardDTO(rs.getInt(2), rs.getString(3),
						 rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return list;
		
	}
	
}
