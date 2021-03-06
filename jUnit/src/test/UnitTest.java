package test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UnitTest {
	//언제 초기화 해주어야 할지.
	static TestService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		//테스트에 사용할 데이터를 셋팅
		service = new TestService();
		System.out.println("테스트 수행 전 맨 처음 한번만 수행되는 메서드");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception{
		//테스트에 사용된 데이터를 제거
		System.out.println("테스트 수행 후 맨 마지막에서 한번만 수행되는 메서드");
	}
	// static 붙는 메서드는 위 두개 밖에 없음
	
	@BeforeEach
	void setUp() throws Exception{
		System.out.println("테스트 메서드 수행 전에 실행되는 메서드");
	}
	
	@AfterEach
	void tearDown() throws Exception{
		System.out.println("테스트 메서드 수행 후에 실행되는 메서드");
	}
		
	@Test
	@Order(4)
	@DisplayName("fail if문으로 비교 테스트-4")
	void test() {
		//fail은 단독으로 쓰지 않고 if랑 결합해서 많이 쓴다.
		if(service.equalsNumber(10, 20))
			fail("숫자가 같은 값이 아닙니다.");
	}
	
	@Test
	@Order(3)
	@DisplayName("두 객체 비교 테스트-3")
	void objectTest() {
		//두 객체가 같은지 체크
		assertSame(service, service);
	}
	
	//@Test는 필수, @DisplayName은 써도 되고 안 써도 되고
	@Test
	@Order(2)
	@DisplayName("두 개 숫자 비교 테스트-2")
	void equalNumber() {
		assertEquals(service.rectArea(10, 3), 10*3, "사각형 넓이 구하는 메서드 테스트 실패");
		System.out.println("equalNumber");
	}
	
	@Test
	@Order(1)
	@DisplayName("true js 테스트-1")
	void testNumber() {
		assumeTrue(true, "결과가 거짓이 나왔습니다.");
		System.out.println("testNumber");
	}
	
}
