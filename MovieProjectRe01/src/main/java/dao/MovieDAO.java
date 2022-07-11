package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MovieDTO;

public class MovieDAO {
	private static MovieDAO instance = new MovieDAO();
	private Connection conn;
	
	private MovieDAO() {
		conn = DBManager.getInstance().getConn();
	}
	
	public static MovieDAO getInstance() {
		if(instance == null)
			instance = new MovieDAO();
		
		return instance;
	}

	public ArrayList<MovieDTO> selectMovie(String kind, String search) {
		ArrayList<MovieDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM MOVIE WHERE ";
				
		if(kind.equals("year"))
			sql += "to_char(open_date,'YYYY') = ?";
		else
			sql += kind+" like '%' || ? || '%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MovieDTO(rs.getInt(1),rs.getString(2)
						,rs.getString(3),rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		return list;
	}

	public int selectCount() {
		String sql = "SELECT COUNT(*) FROM MOVIE";
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs, pstmt);
		}
		
		return result;
		
	}

	public ArrayList<MovieDTO> selectMovieList(int pageNo, String kind, String search) {
		ArrayList<MovieDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM "
				+ "(SELECT CEIL(ROWNUM / 7) AS PAGE_NO, M.* "
				+ "FROM (SELECT * FROM MOVIE ORDER BY BNO DESC) M ) "
				+ "WHERE PAGE_NO = ? ";
		
		if(kind.equals("year"))
			sql += "to_char(open_date,'YYYY') = ?";
		else
			sql += kind+" like '%' || ? || '%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MovieDTO(rs.getInt(2),rs.getString(3)
						,rs.getString(4),rs.getInt(5),rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
}
