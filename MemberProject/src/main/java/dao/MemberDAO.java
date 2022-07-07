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
	
	private MemberDAO() {
		conn = DBManager.getInstance().getConn();
	}
	
	public static MemberDAO getInstance() {
		if(instance ==null)
			instance = new MemberDAO();
		
		return instance;
	}
	
	public MemberDTO login(String id, String passwd) {
		MemberDTO dto = null;
		
		String sql = "select * from member where id like ? and passwd like ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs,pstmt);
		}
		
		return dto;
		
	}

	public ArrayList<MemberDTO> selectTopAge3() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		String sql = "select m.* from (select * from member ORDER BY age desc) m where rownum <= 3";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add( new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6))) ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs,pstmt);
		}
		
		
		return list;
	}


	public int insertMemberDTO(MemberDTO dto) {
		int result = 0;
		
		String sql = "INSERT INTO MEMBER "
				+ "VALUES (?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getAge());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getAddress());
			//update는 주로 delete나 insert 업데이트 할 때 씀
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(null, pstmt);
		}
		
		return result;
	}

	public int updateMemberDTO(MemberDTO dto) {
		int result = 0;
		
		String sql = "UPDATE MEMBER "
				+ "SET PASSWD = ?, "
				+ "	   NAME = ? , "
				+ "    AGE = ? , "
				+ "    GENDER = ? , "
				+ "    ADDRESS = ? "
				+ "WHERE ID = ? ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public ArrayList<MemberDTO> selectAllMember() {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		String sql = "select * from member";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add( new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs,pstmt);
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
				list.add( new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6))) ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.getInstance().close(rs,pstmt);
		}
		
		return list;
		
	}

	public int deleteMemberDTO(String id) {
		int result = 0;
		
		String sql = "DELETE FROM MEMBER "
				+ "WHERE ID = ? ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
