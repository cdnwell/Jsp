package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DBManager;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private Connection conn;
	private DBManager manager;
	
	private EmployeeDAO() {
		conn = DBManager.getInstance().getConn();
		manager = DBManager.getInstance();
	}
	
	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		
		return instance;
	}

	public EmployeeDTO login(String name, String eno) {
		EmployeeDTO dto = null;
		
		String sql = "select e.eno, e.name,e.department, pl.name, es.salary "
				+ "from employee e, employee_salary es, position_list pl "
				+ "where e.eno = es.eno and e.position = pl.pno "
				+ "and e.name = ? and e.eno = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, eno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		
		return dto;
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		ArrayList<EmployeeDTO> list = new ArrayList<>();
		
		String sql = "select e.eno, e.name,e.department, pl.name, es.salary "
				+ "from employee e, employee_salary es, position_list pl "
				+ "where e.eno = es.eno and e.position = pl.pno";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(rs, pstmt);
		}
		
		return list;
	}

	public void insertEmployee(EmployeeDTO dto) {
		int position = 0;
		
		switch(dto.getPosition()) {
		case "사원":
			position = 1;
			break;
		case "주임":
			position = 2;
			break;
		case "대리":
			position = 3;
			break;
		case "과장":
			position = 4;
			break;
		case "차장":
			position = 5;
			break;
		case "부장":
			position = 6;
			break;
		case "사장":
			position = 7;
			break;
		}
		
		String sql = "insert into employee values(?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEno());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDepartment());
			pstmt.setInt(4, position);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	public int deleteEmployee(String eno) {
		int result = 0;
		String sql = "delete from employee where eno = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
		return result;
	}
	
	public void insertEmployeeSup(EmployeeDTO dto) {
		String sql = "insert into employee_salary values(?,?) ";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEno());
			pstmt.setInt(2, dto.getSalary());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.close(null, pstmt);
		}
		
	}

	
}
