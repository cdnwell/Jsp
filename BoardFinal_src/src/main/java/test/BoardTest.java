package test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BoardTest {
	
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
		
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("테스트가 진행 된 후에 실행되는 메소드");
	}
	
	@Test
	void test() {
		System.out.println("테스트 실행...");
	}

}
