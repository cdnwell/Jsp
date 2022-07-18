package mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.EmployeeDTO;

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
	
	//메서드 명 상관 없다. xml에 넣은것과 달라도 됨.
	public List<EmployeeDTO> selectAllEmployee(){
		return session.selectList("selectAllEmployee");
	}
	
	public List<EmployeeDTO> selectDeptEmployee(String dept){
		return session.selectList("selectDeptEmployee", dept);
	}
	
	public int insertEmployee(EmployeeDTO dto) {
		return session.insert("insertEmployee",dto);
	}
	
	public int updateEmployeePosition() {
		return session.update("updatePosition");
	}

	public List<EmployeeDTO> selectPosition(HashMap<String, Integer> map) {
		return session.selectList("selectPosition",map);
	}
	
	//key값은 무조건 문자열이다.
	public List<Map<String,Object>> selectPositionCount(){
		return session.selectList("selectPositionCount");
	}

	public List<EmployeeDTO> selectSearchEmployee(Map<String, Object> map) {
		return session.selectList("selectSearchEmployee",map);
	}
	
}
