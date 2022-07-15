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
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
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

	public int selectAllCount() {
		int count = 0;
		String sql = "select count(*) from board_view";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return count;
	}

	public void insertBoard(BoardDTO dto) {

		String sql = "insert into board(bno, title, writer, content,bcount) "
				+ "values(board_bno.nextval ,? ,? ,? ,0)";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	public BoardDTO selectBoard(int bno) {
		BoardDTO dto = null;
		
		String sql = "select * from board_content_view where bno = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6), 
						rs.getInt(7), rs.getInt(8),rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}

	public void deleteBoard(int bno) {
		
		String sql = "delete from board where bno = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	public void updateBoard(BoardDTO dto) {
		
		String sql = "update board set title = ?, content = ? where bno = ?";
		
		PreparedStatement pstmt = null;
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getBno());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
	}

	public void addCountBoard(int bno) {
		
		String sql = "update board set bcount = bcount + 1 where bno = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
	}

	public int insertBoardLike(int bno, String id) {
		String sql = "insert into board_like values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
	}

	public int deleteBoardLike(int bno, String id) {
		String sql = "delete from board_like where bno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
	}

	public int insertBoardHate(int bno, String id) {
		String sql = "insert into board_hate values(?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	
	public int deleteBoardHate(int bno, String id) {
		String sql = "delete from board_hate where bno = ? and id = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(null, pstmt);
		}
		return result;
	}
	
}
