package db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;

import config.DBManager;
import dto.MemberDTO;

public class SelectAllMemberMain {

	public static void main(String[] args) {
		Connection conn = DBManager.getInstance().getConn();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			
			while(rs.next()) {
//				MemberVO vo = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
//						rs.getString(5),rs.getString(6));
				System.out.println(rs.getString(1) + rs.getString(2) 
				+ rs.getString(3) + rs.getInt(4) + rs.getString(5) 
				+ rs.getString(6));
//				list.add(vo);
			}
//			JSONArray array = new JSONArray(list);
//			System.out.println(array);
//			
//			File file = new File("member.json");
//			FileWriter fw = null;
//			PrintWriter pw = null;
			 
//			fw = new FileWriter(file);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
