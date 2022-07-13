package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private Connection conn;
	private DBManager manager;
	
	private MemberDAO() {
		conn = DBManager.getInstance().getConn();
		manager = DBManager.getInstance();
	}
	
	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		
		return instance;
	}

	public MemberDTO login(String id, String passwd) {
		MemberDTO dto = null;
		
		String sql = "select * from member where id = ? and passwd = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return dto;
	}

	public ArrayList<MemberDTO> selectTop3Member() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		String sql = "select mem.* from "
				+ "(select rownum as rw_num, m.* "
				+ "from "
				+ "(select * from member "
				+ "order by age desc) m "
				+ ") mem "
				+ "where rw_num <= 3";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6),rs.getString(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return list;
	}

	public ArrayList<MemberDTO> selectMemberList() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		String sql = "select * from member";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getString(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void insertMember(MemberDTO dto) {
		
		String sql = "insert into member(id,passwd,name,age,gender,address) "
				+ "values(?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	public void deleteMember(String id) {
		String sql = "delete from member where id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	public MemberDTO selectMember(String id) {
		MemberDTO dto = null;
		String sql = "select * from member where id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getInt(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return dto;
	}
	
}
