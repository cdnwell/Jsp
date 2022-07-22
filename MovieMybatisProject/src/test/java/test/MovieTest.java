package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.MovieDTO;

class MovieTest {
	static SqlSession session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("테스트 전에 실행되는 메소드");
		FileReader fr = new FileReader("movie2.json");
		BufferedReader br = new BufferedReader(fr);
		
		String str = "";
		while(true) {
			String s = br.readLine();
			if(s == null) break;
			str += s;
		}
		
		JSONArray arr = new JSONArray(str);
		System.out.println(arr);
		int count = 0;
		session = DBManager.getInstance().getTestSession();
		
		for(int i=0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			MovieDTO dto = new MovieDTO(obj.getInt("bno"), obj.getString("title")
					, obj.getString("open_date"), obj.getInt("audience_count")
					, obj.getString("director"));
			
			count += session.insert("insertMovieTest",dto);
		}
		System.out.println("데이터 " + count + "건 추가");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		System.out.println("테스트 데이터 제거");
	}
	
	@Test
	@DisplayName("test1")
	void testInsertMovie() {
//		MovieDTO dto = new MovieDTO(11,"테스트 제목", "23/09/11", 123456, "감독");
//		int result = 0;
//		try {
//			result = session.insert("insertMovie",dto);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		assertEquals(result, 1, "영화 정보 추가 기능 테스트 실패");
		
		// 1. dto 하나를 만들어서 데이터를 넣은 후 데이터가 추가 되었는지 결과 값 1로 비교하여 데이터 추가 여부 판별
		
		MovieDTO dto = new MovieDTO(1200, "영화 제목", "20/12/11", 125000, "김 감독");
		int result = 0;
		try {
		result = session.insert("insertMovieTest",dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		assertEquals(result, 1, "영화 정보 추가 기능 테스트 실패");
	}
	
	@Test
	@DisplayName("test2")
	void testSelectMovieList() {
//		List<MovieDTO> list = session.selectList("selectMovieList","닥터");
//		assumeFalse(list.size() == 0,"영화 정보 검색 기능 테스트 실패");
//		
//		//둘 다 같은 방법이다.
//		if(list.size() == 0)
//			fail("영화 정보 검색 기능 테스트 실패");
		
		// 1. 영화 한건을 검색한 이후 검색으로 반환 된 list 사이즈가 0이면 '검색 테스트 실패' 라는 메시지 출력
		
		List<MovieDTO> list = session.selectList("selectMovieList","Atom");
		
		if(list.size() == 0)
			fail("영화 정보 검색 기능 테스트 실패");
		
	}
	
}
