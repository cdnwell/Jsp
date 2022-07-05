<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="config.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1.Connenction 객체를 생성한다.
	// 1-1.DBManager에서 인스턴스를 메서드로 받아와 메서드를 다시 호출해 conn 인스턴스를 받아온다.
	// 2.sql문을 작성해준다.
	// 3.preparedstatement 객체 생성
	// 3-1.resultset 객체 생성
	// 4.preparedstatement 객체에 connection 인스턴스에서 preparestatement함수로 sql을 매개변수로 받아온다.
	// 5.와일드카드는 setString을로 설정해주고 이 메서드의 인덱스는 1에서 부터 시작한다. 두개의 메서드를 받고
	// 5-1.search메서드, 인덱스를 받음
	// 6.MemberDTO클래스의 익명 객체를 만들어 list에 넣어준다.
	// 7.리스트를 ajax로 반환한다.
	Connection conn = DBManager.getInstance().getConn();
	String kind = request.getParameter("kind");
	String search = request.getParameter("search");
	
	String sql = "select * from member where ";
	sql += kind + " like '%' || ? || '%'";
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,search);
		rs = pstmt.executeQuery();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 		
		while (rs.next()) {
			list.add(new MemberDTO(rs.getString(1),rs.getString(2),
					rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
		}
		
		JSONArray array = new JSONArray(list);
		
		out.write(array.toString());
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>