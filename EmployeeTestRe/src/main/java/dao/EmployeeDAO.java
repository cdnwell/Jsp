package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSession session;
	
	private EmployeeDAO() {
		session = DBManager.getInstance().getSession();
	}
	
	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		
		return instance;
	}

	public List<EmployeeDTO> selectByEno(String content) {
		return session.selectList("selectByEno",content);
	}

	public List<EmployeeDTO> selectByName(String content) {
		return session.selectList("selectByName",content);
	}

	public List<EmployeeDTO> selectByPosition(int position) {
		return session.selectList("selectByPosition",position);
	}
	
	
}
