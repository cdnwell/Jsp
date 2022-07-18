package mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.EmployeeDTO;
import dto.EmployeeExDTO;
import dto.PositionListDTO;

public class EmployeeMapper {
	private static EmployeeMapper instance = new EmployeeMapper();
	private SqlSession session;
	
	private EmployeeMapper() {
		session = DBManager.getInstance().getSession();
	}
	
	public static EmployeeMapper getInstance() {
		if(instance == null)
			instance = new EmployeeMapper();
		
		return instance;
	}

	public List<EmployeeDTO> login(String eno, String name) {
		HashMap<String,String> map = new HashMap<>();
		
		map.put("eno", eno);
		map.put("name", name);
		
		return session.selectList("login", map);
	}

	
	public List<String> selectPosList(int position) {
		return session.selectList("selectPosList", position);
	}

	public List<EmployeeExDTO> selectEmployeeList() {
		return session.selectList("selectEmployeeList");
	}

	
	
}
