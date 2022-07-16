package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import config.DBManager;
import dto.StudentDTO;

public class StudentDAO {
	private static StudentDAO instance = new StudentDAO();
	private Connection conn;
	private DBManager manager;
	
	private StudentDAO() {
		manager = DBManager.getInstance();
		conn = manager.getConn();
	}
	
	public static StudentDAO getInstance() {
		if(instance == null)
			instance = new StudentDAO();
		
		return instance;
	}

	public ArrayList<StudentDTO> selectStudentList() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM STUDENT_MAJOR_LIST";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return list;
	}

	public int updateMajor(int mno, String mname) {
		int result = 0;
		String sql = "UPDATE MAJOR_LIST SET MNAME = ? WHERE MNO = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			pstmt.setInt(2, mno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
	}

	public int deleteMajor(int mno) {
		int result = 0;
		String sql = "DELETE FROM MAJOR_LIST WHERE MNO = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
	}

	public int insertMajor(int mno, String mname) {
		int result = 0;
		String sql = "INSERT INTO MAJOR_LIST VALUES(?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mno);
			pstmt.setString(2, mname);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
		
	}

	public ArrayList<StudentDTO> selectStudentSearch(String kind, String search) {
		ArrayList<StudentDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM STUDENT_MAJOR_LIST WHERE "+ kind + " like '%' || ? || '%'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return list;
	}

	public HashMap<StudentDTO,Integer> selectUnderAverage() {
		HashMap<StudentDTO,Integer> map = new HashMap<>();
		
		String sql = "SELECT * FROM STUDENT WHERE SCORE < 2";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map.put(new StudentDTO(rs.getString(1),rs.getString(2),null,rs.getDouble(4)), rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	
}
