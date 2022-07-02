//package dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import config.DBManager;
//import vo.MemberVO;
//import vo.StudentVO;
//
///*
// * db작업 여기서
// * 학생관리 dao, 학과 관리 dao... 이후에는 여러개 dao가 생성된다.
// */
//public class MemberDAO {
//	private static MemberDAO instance = new MemberDAO();
//	private DBManager manager;
//
//	private MemberDAO() {
//		manager = DBManager.getInstance();
//	}
//
//	public static MemberDAO getInstance() {
//		if (instance == null)
//			instance = new MemberDAO();
//		return instance;
//	}
//
//	public ArrayList<MemberVO> selectAllMember() {
//		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
//		String sql = "SELECT ID, PASSWD, NAME, AGE, GENDER, ADDRESS "
//				+ "FROM MEMBER";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String id = rs.getString(1);
//				int passwd = rs.getInt(2);
//				String name = rs.getString(3);
//				int age = rs.getInt(4);
//				String gender = rs.getString(5);
//				String address = rs.getString(6);
//				list.add(new MemberVO(id,passwd,name,age,gender,address));
//			} // 하나라서 if문만 써도 된다. while써도 문제 될건 없음
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}
//
//	public ArrayList<StudentVO> selectAllStudent() {
//		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
//		String sql = "select s.sno, s.sname, m.major_name, s.score "
//				+ "from STUDENT s, MAJOR m where s.major_no = m.major_no(+)";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String sno = rs.getString(1);
//				String sname = rs.getString(2);
//				String majorName = rs.getString(3);
//				double score = rs.getDouble(4);
//				list.add(new StudentVO(sno, sname, 0, majorName, score));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, rs);
//		}
//
//		return list;
//	}
//
//	public int insertStudent(StudentVO vo) {
//		int count = 0;
//
//		PreparedStatement pstmt = null;
//		String sql = "insert into student values(?,?,?,?)";
//
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			pstmt.setString(1, vo.getSno());
//			pstmt.setString(2, vo.getSname());
//			pstmt.setInt(3, vo.getMajorNo());
//			pstmt.setDouble(4, vo.getScore());
//			count = pstmt.executeUpdate();
//			manager.getConn().commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, null);
//		}
//
//		return count;
//
//	}
//
//	public int updateStudent(StudentVO vo) {
//		int count = 0;
//
//		PreparedStatement pstmt = null;
//		String sql = "update student set sname=?,major_no=?,score=? where sno like ? for update wait 3";
//
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			pstmt.setString(4, vo.getSno());
//			pstmt.setString(1, vo.getSname());
//			pstmt.setInt(2, vo.getMajorNo());
//			pstmt.setDouble(3, vo.getScore());
//			count = pstmt.executeUpdate();
//			manager.getConn().commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, null);
//		}
//
//		return count;
//	}
//
//	public int deleteStudent(String sno) {
//		int count = 0;
//
//		PreparedStatement pstmt = null;
//		String sql = "delete from student where sno like ?";
//		// 공백들을 날려야된다. 중요
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			pstmt.setString(1, sno);
//			count = pstmt.executeUpdate();
////			manager.getCon/n().commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, null);
//		}
//
//		return count;
//
//	}
//
//	public ArrayList<StudentVO> selectRankOne() {
//		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
//		String sql = "SELECT * FROM(SELECT S.SNO, S.SNAME, M.MAJOR_NAME, S.SCORE, RANK() OVER(ORDER BY S.SCORE DESC) AS RK FROM STUDENT S, MAJOR M WHERE S.MAJOR_NO = M.MAJOR_NO ) WHERE RK = 1";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String sno = rs.getString(1);
//				String sname = rs.getString(2);
//				String majorName = rs.getString(3);
//				double score = rs.getDouble(4);
//				list.add(new StudentVO(sno, sname, 0, majorName, score));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, rs);
//		}
//
//		return list;
//	}
//
//	public HashMap<String, Double> selectMajorAvgScore() {
//		HashMap<String, Double> map = new HashMap<String, Double> ();
//		String sql ="SELECT M.MAJOR_NAME, TRUNC(AVG(S.SCORE),2) FROM STUDENT S,MAJOR M "
//				+ "WHERE S.MAJOR_NO = M.MAJOR_NO(+) GROUP BY M.MAJOR_NAME";
//		PreparedStatement pstmt = null;
//		ResultSet rs =null;
//		try {
//		pstmt = manager.getConn().prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//			while(rs.next()) {
//				map.put(rs.getString(1), rs.getDouble(2));
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return map;
//	}
//
//	public ArrayList<StudentVO> selectScholarshipStudent() {
//		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
//		
//		String sql = "SELECT S.SNO, S.SNAME, M.MAJOR_NAME, SS.MONEY FROM STUDENT S, MAJOR M, STUDENT_SCHOLARSHIP SS WHERE S.MAJOR_NO = M.MAJOR_NO(+) AND S.SNO = SS.STUDENT_NO";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs =null;
//		try {
//			pstmt = manager.getConn().prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String sno = rs.getString(1);
//				String sname = rs.getString(2);
//				String majorName = rs.getString(3);
//				int money = rs.getInt(4);
//				list.add(new StudentVO(sno, sname, money, majorName, 0));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			manager.close(pstmt, rs);
//		}
//		
//		return list;
//	}
//	
//	public ArrayList<HashMap<String,Object>> selectSchoolScholarship() {
//		String sql = "SELECT S.SNO, S.SNAME, M.MAJOR_NAME, SS.MONEY "
//				+ "FROM STUDENT S, MAJOR M, STUDENT_SCHOLARSHIP SS "
//				+ "WHERE S.MAJOR_NO = M.MAJOR_NO(+) AND S.SNO = SS.STUDENT_NO";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
//		
//		try {
//		pstmt = manager.getConn().prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("sno", rs.getString(1));
//			map.put("sname", rs.getString(2));
//			map.put("major_name", rs.getString(3));
//			map.put("price", rs.getInt(4));
//			
//			list.add(map);
//		}
//		
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
//	
////	public Map<StudentVO,MajorVO> selectMajorAvgScore() {
////		Map<StudentVO,MajorVO> list = new Map<StudentVO, MajorVO>();
////		
////		String sql = "SELECT M.MAJOR_NAME, TRUNC(AVG(S.SCORE),2) FROM STUDENT S,MAJOR M WHERE S.MAJOR_NO = M.MAJOR_NO(+) GROUP BY M.MAJOR_NAME";
////		
////		PreparedStatement pstmt = null;
////		ResultSet rs = null;
////		try {
////			pstmt = manager.getConn().prepareStatement(sql);
////			rs = pstmt.executeQuery();
////
////			while (rs.next()) {
////				String majorName = rs.getString(1);
////				double score = rs.getDouble(2);
////				list.put(new StudentVO("", "",0, "", score),new MajorVO(0,majorName));
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			manager.close(pstmt, rs);
////		}
////		
////		return list;
////	}
//
////	public int updateStudent(StudentVO vo) {
////
//////		int count = 0;
//////
//////		PreparedStatement pstmt = null;
//////		String sql = "update student set sname = ?, major_no = ?, score = ?";
//////
//////		try {
//////			pstmt = manager.getConn().prepareStatement(sql);
//////			pstmt.setString(1, vo.getSname());
//////			pstmt.setInt(2, vo.getMajorNo());
//////			pstmt.setDouble(3, vo.getScore());
//////			count = pstmt.executeUpdate();
//////			manager.getConn().commit();
//////		} catch (SQLException e) {
//////			e.printStackTrace();
//////		} finally {
//////			manager.close(pstmt, null);
//////		}
//////
//////		return count;
////		
////		int count = 0;
////
////		PreparedStatement pstmt = null;
////		String sql = "update student set sname =?, major_no = ?, score =?, where sno like ?";
////
////		try {
////			pstmt = manager.getConn().prepareStatement(sql);
////			pstmt.setString(4, vo.getSno());
////			pstmt.setString(1, vo.getSname());
////			pstmt.setInt(2, vo.getMajorNo());
////			pstmt.setDouble(3, vo.getScore());
////			count = pstmt.executeUpdate();
////			manager.getConn().commit();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			manager.close(pstmt, null);
////		}
////
////		return count;
////		
////	}
//
//}