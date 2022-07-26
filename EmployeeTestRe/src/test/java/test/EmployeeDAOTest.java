package test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.EmployeeDTO;

class EmployeeDAOTest {
	static SqlSession session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		session = DBManager.getInstance().getTestSession();
		EmployeeDTO dto = new EmployeeDTO("AA00", "김철수", "회계", 3);
		
		session.insert("insertEmployee", dto);
		System.out.println("데이터 등록");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		System.out.println("데이터 제거 완료");
	}

	@Test
	void searchPositionTest() {
		int position = 4;
		List<EmployeeDTO> list = session.selectList("selectByPosition",position);
		int result = list.size();
		assertNotEquals(result, 0, "직급 조회 테스트 실패");
	}
	
	@Test
	void serachNameTest() {
		String name = "강병현";
		List<EmployeeDTO> list = session.selectList("selectByName",name);
		int result = list.size();
		assertNotEquals(result, 0, "이름 조회 테스트 실패");
	}

	@Test
	void serachEnoTest() {
		String eno = "AA00";
		List<EmployeeDTO> list = session.selectList("selectByEno",eno);
		int result = list.size();
		assertNotEquals(result, 0, "사번 조회 테스트 실패");
	}
	
}
