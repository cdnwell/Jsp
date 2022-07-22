package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.ProductDTO;

class ProductDAOTest {
	static SqlSession session;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		FileReader fr = new FileReader("product.json");
		BufferedReader br = new BufferedReader(fr);
		
		String str = "";
		while(true) {
			String s = br.readLine();
			if(s == null) break;
			str += s;
		}
		
		session = DBManager.getInstance().getTestSession();
		JSONArray arr = new JSONArray(str);
		for(int i = 0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			ProductDTO dto = new ProductDTO(obj.getString("product_no"),
					obj.getString("product_name"), obj.getInt("price"),
					obj.getInt("ea"), obj.getString("maker"));
			session.insert("insertProduct",dto);
		}
		System.out.println("데이터가 저장되었습니다.");
		
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		System.out.println("데이터가 삭제 되었습니다.");
	}

	@Test
	@DisplayName("제품정보 검색 테스트")
	void test() {
		
		String testNo = "264484692074";
		ProductDTO dto = session.selectOne("selectProduct",testNo);
		
		if(dto == null)
			fail("오류, 해당 데이터는 있는데 검색결과가 없습니다. SQL문을 확인해보세요");
		 
	}

}
