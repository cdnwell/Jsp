package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBManager;
import dto.TeacherDTO;

public class TeacherDAO {
	private static TeacherDAO instance = new TeacherDAO();
	private Connection conn;
	private DBManager manager;
	
	private TeacherDAO() {
		manager = DBManager.getInstance();
		conn = manager.getConn();
	}
	
	public static TeacherDAO getInstance() {
		if(instance == null)
			instance = new TeacherDAO();
		
		return instance;
	}

	public TeacherDTO login(String id, String pass) {
		String sql = "select * from edu_person where id = ? and pass = ?";
		TeacherDTO dto = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new TeacherDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
}
